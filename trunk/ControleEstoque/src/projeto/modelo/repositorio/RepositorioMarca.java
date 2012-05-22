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
import projeto.modelo.to.Marca;
/**
 * @author Felipe Carlos
 *
 */
public class RepositorioMarca implements IRepositorioMarca{
    
    private IGerenciadorConexao g;
	
    public RepositorioMarca () {
        g = GerenciadorConexao.getInstancia();
    }
    
    @Override
    public void salvar ( Marca m ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO Marcas( marcas_Descricao ) VALUES( ? )";
        try {
            PreparedStatement pstm = c.prepareStatement( sqlSalvar );
            pstm.setString( 1,m.getMarcas_Descricao() );
            pstm.executeUpdate();
            pstm.close();
        } catch ( SQLException ex ) {
            throw new RepositorioException ( ex.getMessage() );
        } finally {
            g.desconectar( c );
        }
    }
	
	
    @Override
    public void excluirMarcas( String marcas_Descricao ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Marcas WHERE (marcas_Descricao = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString( 1, marcas_Descricao );
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar( c );
        }
    }
	
    @Override
    public void excluirMarcas( int marcas_Codigo ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Marcas WHERE (marcas_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt( 1, marcas_Codigo );
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar( c );
        }
    }
	
    @Override
    public void alterar(Marca m ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE Marcas SET marcas_Descricao = ? WHERE marcas_Codigo = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, m.getMarcas_Descricao());
            pstm.setInt(2, m.getMarcas_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex){
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Marca consultarMarcas( int marcas_Codigo ) throws ConexaoException, RepositorioException {
    	Marca m = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT m.marcas_Codigo, m.marcas_Descricao FROM Marcas AS m WHERE ( m.marcas_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt( 1, marcas_Codigo );
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if( rs.next() ){
                m = new Marca();
                m.setMarcas_Codigo( marcas_Codigo );
                m.setMarcas_Descricao( rs.getString( "m.marcas_Descricao" ) );            
            }
        } catch( SQLException e ){
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return m;
    }

    @Override
    public Marca consultarMarcas( String marcas_Descricao ) throws ConexaoException, RepositorioException {
    	Marca m = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT m.marcas_Codigo, m.marcas_Descricao FROM Marcas AS m WHERE ( m.marcas_Descricao = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString( 1, marcas_Descricao );
            ResultSet rs = pstm.executeQuery();
            /*verifica se retornou algum registro e cria o Objeto*/
            if( rs.next() ){
                m = new Marca();
                m.setMarcas_Codigo( rs.getInt( "m.marcas_Codigo" ) );
                m.setMarcas_Descricao( rs.getString( "m.marcas_Descricao" ) );            
            }
        } catch( SQLException e ){
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar( c );
        } return m;
    }
    
    @Override
    public Collection<Marca> listarMarca(String marcas_Descricao) throws ConexaoException,RepositorioException {
        ArrayList <Marca> lista = new ArrayList <Marca>();
        Marca m;
        Connection c = g.conectar();
        String sqlLista = "SELECT marcas_Codigo,marcas_Descricao FROM marcas ORDER BY marcas_Codigo";
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while( rs.next() ){
                m = new Marca();
                m.setMarcas_Codigo( rs.getInt( "marcas_Codigo" ) );
                m.setMarcas_Descricao( rs.getString( "marcas_Descricao" ) );
                lista.add( m );
            } return lista;
        } catch( SQLException e ) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar( c );
        }
    }
}