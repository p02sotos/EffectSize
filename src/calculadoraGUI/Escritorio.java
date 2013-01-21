/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;


/**
 *
 * @author biblioteca
 */
public class Escritorio extends JDesktopPane implements ActionListener {
    private CohenGUI cohen;
    private JFrame v;
    private Menu menu;
    

    public Escritorio() {
        super();
        
        //Frame
        v = new JFrame("Herramientas Estadística en Java");
        v.getContentPane().add(this);
        v.setSize(700, 900);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);  
        
        
        //Menu
        
        
        //Frame de Cálculo de d de Cohen
        cohen = new CohenGUI();
        menu = new Menu();
        menu.getArchivoItemSalir().addActionListener(this);
        menu.getCohenItemMenu().addActionListener(this);
        v.setJMenuBar(menu);
        add(cohen);
        //cohen.setVisible(true);
        
          
              
       
        
        
    }

    public CohenGUI getCohen() {
        return cohen;
    }

    public void setCohen(CohenGUI cohen) {
        this.cohen = cohen;
    }

    public JFrame getV() {
        return v;
    }

    public void setV(JFrame v) {
        this.v = v;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == menu.getCohenItemMenu()) {
             
           cohen.setVisible(true); 
               
                
            }
        else if (e.getSource() == menu.getArchivoItemSalir()) {
            System.exit(0);
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
}
