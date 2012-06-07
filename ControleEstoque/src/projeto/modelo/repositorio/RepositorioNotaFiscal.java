/**
 *
 */
package projeto.modelo.repositorio;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import projeto.conexao.GerenciadorConexao;
import projeto.conexao.IGerenciadorConexao;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.NotaFiscal;

/**
 * @author Thiago Evoa
 *
 */
public class RepositorioNotaFiscal implements IRepositorioNotaFiscal {

    private IGerenciadorConexao g;

    public RepositorioNotaFiscal() {
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(NotaFiscal nf) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlSalvar = "INSERT INTO NotasFiscal(clientes_Codigo,funcionarios_Codigo,formasPagamento_Codigo,notasFiscal_DataEmissao) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvar);
            pstm.setInt(1, nf.getClientes_Codigo());
            pstm.setInt(2, nf.getFuncionarios_Codigo());
            pstm.setInt(3, nf.getFormasPagamento_Codigo());
            //converter a data para string no formato do banco!
            SimpleDateFormat esse = new SimpleDateFormat("yyyy_MM_dd");  
            String dataConvertida = esse.format(nf.getNotasFiscal_DataEmissao());  
            pstm.setString(4, dataConvertida);
            
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(NotaFiscal nf) throws RepositorioException, ConexaoException {
        Connection c = g.conectar();
        String sqlAlterar = "UPDATE NotasFiscal set (?,?) WHERE notasFiscal_Numero (?)";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setInt(1, nf.getFormasPagamento_Codigo());
            pstm.setInt(2, nf.getClientes_Codigo());
            pstm.setInt(3, nf.getNotasFiscal_Numero());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void cancelar(int notasFiscal_Numero) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlCancelar = "DELETE FROM NotasFiscal WHERE (notasFiscal_Numero = ?)";
        try {
            java.sql.PreparedStatement pstm = c.prepareStatement(sqlCancelar);
            pstm.setInt(1, notasFiscal_Numero);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public NotaFiscal consultar(int notasFiscal_Numero) throws ConexaoException, RepositorioException {
        NotaFiscal nf = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT nf.notasfiscal_Numero,nf.clientes_Codigo,nf.funcionarios_Codigo,nf.formasPagamento_Codigo,nf.notasFiscal_ValorNotaFiscal,nf.notasFiscal_DataEmissao,nf.notasFiscal_Status FROM NotasFiscal AS nf WHERE (nf.notasFiscal_Numero = ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, notasFiscal_Numero);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nf = new NotaFiscal();
                nf.setNotasFiscal_Numero(rs.getInt("nf.notasfiscal_Numero"));
                nf.setClientes_Codigo(rs.getInt("nf.clientes_Codigo"));
                nf.setFuncionarios_Codigo(rs.getInt("nf.funcionarios_Codigo"));
                nf.setFormasPagamento_Codigo(rs.getInt("nf.formasPagamento_Codigo"));
                nf.setNotasFiscal_ValorNotaFiscal(rs.getDouble("nf.notasFiscal_ValorNotaFiscal"));
                nf.setNotasFiscal_DataEmissao(rs.getDate("nf.notasFiscal_DataEmissao"));
                nf.setNotasFiscal_Status(rs.getBoolean("nf.notasFiscal_Status"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return nf;
    }

    @Override
    public Collection<NotaFiscal> listar(int notasFiscal_Numero) throws ConexaoException, RepositorioException {
        ArrayList<NotaFiscal> lista = new ArrayList<NotaFiscal>();
        NotaFiscal nf;
        Connection c = g.conectar();
        String sqlLista = "SELECT notasfiscal_Numero,clientes_Codigo,funcionarios_Codigo,formasPagamento_Codigo,notasFiscal_ValorNotaFiscal,notasFiscal_DataEmissao,notasFiscal_Status FROM Funcionarios";
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            while (rs.next()) {
                nf = new NotaFiscal();
                nf.setNotasFiscal_Numero(rs.getInt("notasFiscal_Numero"));
                nf.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                nf.setFuncionarios_Codigo(rs.getInt("funcionarios_Codigo"));
                nf.setFormasPagamento_Codigo(rs.getInt("formasPagamento_codigo"));
                nf.setNotasFiscal_ValorNotaFiscal(rs.getDouble("notasFiscal_ValorNotaFiscal"));
                nf.setNotasFiscal_DataEmissao(rs.getDate("notasFiscal_DataEmissao"));
                nf.setNotasFiscal_Status(rs.getBoolean("NotasFiscal_Status"));
                lista.add(nf);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
    
    /**
     * Consultar a Ultima nota do Cliente
     * @param Cliente_Codigo
     * @return
     * @throws ConexaoException
     * @throws RepositorioException 
     */
    @Override
    public NotaFiscal consultarUltimaNota(int Cliente_Codigo) throws ConexaoException, RepositorioException {
        NotaFiscal nf = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT notasfiscal_Numero FROM NotasFiscal Order By (clientes_Codigo = ? ) DESC LIMIT 1 ";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, Cliente_Codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nf = new NotaFiscal();
                nf.setNotasFiscal_Numero(rs.getInt("notasfiscal_Numero"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return nf;
    }
}