/**
 * 
 */
package projeto.modelo.to;

/**
 * @author Thiago Evoa
 *
 */
public class Usuario {
	private int funcionarios_Codigo;
	private String funcionarios_Nome;
	private Funcionario funcionarios = new Funcionario();
	private String usuarios_Login;
	private String usuarios_Senha;
	
	public Usuario () {}
	
	public Usuario (String usuarios_Login, String usuarios_Senha,int funcionarios_Codigo) {
		this.setFuncionarios_Codigo(funcionarios_Codigo);
		this.setUsuarios_Login(usuarios_Login);
		this.setUsuarios_Senha(usuarios_Senha);
				
	}

	public int getFuncionarios_Codigo() {
		return funcionarios_Codigo;
	}

	public void setFuncionarios_Codigo(int funcionarios_Codigo) {
		this.funcionarios_Codigo = funcionarios_Codigo;
	}

	public String getUsuarios_Login() {
		return usuarios_Login;
	}

	public void setUsuarios_Login(String usuarios_Login) {
		this.usuarios_Login = usuarios_Login;
	}

	public String getUsuarios_Senha() {
		return usuarios_Senha;
	}

	public void setUsuarios_Senha(String usuarios_Senha) {
		this.usuarios_Senha = usuarios_Senha;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios_Nome(String funcionarios_Nome) {
		this.funcionarios_Nome = funcionarios_Nome;
	}

	public String getFuncionarios_Nome() {
		return funcionarios_Nome;
	}

}