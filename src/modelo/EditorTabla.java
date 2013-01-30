package modelo;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import utils.JTextValidator;

/**
 *
 * @author p02sotos
 */
 public class EditorTabla extends DefaultCellEditor {
     public EditorTabla() {         
             super(new JTextValidator("[[0-9]|.]*"));             
            ;
  }    
}
