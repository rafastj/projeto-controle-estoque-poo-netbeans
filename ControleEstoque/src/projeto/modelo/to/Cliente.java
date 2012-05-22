/**
 * 
 */
package projeto.modelo.to;

/**
 * @author Sandro
 *
 */
public class Cliente {
	private int clientes_Codigo;
	private String clientes_NumeroResidencia;
	private String clientes_Tipo;
	private int enderecos_Codigo;
	private Endereco endereco = new Endereco();
	
	public Cliente() {}
	
	/*public Cliente (String clientes_NumeroResidencia, String clientes_Tipo, int enderecos_Codigo) {
		this.clientes_NumeroResidencia = clientes_NumeroResidencia;
		this.clientes_Tipo = clientes_Tipo;
		this.enderecos_Codigo = enderecos_Codigo;
	}*/

	public int getClientes_Codigo() {
		return clientes_Codigo;
	}

	public void setClientes_Codigo(int clientes_Codigo) {
		this.clientes_Codigo = clientes_Codigo;
	}

	public String getClientes_NumeroResidencia() {
		return clientes_NumeroResidencia;
	}

	public void setClientes_NumeroResidencia(String clientes_NumeroResidencia) {
		this.clientes_NumeroResidencia = clientes_NumeroResidencia;
	}

	public String getClientes_Tipo() {
		return clientes_Tipo;
	}

	public void setClientes_Tipo(String clientes_Tipo) {
		this.clientes_Tipo = clientes_Tipo;
	}

	public int getEnderecos_Codigo() {
		return enderecos_Codigo;
	}

	public void setEnderecos_Codigo(int enderecos_Codigo) {
		this.enderecos_Codigo = enderecos_Codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}