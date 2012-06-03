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
public class SoStrings extends JTextField{
    
    public SoStrings(){
        super();
    }
    
    public SoStrings(String cols){
        super(cols);
    }
    
  @Override
     protected Document createDefaultModel() {  
          return (Document) new NumberDocument();  
     } 
    
    static class NumberDocument extends PlainDocument{

    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
        for(int i = 0; i < str.length(); i++){
            
                if(Character.isLetter(str.charAt(i))){//se for Letras ok
                    
                     super.insertString(offs, str, a);
                }
            }
    
        }
    
    }
    
}
