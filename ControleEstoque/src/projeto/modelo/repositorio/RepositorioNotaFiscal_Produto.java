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
import projeto.modelo.to.NotaFiscal;
import projeto.modelo.to.NotaFiscal_Produto;
import projeto.modelo.to.Produto;

/**
 * @author diego
 *
 */
public class RepositorioNotaFiscal_Produto implements IRepositorioNotaFiscal_Produto {
    //variavel g responsavel pela chamada da conexao
    private IGerenciadorConexao g;

    //atribuição a g da instancia da conexao
    public RepositorioNotaFiscal_Produto (){
            g = GerenciadorConexao.getInstancia();
    }

    /**
    * Implementação padão DAO para Salvar o produto na tabela produto
    */
    @Override
    public void salvar (NotaFiscal_Produto np) throws ConexaoException,RepositorioException{
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlSalvar = "INSERT INTO notasfiscal_produtos(PRODUTOS_CODIGO, NOTASFISCAL_NUMERO, NOTASFISCALPRODUTOS_QUANTIDADE, NOTASFISCALPRODUTOS_VALORQUANTIDADE) VALUES (?,?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, np.getProdutos_Codigo());
            pstm.setInt(2, np.getNotasFiscal_Numero());
            pstm.setInt(3, np.getNotasFiscalProdutos_Quantidade());
            pstm.setDouble(4, np.getNotasFiscalProdutos_ValorQuantidade());
            pstm.executeUpdate();
            pstm.close();
        }catch (SQLException ex){
            throw new RepositorioException( ex.getMessage() );
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public void atualizarProdutoQtde (Produto p) throws ConexaoException, RepositorioException{
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlAtualizar = "UPDATE produtos SET PRODUTOS_QUANTIDADE = ? WHERE PRODUTOS_CODIGO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlAtualizar);
            pstm.setInt(1, p.getProdutos_Quantidade());
            pstm.setInt(2, p.getProdutos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        }catch (SQLException ex){
            throw new RepositorioException(ex.getMessage());
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public void atualizarNotaFiscalValordaNota (NotaFiscal np) throws ConexaoException, RepositorioException{
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlAtualizar = "UPDATE notasfiscal SET  NOTASFISCAL_VALORNOTAFISCAL = ? WHERE NOTASFISCAL_NUMERO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlAtualizar);
            pstm.setDouble(1, np.getNotasFiscal_ValorNotaFiscal());
            pstm.setInt(2, np.getNotasFiscal_Numero());
            pstm.executeUpdate();
            pstm.close();
        }catch (SQLException ex){
            throw new RepositorioException(ex.getMessage());
        }finally{
            g.desconectar(c);
        }
    }

    //Consultar quais produto fazem parte da Nota
    @Override
    public NotaFiscal_Produto consultarNotaFiscal_Numero (int NotaFiscal_Numero) throws ConexaoException, RepositorioException{
        NotaFiscal_Produto np = null;
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlConsultar = "SELECT np.NOTASFISCAL_NUMERO, np.PRODUTOS_CODIGO, p.PRODUTOS_DESCRICAO, np.NOTASFISCALPRODUTOS_QUANTIDADE, np.NOTASFISCALPRODUTOS_VALORQUANTIDADE FROM notasfiscal_produtos as np INNER JOIN Produtos p ON np.Produtos_Codigo = p.Produtos_Codigo WHERE np.NOTASFISCAL_NUMERO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setInt(1, NotaFiscal_Numero);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                np = new NotaFiscal_Produto();
                np.setNotasFiscal_Numero( rs.getInt("np.NOTASFISCAL_NUMERO"));
                np.setProdutos_Codigo( rs.getInt("np.PRODUTOS_CODIGO"));
                np.getProduto().setProdutos_Descricao( rs.getString("p.PRODUTOS_DESCRICAO"));
                np.setNotasFiscalProdutos_Quantidade( rs.getInt("np.NOTASFISCALPRODUTOS_QUANTIDADE"));
                np.setNotasFiscalProdutos_ValorQuantidade( rs.getDouble("np.NOTASFISCALPRODUTOS_VALORQUANTIDADE"));
            }
        }catch (SQLException ex){
            throw new RepositorioException(ex.getMessage());
        }finally{
            g.desconectar(c);
        }
        return np;
    }

