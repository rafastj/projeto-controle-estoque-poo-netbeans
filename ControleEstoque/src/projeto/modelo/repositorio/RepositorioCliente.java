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
    public void alterar(PessoaFisica pf) throws ConexaoException, RepositorioException {
         /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlAlterarPF = "UPDATE PessoaFisica SET PessoasFisica_CPF = ? ,PessoasFisica_Nome = ?, PessoasFisica_Sexo = ? WHERE PessoasFisica_CPF = ?";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterarPF);
            pstm.setString(1, pf.getPessoasFisica_CPF());
            pstm.setString(2, pf.getPessoasFisica_Nome());
            pstm.setString(3, pf.getPessoasFisica_Sexo());
            pstm.setString(5, pf.getClientes_NumeroResidencia());
            //pstm.setDouble(6, pf.getProdutos_ValorVenda());
           // pstm.setInt(7, pf.getProdutos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }
    
    @Override
    public void alterar(PessoaJuridica pj) throws ConexaoException, RepositorioException {
              /**
         * conectar faz a conexão com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da Instrução de inserção SQL
         */
        String sqlAlterar = "UPDATE Produtos SET Segmentos_Codigo = ? ,Tipos_Codigo = ?, Marcas_Codigo = ?, Produtos_Descricao = ?, Produtos_Quantidade = ?, Produtos_ValorVenda = ? WHERE produtos_Codigo = ?";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterar);
            pstm.setInt(1, pj.getClientes_Codigo());
            pstm.setString(2, pj.getPessoasJuridica_RazaoSocial());
            pstm.setString(3, pj.getPessoasJuridica_CNPJ());
            pstm.setString(4, pj.getClientes_NumeroResidencia());
//            pstm.setString(5, pj.getClientes_NumeroResidencia());
            //pstm.setDouble(6, pf.getProdutos_ValorVenda());
           // pstm.setInt(7, pf.getProdutos_Codigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
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
    
    public PessoaFisica consultar(int cliente_Codigo) throws ConexaoException, RepositorioException {
        PessoaFisica pf = null;
        Connection c = g.conectar();
        String sqlConsulta = "SELECT cli.clientes_Codigo,cli.enderecos_Codigo,pf.pessoasfisica_Nome,cli.clientes_NumeroResidencia FROM PessoasFisica AS pf, Clientes as cli WHERE (pf.clientes_Codigo = 1 )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, cliente_Codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setClientes_Codigo(rs.getInt("pf.cliente_Codigo"));
                pf.setEnderecos_Codigo(rs.getInt("pf.pessoafisica_nome"));
                pf.setPessoasFisica_Nome(rs.getString("fu.funcionarios_Nome"));
                pf.setPessoasFisica_CPF(sqlConsulta);
                pf.setPessoasFisica_Sexo(sqlConsulta);
                pf.setClientes_NumeroResidencia(rs.getString("fu.Funcionarios_NumeroResidencia"));
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
    public Collection<PessoaFisica> listarPessoaFisica() throws ConexaoException, RepositorioException {
        ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>();
        PessoaFisica pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT pf.clientes_Codigo, pf.pessoasfisica_CPf, pf.pessoasfisica_nome,cli.clientes_tipo, cli.clientes_numeroresidencia, cli.enderecos_Codigo from PessoasFisica AS pf, clientes as cli ORDER BY pf.clientes_Codigo";

        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                pf = new PessoaFisica();
                pf.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                pf.setPessoasFisica_CPF(rs.getString("pessoasfisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pessoasfisica_nome"));
                pf.setClientes_NumeroResidencia(rs.getString("clientes_NumeroResidencia"));
                pf.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                pf.setClientes_Tipo(rs.getString("clientes_tipo"));
                lista.add(pf);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }

    
    @Override
    public Collection<PessoaJuridica> listarPessoaJuridica() throws ConexaoException, RepositorioException {
        ArrayList<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
        PessoaJuridica pj;
        Connection c = g.conectar();
        String sqlLista = "SELECT pj.clientes_Codigo, pj.PessoasJuridica_CNPJ, pj.PessoasJuridica_RazaoSocial,cli.clientes_tipo, cli.clientes_numeroresidencia, cli.enderecos_Codigo from PessoasJuridica AS pj, clientes as cli ORDER BY pj.clientes_Codigo";

        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                pj = new PessoaJuridica();
                pj.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                pj.setPessoasJuridica_CNPJ(rs.getString("PessoasJuridica_CNPJ"));
                pj.setPessoasJuridica_RazaoSocial(rs.getString("PessoasJuridica_RazaoSocial"));
                pj.setClientes_NumeroResidencia(rs.getString("clientes_NumeroResidencia"));
                pj.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                pj.setClientes_Tipo(rs.getString("clientes_tipo"));
                lista.add(pj);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }

}