/**
 * 
 */
package projeto.modelo.to;

/**
 * @author Bruno Pinheiro
 *
 */
public class FormaPagamento {
	
	private int formaPagamento_Codigo;
	private String formaPagamento_Descricao;
	

public FormaPagamento() {}

public FormaPagamento (int formaPagamento_Codigo, String formaPagamento_Descricao)
{
	this.formaPagamento_Codigo = formaPagamento_Codigo;
	this.formaPagamento_Descricao = formaPagamento_Descricao;
}


public int getFormaPagamento_Codigo() {
	return formaPagamento_Codigo;
}


public void setFormaPagamento_Codigo(int formaPagamento_Codigo) {
	this.formaPagamento_Codigo = formaPagamento_Codigo;
}


public String getFormaPagamento_Descricao() {
	return formaPagamento_Descricao;
}


public void setFormaPagamento_Descricao(String formaPagamento_Descricao) {
	this.formaPagamento_Descricao = formaPagamento_Descricao;
}
	

}