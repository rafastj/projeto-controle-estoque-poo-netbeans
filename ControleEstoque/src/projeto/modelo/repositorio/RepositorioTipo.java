/**
 *
 */
package projeto.modelo.repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import projeto.conexao.GerenciadorConexao;
import projeto.conexao.IGerenciadorConexao;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Tipo;

/**
 * @author Felipe Carlos
 *
 */
public class RepositorioTipo implements IRepositorioTipo {

    	private IGerenciadorConexao g;
	
	public RepositorioTipo () {
		g = GerenciadorConexao.getInstancia();
	}
	public void salvar ( Tipo t ) throws ConexaoException, RepositorioException {
		Connection c = g.conectar();
		//String sqlSalvar = "INSERT INTO Tipos( tipos_Descricao ) VALUES( ? )";
		String sqlSalvar ="INSERT INTO `estoque`.`tipos` (`TIPOS_CODIGO` ,`TIPOS_DESCRICAO`)VALUES (?,?)";
		try {
			PreparedStatement pstm = c.prepareStatement( sqlSalvar );
			pstm.setInt( 1,t.getTipos_Codigo() );
			pstm.setString( 2,t.getTipos_Descricao() );
			pstm.executeUpdate();
            pstm.close();
		} catch ( SQLException ex ) {
			throw new RepositorioException ( ex.getMessage() );
		} finally {
			g.desconectar( c );
		}
	}
	

	public void excluirTipos( int tipos_Codigo ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Tipos WHERE (tipos_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt( 1, tipos_Codigo );
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar( c );
        }
    }
	
	public void excluirTipos( String tipos_Descricao ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Tipos WHERE (tipos_Descricao = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString( 1, tipos_Descricao );
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar( c );
        }
    }
	
	
    public void alterar(Tipo t) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE Tipos SET tipos_Descricao = ? WHERE tipos_Codigo=?";
        try {
        	PreparedStatement pstm = c.prepareStatement(sqlAlterar);
        	pstm.setString(1, t.getTipos_Descricao());
        	pstm.setInt(2, t.getTipos_Codigo());
        	pstm.executeUpdate();
        	pstm.close();
        } catch (SQLException ex){
        	throw new RepositorioException();
        } finally {
        	g.desconectar(c);
        }
    }

    public Tipo consultarTipos( int tipos_Codigo ) throws ConexaoException, RepositorioException {
    	Tipo t = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT t.tipos_Codigo, t.tipos_Descricao FROM Tipos AS t WHERE ( t.tipos_Codigo = ? )";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt( 1, tipos_Codigo );
            ResultSet rs = pstm.executeQuery();

            //verifica se retornou algum registro e cria o Objeto
            if( rs.next() ){
                t = new Tipo();
                t.setTipos_Codigo( tipos_Codigo );
                t.setTipos_Descricao( rs.getString( "t.tipos_Descricao" ) );            
            }
        } catch( SQLException e ){
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return t;
    }
    

    public Tipo consultarTipos( String tipos_Descricao ) throws ConexaoException, RepositorioException {
    	Tipo t = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT t.tipos_Codigo, t.tipos_Descricao FROM Tipos AS t WHERE ( t.tipos_Descricao = ? )";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString( 1, tipos_Descricao );
            ResultSet rs = pstm.executeQuery();

            /*verifica se retornou algum registro e cria o Objeto*/
            if( rs.next() ){
                t = new Tipo();
                t.setTipos_Codigo( rs.getInt( "t.tipos_Codigo" ) );
                t.setTipos_Descricao( rs.getString( "t.tipos_Descricao" ) );            
            }
        } catch( SQLException e ){	
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return t;
    }
    
    
    public Collection<Tipo> listarTipo() throws ConexaoException,RepositorioException {
        ArrayList <Tipo> lista = new ArrayList <Tipo>();
        Tipo t;
        Connection c = g.conectar();
        String sqlLista = "SELECT tipos_Codigo,tipos_Descricao FROM tipos ORDER BY tipos_Codigo";
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while( rs.next() ){
                t = new Tipo();
                t.setTipos_Codigo( rs.getInt( "tipos_Codigo" ) );
                t.setTipos_Descricao( rs.getString( "tipos_Descricao" ) );
                lista.add( t );
            } return lista;
        } catch( SQLException e ) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar( c );
        }
    }
    
    public Collection<Tipo> listarTipoDescricao(String tipos_Descricao) throws ConexaoException,RepositorioException {
        ArrayList <Tipo> lista = new ArrayList <Tipo>();
        Tipo t;
        Connection c = g.conectar();
        String sqlLista = "SELECT tipos_Codigo,tipos_Descricao FROM tipos where tipos_Descricao LIKE ? ORDER BY tipos_Codigo";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, tipos_Descricao+"%");
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while( rs.next() ){
                t = new Tipo();
                t.setTipos_Codigo( rs.getInt( "tipos_Codigo" ) );
                t.setTipos_Descricao( rs.getString( "tipos_Descricao" ) );
                lista.add( t );
            } return lista;
        } catch( SQLException e ) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar( c );
        }
    }
    public int Codigo()throws ConexaoException,RepositorioException {
    	int cod = 0;
    	Connection c = g.conectar();
		String sqlAuto="SELECT Auto_increment as tipos_codigo FROM information_schema.tables WHERE table_name='tipos'";
        try {
        	Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlAuto);
            while( rs.next() ){
                cod= rs.getInt( "tipos_codigo" );
                
            	}return cod;
            } catch( SQLException e ) {
                throw new RepositorioException(e);
            } finally {
                g.desconectar( c );
            }
        }
}