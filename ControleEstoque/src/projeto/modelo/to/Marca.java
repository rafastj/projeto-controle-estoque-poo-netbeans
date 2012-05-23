/**
 *
 */
package projeto.modelo.to;

/**
 * @author Felipe Carlos
 *
 */
public class Marca {

    private int marcas_Codigo;
    private String marcas_Descricao;

    public Marca() {
    }

    public Marca(int marcas_Codigo, String marcas_Descricao) {

        this.marcas_Codigo = marcas_Codigo;
        this.marcas_Descricao = marcas_Descricao;
    }

    public int getMarcas_Codigo() {
        return marcas_Codigo;
    }

    public void setMarcas_Codigo(int marcas_Codigo) {
        this.marcas_Codigo = marcas_Codigo;
    }

    public String getMarcas_Descricao() {
        return marcas_Descricao;
    }

    public void setMarcas_Descricao(String marcas_Descricao) {
        this.marcas_Descricao = marcas_Descricao;
    }
}