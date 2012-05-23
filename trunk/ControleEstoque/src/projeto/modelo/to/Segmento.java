/**
 *
 */
package projeto.modelo.to;

/**
 * @author Bruno Pinheiro
 *
 */
public class Segmento {

    private int segmentos_Codigo;
    private String segmentos_Descricao;

    public Segmento() {
    }

    public Segmento(int segmentos_Codigo, String segmentos_Descricao) {
        this.segmentos_Codigo = segmentos_Codigo;
        this.segmentos_Descricao = segmentos_Descricao;
    }

    public int getSegmentos_Codigo() {
        return segmentos_Codigo;
    }

    public void setSegmentos_Codigo(int segmentos_Codigo) {
        this.segmentos_Codigo = segmentos_Codigo;
    }

    public String getSegmentos_Descricao() {
        return segmentos_Descricao;
    }

    public void setSegmentos_Descricao(String segmentos_Descricao) {
        this.segmentos_Descricao = segmentos_Descricao;
    }
}