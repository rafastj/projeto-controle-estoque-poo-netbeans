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
import projeto.modelo.to.Endereco;
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
         * conectar faz a conexÃ£o com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da InstruÃ§Ã£o de inserÃ§Ã£o SQL
         */
        String sqlAlterarPF = "UPDATE PessoasFisica SET PessoasFisica_CPF = ? ,PessoasFisica_Nome = ?, PessoasFisica_Sexo = ? WHERE CLIENTES_CODIGO = ?";
        String sqlAlterarCli = "UPDATE CLIENTES SET CLIENTES_NUMERORESIDENCIA = ?, CLIENTES_TIPO = ? WHERE CLIENTES_CODIGO = ?";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterarCli);
            pstm.setString(1, pf.getClientes_NumeroResidencia());
            pstm.setString(2, pf.getClientes_Tipo());
            pstm.setInt(3, pf.getClientes_Codigo());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = c.prepareStatement(sqlAlterarPF);
            pstm.setString(1, pf.getPessoasFisica_CPF());
            pstm.setString(2, pf.getPessoasFisica_Nome());
            pstm.setString(3, pf.getPessoasFisica_Sexo());
            pstm.setInt(4, pf.getClientes_Codigo());
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
         * conectar faz a conexÃ£o com o banco de dados
         */
        Connection c = g.conectar();
        /**
         * variavel do tipo String da InstruÃ§Ã£o de inserÃ§Ã£o SQL
         */
        String sqlAlterarPJ = "UPDATE PESSOASJURIDICA SET PESSOASJURIDICA_CNPJ = ? ,PESSOASFISICA_RAZAOSOCIAL = ?, WHERE CLIENTES_CODIGO = ?";
        String sqlAlterarCli = "UPDATE CLENTES SET CLIENTES_NUMERORESIDENCIA = ?, CLIENTES_TIPO = ? WHERE CLIENTES_CODIGO = ?";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlAlterarCli);
            pstm.setString(1, pj.getClientes_NumeroResidencia());
            pstm.setString(2, pj.getClientes_Tipo());
            pstm.setInt(3, pj.getClientes_Codigo());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = c.prepareStatement(sqlAlterarPJ);
            pstm.setString(1, pj.getPessoasJuridica_CNPJ());
            pstm.setString(2, pj.getPessoasJuridica_RazaoSocial());
            pstm.setInt(3, pj.getClientes_Codigo());
            pstm.executeUpdate();
            pstm.close();
            
        } catch (SQLException ex) {
            throw new RepositorioException(ex.getMessage());
        } finally {
            g.desconectar(c);
        }
    }

     
   
    @Override
    public void excluirPF(int codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluirPF = "DELETE FROM PessoasFisica WHERE (clientes_codigo = ?)";
        String sqlExcluirCli = "DELETE FROM Clientes WHERE (clientes_codigo = ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluirPF);
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
            pstm.close();
            
            pstm = c.prepareStatement(sqlExcluirCli);
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
            pstm.close();
            
            
        } catch (SQLException ex) {
            throw new RepositorioException();
        } finally {
            g.desconectar(c);
        }
    }

    @Override
       public void excluirPJ(int codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlExcluirPF = "DELETE FROM PessoasJuridica WHERE (clientes_codigo = ?)";
        String sqlExcluirCli = "DELETE FROM Clientes WHERE (clientes_codigo = ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlExcluirPF);
            pstm.setInt(1, codigo);
            pstm.executeUpdate();
            pstm.close();
            
            pstm = c.prepareStatement(sqlExcluirCli);
            pstm.setInt(1, codigo);
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
        String sqlConsulta = "SELECT pf.clientes_codigo, pf.pessoasfisica_CPF, pf.pessoasfisica_nome, pf.pessoasfisica_sexo, e.enderecos_logradouro, cli.clientes_numeroresidencia, ci.cidades_Nome  FROM pessoasfisica AS pf INNER JOIN clientes AS cli ON cli.clientes_Codigo = pf.clientes_Codigo INNER JOIN enderecos AS e ON cli.enderecos_Codigo = e.enderecos_Codigo INNER JOIN cidades AS ci ON ci.cidades_Codigo = e.cidades_Codigo WHERE ( pessoasfisica_cpf = ? )";
        
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, pf_CPF );
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setClientes_Codigo(rs.getInt("pf.clientes_codigo"));
                pf.setPessoasFisica_CPF(rs.getString("pf.pessoasfisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pf.pessoasfisica_nome"));
                pf.setPessoasFisica_Sexo(rs.getString("pf.pessoasfisica_sexo"));
                pf.getEndereco().setEnderecos_Logradouro(rs.getString("e.enderecos_logradouro"));
                pf.setClientes_NumeroResidencia(rs.getString("cli.clientes_numeroresidencia"));
                pf.getEndereco().getCidade().setCidades_Nome(rs.getString("ci.cidades_Nome"));
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
        String sqlConsulta = "SELECT pj.clientes_codigo, pj.pessoasjuridica_CNPJ, pj.pessoasjuridica_razaosocial, cli.clientes_numeroresidencia, cli.clientes_tipo, e.enderecos_cep, e.enderecos_logradouro, ci.cidades_nome FROM pessoasjuridica AS pj INNER JOIN Clientes AS cli ON pj.clientes_Codigo = cli.clientes_Codigo INNER JOIN Enderecos AS e ON cli.enderecos_Codigo = e.enderecos_Codigo INNER JOIN Cidades AS ci ON e.cidades_Codigo = ci.cidades_Codigo WHERE ( pessoasjuridica_CNPJ like ? )";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setString(1, '%' + pj_CNPJ + '%');
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pj = new PessoaJuridica();
                pj.setClientes_Codigo(rs.getInt("pj.clientes_codigo"));
                pj.setPessoasJuridica_CNPJ(rs.getString("pj.pessoasjuridica_CNPJ"));
                pj.setPessoasJuridica_RazaoSocial(rs.getString("pj.pessoasjuridica_razaosocial"));
                pj.setClientes_NumeroResidencia(rs.getString("cli.clientes_numeroresidencia"));
                pj.setClientes_Tipo(rs.getString("cli.clientes_tipo"));
                pj.getEndereco().setEnderecos_CEP(rs.getString("e.enderecos_cep"));
                pj.getEndereco().setEnderecos_Logradouro(rs.getString("e.enderecos_logradouro"));
                pj.getEndereco().getCidade().setCidades_Nome(rs.getString("ci.cidades_nome"));
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
        public boolean consultarCliente(int codigo) throws ConexaoException, RepositorioException {
        Connection c = g.conectar();
        String sqlConsulta = "select * from clientes where (clientes_codigo = ?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sqlConsulta);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RepositorioException(e.getMessage());
        } finally {
            g.desconectar(c);
        }
        return false;
    }

    
    
    @Override
    public Collection<PessoaFisica> listarPessoaFisica() throws ConexaoException, RepositorioException {
        ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>();
        PessoaFisica pf;
        Connection c = g.conectar();
        String sqlLista = "SELECT pf.clientes_Codigo, pf.pessoasfisica_CPF, pf.pessoasFisica_nome, pf.pessoasfisica_sexo,"
                + " end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome,"
                + " cli.clientes_numeroresidencia, cli.clientes_tipo from ((PessoasFisica AS pf INNER JOIN clientes as cli"
                + " on pf.clientes_codigo = cli.clientes_codigo) INNER JOIN ENDERECOS AS end ON CLI.enderecos_Codigo = end.enderecos_Codigo)"
                + " INNER JOIN CIDADES AS cd ON end.cidades_Codigo = cd.cidades_Codigo ORDER BY pf.pessoasfisica_CPF";


        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sqlLista);
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                pf = new PessoaFisica();
                
                pf.getEndereco().getCidade().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pf.getEndereco().getCidade().setCidades_Nome(rs.getString("cidades_nome"));
                pf.getEndereco().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pf.getEndereco().setEnderecos_Codigo(rs.getInt("enderecos_codigo"));
                pf.getEndereco().setEnderecos_CEP(rs.getString("enderecos_cep"));
                pf.getEndereco().setEnderecos_Logradouro(rs.getString("enderecos_logradouro"));
                pf.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                pf.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                pf.setPessoasFisica_CPF(rs.getString("pessoasfisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pessoasFisica_nome"));
                pf.setPessoasFisica_Sexo(rs.getString("pessoasFisica_Sexo"));
                pf.setClientes_NumeroResidencia(rs.getString("clientes_NumeroResidencia"));
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

    @Override

        public Collection<PessoaFisica> listarPfCidade(String cidades_Nome) throws ConexaoException, RepositorioException {
        ArrayList<PessoaFisica> lista = new ArrayList<PessoaFisica>();
        PessoaFisica pf;
        Endereco end;
        Cidade cid;
        Connection c = g.conectar();
        String sqlLista = "SELECT pf.clientes_Codigo, pf.pessoasfisica_CPF, pf.pessoasFisica_nome, pf.pessoasfisica_sexo,"
                + " end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome,"
                + " cli.clientes_numeroresidencia, cli.clientes_tipo from ((PessoasFisica AS pf INNER JOIN clientes as cli"
                + " on pf.clientes_codigo = cli.clientes_codigo) INNER JOIN ENDERECOS AS end ON CLI.enderecos_Codigo = end.enderecos_Codigo) INNER JOIN CIDADES AS cd ON end.cidades_Codigo = cd.cidades_Codigo WHERE cidades_Nome = ? ORDER BY pf.pessoasfisica_CPF";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, cidades_Nome);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                pf = new PessoaFisica();
                
                pf.getEndereco().getCidade().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pf.getEndereco().getCidade().setCidades_Nome(rs.getString("cidades_nome"));
                pf.getEndereco().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pf.getEndereco().setEnderecos_Codigo(rs.getInt("enderecos_codigo"));
                pf.getEndereco().setEnderecos_CEP(rs.getString("enderecos_cep"));
                pf.getEndereco().setEnderecos_Logradouro("enderecos_logradouro");
                pf.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                pf.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                pf.setPessoasFisica_CPF(rs.getString("pessoasfisica_CPF"));
                pf.setPessoasFisica_Nome(rs.getString("pessoasFisica_nome"));
                pf.setPessoasFisica_Sexo(rs.getString("pessoasFisica_Sexo"));
                pf.setClientes_NumeroResidencia(rs.getString("clientes_NumeroResidencia"));
                lista.add(pf);
            }
            return lista;
        } catch (SQLException e) {
            throw new RepositorioException(e);
        } finally {
            g.desconectar(c);
        }
    }
        public Collection<PessoaJuridica> listarPjCidade(String cidades_Nome) throws ConexaoException, RepositorioException {
        ArrayList<PessoaJuridica> lista = new ArrayList<PessoaJuridica>();
        PessoaJuridica pj;

        Connection c = g.conectar();
        String sqlLista = "SELECT pj.clientes_Codigo, pj.pessoasfisica_CNPJ, pj.pessoasFisica_RazaoSocial,"
                + " end.enderecos_Codigo, end.enderecos_CEP, end.enderecos_Logradouro, cd.cidades_Codigo, cd.cidades_Nome,"
                + " cli.clientes_numeroresidencia, cli.clientes_tipo from ((PessoasJuridicaa AS pj INNER JOIN clientes as cli"
                + " on pj.clientes_codigo = cli.clientes_codigo) INNER JOIN ENDERECOS AS end ON CLI.enderecos_Codigo = end.enderecos_Codigo) INNER JOIN CIDADES AS cd ON end.cidades_Codigo = cd.cidades_Codigo WHERE cidades_Nome = ? ORDER BY pj.pessoasfisica_CNPJ";

        try {
            PreparedStatement pstm = c.prepareStatement(sqlLista);
            pstm.setString(1, cidades_Nome);
            ResultSet rs = pstm.executeQuery();
            //verifica se retornou algum registro e cria os Objetos
            while (rs.next()) {
                pj = new PessoaJuridica();
                
                pj.getEndereco().getCidade().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pj.getEndereco().getCidade().setCidades_Nome(rs.getString("cidades_nome"));
                pj.getEndereco().setCidades_Codigo(rs.getInt("cidades_codigo"));
                pj.getEndereco().setEnderecos_Codigo(rs.getInt("enderecos_codigo"));
                pj.getEndereco().setEnderecos_CEP(rs.getString("enderecos_cep"));
                pj.getEndereco().setEnderecos_Logradouro("enderecos_logradouro");
                pj.setEnderecos_Codigo(rs.getInt("enderecos_Codigo"));
                pj.setClientes_Codigo(rs.getInt("clientes_Codigo"));
                pj.setPessoasJuridica_CNPJ(rs.getString("pessoasJuridica_CNPJ"));
                pj.setPessoasJuridica_RazaoSocial(rs.getString("pessoasJuridica_Razao_Social"));
                pj.setClientes_NumeroResidencia(rs.getString("clientes_NumeroResidencia"));
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