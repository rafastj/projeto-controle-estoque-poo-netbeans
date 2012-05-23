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

    /**
     * Verifica se todos os campos obrigatórios estão OK.
     *
     * @return true Se não houver problemas.
     */
    public boolean isValido() {
        if ((getCidades_Nome().equals("")) || (getCidades_Nome() == null) || (getCidades_Codigo() == 0)) {
            return false;
        }
        return true;
    }

    /**
     * Verifica se todos os campos obrigatórios estão OK.
     *
     * @return null, ou o nome do primeiro campo inválido.
     */
    public String getValidoString() {
        if ((getCidades_Nome().equals("")) || (getCidades_Nome()) == null) {
            return "cidades_Nome";
        }
        return null;
    }
}