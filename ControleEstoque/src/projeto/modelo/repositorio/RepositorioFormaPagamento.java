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
import projeto.modelo.to.FormaPagamento;

/**
 * @author Bruno Pinheiro
 */
public class RepositorioFormaPagamento implements IRepositorioFormaPagamento {

    private IGerenciadorConexao g;

    public RepositorioFormaPagamento() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(FormaPagamento fp) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO FormasPagamento( formasPagamento_Descricao ) VALUES( ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setString(1, fp.getFormaPagamento_Descricao());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(int formaPagamento_Codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM formasPagamento WHERE (formasPagamento_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, formaPagamento_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(FormaPagamento fp) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE formasPagamento SET formasPagamento_Descricao = ? WHERE formasPagamento_Codigo = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, fp.getFormaPagamento_Descricao());
            pstm.setInt(2, fp.getFormaPagamento_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public FormaPagamento consultarFormaPagamento(int formaPagamento_Codigo) throws ConexaoException, RepositorioException {
        FormaPagamento fp = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT fp.formasPagamento_Codigo, fp.formasPagamento_Descricao FROM FormasPagamento AS fp WHERE ( fp.formasPagamento_Codigo = ? )";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, formaPagamento_Codigo);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo(formaPagamento_Codigo);
                fp.setFormaPagamento_Descricao(rs.getString("fp.formasPagamento_Descricao"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return fp;
    }

    @Override
    public FormaPagamento consultarFormaPagamento(String formaPagamento_Descricao) throws ConexaoException, RepositorioException {
        FormaPagamento fp = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT s.segmentos_Codigo, s.segmentos_Descricao FROM Segmentos AS s WHERE ( s.segmentos_Descricao = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, formaPagamento_Descricao);
            ResultSet rs = pstm.executeQuery();
            /*
             * verifica se retornou algum registro e cria o Objeto
             */
            if (rs.next()) {
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo(rs.getInt("fp.FormaPagamento_Codigo"));
                fp.setFormaPagamento_Descricao(rs.getString("fp.FormaPagamento_Descricao"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return fp;
    }

    @Override
    public Collection<FormaPagamento> listarFormasPagamentos() throws ConexaoException, RepositorioException {
        ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
        FormaPagamento fp;
        Connection c = g.conectar();
        String sqlLista = "SELECT formasPagamento_Codigo,formasPagamento_Descricao FROM formasPagamento ORDER BY formasPagamento_Codigo";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo(rs.getInt("formasPagamento_Codigo"));
                fp.setFormaPagamento_Descricao(rs.getString("formasPagamento_Descricao"));
                lista.add(fp);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    @Override
     public Collection<FormaPagamento> listarFormasPagamentosDescricao(String formaPagamento_Descricao) throws ConexaoException,RepositorioException {
        ArrayList <FormaPagamento> lista = new ArrayList <FormaPagamento>();
        FormaPagamento fp;
        Connection c = g.conectar();
        String sqlLista = "SELECT formasPagamento_Codigo,formasPagamento_Descricao FROM formasPagamento where formasPagamento_Descricao LIKE ? ORDER BY formasPagamento_Codigo";
        try{
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, formaPagamento_Descricao+"%");
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while( rs.next() ){
                fp = new FormaPagamento();
                fp.setFormaPagamento_Codigo( rs.getInt( "formasPagamento_Codigo" ) );
                fp.setFormaPagamento_Descricao( rs.getString( "formasPagamento_Descricao" ) );
                lista.add( fp );
            } return lista;
        } catch( SQLException e ) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar( c );
        }
    }
    
    public int CodigoFormaPagamento()throws ConexaoException,RepositorioException {
    	int codFormaPagamento = 0;
    	Connection c = g.conectar();
		String sqlAuto="SELECT Auto_increment as formaspagamento_codigo FROM information_schema.tables WHERE table_name='formaspagamento'";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlAuto);
            while( rs.next() ){
                codFormaPagamento = rs.getInt( "formasPagamento_codigo" );
                
            	}return codFormaPagamento;
            } catch( SQLException e ) {
                throw new RepositorioException(e);
            } finally {
                g.desconectar( c );
            }
        }
}