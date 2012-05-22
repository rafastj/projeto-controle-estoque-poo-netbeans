/**
 * 
 */
package projeto.modelo.negocio;

import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.IRepositorioCliente;
import projeto.modelo.repositorio.RepositorioCliente;
import projeto.modelo.to.PessoaFisica;
import projeto.modelo.to.PessoaJuridica;

/**
 * @author Sandro
 *
 */
public class NegocioCliente {
	private IRepositorioCliente rep;
	
	public NegocioCliente() {
		rep = new RepositorioCliente();
	}
	
public void salvar(PessoaFisica pf) throws GeralException {
	boolean cpf=ValidaCPF(pf.getPessoasFisica_CPF());		
		if(cpf == false) {
			throw new GeralException("CPF Inválido!");
		}
		
		if(pf.getClientes_NumeroResidencia() == null) {
			throw new GeralException("Digite o numero da residencia!");
		}
		
		if(pf.getPessoasFisica_Nome()== null) {
			throw new GeralException("Digite o Nome de Cliente!");
		}
		
		try {
			/*PessoaFisica pfConsult = rep.consultarPF(pf.getPessoasFisica_CPF());
			if( pfConsult != null ){
				throw new GeralException("Cliente já está cadastrado!");
			}*/
			rep.salvar(pf);
		} catch(RepositorioException e) {
			throw new GeralException("Erro de programação!");
		} catch(ConexaoException e) {
			throw new GeralException("Banco de dados inacessível!!!");
		}
	}

public void salvar(PessoaJuridica pj) throws GeralException {
	/*boolean cnpj=ValidaCNPJ(pj.getPessoasJuridica_CNPJ());		
	if(cnpj == false) {
		throw new GeralException("CNPJ Inválido!");
	}*/
	
	if(pj.getClientes_NumeroResidencia() == null) {
		throw new GeralException("Digite o numero da residencia!");
	}
	
	if(pj.getPessoasJuridica_RazaoSocial()== null) {
		throw new GeralException("Digite a Razão Social do Cliente!");
	}
	
	try {
		//PessoaJuridica pjConsult = rep.consultarPJ(pj.getPessoasJuridica_CNPJ());
		/*if( pjConsult != null ){
			throw new GeralException("Cliente já está cadastrado!");
		}*/
		rep.salvar(pj);
	} catch(RepositorioException e) {
		throw new GeralException("Erro de programação!");
	} catch(ConexaoException e) {
		throw new GeralException("Banco de dados inacessível!!!");
	}
}

public PessoaFisica consultarPF_Nome( String pessoafisica_Nome ) throws GeralException {
	PessoaFisica pf = null;
	if( pessoafisica_Nome == null )
		throw new GeralException( "Digite um CNPJ!" );

	try {
	    pf = rep.consultarPF_Nome(pessoafisica_Nome);
	    if( pf == null )
	    	throw new GeralException( "Fornecedor não está cadastrado!" );
	
	} catch ( RepositorioException e ){
		throw new GeralException( "Erro de programação!" );
	
	} catch ( ConexaoException e ){
		throw new GeralException( "O banco de dados não está acessível no momento" );
	}
	return pf;
}


public static boolean ValidaCPF (String strCpf ) {
    int     d1, d2;
    int     digito1, digito2, resto;
    int     digitoCPF;
    String  nDigResult;

    d1 = d2 = 0;
    digito1 = digito2 = resto = 0;

    for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
    {
       digitoCPF = Integer.valueOf (strCpf.substring(nCount -1, nCount)).intValue();
       d1 = d1 + ( 11 - nCount ) * digitoCPF;
       d2 = d2 + ( 12 - nCount ) * digitoCPF;
    };
    resto = (d1 % 11);
    if (resto < 2)
       digito1 = 0;
    else
       digito1 = 11 - resto;

	d2 += 2 * digito1;
    resto = (d2 % 11);

    if (resto < 2)
       digito2 = 0;
    else
       digito2 = 11 - resto;

    String nDigVerific = strCpf.substring (strCpf.length()-2, strCpf.length());
    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
    return nDigVerific.equals(nDigResult);
 }


}