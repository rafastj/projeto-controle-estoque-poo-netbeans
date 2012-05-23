/**
 *
 */
package projeto.modelo.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import projeto.conexao.GerenciadorConexao;
import projeto.conexao.IGerenciadorConexao;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Produto;

/**
 * @author Diego Silva
 *
 */
public class RepositorioProduto implements IRepositorioProduto {

    private IGerenciadorConexao g;

    public RepositorioProduto() {
        g = GerenciadorConexao.getInstancia();
    }

    /**
     * Implementação padão DAO para Salvar o produto na tabela produto
     */
    @Override
    public void salvar(Produto p) throws ConexaoException, RepositorioException {
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        //variavel do tipo String da Instrução de inserção SQL
        String sqlSalvar = "Insert into Produtos (Segmentos_Codigo,Tipos_Codigo,Marcas_Codigo,Produtos_Descricao,Produtos_Quantidade,Produtos_ValorVenda) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, p.getSegmentos_Codigo());
            pstm.setInt(2, p.getTipos_Codigo());
            pstm.setInt(3, p.getMarcas_Codigo());
            pstm.setString(4, p.getProdutos_Descricao());
            pstm.setInt(5, p.getProdutos_Quantidade());
            pstm.setDouble(6, p.getProdutos_ValorVenda());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    /**
     * Imprementação padrão DAO para exclusão da tabela Produto
     */
    @Override
    public void excluir(int produtos_Codigo) throws ConexaoException, RepositorioException {
        /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlExcluir = "DELETE FROM PRODUTOS WHERE (produtos_Codigo = ?)";
        try {
            /**
             * indica o codigo do produto que irar ser deletado
             */
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, produtos_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            /**
             * Desconecta do banco de dados
             */
            g.desconectar(c);
        }
    }

    /**
     * Implementação padrão DAO para alteração da tabela Produtos
     */
    @Override
    public void alterar(Produto p) throws ConexaoException, RepositorioException {
        /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlAlterar = "UPDATE Produtos SET Segmentos_Codigo = ? ,Tipos_Codigo = ?, Marcas_Codigo = ?, Produtos_Descricao = ?, Produtos_Quantidade = ?, Produtos_ValorVenda = ? WHERE produtos_Codigo = ?";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setInt(1, p.getSegmentos_Codigo());
            pstm.setInt(2, p.getTipos_Codigo());
            pstm.setInt(3, p.getMarcas_Codigo());
            pstm.setString(4, p.getProdutos_Descricao());
            pstm.setInt(5, p.getProdutos_Quantidade());
            pstm.setDouble(6, p.getProdutos_ValorVenda());
            pstm.setInt(7, p.getProdutos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    /**
     * Implementação padrão DAO para consultar pela Descrição da tabela Produtos
     */
    @Override
    public Produto consultarDescricao(String produtos_Descricao) throws ConexaoException, RepositorioException {

        Produto p = null;

        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();

        //variavel do tipo String da Instrução de inserção SQL
        String sqlconsultar = "SELECT Produtos_Codigo, Segmentos_Codigo,Tipos_Codigo,Marcas_Codigo,Produtos_Descricao,Produtos_Quantidade,Produtos_ValorVenda from Produtos WHERE (produtos_Descricao like ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlconsultar);
            pstm.setString(1, "%" + produtos_Descricao + "%");//essa porcentagem faz a introdução do like
            ResultSet rs = pstm.executeQuery();
            //abaixo se caso for encontrado o produto, ele será setado no p
            if (rs.next()) {
                p = new Produto();
                p.setProdutos_Codigo(rs.getInt("Produtos_Codigo"));
                p.setProdutos_Descricao(produtos_Descricao);
                p.setSegmentos_Codigo(rs.getInt("Segmentos_Codigo"));
                p.setTipos_Codigo(rs.getInt("Tipos_Codigo"));
                p.setMarcas_Codigo(rs.getInt("Marcas_Codigo"));
                p.setProdutos_Descricao(rs.getString("produtos_Descricao"));
                p.setProdutos_Quantidade(rs.getInt("produtos_Quantidade"));
                p.setProdutos_ValorVenda(rs.getDouble("produtos_ValorVenda"));
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return p; //retorno do resultado da consulta
    }

    /**
     * Implementação padrão DAO para consultar pelo Codigo da tabela Produtos
     */
    @Override
    public Produto consultarCodigo(int produtos_Codigo) throws ConexaoException, RepositorioException {

        Produto p = null;
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        //variavel do tipo String da Instrução de inserção SQL
        String sqlconsultar = "SELECT Segmentos_Codigo,Tipos_Codigo,Marcas_Codigo,Produtos_Descricao,Produtos_Quantidade,Produtos_ValorVenda from Produtos WHERE (produtos_Codigo = ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlconsultar);
            pstm.setInt(1, produtos_Codigo);//essa porcentagem faz a introdução do like
            ResultSet rs = pstm.executeQuery();
            //abaixo se caso for encontrado o produto, ele será setado no p
            if (rs.next()) {
                p = new Produto();
                p.setProdutos_Codigo(produtos_Codigo);
                p.setSegmentos_Codigo(rs.getInt("Segmentos_Codigo"));
                p.setTipos_Codigo(rs.getInt("Tipos_Codigo"));
                p.setMarcas_Codigo(rs.getInt("Marcas_Codigo"));
                p.setProdutos_Descricao(rs.getString("produtos_Descricao"));
                p.setProdutos_Quantidade(rs.getInt("produtos_Quantidade"));
                p.setProdutos_ValorVenda(rs.getDouble("produtos_ValorVenda"));
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return p; //retorno do resultado da consulta
    }

    /**
     * Implementação padrão DAO para listar pela descrição informada da tabela
     * Produtos
     */
    @Override
    public Collection<Produto> listar(String produtos_Descricao) throws ConexaoException, RepositorioException {
        // criar variavel arrey list
        ArrayList<Produto> lista = new ArrayList<Produto>();
        Produto p;
        Connection c = g.conectar();
        String sqlLista = "SELECT s.segmentos_Descricao, t.tipos_Descricao, m.marcas_Descricao, p.produtos_Descricao, p.produtos_Quantidade, p.produtos_ValorVenda from Produtos p inner join Segmentos s On p.segmentos_Codigo = s.segmentos_Codigo inner join Tipos t On p.tipos_Codigo = t.tipos_Codigo inner join Marcas m On p.marcas_Codigo = m.marcas_Codigo where p.produtos_Descricao like ? order by p.produtos_Descricao";
        //	String sqlLista = "SELECT produtos_Descricao from Produtos where produtos_Descricao like ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);//salvar todos os registro na variavel do Result set
            pstm.setString(1, "%" + produtos_Descricao + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                p = new Produto();
                //AJUDA PROFESSOR! VALEU!
                p.getSegmentos().setSegmentos_Descricao(rs.getString("s.segmentos_Descricao"));
                p.getTipo().setTipos_Descricao(rs.getString("t.tipos_Descricao"));
                p.getMarcas().setMarcas_Descricao(rs.getString("m.marcas_Descricao"));
                p.setProdutos_Descricao(rs.getString("p.produtos_Descricao"));
                p.setProdutos_Quantidade(rs.getInt("p.produtos_Quantidade"));
                p.setProdutos_ValorVenda(rs.getDouble("p.produtos_ValorVenda"));
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }
}