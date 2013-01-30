/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import controller.CalcularCohen;
import modelo.Muestras;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import calculadorasimplecohen.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import controller.ReadFileTXT;

/**
 *
 * @author p02sotos
 * Interfaz gráfica y gestor de eventos básico para introducir los datos
 * 
 */
public class CohenGUI extends JInternalFrame implements ActionListener {
    private Muestras panelMuestra1;
    private Muestras panelMuestra2;
    private JButton botonResultado;
    private JLabel resultado;
    private JLabel mensaje;
    private JPanel panelResultados;
    private JTabbedPane tabPanel;
    private JPanel panelSimple;
    private JPanel panelFichero;
    private JButton ficheroBoton;
    private JFileChooser seleccionarFichero;
    
    public CohenGUI(){
        super("Calculadora de Cohen",false, true, false, true);
        panelMuestra1 = new Muestras();
        panelMuestra2 = new Muestras();
        botonResultado = new JButton("Calcular Cohen");
        ficheroBoton = new JButton("Cargar datos"); //Boton para cargar archivo de texyto
        tabPanel = new JTabbedPane();
        resultado = new JLabel();
        mensaje = new JLabel();
        setSize(400, 800);
        setMaximumSize(new Dimension(600, 600));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //setResizable(false);
        //FlowLayout dis = new FlowLayout(FlowLayout.CENTER, 40, 40);
        
        /****************************
         * Layouts de los paneles
         ****************************/   
            GridLayout dis1 = new GridLayout(4, 1);
            GridLayout dis2 = new GridLayout(1, 2);
        //****************************************************************
        
        /****************************************************************
         *Primera Pestaña.
         ****************************************************************/
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bordeNegro = BorderFactory.createLineBorder(Color.black);
        Border bordeCompuesto = BorderFactory.createCompoundBorder(padding, bordeNegro) ;
        panelSimple = new JPanel(dis1);              
        panelResultados = new JPanel(dis2);
        //Iniciamos el Layout del Frame
        panelSimple.add(panelMuestra1);
        panelSimple.add(panelMuestra2);
        panelSimple.add(botonResultado);
        panelSimple.add(panelResultados);
        resultado.setBorder(bordeCompuesto);
        mensaje.setBorder(bordeCompuesto);
        panelResultados.add(resultado);
        panelResultados.add(mensaje);
        botonResultado.addActionListener(this); //Evento en el botón
        tabPanel.addTab("Simple", panelSimple);//Añadimos la pestaña
        /****************************
        * Fin de la primera pestaña
        ****************************/        
       
        /****************************************************************
         * Iniciamos la segunda pestaña y añadimos los componentes a ella
         * Esta será más completa.
         ****************************************************************/
        Masivo panelPestana2 = new Masivo();
        tabPanel.addTab("Masivo", panelPestana2);
        add(tabPanel); 
        
        /****************************
        * Fin de la segunda pestaña
        ****************************/    
        /****************************************************************
         * Iniciamos la tercera pestaña y añadimos los componentes a ella
         * ***************************************************************/
        UtilsEffectSize utilEffect = new UtilsEffectSize();
        tabPanel.addTab("Utilidades Effect Size", utilEffect);
        
        
        
        
        //Iniciamos el LookAndFeel llamando a su método
         
        
    }
    public Muestras getPanelMuestra1() {
        return panelMuestra1;
    }
    public void setPanelMuestra1(Muestras panelMuestra1) {
        this.panelMuestra1 = panelMuestra1;
    }
    public Muestras getPanelMuestra2() {
        return panelMuestra2;
    }
    public void setPanelMuestra2(Muestras panelMuestra2) {
        this.panelMuestra2 = panelMuestra2;
    }
    public JButton getBotonResultado() {
        return botonResultado;
    }
    public void setBotonResultado(JButton botonResultado) {
        this.botonResultado = botonResultado;
    }
    public JLabel getMensaje() {
        return mensaje;
    }
    public void setMensaje(JLabel mensaje) {
        this.mensaje = mensaje;
    }
    public JPanel getPanelResultados() {
        return panelResultados;
    }
    public void setPanelResultados(JPanel panelResultados) {
        this.panelResultados = panelResultados;
    }
    public JTabbedPane getTabPanel() {
        return tabPanel;
    }
    public void setTabPanel(JTabbedPane tabPanel) {
        this.tabPanel = tabPanel;
    }
    public JPanel getPanelSimple() {
        return panelSimple;
    }
    public void setPanelSimple(JPanel panelSimple) {
        this.panelSimple = panelSimple;
    }
    public JPanel getPanelFichero() {
        return panelFichero;
    }
    public void setPanelFichero(JPanel panelFichero) {
        this.panelFichero = panelFichero;
    }
    public JButton getFicheroBoton() {
        return ficheroBoton;
    }
    public void setFicheroBoton(JButton ficheroBoton) {
        this.ficheroBoton = ficheroBoton;
    }
    public JFileChooser getSeleccionarFichero() {
        return seleccionarFichero;
    }
    public void setSeleccionarFichero(JFileChooser seleccionarFichero) {
        this.seleccionarFichero = seleccionarFichero;
    }
    public  void lookAndFeel (){
     //Iniciamos el JPanel de los botones e iniciamos el panel
        
    }
    
    
    @Override
     public void actionPerformed(ActionEvent e) {
         float resTeemporal;
            if (e.getSource() == botonResultado) {
                Muestras a = panelMuestra1;
                Muestras b= panelMuestra2;
                resTeemporal = (float)CalcularCohen.calcular(a, b);
                   
               resultado.setText(
                       "<html> <p style = \"color: red; padding: 10px; text-align: center; margin: auto;\"> "
                       + String.valueOf(resTeemporal)
                       + "</p></html>"
                       );
                mensaje.setText(CalcularCohen.compruebaTamano(resTeemporal));
            }   
    }
}
