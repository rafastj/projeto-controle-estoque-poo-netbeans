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
import projeto.modelo.to.Usuario;

/**
 * @author Thiago Evoa
 */
public class RepositorioUsuario implements IRepositorioUsuario {

    private IGerenciadorConexao g;

    public RepositorioUsuario() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Usuario us) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO usuarios(funcionarios_Codigo,usuarios_Login,usuarios_Senha) VALUES(?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, us.getFuncionarios_Codigo());
            pstm.setString(2, us.getUsuarios_Login());
            pstm.setString(3, us.getUsuarios_Senha());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(int funcionarios_Codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM usuarios WHERE (funcionarios_Codigo = ?)";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, funcionarios_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(String funcionarios_Nome) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM usuarios WHERE (funcionarios_Codigo = ?)";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString(1, funcionarios_Nome);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Usuario us) throws RepositorioException, ConexaoException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE Usuarios set Usuarios_Login = ?,Usuarios_Senha = ? WHERE funcionarios_Codigo = ?";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, us.getUsuarios_Login());
            pstm.setString(2, us.getUsuarios_Senha());
            pstm.setInt(3, us.getFuncionarios_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Usuario consultar(int funcionarios_Codigo) throws ConexaoException, RepositorioException {
        Usuario us = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT us.funcionarios_Codigo,us.usuarios_Login,us.usuarios_Senha FROM Usuarios AS us WHERE (us.funcionarios_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, funcionarios_Codigo );
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                us = new Usuario();
                us.setFuncionarios_Codigo(rs.getInt("us.funcionarios_Codigo"));
                us.setUsuarios_Login(rs.getString("us.usuarios_Login"));
                us.setUsuarios_Senha(rs.getString("us.usuarios_Senha"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return us;
    }

    @Override
    public Usuario consultar(String funcionarios_Nome) throws ConexaoException, RepositorioException {
        Usuario us = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT us.funcionarios_Codigo,us.usuarios_Login,us.usuarios_Senha FROM Usuarios AS us WHERE (us.usuarios_Login LIKE ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, "%"+funcionarios_Nome+"%");
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                us = new Usuario();
                us.setFuncionarios_Codigo(rs.getInt("us.funcionarios_Codigo"));
                us.setUsuarios_Login(rs.getString("us.usuarios_Login"));
                us.setUsuarios_Senha(rs.getString("us.usuarios_Senha"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return us;
    }

    @Override
    public Collection<Usuario> listar(int funcionarios_Codigo) throws ConexaoException, RepositorioException {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Usuario us;
        Connection c = g.conectar();
        String sqlLista = "SELECT funcionarios_Codigo,usuarios_Login,usuarios_Senha FROM Usuarios";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                us = new Usuario();
                us.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                us.setUsuarios_Login(rs.getString("usuarios_Login"));
                us.setUsuarios_Senha(rs.getString("usuarios_Senha"));
                lista.add(us);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Collection<Usuario> listar(String funcionarios_Nome) throws ConexaoException, RepositorioException {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Usuario us;
        Connection c = g.conectar();
        String sqlLista = "SELECT funcionarios_Codigo,usuarios_Login,usuarios_Senha FROM Usuarios";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                us = new Usuario();
                us.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                us.setUsuarios_Login(rs.getString("usuarios_Login"));
                us.setUsuarios_Senha(rs.getString("usuarios_Senha"));
                lista.add(us);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    public Collection<Usuario> listarTodosUsuario() throws ConexaoException, RepositorioException {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Usuario us;
        Connection c = g.conectar();
        String sqlLista = "SELECT us.funcionarios_Codigo, f.funcionarios_Nome,us.usuarios_Login FROM Usuarios AS us INNER JOIN Funcionarios as f ON f.funcionarios_Codigo = us.Funcionarios_Codigo order by f.funcionarios_Nome";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                us = new Usuario();
                us.setFuncionarios_Codigo(rs.getInt("us.funcionarios_Codigo"));
                us.getFuncionarios().setFuncionarios_Nome(rs.getString("f.funcionarios_Nome"));
                us.setUsuarios_Login(rs.getString("us.usuarios_Login"));            
                lista.add(us);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
}