/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author biblioteca
 */
public class Escritorio extends JDesktopPane implements MouseListener, ActionListener{
    private CohenGUI cohen;
    private JFrame v;
    private Menu menu;
    private MenuPopUp menuEmergente;
    
    public Escritorio() {
        super();
/*************
Frame 
**************/        
        v = new JFrame("Herramientas Estadística en Java");
        v.getContentPane().add(this);
        v.setSize(700, 900);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);    
/*************
Menu 
**************/
        //Frame de Cálculo de d de Cohen
        cohen = new CohenGUI();
        menu = new Menu();
        menu.getArchivoItemSalir().addActionListener(this);
        menu.getCohenItemMenu().addActionListener(this);
        menu.getAboutItemMenu().addActionListener(this);
        v.setJMenuBar(menu);
        add(cohen);
 /*************
Menu Emergente
**************/
        menuEmergente = new MenuPopUp();
        
         /* Escuchas de eventos para el menu emergente
         *******************************************/
        this.addMouseListener(this); 
        menuEmergente.getItemCohen().addActionListener(this);
         
         /* Setters and Getters
         ***********************/
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
/*
 * Receptores de eventos
 */
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == menu.getCohenItemMenu()) {
           cohen.setVisible(true); 
         }
        else if (e.getSource() == menu.getArchivoItemSalir()) {
            System.exit(0);
        }
        else if (e.getSource() == menu.getAboutItemMenu()) {
            JOptionPane.showMessageDialog(this,
                "Programa realizado por Sergio Soriano Toro");
        } 
        else if (e.getSource()== menuEmergente.getItemCohen()) {
             cohen.setVisible(true); 
        }       
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if( e.getButton() == MouseEvent.BUTTON3 ){
                        menuEmergente.show(this, e.getX(), e.getY());
        }
    }
/*
 * Eventos no escuchados
 */
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
      
    
    
}
