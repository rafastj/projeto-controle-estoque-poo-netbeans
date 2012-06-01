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
import projeto.modelo.to.Endereco;

/**
 * @author DANIEL VALENÇA
 */
public class RepositorioEndereco implements IRepositorioEndereco {

    private IGerenciadorConexao g;

    public RepositorioEndereco() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(Endereco end) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO Enderecos( enderecos_CEP, cidades_Codigo, enderecos_Logradouro ) VALUES( ?, ?, ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setString(1, end.getEnderecos_CEP());
            pstm.setInt(2, end.getCidades_Codigo());
            pstm.setString(3, end.getEnderecos_Logradouro());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Endereco consultarLogradouro(String enderecos_Logradouro) throws ConexaoException, RepositorioException {
        Endereco end = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT ENDERECOS_CODIGO, ENDERECOS_CEP, CIDADES_CODIGO, ENDERECOS_LOGRADOURO FROM enderecos WHERE ( ENDERECOS_LOGRADOURO LIKE ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setString(1, enderecos_Logradouro + "%");
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return end;
    }

    @Override
    public Endereco consultarCep(String enderecos_CEP) throws ConexaoException, RepositorioException {
        Endereco end = null;
        Connection c = g.conectar();
        String sqlConsultar = "SELECT ENDERECOS_CODIGO, ENDERECOS_CEP, CIDADES_CODIGO, ENDERECOS_LOGRADOURO FROM enderecos WHERE ( ENDERECOS_CEP = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsultar);
            pstm.setString(1, enderecos_CEP);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria o Objeto
            if (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return end;
    }

    @Override
    public void excluir(String enderecos_Cep) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM Enderecos WHERE ( enderecos_Cep = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setString(1, enderecos_Cep);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Endereco end) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE enderecos SET ENDERECOS_CEP = ?, ENDERECOS_LOGRADOURO = ?, CIDADES_CODIGO = ? WHERE ENDERECOS_CODIGO = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setString(1, end.getEnderecos_CEP());
            pstm.setString(2, end.getEnderecos_Logradouro());
            pstm.setInt(3, end.getCidades_Codigo());
            pstm.setInt(4, end.getEnderecos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public Collection<Endereco> listarTudo() throws ConexaoException, RepositorioException {
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        Endereco end;
        Connection c = g.conectar();
        String sqlLista = "SELECT end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome from Enderecos as end inner join Cidades as cd On end.cidades_Codigo = cd.cidades_Codigo order by end.enderecos_CEP";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                end.setCidades_Nome(rs.getString("cidades_Nome"));
                lista.add(end);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    @Override
    public Collection<Endereco> listarEndCEP(String enderecos_CEP) throws ConexaoException, RepositorioException {
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        Endereco end;
        Connection c = g.conectar();
        String sqlLista = "SELECT end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome from Enderecos as end inner join Cidades as cd On end.cidades_Codigo = cd.cidades_Codigo where end.Enderecos_CEP = ? ORDER BY end.enderecos_CEP";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, enderecos_CEP);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                end.setCidades_Nome(rs.getString("cidades_Nome"));
                lista.add(end);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    @Override
    public Collection<Endereco> listarEndLog(String enderecos_Logradouro) throws ConexaoException, RepositorioException {
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        Endereco end;
        Connection c = g.conectar();
        String sqlLista = "SELECT end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome from Enderecos as end inner join Cidades as cd On end.cidades_Codigo = cd.cidades_Codigo where end.Enderecos_Logradouro LIKE ? ORDER BY end.enderecos_CEP";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, "%"+enderecos_Logradouro+"%");
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                end.setCidades_Nome(rs.getString("cidades_Nome"));
                lista.add(end);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    @Override
    public Collection<Endereco> listarEndCidade(String cidades_Nome) throws ConexaoException, RepositorioException {
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        Endereco end;
        Connection c = g.conectar();
        String sqlLista = "SELECT end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome from Enderecos as end inner join Cidades as cd On end.cidades_Codigo = cd.cidades_Codigo where cd.cidades_Nome = ? ORDER BY end.enderecos_CEP";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, cidades_Nome);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                end = new Endereco();
                end.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                end.setEnderecos_CEP(rs.getString("enderecos_CEP"));
                end.setEnderecos_Logradouro(rs.getString("enderecos_Logradouro"));
                end.setCidades_Codigo(rs.getInt("cidades_Codigo"));
                end.setCidades_Nome(rs.getString("cidades_Nome"));
                lista.add(end);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
}