    @Override
    public NotaFiscal_Produto consultarNotaFiscal_Produto (int NotaFiscal_Numero, int Produtos_Codigo) throws ConexaoException, RepositorioException{
        NotaFiscal_Produto np = null;
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlConsultar = "SELECT np.NOTASFISCAL_NUMERO, np.PRODUTOS_CODIGO, p.PRODUTOS_DESCRICAO, np.NOTASFISCALPRODUTOS_QUANTIDADE, np.NOTASFISCALPRODUTOS_VALORQUANTIDADE FROM notasfiscal_produtos as np INNER JOIN Produtos p ON np.Produtos_Codigo = p.Produtos_Codigo WHERE np.NOTASFISCAL_NUMERO = ? AND p.Produtos_Codigo = ? ";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setInt(1, NotaFiscal_Numero);
            pstm.setInt(2, Produtos_Codigo);
            ResultSet rs = pstm.executeQuery();

            if(rs.next()){
                np = new NotaFiscal_Produto();
                np.setNotasFiscal_Numero( rs.getInt("np.NOTASFISCAL_NUMERO"));
                np.setProdutos_Codigo( rs.getInt("np.PRODUTOS_CODIGO"));
                np.getProduto().setProdutos_Descricao( rs.getString("p.PRODUTOS_DESCRICAO"));
                np.setNotasFiscalProdutos_Quantidade( rs.getInt("np.NOTASFISCALPRODUTOS_QUANTIDADE"));
                np.setNotasFiscalProdutos_ValorQuantidade( rs.getDouble("np.NOTASFISCALPRODUTOS_VALORQUANTIDADE"));
            }
        }catch (SQLException ex){
            throw new RepositorioException(ex.getMessage());
        }finally{
            g.desconectar(c);
        }
        return np;
    }

    /**
    * EXCLUIR o vinculo da Nota Fiscal do Produto
    */
    @Override
    public void excluir (int NotaFiscal_Numero, int Produtos_Codigo) throws ConexaoException, RepositorioException{
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlExcluir = "DELETE FROM notasfiscal_produtos WHERE NOTASFISCAL_NUMERO = ? AND PRODUTOS_CODIGO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, NotaFiscal_Numero);
            pstm.setInt(2, Produtos_Codigo);
            pstm.executeUpdate();
            pstm.close();
        }catch (SQLException ex){
            throw new RepositorioException( ex.getMessage());
        }finally{
            g.desconectar(c);
        }
    }

    /**
    * LISTAR todos os PRODUTOS vinculados a tal NOTA FISCAL
    */
    @Override
    public Collection <NotaFiscal_Produto> lista (int NotaFiscal_Numero) throws ConexaoException, RepositorioException{
        // criar variavel array list
        ArrayList<NotaFiscal_Produto> lista = new ArrayList<NotaFiscal_Produto>();
        NotaFiscal_Produto np;
        //conectar com o banco de dados
        Connection c = g.conectar();
        String sqlLista = "SELECT np.NOTASFISCAL_NUMERO, np.PRODUTOS_CODIGO, p.PRODUTOS_DESCRICAO, np.NOTASFISCALPRODUTOS_QUANTIDADE, np.NOTASFISCALPRODUTOS_VALORQUANTIDADE FROM notasfiscal_produtos as np INNER JOIN Produtos p ON np.Produtos_Codigo = p.Produtos_Codigo WHERE np.NOTASFISCAL_NUMERO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setInt(1, NotaFiscal_Numero);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                np = new NotaFiscal_Produto();
                np.setNotasFiscal_Numero( rs.getInt("np.NOTASFISCAL_NUMERO"));
                np.setProdutos_Codigo( rs.getInt("np.PRODUTOS_CODIGO"));
                np.getProduto().setProdutos_Descricao( rs.getString("p.PRODUTOS_DESCRICAO"));
                np.setNotasFiscalProdutos_Quantidade( rs.getInt("np.NOTASFISCALPRODUTOS_QUANTIDADE"));
                np.setNotasFiscalProdutos_ValorQuantidade( rs.getDouble("np.NOTASFISCALPRODUTOS_VALORQUANTIDADE"));
                //adiciona a variavel array list
                lista.add(np);
            }
            return lista;
        }catch (SQLException ex){
            throw new RepositorioException( ex.getMessage() );
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public void atualizarNotaFiscal_Produto (NotaFiscal_Produto np) throws ConexaoException, RepositorioException{
        //conectar faz a conexão com o banco de dados
        Connection c = g.conectar();
        /**
        * variavel do tipo String da Instrução de inserção SQL
        */
        String sqlAtualizar = "UPDATE notasfiscal_produtos SET PRODUTOS_CODIGO = ? ,NOTASFISCALPRODUTOS_QUANTIDADE = ?,NOTASFISCALPRODUTOS_VALORQUANTIDADE = ? WHERE NOTASFISCAL_NUMERO = ? AND PRODUTOS_CODIGO = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlAtualizar);
            pstm.setInt(1, np.getProdutos_Codigo());
            pstm.setInt(2,np.getNotasFiscalProdutos_Quantidade());
            pstm.setDouble(3, np.getNotasFiscalProdutos_ValorQuantidade());
            pstm.setInt(4, np.getNotasFiscal_Numero());
            pstm.setInt(5, np.getProduto().getProdutos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        }catch (SQLException ex){
            throw new RepositorioException( ex.getMessage() );
        }finally{
            g.desconectar(c);
        }
    }
}