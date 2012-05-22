
/**
 * 
 */
package projeto.validaCampo;

/**
 * @author Equipe
 *
 */
public class ValidaCampo {
	
	/**
	 * Método para Validação de CNPJ
	 * @param str_cnpj
	 * @return
	 */
	public  boolean validaCnpj( String str_cnpj ) {   
        if (! str_cnpj.substring(0,1).equals("")){   
            try{   
                str_cnpj=str_cnpj.replace('.',' ');   
                str_cnpj=str_cnpj.replace('/',' ');   
                str_cnpj=str_cnpj.replace('-',' ');   
                str_cnpj=str_cnpj.replaceAll(" ","");   
                int soma = 0, dig;   
                String cnpj_calc = str_cnpj.substring(0,12);   
                   
                if ( str_cnpj.length() != 14 )   
                    return false;   
                char[] chr_cnpj = str_cnpj.toCharArray();   
                // Primeira parte  
                for( int i = 0; i < 4; i++ )   
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )   
                        soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;   
                for( int i = 0; i < 8; i++ )   
                    if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )   
                        soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;   
                dig = 11 - (soma % 11);   
                cnpj_calc += ( dig == 10 || dig == 11 ) ?   
                    "0" : Integer.toString(dig);   
                // Segunda parte  
                soma = 0;   
                for ( int i = 0; i < 5; i++ )   
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )   
                        soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;   
                for ( int i = 0; i < 8; i++ )   
                    if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )   
                        soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;   
                dig = 11 - (soma % 11);   
                cnpj_calc += ( dig == 10 || dig == 11 ) ?   
                    "0" : Integer.toString(dig);   
                return str_cnpj.equals(cnpj_calc);   
            } catch (Exception e){   
                System.err.println("Erro !"+e);   
                return false;   
            }   
        }else return false;   
    }
	
	/**
	 * Método para validação de CPF
	 * @param strCpf
	 * @return
	 */
	public static boolean ValidaCPF (String strCpf ) {
	    int     d1, d2;
	    int     digito1, digito2, resto;
	    int     digitoCPF;
	    String  nDigResult;

	    d1 = d2 = 0;
	    digito1 = digito2 = resto = 0;

	    for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {
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