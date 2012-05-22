/**
 * 
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioCidade;
import projeto.modelo.repositorio.RepositorioCidade;
import projeto.modelo.to.Cidade;

/**
 * @author DANIEL VALENï¿½A
 *
 */
public class NegocioCidade {
	
	private IRepositorioCidade rep;
	
	/**
	 * Construtor inicializa o atributo "rep",
     * responsï¿½vel pela camada de Acesso a Dados;
	 */
	public NegocioCidade() {
		rep = new RepositorioCidade();
	}
	
	/**
	 * Verifica e valida os dados antes de salvar
	 * @param cd Cidade
	 * @throws GeralException
	 */
	public void salvar(Cidade cd) throws GeralException {
		
		if( (cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals("")) ) {
			throw new GeralException("Digite o nome ou o cï¿½dido da cidade!");
		}
		
		/*validaï¿½ï¿½o dos campos pelo objeto e retorna o campo com problema*/
        String campo = cd.getValidoString();
        if( campo != null ){
            throw new GeralException(campo + " invï¿½lido");
        }

        /*validaï¿½ï¿½o dos campos pelo objeto e retorna true/false */
        if( cd.isValido() ){
            throw new GeralException("invï¿½lido");
        }
		
		try {
			Cidade cdConsult = rep.consultar(cd.getCidades_Nome());
			if( cdConsult != null ){
				throw new GeralException("Cidade jï¿½ estï¿½ cadastrada!");
			}
			rep.salvar(cd);
			throw new GeralException("Registro foi salvo com sucesso!");
		} catch(RepositorioException e) {
			throw new GeralException("Erro de programaï¿½ï¿½o!");
		} catch(ConexaoException e) {
			throw new GeralException("Banco de dados inacessï¿½vel!!!");
		}
	}
	
	/**
	 * Mï¿½todo para efetuar uma consulta pelo nome da cidade informada
	 * @param cidade_Nome
	 * @return Cidade cd
	 * @throws GeralException
	 */
	
	public Cidade consultar(String cidades_Nome) throws GeralException {
        Cidade cd = null;
        if( (cidades_Nome == null) || (cidades_Nome.equals("")) )
        	throw new GeralException("Digite o nome ou o cï¿½dido da cidade!");
        try{
        	cd = rep.consultar(cidades_Nome);
            if(cd == null)
                throw new GeralException("Cidade nï¿½o estï¿½ cadastrada!");
        }catch(RepositorioException e){
            throw new GeralException("Erro de programaï¿½ï¿½o!");
        }catch(ConexaoException e){
            throw new GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel no momento");
        }
        return cd;
    }
	
	/**
	 * Mï¿½todo para efetuar uma consulta pelo cï¿½digo de uma cidade
	 * @param cidade_Codigo
	 * @return Cidade cd
	 * @throws GeralException
	 */
	public Cidade consultar(int cidades_Codigo) throws GeralException {
        Cidade cd = null;
        if (cidades_Codigo <= 0)
            throw new GeralException("Digite um cï¿½dido vï¿½lido!");
        try{
            cd = rep.consultar(cidades_Codigo);
            if(cd == null)
                throw new GeralException("Cidade nï¿½o estï¿½ cadastrada!");
        }catch(RepositorioException e){
            throw new GeralException("Erro de programaï¿½ï¿½o!");
        }catch(ConexaoException e){
            throw new GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel no momento");
        }
        return cd;
    }
	
	/**
	 * Valida o cï¿½digo da cidade antes de efetuar a exclusï¿½o.
	 * @param cidade_Codigo
	 * @return
	 */
	public void excluir(int cidades_Codigo) throws GeralException {
		if (cidades_Codigo <= 0) {
			throw new GeralException("Digite um cï¿½dido vï¿½lido!");
		}
		try{			
			Cidade cd = rep.consultar(cidades_Codigo);
			if( cd == null ){
				throw new GeralException("Cidade nï¿½o estï¿½ cadastrada!");
			}
			rep.excluir(cidades_Codigo);
		} catch (RepositorioException ex){
			throw new GeralException("Registro nï¿½o pode ser excluï¿½do!\nMotivo: Existem um ou mais endereï¿½os cadastrados para esta cidade.");
		} catch (ConexaoException ex){
			throw new GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel!");
		}
	}
	
	public void excluir(String cidades_Nome) throws GeralException {
		if( (cidades_Nome == null) || (cidades_Nome.equals("")) ) {
			throw new GeralException("Digite o nome ou o cï¿½dido da cidade!");
		}
		try{			
			Cidade cd = rep.consultar(cidades_Nome);
			if( cd == null ){
				throw new GeralException("Cidade nï¿½o estï¿½ cadastrada!");
			}
			
			rep.excluir(cidades_Nome);
			
		}catch (RepositorioException ex){
			throw new GeralException("Registro nï¿½o pode ser excluï¿½do!\nMotivo: Existem um ou mais endereï¿½os cadastrados para esta cidade.");
			
		}catch (ConexaoException ex){
			throw new GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel!");
		}
	}
	
	/**
	 * Mï¿½todo para alterar um registro a partir de seu cï¿½digo informado.
	 * @param cd Cidade
	 * @throws GeralException
	 */
	public void alterar(Cidade cd) throws GeralException {
		
		if( cd.getCidades_Codigo() <= 0 )
            throw new GeralException("Digite um cï¿½dido vï¿½lido!");
		
		if ( (cd.getCidades_Nome() == null) || (cd.getCidades_Nome().equals("")) )
			throw new GeralException("Digite o nome ou o cï¿½dido da cidade!");
			
        try{
            Cidade cdConsul = rep.consultar(cd.getCidades_Codigo());
            if( cdConsul == null ){
				throw new GeralException("Cidade nï¿½o estï¿½ cadastrada!");
            }
			
           rep.alterar(cd);
            
        } catch (RepositorioException ex){
			throw new GeralException("Erro de programaï¿½ï¿½o!");
		} catch (ConexaoException ex){
			throw new  GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel!");
		}
	}
	
	public Collection <Cidade> listar ( String cidades_Nome) throws GeralException{
		
		ArrayList<Cidade> lista;
		
		if (cidades_Nome == null) {
        	throw new GeralException("Digite o nome ou o cï¿½dido da cidade!");
		}
		try{
			lista = (ArrayList<Cidade>)new RepositorioCidade().listar(cidades_Nome);
		
		}catch (RepositorioException ex ){
			throw new GeralException("Erro de programaï¿½ï¿½o!");
		}catch (ConexaoException ex ){
			throw new GeralException("O banco de dados nï¿½o estï¿½ acessï¿½vel!");
		}return lista;
	}
}