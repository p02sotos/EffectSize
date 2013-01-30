/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

/**
 *
 * @author biblioteca
 */
public abstract class LookAndFeel {

    public LookAndFeel() {
    }
    
    public static void nimbus(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CohenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }     
    }
    
    
}
