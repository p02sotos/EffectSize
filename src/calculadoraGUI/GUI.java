/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import calculadorasimplecohen.*;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import utils.ReadFileTXT;

/**
 *
 * @author p02sotos
 * Interfaz gráfica y gestor de eventos básico para introducir los datos
 * 
 */
public class GUI extends JInternalFrame implements ActionListener {
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
    
    public GUI(){
        super("Calculadora de Cohen");
        panelMuestra1 = new Muestras(1);
        panelMuestra2 = new Muestras(2);
        botonResultado = new JButton("Calcular Cohen");
        ficheroBoton = new JButton("Cargar datos"); //Boton para cargar archivo de texyto
        tabPanel = new JTabbedPane();
        resultado = new JLabel();
        mensaje = new JLabel();
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        //Iniciamos el JPanel de los botones e iniciamos el panel
         
        
    
        /****************************************************************
         * Iniciamos la segunda pestaña y añadimos los componentes a ella
         * Esta será más completa.
         ****************************************************************/
        Masivo panelPestana2 = new Masivo();
       // panelFichero.add(ficheroBoton); //Boton al panel de la segunda pestaña
       // ficheroBoton.addActionListener(this);  //Evento del botón
        tabPanel.addTab("Masivo", panelPestana2); // Segunda Pestaña
      
        /****************************
        * Fin de la segunda pestaña
        ****************************/     
         
        
        tabPanel.addTab("Probando", panelPestana2);
        add(tabPanel);
            
            
    
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
            else if (e.getSource() == ficheroBoton) {
                seleccionarFichero = new JFileChooser();
                int fi = seleccionarFichero.showOpenDialog(GUI.this);
                File fichero = seleccionarFichero.getSelectedFile();
                ArrayList lista;
                ReadFileTXT lectura = new ReadFileTXT(fichero, " ");
                lista = lectura.readFromFile();
                
                
                
            };
            
            
        }
    
}
