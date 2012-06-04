/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioMarca;
import projeto.modelo.repositorio.RepositorioMarca;
import projeto.modelo.to.Marca;

/**
 * @author Felipe Carlos
 *
 */
public class NegocioMarca {

    private IRepositorioMarca rep;

    /**
     * Contrutor inicializa o atributo "rep" responsável pela camada de acesso a
     * dados
     */
    public NegocioMarca() {
        rep = new RepositorioMarca();
    }

    /**
     * Verificar os dados antes de salvar este método usa Exceptions para
     * transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void salvar(Marca m) throws GeralException {
        //validação dos campos no próprio método

        if (m.getMarcas_Descricao() == null) {
            throw new GeralException("Descrição não informada!");
        }

        try {

            Marca mconsul = rep.consultarMarcas(m.getMarcas_Descricao());
            if (mconsul != null) {
                throw new GeralException("Marca já cadastrada!");
            }

            rep.salvar(m);
            throw new GeralException("Marca salva com sucesso!");
        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo errado");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verifica os dados antes de consultar a String Descricao
     */
    public Marca consultarMarcas(String marcas_Descricao) throws GeralException {
        Marca m = null;

        if (marcas_Descricao == null) {
            throw new GeralException("Descrição da marca não informada");
        }

        try {
            m = rep.consultarMarcas(marcas_Descricao);

            if (m == null) {
                throw new GeralException("Tipo não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo errado");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return m;
    }

    /**
     * Verifica os dados antes de consultar a String Codigo
     */
    public Marca consultarMarcas(int marcas_Codigo) throws GeralException {
        Marca m = null;

        if (marcas_Codigo <= 0) {
            throw new GeralException("Codigo da marca não informada");
        }

        try {
            m = rep.consultarMarcas(marcas_Codigo);

            if (m == null) {
                throw new GeralException("Marca não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return m;
    }

    /**
     * Verificar os dados antes de excluir a marca este método usa Exceptions
     * para transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void excluirMarcas(int marcas_Codigo) throws GeralException {

        //verificar se a marca do produto foi informado
        if (marcas_Codigo <= 0) {
            throw new GeralException("Marca não foi selecionado para ser deletado!");
        }

        try {

            Marca m = rep.consultarMarcas(marcas_Codigo);
            if (m == null) {
                throw new GeralException("Marca não existe!");
            }

            rep.excluirMarcas(marcas_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo errado");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    public void excluirMarcas(String marcas_Descricao) throws GeralException {

        //verificar se o codigo do produto foi informado
        if (marcas_Descricao == null) {
            throw new GeralException("Marca não foi selecionado para ser deletado!");
        }

        try {

            Marca m = rep.consultarMarcas(marcas_Descricao);
            if (m == null) {
                throw new GeralException("Marca não existe!");
            }

            rep.excluirMarcas(marcas_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo errado");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de Aletar a marca
     *
     * @param p
     * @throws GeralException
     */
    public void alterar(Marca m) throws GeralException {
        //validação dos campos no próprio método

        //validação da seleção da narca do  produto
        if (m.getMarcas_Codigo() <= 0) {
            throw new GeralException("Marca não informada!");
        }

        //validação da descricao
        if (m.getMarcas_Descricao() == null) {
            throw new GeralException("Marca da Descrição não informada!");
        }

        try {

            Marca mconsul = rep.consultarMarcas(m.getMarcas_Codigo());
            if (mconsul == null) {
                throw new GeralException("Marca não existe!");
            }

            rep.alterar(m);

        } catch (RepositorioException ex) {
            throw new GeralException("Felipe fez algo de errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de consultar a lista
     */
       public Collection<Marca> listarMarca() throws GeralException {

        ArrayList<Marca> lista;
        try {
            lista = (ArrayList<Marca>) new RepositorioMarca().listarMarca();

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
     public Collection<Marca> listarMarcasDescricao(String marcas_Descricao)throws GeralException{
       ArrayList<Marca> lista;
        try {
            lista = (ArrayList<Marca>) new RepositorioMarca().listarMarcasDescricao(marcas_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Erro de programação!");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível no momento");
        }
        return lista;
    }
    
    public int CodigoMarca()throws GeralException{
		int m = 0;
		try {
			m = rep.CodigoMarca();
		} catch (ConexaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return m;
	 }

}
