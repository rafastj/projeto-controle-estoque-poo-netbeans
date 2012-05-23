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
import projeto.modelo.to.Segmento;

/**
 * @author Bruno Pinheiro
 *
 */
public class RepositorioSegmento implements IRepositorioSegmento {

    private IGerenciadorConexao g;

    public RepositorioSegmento() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Segmento s) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO Segmentos( segmentos_Descricao ) VALUES( ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setString(1, s.getSegmentos_Descricao());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(int segmentos_Codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM segmentos WHERE (segmentos_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, segmentos_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Segmento s) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE Segmentos SET segmentos_Descricao = ? WHERE segmentos_Codigo = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, s.getSegmentos_Descricao());
            pstm.setInt(2, s.getSegmentos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Segmento consultarSegmentos(int segmentos_Codigo) throws ConexaoException, RepositorioException {
        Segmento s = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT s.segmentos_Codigo, s.segmentos_Descricao FROM Segmentos AS s WHERE ( s.segmentos_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, segmentos_Codigo);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                s = new Segmento();
                s.setSegmentos_Codigo(segmentos_Codigo);
                s.setSegmentos_Descricao(rs.getString("s.segmentos_Descricao"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return s;
    }

    @Override
    public Segmento consultarSegmentos(String segmentos_Descricao) throws ConexaoException, RepositorioException {
        Segmento s = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT s.segmentos_Codigo, s.segmentos_Descricao FROM Segmentos AS s WHERE ( s.segmentos_Descricao = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, segmentos_Descricao);
            ResultSet rs = pstm.executeQuery();
            /*
             * verifica se retornou algum registro e cria o Objeto
             */
            if (rs.next()) {
                s = new Segmento();
                s.setSegmentos_Codigo(rs.getInt("s.segmentos_Codigo"));
                s.setSegmentos_Descricao(rs.getString("s.segmentos_Descricao"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return s;
    }

    @Override
    public Collection<Segmento> listarSegmentos(String segmentos_Descricao) throws ConexaoException, RepositorioException {
        ArrayList<Segmento> lista = new ArrayList<Segmento>();
        Segmento s;
        Connection c = g.conectar();
        String sqlLista = "SELECT segmentos_Codigo,segmentos_Descricao FROM segmentos ORDER BY segmentos_Codigo";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                s = new Segmento();
                s.setSegmentos_Codigo(rs.getInt("segmentos_Codigo"));
                s.setSegmentos_Descricao(rs.getString("segmentos_Descricao"));
                lista.add(s);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
}