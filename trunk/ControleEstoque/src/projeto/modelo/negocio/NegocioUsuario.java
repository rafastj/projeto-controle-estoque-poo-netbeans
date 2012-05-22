/**
 * 
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioUsuario;
import projeto.modelo.repositorio.RepositorioUsuario;
import projeto.modelo.to.Usuario;

/**
 * @author Thiago Evoa
 *
 */
public class NegocioUsuario {
	
	private IRepositorioUsuario rep;
	
	/**
	 * Construtor inicializa o atributo "rep",
     * responsável pela camada de Acesso a Dados;
	 */
	public NegocioUsuario() {
		rep = new RepositorioUsuario();
	}
	
	/**
	 * Verifica e valida os dados antes de salvar
	 * @param us Usuario
	 * @throws GeralException
	 */
	public void salvar(Usuario us) throws GeralException {
		
		if(us.getFuncionarios_Codigo() <= 0) {
			throw new GeralException("Digite o código do usuário!");
		}		
		if (us.getUsuarios_Login() == null) {
			throw new GeralException("Informe o Login!");
		}
		if (us.getUsuarios_Senha() == null) {
			throw new GeralException("Informe a Senha!");
		}
		try {
			Usuario usconsult = rep.consultar(us.getFuncionarios_Codigo());
			if( usconsult != null ){
				throw new GeralException("Usuário já está cadastrado!");
			}
			rep.salvar(us);
			throw new GeralException("Registro foi salvo com sucesso!");
		} catch(RepositorioException e) {
			throw new GeralException("Erro de programação!");
		} catch(ConexaoException e) {
			throw new GeralException("Banco de dados inacessível!!!");
		}
	}
		
	/**
	 * Método para efetuar uma consulta pelo codigo do funcionario informada
	 * @param Funcionarios_Codigo
	 * @return Usuario us
	 * @throws GeralException
	 */
	public Usuario consultar(int funcionarios_Codigo) throws GeralException{
        Usuario us = null;
        if(funcionarios_Codigo <= 0)
            throw new GeralException("Digite o codigo do Usuário!");
        try{
            us = rep.consultar(funcionarios_Codigo);
            if(us == null)
                throw new GeralException("Usuario não está cadastrado!");
        }catch(RepositorioException e){
            throw new GeralException("Erro de programação!");
        }catch(ConexaoException e){
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return us;
    }
	/**
	 * Método para efetuar uma consulta pelo nome do Usuario
	 * @param funcionarios_Codigo
	 * @return
	 * @throws GeralException
	 */
	public Usuario consultar(String funcionarios_Nome) throws GeralException{
        Usuario us = null;
        if((funcionarios_Nome.equals(null)) || (funcionarios_Nome.equals("")))
            throw new GeralException("Digite o nome do Usuário!");
        try{
            us = rep.consultar(funcionarios_Nome);
            if(us == null)
                throw new GeralException("Usuario não está cadastrado!");
        }catch(RepositorioException e){
            throw new GeralException("Erro de programação!");
        }catch(ConexaoException e){
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return us;
    }
		
	/**
	 * Valida o código do usuário antes de efetuar a exclusão.
	 * @param funcinarios_Codigo
	 * @return
	 */
	public void excluir(int funcionarios_Codigo) throws GeralException {
		if (funcionarios_Codigo <= 0) {
			throw new GeralException("Digite um códido válido!");
		}
		try{			
			Usuario us = rep.consultar(funcionarios_Codigo);
			if( us == null ){
				throw new GeralException("Usuário não está cadastrado!");
			}
			
			rep.excluir(funcionarios_Codigo);
			
		}catch (RepositorioException ex){
			throw new GeralException("Erro de programação!");
			
		}catch (ConexaoException ex){
			throw new GeralException("O banco de dados não está acessível!");
		}
	}
	
	/**
	 * Valida o código do usuário antes de efetuar a exclusão.
	 * @param funcinarios_Codigo
	 * @return
	 */
	public void excluir(String funcionarios_Nome) throws GeralException {
		 if((funcionarios_Nome.equals(null)) || (funcionarios_Nome.equals(""))) {
			throw new GeralException("Digite um códido válido!");
		}
		try{			
			Usuario us = rep.consultar(funcionarios_Nome);
			if( us == null ){
				throw new GeralException("Usuário não está cadastrado!");
			}
			
			rep.excluir(funcionarios_Nome);
			
		}catch (RepositorioException ex){
			throw new GeralException("Erro de programação!");
			
		}catch (ConexaoException ex){
			throw new GeralException("O banco de dados não está acessível!");
		}
	}
		
	/**
	 * Método para alterar um registro a partir de seu código informado.
	 * @param us Usuario
	 * @throws GeralException
	 */
	public void alterar(Usuario us) throws GeralException {
		
		if( us.getFuncionarios_Codigo() <= 0 )
            throw new GeralException("Digite um códido válido!");
		
        try{
            Usuario usConsul = rep.consultar(us.getFuncionarios_Codigo());
            if( usConsul == null ){
				throw new GeralException("Usuário não está cadastrado!");
            }
			
           rep.alterar(us);
            
        } catch (RepositorioException ex){
			throw new GeralException("Erro de programação!");
		} catch (ConexaoException ex){
			throw new  GeralException("O banco de dados não está acessível!");
		}
	}
	
	/**
	 * Método para listar o usuário pelo código
	 * @param funcionarios_Codigo
	 * @return
	 * @throws GeralException
	 */
public Collection <Usuario> listar ( int funcionarios_Codigo) throws GeralException{
		
		ArrayList<Usuario> lista;
		
		if( funcionarios_Codigo <= 0 ){
			throw new GeralException("Digite o código de um usuário!");
		}
		try{
			lista = (ArrayList<Usuario>)new RepositorioUsuario().listar(funcionarios_Codigo);
		
	}catch (RepositorioException ex ){
		throw new GeralException("Erro de programação!");
	}catch (ConexaoException ex ){
		throw new GeralException("O banco de dados não está acessível!");
	}
	return lista;
	}

public Collection <Usuario> listar ( String funcionarios_Nome) throws GeralException{
	
	ArrayList<Usuario> lista;
	
	if((funcionarios_Nome.equals(null)) || (funcionarios_Nome.equals(""))){
		throw new GeralException("Digite o nome de um usuário!");
	}
	try{
		lista = (ArrayList<Usuario>)new RepositorioUsuario().listar(funcionarios_Nome);
	
	}catch (RepositorioException ex ){
		throw new GeralException("Erro de programação!");
	}catch (ConexaoException ex ){
		throw new GeralException("O banco de dados não está acessível!");
	}
	return lista;
	}
}