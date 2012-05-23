/**
 *
 */
package projeto.modelo.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import projeto.conexao.GerenciadorConexao;
import projeto.conexao.IGerenciadorConexao;
import projeto.erro.ConexaoException;
import projeto.erro.RepositorioException;
import projeto.modelo.to.Cliente;
import projeto.modelo.to.PessoaFisica;
import projeto.modelo.to.PessoaJuridica;

/**
 * @author Sandro
 *
 */
public class RepositorioCliente implements IRepositorioCliente {

    private IGerenciadorConexao g;

    public RepositorioCliente() {
        //cria uma instância do GerConexao para ser usada pelo Repositório
        g = GerenciadorConexao.getInstancia();
    }

    @Override
    public void salvar(PessoaFisica pf) throws ConexaoException, RepositorioException {
        //solicita uma conexão ao gerenciador
        Connection c = g.conectar();
        //cria e prepara a SQL para ser executada
        String sqlSalvarCli = "INSERT INTO clientes(enderecos_Codigo,clientes_NumeroResidencia,clientes_Tipo) VALUES(?,?,?)";
        String sqlSalvarPF = "INSERT INTO PessoasFisica(Clientes_Codigo,PessoasFisica_CPF,PessoasFisica_Nome,PessoasFisica_Sexo) VALUES(Last_Insert_ID(),?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvarCli);
            pstm.setInt(1, pf.getEnderecos_Codigo());
            pstm.setString(2, pf.getClientes_NumeroResidencia());
            pstm.setString(3, pf.getClientes_Tipo());
            pstm.executeUpdate();
            pstm.close();
            pstm = c.prepareStatement(sqlSalvarPF);
            pstm.setString(1, pf.getPessoasFisica_CPF());
            pstm.setString(2, pf.getPessoasFisica_Nome());
            pstm.setString(3, pf.getPessoasFisica_Sexo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void salvar(PessoaJuridica pj) throws ConexaoException, RepositorioException {
        //solicita uma conexão ao gerenciador
        Connection c = g.conectar();
        //cria e prepara a SQL para ser executada
        String sqlSalvarCli = "INSERT INTO clientes(enderecos_codigo,clientes_NumeroResidencia,clientes_Tipo) VALUES(?,?,?)";
        String sqlSalvarPJ = "INSERT INTO PessoasJuridica(Clientes_Codigo,PessoasJuridica_CNPJ,PessoasJuridica_RazaoSocial) VALUES(Last_Insert_ID(),?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlSalvarCli);
            pstm.setInt(1, pj.getEnderecos_Codigo());
            pstm.setString(2, pj.getClientes_NumeroResidencia());
            pstm.setString(3, pj.getClientes_Tipo());
            pstm.executeUpdate();
            pstm.close();
            pstm = c.prepareStatement(sqlSalvarPJ);
            pstm.setString(1, pj.getPessoasJuridica_CNPJ());
            pstm.setString(2, pj.getPessoasJuridica_RazaoSocial());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(PessoaFisica pf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(PessoaJuridica pf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluir = "DELETE FROM produto WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluir);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public PessoaFisica consultarPF(String pf_CPF) throws ConexaoException, RepositorioException {
        PessoaFisica pf = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT clientes_codigo, pessoasfisica_CPF, pessoasfisica_nome, pessoasfisica_sexo FROM pessoasfisica WHERE ( pessoasfisica_cpf = ? )";
        //"select PessoasFisica_CPF from PessoasFisicaliente_nome, c.clientemodelo from marcas as m innerjoin carros as c on Clientes.clientes_Codigo = PessoasFisica_Codigo(id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + pf_CPF + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setPessoasFisica_CPF(rs.getString("pessoasFisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pessoasfisica_Nome"));
                pf.setPessoasFisica_Sexo(rs.getString("pessoasfisica_sexo"));
                pf.setClientes_Codigo(rs.getInt("cliente_codigo"));
                //pf.setEnderecos_Codigo(rs.getInt("end_cod"));               
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return pf;
    }

    @Override
    public PessoaFisica consultarPF_Nome(String pf_Nome) throws ConexaoException, RepositorioException {
        PessoaFisica pf = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT clientes_codigo, pessoasfisica_CPF, pessoasfisica_nome, pessoasfisica_sexo FROM pessoasfisica WHERE ( pessoasfisica_Nome LIKE ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + pf_Nome + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setPessoasFisica_CPF(rs.getString("pessoasFisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pessoasfisica_Nome"));
                pf.setPessoasFisica_Sexo(rs.getString("pessoasfisica_sexo"));
                pf.setClientes_Codigo(rs.getInt("clientes_codigo"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return pf;
    }

    @Override
    public PessoaJuridica consultarPJ(String pj_CNPJ) throws ConexaoException, RepositorioException {
        PessoaJuridica pj = null;
        Connection c = g.conectar();
        String sqlConsulta = "select c.cliente_nome, c.clientemodelo from marcas as m innerjoin carros as c on c.marca = m.marca(id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + pj_CNPJ + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pj = new PessoaJuridica();
                pj.setPessoasJuridica_CNPJ(rs.getString("pessoasFisica_CPF"));
                pj.setPessoasJuridica_RazaoSocial(rs.getString("nome"));
                pj.setClientes_Tipo(rs.getString("status"));
                pj.setEnderecos_Codigo(rs.getInt("end_cod"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return pj;
    }

    @Override
    public PessoaJuridica consultarPJ_RSocial(String pj_RazaoSocial) throws ConexaoException, RepositorioException {
        PessoaJuridica pj = null;
        Connection c = g.conectar();
        String sqlConsulta = "select c.cliente_nome, c.clientemodelo from marcas as m innerjoin carros as c on c.marca = m.marca(id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + pj_RazaoSocial + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pj = new PessoaJuridica();
                pj.setPessoasJuridica_CNPJ(rs.getString("pessoasFisica_CPF"));
                pj.setPessoasJuridica_RazaoSocial(rs.getString("nome"));
                pj.setClientes_Tipo(rs.getString("status"));
                pj.setEnderecos_Codigo(rs.getInt("end_cod"));
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return pj;
    }

    @Override
    public Collection<Cliente> listar() throws ConexaoException, RepositorioException {
        // TODO Auto-generated method stub
        return null;
    }
    /*
     * public Collection<Produto> listar() throws
     * ConexaoException,RepositorioException { ArrayList<Produto> lista = new
     * ArrayList(); Produto p; Connection c = g.conectar(); String sqlLista =
     * "SELECT id,nome,descricao,status FROM produto"; try{ Statement stm =
     * c.createStatement(); ResultSet rs = stm.executeQuery(sqlLista); while(
     * rs.next() ){ p = new Produto(); p.setId( rs.getInt("id") ); p.setNome(
     * rs.getString("nome") ); p.setDescricao( rs.getString("descricao") );
     * p.setStatus( rs.getInt("status") ); lista.add(p); } return lista;
     * }catch(SQLException e){ throw new RepositorioException(e); }finally{
     * g.desconectar(c); }
    }
     */
}