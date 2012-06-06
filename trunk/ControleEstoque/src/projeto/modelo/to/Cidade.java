/**
 *
 */
package projeto.modelo.to;

/**
 * @author DANIEL VALENÇA
 */
public class Cidade {

    private int cidades_Codigo;
    private String cidades_Nome;
    
    public Cidade() {
    }

    /**
     * Construtor da classe cidade
     * @param cidades_Nome String que contem o nome da cidade
     */
    public Cidade(String cidades_Nome) {
        this.cidades_Nome = cidades_Nome;
    }

    /**
     * Método que pega o código da cidade.
     * @return Retorna o código da cidade.
     */
    public int getCidades_Codigo() {
        return cidades_Codigo;
    }

    public void setCidades_Codigo(int cidades_Codigo) {
        this.cidades_Codigo = cidades_Codigo;
    }

    public String getCidades_Nome() {
        return cidades_Nome;
    }

    public void setCidades_Nome(String cidades_Nome) {
        this.cidades_Nome = cidades_Nome;
    }
}