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
import projeto.modelo.to.Funcionario;

/**
 * @author Thiago Evoa
 *
 */
public class RepositorioFuncionario implements IRepositorioFuncionario {

    private IGerenciadorConexao g;

    public RepositorioFuncionario() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Funcionario fu) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO funcionarios(enderecos_Codigo,funcionarios_Nome,Funcionarios_NumeroResidencia) VALUES(?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, fu.getEnderecos_Codigo());
            pstm.setString(2, fu.getFuncionarios_Nome());
            pstm.setString(3, fu.getFuncionarios_NumeroResidencia());
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
        String sqlExcluir = "DELETE FROM usuario WHERE (funcionarios_Codigo = ?)";
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
        String sqlExcluir = "DELETE FROM usuario WHERE (funcionarios_Codigo = ?)";
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
    public void alterar(Funcionario fu) throws RepositorioException, ConexaoException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE Funcionarios set ENDERECOS_CODIGO = ?, FUNCIONARIOS_NUMERORESIDENCIA = ? WHERE funcionarios_Codigo = ?";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setInt(1, fu.getEnderecos_Codigo());
            pstm.setString(2, fu.getFuncionarios_NumeroResidencia());
            pstm.setInt(3, fu.getFuncionarios_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Funcionario consultar(int funcionarios_Codigo) throws ConexaoException, RepositorioException {
        Funcionario fu = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT fu.funcionarios_Codigo,fu.enderecos_Codigo,fu.funcionarios_Nome,fu.Funcionarios_NumeroResidencia FROM Funcionarios AS fu WHERE (fu.funcionarios_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, funcionarios_Codigo );
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fu = new Funcionario();
                fu.setFuncionarios_Codigo(rs.getInt("fu.funcionarios_Codigo"));
                fu.setEnderecos_Codigo(rs.getInt("fu.enderecos_Codigo"));
                fu.setFuncionarios_Nome(rs.getString("fu.funcionarios_Nome"));
                fu.setFuncionarios_NumeroResidencia(rs.getString("fu.Funcionarios_NumeroResidencia"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return fu;
    }

    @Override
    public Funcionario consultar(String funcionarios_Nome) throws ConexaoException, RepositorioException {
        Funcionario fu = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT fu.funcionarios_Codigo,fu.enderecos_Codigo,fu.funcionarios_Nome,fu.Funcionarios_NumeroResidencia FROM Funcionarios AS fu WHERE (fu.funcionarios_Nome Like ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + funcionarios_Nome + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fu = new Funcionario();
                fu.setFuncionarios_Codigo(rs.getInt("fu.funcionarios_Codigo"));
                fu.setEnderecos_Codigo(rs.getInt("fu.enderecos_Codigo"));
                fu.setFuncionarios_Nome(rs.getString("fu.funcionarios_Nome"));
                fu.setFuncionarios_NumeroResidencia(rs.getString("fu.Funcionarios_NumeroResidencia"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return fu;
    }

    @Override
    public Collection<Funcionario> listar(int funcionarios_Codigo) throws ConexaoException, RepositorioException {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario fu;
        Connection c = g.conectar();
        String sqlLista = "SELECT funcionarios_Codigo,enderecos_Codigo,funcionarios_Nome,Funcionarios_NumeroResidencia FROM Funcionarios";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                fu = new Funcionario();
                fu.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                fu.setFuncionarios_Nome(rs.getString("funcionarios_Nome"));
                fu.setFuncionarios_NumeroResidencia(rs.getString("funcionarios_NumeroResidencia"));
                lista.add(fu);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    public Collection<Funcionario> listar(String funcionarios_Nome) throws ConexaoException, RepositorioException {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario fu;
        Connection c = g.conectar();
        String sqlLista = "SELECT funcionarios_Codigo,enderecos_Codigo,funcionarios_Nome,Funcionarios_NumeroResidencia FROM Funcionarios";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                fu = new Funcionario();
                fu.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                fu.setFuncionarios_Nome(rs.getString("funcionarios_Nome"));
                fu.setFuncionarios_NumeroResidencia(rs.getString("funcionarios_NumeroResidencia"));
                lista.add(fu);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Collection<Funcionario> listarTudo() throws ConexaoException, RepositorioException {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario fu;
        Connection c = g.conectar();
        String sqlLista = "SELECT f.funcionarios_Codigo, f.enderecos_Codigo, e.Enderecos_Logradouro, e.Enderecos_CEP, f.funcionarios_Nome, f.Funcionarios_NumeroResidencia FROM Funcionarios as f INNER JOIN Enderecos as e ON f.enderecos_Codigo = e.enderecos_Codigo order by funcionarios_Nome";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                fu = new Funcionario();
                fu.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                fu.setFuncionarios_Nome(rs.getString("funcionarios_Nome"));
                fu.getEnderecos().setEnderecos_Logradouro(rs.getString("e.Enderecos_Logradouro"));
                fu.getEnderecos().setEnderecos_CEP(rs.getString("e.Enderecos_CEP"));
                fu.setFuncionarios_NumeroResidencia(rs.getString("funcionarios_NumeroResidencia"));
                lista.add(fu);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        } 
    }
}