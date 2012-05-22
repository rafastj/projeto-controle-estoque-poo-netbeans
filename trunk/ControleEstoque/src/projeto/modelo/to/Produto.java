/**
 * 
 */
package projeto.modelo.to;

/**
 * @author diego
 *
 */
public class Produto {
	
	private int produtos_Codigo;
	private int segmentos_Codigo;
	private Segmento segmentos = new Segmento();
	private int tipos_Codigo;
	private Tipo tipo = new Tipo();
	private int marcas_Codigo;
	private Marca marca = new Marca();
	private String produtos_Descricao;
	private int produtos_Quantidade;
	private double produtos_ValorVenda;
	
	public Produto (){}
	
	public Produto (int segmentos_Codigo,int tipos_Codigo,int marcas_Codigo,String produtos_Descricao,int produtos_Quantidade,double produtos_ValorVenda){
		this.segmentos_Codigo = segmentos_Codigo;
		this.tipos_Codigo = tipos_Codigo;
		this.marcas_Codigo = marcas_Codigo;
		this.produtos_Descricao = produtos_Descricao;
		this.produtos_Quantidade = produtos_Quantidade;
		this.produtos_ValorVenda = produtos_ValorVenda;
	}

	public int getProdutos_Codigo() {
		return produtos_Codigo;
	}

	public void setProdutos_Codigo(int produtos_Codigo) {
		this.produtos_Codigo = produtos_Codigo;
	}

	public int getSegmentos_Codigo() {
		return segmentos_Codigo;
	}

	public void setSegmentos_Codigo(int segmentos_Codigo) {
		this.segmentos_Codigo = segmentos_Codigo;
	}

	public Segmento getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(Segmento segmentos) {
		this.segmentos = segmentos;
	}

	public int getTipos_Codigo() {
		return tipos_Codigo;
	}

	public void setTipos_Codigo(int tipos_Codigo) {
		this.tipos_Codigo = tipos_Codigo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getMarcas_Codigo() {
		return marcas_Codigo;
	}

	public void setMarcas_Codigo(int marcas_Codigo) {
		this.marcas_Codigo = marcas_Codigo;
	}

	public Marca getMarcas() {
		return marca;
	}

	public void setMarcas(Marca marca) {
		this.marca = marca;
	}

	public String getProdutos_Descricao() {
		return produtos_Descricao;
	}

	public void setProdutos_Descricao(String produtos_Descricao) {
		this.produtos_Descricao = produtos_Descricao;
	}

	public int getProdutos_Quantidade() {
		return produtos_Quantidade;
	}

	public void setProdutos_Quantidade(int produtos_Quantidade) {
		this.produtos_Quantidade = produtos_Quantidade;
	}

	public double getProdutos_ValorVenda() {
		return produtos_ValorVenda;
	}

	public void setProdutos_ValorVenda(double produtos_ValorVenda) {
		this.produtos_ValorVenda = produtos_ValorVenda;
	}
}