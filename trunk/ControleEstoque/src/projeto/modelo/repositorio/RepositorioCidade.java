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
import projeto.modelo.to.Cidade;

/**
 * @author DANIEL VALENÇA
 *
 */
public class RepositorioCidade implements IRepositorioCidade {

    private IGerenciadorConexao g;

    public RepositorioCidade() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Cidade cd) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO Cidades( cidades_Nome ) VALUES( ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setString(1, cd.getCidades_Nome());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Cidade consultar(int cidades_Codigo) throws ConexaoException, RepositorioException {
        Cidade cd = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT cidades_Codigo, cidades_Nome FROM Cidades WHERE ( cidades_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setInt(1, cidades_Codigo);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                cd = new Cidade();
                cd.setCidades_Codigo(cidades_Codigo);
                cd.setCidades_Nome(rs.getString("cidades_Nome"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return cd;
    }

    @Override
    public Cidade consultar(String cidades_Nome) throws ConexaoException, RepositorioException {
        Cidade cd = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT cidades_Codigo, cidades_Nome FROM Cidades WHERE ( cidades_Nome LIKE ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setString(1, cidades_Nome + "%");
            ResultSet rs = pstm.executeQuery();
            /*
             * verifica se retornou algum registro e cria o Objeto
             */
            if (rs.next()) {
                cd = new Cidade();
                cd.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                cd.setCidades_Nome(rs.getString("cidades_Nome"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return cd;
    }

    @Override
    public void excluir(int cidades_Codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Cidades WHERE ( cidades_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, cidades_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(String cidades_Nome) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Cidades WHERE ( cidades_Nome LIKE ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString(1, cidades_Nome + "%");
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Cidade cd) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE cidades SET cidades_Nome = ? where cidades_Codigo = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, cd.getCidades_Nome());
            pstm.setInt(2, cd.getCidades_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
   public Collection<Cidade> listar() throws ConexaoException, RepositorioException {
        ArrayList<Cidade> lista = new ArrayList<Cidade>();
        Cidade cd;
        Connection c = g.conectar();
        String sqlLista = "SELECT cidades_Codigo,cidades_Nome FROM cidades ORDER BY cidades_Codigo";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                cd = new Cidade();
                cd.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                cd.setCidades_Nome(rs.getString("cidades_Nome"));
                lista.add(cd);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
}