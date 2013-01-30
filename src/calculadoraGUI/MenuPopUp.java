/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author biblioteca
 */
public class MenuPopUp extends JPopupMenu implements ActionListener {
    JMenuItem itemCohen;
    

    public MenuPopUp() {
        super();
        itemCohen = new JMenuItem("Calculadora de Cohen");
        add(itemCohen);
    }

    public JMenuItem getItemCohen() {
        return itemCohen;
    }
    public void setItemCohen(JMenuItem itemCohen) {
        this.itemCohen = itemCohen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== itemCohen) {
         
        }
    } 
    
    
}
