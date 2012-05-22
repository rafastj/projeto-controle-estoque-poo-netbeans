/**
 * 
 */
package projeto.modelo.to;

/**
 * @author Sandro
 *
 */
public class PessoaJuridica extends Cliente{
	private String pessoasJuridica_CNPJ;
	private String pessoasJuridica_RazaoSocial;
	
	public PessoaJuridica(){}
	
	public PessoaJuridica(int enderecos_codigo,String clientes_NumeroResidencia, String clientes_Tipo, String pessoasJuridica_CNPJ, String pessoasJuridica_RazaoSocial){
		this.pessoasJuridica_CNPJ = pessoasJuridica_CNPJ;
		this.pessoasJuridica_RazaoSocial = pessoasJuridica_RazaoSocial;
		this.setEnderecos_Codigo(enderecos_codigo);
		this.setClientes_NumeroResidencia(clientes_NumeroResidencia);
		this.setClientes_Tipo(clientes_Tipo);

	}

	public String getPessoasJuridica_CNPJ() {
		return pessoasJuridica_CNPJ;
	}

	public void setPessoasJuridica_CNPJ(String pessoasJuridica_CNPJ) {
		this.pessoasJuridica_CNPJ = pessoasJuridica_CNPJ;
	}

	public String getPessoasJuridica_RazaoSocial() {
		return pessoasJuridica_RazaoSocial;
	}

	public void setPessoasJuridica_RazaoSocial(String pessoasJuridica_RazaoSocial) {
		this.pessoasJuridica_RazaoSocial = pessoasJuridica_RazaoSocial;
	}
}