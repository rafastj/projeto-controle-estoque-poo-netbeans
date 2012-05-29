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
import projeto.modelo.to.Produto_Fornecedor;

/**
 * @author diego
 *
 */
public class RepositorioProduto_Fornecedor implements IRepositorioProduto_Fornecedor {

    private IGerenciadorConexao g;
    //Negocio para a conexão

    public RepositorioProduto_Fornecedor() {
        g = GerenciadorConexao.getInstancia();
    }

    /**
     * Implementação padão DAO para Salvar o fornecedor de Produto na tabela
     * produtos_fornecedores
     */
    @Override
    public void salvar(Produto_Fornecedor pf) throws ConexaoException, RepositorioException {
        //Chama a singleton "apena usatilizar um objeto criado se não ele criar"
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO Produtos_Fornecedores  (PRODUTOS_CODIGO,FORNECEDORES_CODIGO)  VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, pf.getProdutos_Codigo());
            pstm.setInt(2, pf.getFornecedores_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    /**
     * Implementação padão DAO para consultar o codigo produto na tabela
     * produtos_fornecedores
     */
    @Override
    public Produto_Fornecedor ConsultarLigacaoFornecedorProduto(String Fornecedores_RazaoSocial, String Produtos_Descricao) throws ConexaoException, RepositorioException {
        //chamar o singleton "Apenas utilizar um objeto criado! se não estiver criado ele criar
        Connection c = g.conectar();
        //declarar o Produto_Fornecedor igual a null
        Produto_Fornecedor pf = null;
        //instrução SQL onde irar verificar se ex
        String sqlConsultarCodigo = "SELECT f.Fornecedores_RazaoSocial, p.Produtos_Descricao, pf.Fornecedores_Codigo, pf.Produtos_Codigo FROM produtos_fornecedores pf Inner Join Fornecedores f On f.Fornecedores_Codigo = pf.Fornecedores_Codigo Inner Join Produtos p On p.Produtos_Codigo = pf.Produtos_Codigo WHERE (p.Produtos_Descricao like ? and f.Fornecedores_RazaoSocial like ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultarCodigo);
            pstm.setString(1, '%' + Produtos_Descricao + '%');
            pstm.setString(2, '%' + Fornecedores_RazaoSocial + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pf = new Produto_Fornecedor();
                pf.getFornecedor().setFornecedores_RazaoSocial(rs.getString("f.Fornecedores_RazaoSocial"));
                pf.getProduto().setProdutos_Descricao(rs.getString("p.Produtos_Descricao"));
                pf.setFornecedores_Codigo(rs.getInt("pf.Fornecedores_Codigo"));
                pf.setProdutos_Codigo(rs.getInt("pf.Produtos_Codigo"));
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return pf;
    }

    /**
     * Implementação padão DAO para EXCLUIR o codigo produto na tabela
     * produtos_fornecedores
     */
    @Override
    public void excluir(int Fornecedor_Codigo, int Produto_Codigo) throws ConexaoException, RepositorioException {
        /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlExcluir = "DELETE FROM produtos_fornecedores WHERE  ( FORNECEDORES_CODIGO = ? and PRODUTOS_CODIGO = ? )";
        try {
            /**
             * indica o codigo do produto que irar ser deletado
             */
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, Fornecedor_Codigo);
            pstm.setInt(2, Produto_Codigo);
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
     * Implementação padão DAO para ALTERAR o codigo produto na tabela
     * produtos_fornecedores
     */
    @Override
    public void alterar(int FFornecedor_Codigo, int NProduto_Codigo, int Fornecedor_Codigo, int Produto_Codigo) throws ConexaoException, RepositorioException {
        /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();

        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlAltera = "UPDATE produtos_fornecedores SET FORNECEDORES_CODIGO = ?, PRODUTOS_CODIGO = ? WHERE FORNECEDORES_CODIGO = ? and PRODUTOS_CODIGO = ? ";
        try {
            /**
             * indica o codigo do produto que irar ser deletado
             */
            PreparedStatement pstm = c.prepareStatement(sqlAltera);
            pstm.setInt(1, FFornecedor_Codigo);
            pstm.setInt(2, NProduto_Codigo);
            pstm.setInt(3, Fornecedor_Codigo);
            pstm.setInt(4, Produto_Codigo);
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

    @Override
    public Collection<Produto_Fornecedor> listar(String Produto_Descricao) throws ConexaoException, RepositorioException {
        // criar variavel arrey list
        ArrayList<Produto_Fornecedor> lista = new ArrayList<Produto_Fornecedor>();
        //criar o objeto pf
        Produto_Fornecedor pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT p.produtos_Descricao,f.Fornecedores_RazaoSocial from Produtos_Fornecedores pf INNER JOIN Produtos p ON pf.produtos_Codigo = p.Produtos_Codigo INNER JOIN Fornecedores f ON pf.Fornecedores_Codigo = f.Fornecedores_Codigo WHERE p.produtos_Descricao like ? order by p.produtos_Descricao";
        //	String sqlLista = "SELECT produtos_Descricao from Produtos where produtos_Descricao like ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, "%" + Produto_Descricao + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pf = new Produto_Fornecedor();
                pf.getProduto().setProdutos_Descricao(rs.getString("p.produtos_Descricao"));
                pf.getFornecedor().setFornecedores_RazaoSocial(rs.getString("f.Fornecedores_RazaoSocial"));
                lista.add(pf);
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return lista;
    }

    @Override
    public Collection<Produto_Fornecedor> listarFornecedor(String Fornecedor_RazaoSocial) throws ConexaoException, RepositorioException {
        // criar variavel arrey list
        ArrayList<Produto_Fornecedor> lista = new ArrayList<Produto_Fornecedor>();
        //criar o objeto pf
        Produto_Fornecedor pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT p.produtos_Descricao,f.Fornecedores_RazaoSocial from Produtos_Fornecedores pf INNER JOIN Produtos p ON pf.produtos_Codigo = p.Produtos_Codigo INNER JOIN Fornecedores f ON pf.Fornecedores_Codigo = f.Fornecedores_Codigo WHERE f.fornecedores_RazaoSocial like ? order by p.produtos_Descricao";
        //	String sqlLista = "SELECT produtos_Descricao from Produtos where produtos_Descricao like ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, "%" + Fornecedor_RazaoSocial + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pf = new Produto_Fornecedor();
                pf.getProduto().setProdutos_Descricao(rs.getString("p.produtos_Descricao"));
                pf.getFornecedor().setFornecedores_RazaoSocial(rs.getString("f.Fornecedores_RazaoSocial"));
                lista.add(pf);
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return lista; 
    }
//fim    

    @Override
    public Collection<Produto_Fornecedor> listarTodos() throws ConexaoException, RepositorioException {
          // criar variavel arrey list
        ArrayList<Produto_Fornecedor> lista = new ArrayList<Produto_Fornecedor>();
        //criar o objeto pf
        Produto_Fornecedor pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT p.produtos_Descricao,f.Fornecedores_RazaoSocial from Produtos_Fornecedores pf INNER JOIN Produtos p ON pf.produtos_Codigo = p.Produtos_Codigo INNER JOIN Fornecedores f ON pf.Fornecedores_Codigo = f.Fornecedores_Codigo order by p.produtos_Descricao";
        //	String sqlLista = "SELECT produtos_Descricao from Produtos where produtos_Descricao like ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pf = new Produto_Fornecedor();
                pf.getProduto().setProdutos_Descricao(rs.getString("p.produtos_Descricao"));
                pf.getFornecedor().setFornecedores_RazaoSocial(rs.getString("f.Fornecedores_RazaoSocial"));
                lista.add(pf);
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return lista; 
    }
    
    /**
     * Lista todos os produtos não fornecidos pelo fornecedor
     * @param fornecedor_RazaoSocial
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    @Override
    public Collection<Produto_Fornecedor> listadeProdutosNaoFornecidos(String fornecedor_RazaoSocial) throws ConexaoException, RepositorioException {
          // criar variavel arrey list
        ArrayList<Produto_Fornecedor> lista = new ArrayList<Produto_Fornecedor>();
        //criar o objeto pf
        Produto_Fornecedor pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT p.produtos_Descricao FROM produtos p WHERE p.produtos_codigo NOT IN ( SELECT p.produtos_Codigo from Produtos_Fornecedores pf INNER JOIN Produtos p ON pf.Produtos_Codigo = p.Produtos_Codigo INNER JOIN Fornecedores f ON pf.Fornecedores_Codigo = f.Fornecedores_Codigo WHERE f.Fornecedores_RazaoSocial like ? Order by p.produtos_Descricao )";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, "%" + fornecedor_RazaoSocial + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                pf = new Produto_Fornecedor();
                pf.getProduto().setProdutos_Descricao(rs.getString("p.produtos_Descricao"));
                lista.add(pf);
            }
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
        return lista; 
    }
}