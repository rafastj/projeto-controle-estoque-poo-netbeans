/**
 * 
 */
package projeto.modelo.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import projeto.conexao.GerenciadorConexao;
import projeto.conexao.IGerenciadorConexao;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.FormaPagamento;
/**
 * @author Bruno Pinheiro
 *
 */
public class RepositorioFormaPagamento implements IRepositorioFormaPagamento{
private IGerenciadorConexao g;
	
	public RepositorioFormaPagamento () {
		g = GerenciadorConexao.getInstancia();
	}
	public void salvar ( FormaPagamento fp ) throws ConexaoException, RepositorioException {
		Connection c = g.conectar();
		String sqlSalvar = "INSERT INTO FormaPagamento( formaPagamento_Descricao ) VALUES( ? )";
		try {
			PreparedStatement pstm = c.prepareStatement( sqlSalvar );
			pstm.setString( 1,fp.getFormaPagamento_Descricao() );
			pstm.executeUpdate();
            pstm.close();
		} catch ( SQLException ex ) {
			throw new RepositorioException ( ex.getMessage() );
		} finally {
			g.desconectar( c );
		}
	}
	
	
	public void excluir( int formaPagamento_Codigo ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM formaPagamento WHERE (formaPagamento_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt( 1, formaPagamento_Codigo );
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar( c );
        }
    }
	
	
    public void alterar(FormaPagamento fp ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE FormaPagamento SET formaPagamento_Descricao = ? WHERE formaPagamento_Codigo = ?";
        try {
        	PreparedStatement pstm = c.prepareStatement(sqlAlterar);
        	pstm.setString(1, fp.getFormaPagamento_Descricao());
        	pstm.setInt(2, fp.getFormaPagamento_Codigo());
        	pstm.executeUpdate();
        	pstm.close();
        } catch (SQLException ex){
        	throw new RepositorioException();
        } finally {
        	g.desconectar(c);
        }
    }

    public FormaPagamento consultarFormaPagamento(int formaPagamento_Codigo) throws ConexaoException, RepositorioException {
    	FormaPagamento fp = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT fp.formaPagamento_Codigo, fp.formaPagamento_Descricao FROM FormaPagamento AS fp WHERE ( fp.formaPagamento_Codigo = ? )";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt( 1, formaPagamento_Codigo );
            ResultSet rs = pstm.executeQuery();

            //verifica se retornou algum registro e cria o Objeto
            if( rs.next() ){
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo( formaPagamento_Codigo );
                fp.setFormaPagamento_Descricao( rs.getString( "fp.formaPagamentos_Descricao" ) );            
            }
        } catch( SQLException e ){
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return fp;
    }

    public FormaPagamento consultarFormaPagamento(String formaPagamento_Descricao) throws ConexaoException, RepositorioException {
    	FormaPagamento fp = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT s.segmentos_Codigo, s.segmentos_Descricao FROM Segmentos AS s WHERE ( s.segmentos_Descricao = ? )";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString( 1, formaPagamento_Descricao );
            ResultSet rs = pstm.executeQuery();

            /*verifica se retornou algum registro e cria o Objeto*/
            if( rs.next() ){
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo( rs.getInt( "fp.FormaPagamento_Codigo" ) );
                fp.setFormaPagamento_Descricao( rs.getString( "fp.FormaPagamento_Descricao" ) );            
            }
        } catch( SQLException e ){
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return fp;
    }
    
    
    public Collection<FormaPagamento> listarFormasPagamentos(String formaPagamento_Descricao) throws ConexaoException,RepositorioException {
        ArrayList <FormaPagamento> lista = new ArrayList <FormaPagamento>();
        FormaPagamento fp;
        Connection c = g.conectar();
        String sqlLista = "SELECT formaPagamento_Codigo,formaPagamento_Descricao FROM formaPagamento ORDER BY formaPagamentos_Codigo";
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while( rs.next() ){
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo( rs.getInt( "formaPagamento_Codigo" ) );
                fp.setFormaPagamento_Descricao( rs.getString( "formaPagamento_Descricao" ) );
                lista.add( fp );
            } return lista;
        } catch( SQLException e ) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar( c );
        }
    }

}