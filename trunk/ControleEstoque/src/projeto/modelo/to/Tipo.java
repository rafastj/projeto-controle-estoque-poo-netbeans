/**
 *
 */
package projeto.modelo.to;

/**
 * @author Felipe Carlos
 *
 */
public class Tipo {

    private int tipos_Codigo;
    private String tipos_Descricao;

    public Tipo() {
    }

    public Tipo(int tipos_Codigo, String tipos_Descricao) {
        this.tipos_Codigo = tipos_Codigo;
        this.tipos_Descricao = tipos_Descricao;

    }

    public int getTipos_Codigo() {
        return tipos_Codigo;
    }

    public void setTipos_Codigo(int tipos_Codigo) {
        this.tipos_Codigo = tipos_Codigo;
    }

    public String getTipos_Descricao() {
        return tipos_Descricao;
    }

    public void setTipos_Descricao(String tipos_Descricao) {
        this.tipos_Descricao = tipos_Descricao;
    }
}