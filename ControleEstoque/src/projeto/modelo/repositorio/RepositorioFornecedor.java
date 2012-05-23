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
import projeto.modelo.to.Fornecedor;

/**
 * @author Daniel
 */
public class RepositorioFornecedor implements IRepositorioFornecedor {

    private IGerenciadorConexao g;

    public RepositorioFornecedor() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Fornecedor f) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO fornecedores( FORNECEDORES_CNPJ, FORNECEDORES_RAZAOSOCIAL, FORNECEDORES_NUMERORESIDENCIA, ENDERECOS_CODIGO ) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setString(1, f.getFornecedores_CNPJ());
            pstm.setString(2, f.getFornecedores_RazaoSocial());
            pstm.setInt(3, f.getFornecedores_NumeroResidencia());
            pstm.setInt(4, f.getEnderecos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(int fornecedores_Codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Fornecedores WHERE ( fornecedores_Codigo = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, fornecedores_Codigo);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(String fornecedores_CNPJ) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Fornecedores WHERE ( fornecedores_CNPJ = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString(1, fornecedores_CNPJ);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Fornecedor f) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE fornecedores SET ENDERECOS_CODIGO = ?, FORNECEDORES_CNPJ = ?, FORNECEDORES_RAZAOSOCIAL = ?, FORNECEDORES_NUMERORESIDENCIA = ?, ENDERECOS_CODIGO = ? WHERE FORNECEDORES_CODIGO = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setInt(1, f.getEnderecos_Codigo());
            pstm.setString(2, f.getFornecedores_CNPJ());
            pstm.setString(3, f.getFornecedores_RazaoSocial());
            pstm.setInt(4, f.getFornecedores_NumeroResidencia());
            pstm.setInt(5, f.getEnderecos_Codigo());
            pstm.setInt(6, f.getFornecedores_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Fornecedor consultarRazaoSocial(String fornecedores_RazaoSocial) throws ConexaoException, RepositorioException {
        Fornecedor f = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT FORNECEDORES_CODIGO, ENDERECOS_CODIGO, FORNECEDORES_CNPJ, FORNECEDORES_RAZAOSOCIAL, FORNECEDORES_NUMERORESIDENCIA FROM fornecedores WHERE FORNECEDORES_RazaoSocial LIKE ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setString(1, fornecedores_RazaoSocial + "%");
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                f = new Fornecedor();
                f.setFornecedores_Codigo(rs.getInt("fornecedores_Codigo"));
                f.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                f.setFornecedores_CNPJ(rs.getString("fornecedores_CNPJ"));
                f.setFornecedores_RazaoSocial(rs.getString("fornecedores_RazaoSocial"));
                f.setFornecedores_NumeroResidencia(rs.getInt("fornecedores_NumeroResidencia"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return f;
    }

    @Override
    public Fornecedor consultarCNPJ(String fornecedores_CNPJ) throws ConexaoException, RepositorioException {
        Fornecedor f = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT FORNECEDORES_CODIGO, ENDERECOS_CODIGO, FORNECEDORES_CNPJ, FORNECEDORES_RAZAOSOCIAL, FORNECEDORES_NUMERORESIDENCIA FROM fornecedores WHERE FORNECEDORES_CNPJ = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setString(1, fornecedores_CNPJ);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                f = new Fornecedor();
                f.setFornecedores_Codigo(rs.getInt("fornecedores_Codigo"));
                f.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                f.setFornecedores_CNPJ(rs.getString("fornecedores_CNPJ"));
                f.setFornecedores_RazaoSocial(rs.getString("fornecedores_RazaoSocial"));
                f.setFornecedores_NumeroResidencia(rs.getInt("fornecedores_NumeroResidencia"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return f;
    }

    @Override
    public Collection<Fornecedor> listar(String fornecedores_CNPJ) throws ConexaoException, RepositorioException {
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        Fornecedor f;
        Connection c = g.conectar();
        String sqlLista = "SELECT f.fornecedores_Codigo, f.fornecedores_CNPJ, f.Fornecedores_RazaoSocial, f.fornecedores_NumeroResidencia, f.enderecos_Codigo from FORNECEDORES AS f ORDER BY f.fornecedores_Codigo";

        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                f = new Fornecedor();
                f.setFornecedores_Codigo(rs.getInt("fornecedores_Codigo"));
                f.setFornecedores_CNPJ(rs.getString("fornecedores_CNPJ"));
                f.setFornecedores_RazaoSocial(rs.getString("fornecedores_RazaoSocial"));
                f.setFornecedores_NumeroResidencia(rs.getInt("fornecedores_NumeroResidencia"));
                f.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                lista.add(f);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
}