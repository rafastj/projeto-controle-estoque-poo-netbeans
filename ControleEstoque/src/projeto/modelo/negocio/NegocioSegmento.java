/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioSegmento;
import projeto.modelo.repositorio.RepositorioSegmento;
import projeto.modelo.to.Segmento;

/**
 * @author Bruno Pinheiro
 *
 */
public class NegocioSegmento {

    private IRepositorioSegmento rep;

    /**
     * Contrutor inicializa o atributo "rep" responsável pela camada de acesso a
     * dados
     */
    public NegocioSegmento() {
        rep = new RepositorioSegmento();
    }

    /**
     * Verificar os dados antes de salvar este método usa Exceptions para
     * transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void salvar(Segmento s) throws GeralException {
        //validação dos campos no próprio método

        if (s.getSegmentos_Codigo() <= 0) {
            throw new GeralException("Segmento não informado!");
        }

        if (s.getSegmentos_Descricao() == null) {
            throw new GeralException("Descrição não informada!");
        }

        try {

            Segmento sconsul = rep.consultarSegmentos(s.getSegmentos_Descricao());
            if (sconsul != null) {
                throw new GeralException("Marca já cadastrada!");
            }

            rep.salvar(s);
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
    public Segmento consultarSegmentos(String Segmento_Descricao) throws GeralException {
        Segmento s = null;

        if (Segmento_Descricao == null) {
            throw new GeralException("Descrição do Segmento não informada");
        }

        try {
            s = rep.consultarSegmentos(Segmento_Descricao);

            if (s == null) {
                throw new GeralException("Segmento não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return s;
    }

    /**
     * Verifica os dados antes de consultar a String Codigo
     */
    public Segmento consultarSegmentos(int Segmento_Codigo) throws GeralException {
        Segmento s = null;

        if (Segmento_Codigo <= 0) {
            throw new GeralException("Codigo do segmento não informada");
        }

        try {
            s = rep.consultarSegmentos(Segmento_Codigo);

            if (s == null) {
                throw new GeralException("Segmento não encontrado!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return s;
    }

    /**
     * Verificar os dados antes de excluir o Segmento este método usa Exceptions
     * para transmitir mensagens entre as camadas do sistema (negocio ->
     * apresentação)
     */
    public void excluir(int Segmento_Codigo) throws GeralException {

        //verificar se o Segmento do produto foi informado
        if (Segmento_Codigo <= 0) {
            throw new GeralException("Segmento não foi selecionado para ser deletado!");
        }

        try {

            Segmento s = rep.consultarSegmentos(Segmento_Codigo);
            if (s == null) {
                throw new GeralException("Marca não existe!");
            }

            rep.excluir(Segmento_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo errado");

        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de Aletar o Segmento
     *
     * @param p
     * @throws GeralException
     */
    public void alterar(Segmento s) throws GeralException {
        //validação dos campos no próprio método

        //validação da seleção do Segmento do  produto
        if (s.getSegmentos_Codigo() <= 0) {
            throw new GeralException("Segmento não informado!");
        }

        //validação da descricao
        if (s.getSegmentos_Descricao() == null) {
            throw new GeralException("Segmento da Descrição não informado!");
        }

        try {

            Segmento mconsul = rep.consultarSegmentos(s.getSegmentos_Codigo());
            if (mconsul == null) {
                throw new GeralException("Marca não existe!");
            }

            rep.alterar(s);

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo de errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    /**
     * Verificar os dados antes de consultar a lista
     */
    public Collection<Segmento> listarSegmentos(String Segmento_Descricao) throws GeralException {

        ArrayList<Segmento> lista;

        if (Segmento_Descricao == null) {
            throw new GeralException("Descrição do produto não informada");
        }
        try {
            lista = (ArrayList<Segmento>) new RepositorioSegmento().listarSegmentos(Segmento_Descricao);

        } catch (RepositorioException ex) {
            throw new GeralException("Usuário fez algo de errado!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
}