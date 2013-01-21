/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author biblioteca
 */
public class Escritorio extends JDesktopPane {
    private GUI cohen;
    private JFrame v;

    public Escritorio() {
        super();
        setSize(500, 500);
        v = new JFrame("Prueba JInternalFrame");
        v.getContentPane().add(this);
        v.setSize(700, 900);
        cohen = new GUI();
        
        add(cohen);
        cohen.setVisible(true);
        v.setVisible(true);
        
        setVisible(true);
        
    }
    
    
    
}
