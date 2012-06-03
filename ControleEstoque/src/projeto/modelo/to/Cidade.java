/**
 *
 */
package projeto.modelo.to;

/**
 * @author DANIEL VALENÇA Classe Cidade
 */
public class Cidade {

    private int cidades_Codigo;
    private String cidades_Nome;

    public Cidade() {
    }

    public Cidade(String cidades_Nome) {
        this.cidades_Nome = cidades_Nome;
    }

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