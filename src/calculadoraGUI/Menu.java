/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author biblioteca
 */
public class Menu extends JMenuBar  {
    private JMenu menuHerramientas;
    private JMenu menuArchivo;
    private JMenu menuAyuda;
    private JMenuItem cohenItemMenu;
    private JMenuItem archivoItemSalir;
    private JMenuItem aboutItemMenu;
    

    public Menu() {
        super();
        
        
        /*************
         * Menu
         *************/
        //Menus
        menuHerramientas = new JMenu("Herramientas");
        menuArchivo = new JMenu("Archivo");
        menuAyuda = new JMenu("Ayuda");
        
        
        
        //Items
        cohenItemMenu = new JMenuItem("d de Cohen");
        archivoItemSalir = new JMenuItem("Salir");
        aboutItemMenu = new JMenuItem("About");
        
        menuHerramientas.add(cohenItemMenu);
        menuArchivo.add(archivoItemSalir);
        add(menuArchivo);
        add(menuHerramientas);
        
        
        /************
         * Fin Menu
         ************/
    }

    public JMenu getMenuHerramientas() {
        return menuHerramientas;
    }

    public void setMenuHerramientas(JMenu menuHerramientas) {
        this.menuHerramientas = menuHerramientas;
    }

    public JMenu getMenuArchivo() {
        return menuArchivo;
    }

    public void setMenuArchivo(JMenu menuArchivo) {
        this.menuArchivo = menuArchivo;
    }

    public JMenu getMenuAyuda() {
        return menuAyuda;
    }

    public void setMenuAyuda(JMenu menuAyuda) {
        this.menuAyuda = menuAyuda;
    }

    public JMenuItem getAboutItemMenu() {
        return aboutItemMenu;
    }

    public void setAboutItemMenu(JMenuItem aboutItemMenu) {
        this.aboutItemMenu = aboutItemMenu;
    }
   
    public JMenuItem getCohenItemMenu() {
        return cohenItemMenu;
    }

    public void setCohenItemMenu(JMenuItem cohenItemMenu) {
        this.cohenItemMenu = cohenItemMenu;
    }

    public JMenuItem getArchivoItemSalir() {
        return archivoItemSalir;
    }

    public void setArchivoItemSalir(JMenuItem archivoItemSalir) {
        this.archivoItemSalir = archivoItemSalir;
    }

   
    
}
