/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.modelo.componente;

import javax.swing.text.AttributeSet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author diego
 */
public class ValorReal extends JTextField{
    
    private static final long serialVersionUID = 1L;
    
    public ValorReal(){
        super();
    }
    
    public ValorReal(int cols){
        super(cols);
    }
    
    @Override
     protected Document createDefaultModel() {  
          return (Document) new NumberDocument();  
     }  
  
     static class NumberDocument extends PlainDocument {  
  
        private static final long serialVersionUID = 1L;  
  
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {  
              if (str == null) return;  

              for (int i = 0; i < str.length(); i++) {
                  if(str.equals(",") || str.equals(".")){ //aqui ele irar permitir ponto e virgula
                      
                  }else if(Character.isDigit(str.charAt(i))== false){ //aqui ele verificar se for numero 
                      return;  
                  }  
              }  
              super.insertString(offs, str, a);  
          }  
    
    }
}
