/**
 * 
 */
package projeto.modelo.to;
import java.util.Date;
/**
 * @author Thiago Evoa
 *
 */
public class NotaFiscal {
	private int notasFiscal_Numero;
	private int clientes_Codigo;
	private int funcionarios_Codigo;
	private Funcionario funcionarios = new Funcionario();
	private int formasPagamento_Codigo;
	private FormaPagamento formasPagamento = new FormaPagamento();
	private double notasFiscal_ValorNotaFiscal;
	private Date notasFiscal_DataEmissao;
	private boolean notasFiscal_Status;
	
	public NotaFiscal () {}
	
	public NotaFiscal (int notasFiscal_Numero, int clientes_Codigo, int funcionarios_Codigo, int formasPagamento_Codigo, double notasFiscal_ValorNotaFiscal, Date notasFiscal_DataEmissao, boolean notasFiscal_Status) {
		this.setNotasFiscal_Numero(notasFiscal_Numero);
		this.setClientes_Codigo(clientes_Codigo);
		this.setFuncionarios_Codigo(funcionarios_Codigo);
		this.setFormasPagamento_Codigo(formasPagamento_Codigo);
		this.setNotasFiscal_ValorNotaFiscal(notasFiscal_ValorNotaFiscal);
		this.setNotasFiscal_DataEmissao(notasFiscal_DataEmissao);
		this.setNotasFiscal_Status(notasFiscal_Status);
		
	}

	public int getNotasFiscal_Numero() {
		return notasFiscal_Numero;
	}

	public void setNotasFiscal_Numero(int notasFiscal_Numero) {
		this.notasFiscal_Numero = notasFiscal_Numero;
	}

	public int getClientes_Codigo() {
		return clientes_Codigo;
	}

	public void setClientes_Codigo(int clientes_Codigo) {
		this.clientes_Codigo = clientes_Codigo;
	}

	public int getFuncionarios_Codigo() {
		return funcionarios_Codigo;
	}

	public void setFuncionarios_Codigo(int funcionarios_Codigo) {
		this.funcionarios_Codigo = funcionarios_Codigo;
	}

	public int getFormasPagamento_Codigo() {
		return formasPagamento_Codigo;
	}

	public void setFormasPagamento_Codigo(int formasPagamento_Codigo) {
		this.formasPagamento_Codigo = formasPagamento_Codigo;
	}

	public double getNotasFiscal_ValorNotaFiscal() {
		return notasFiscal_ValorNotaFiscal;
	}

	public void setNotasFiscal_ValorNotaFiscal(double notasFiscal_ValorNotaFiscal) {
		this.notasFiscal_ValorNotaFiscal = notasFiscal_ValorNotaFiscal;
	}

	public Date getNotasFiscal_DataEmissao() {
		return notasFiscal_DataEmissao;
	}

	public void setNotasFiscal_DataEmissao(Date notasFiscal_DataEmissao) {
		this.notasFiscal_DataEmissao = notasFiscal_DataEmissao;
	}

	public boolean getNotasFiscal_Status() {
		return notasFiscal_Status;
	}

	public void setNotasFiscal_Status(boolean notasFiscal_Status) {
		this.notasFiscal_Status = notasFiscal_Status;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFormasPagamento(FormaPagamento formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public FormaPagamento getFormasPagamento() {
		return formasPagamento;
	}
	
}