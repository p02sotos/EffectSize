/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import calculadorasimplecohen.*;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author p02sotos
 * Interfaz gráfica y gestor de eventos básico para introducir los datos
 * 
 */
public class GUI extends JFrame implements ActionListener {
    private Muestras panelMuestra1;
    private Muestras panelMuestra2;
    private JButton botonResultado;
    private JLabel resultado;
    private JLabel mensaje;
    private JPanel panelResultados;
    private JTabbedPane tabPanel;
    private JPanel panelSimple;
    
    public GUI(){
        super("Calculadora de Cohen");
        panelMuestra1 = new Muestras(1);
        panelMuestra2 = new Muestras(2);
        botonResultado = new JButton("Calcular Cohen");
        tabPanel = new JTabbedPane();
        resultado = new JLabel();
        mensaje = new JLabel();
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        //FlowLayout dis = new FlowLayout(FlowLayout.CENTER, 40, 40);
        /****************************************************************
         * Iniciamos la primera pestaña y añadimos los componentes a ella.
         ****************************************************************/
        GridLayout dis1 = new GridLayout(4, 1);
        panelSimple = new JPanel(dis1);
        GridLayout dis2 = new GridLayout(1, 2);
        panelResultados = new JPanel(dis2);
        //Iniciamos el Layout del Frame
        panelSimple.add(panelMuestra1);
        panelSimple.add(panelMuestra2);
        panelSimple.add(botonResultado);
        panelSimple.add(panelResultados);
        panelResultados.add(resultado);
        panelResultados.add(mensaje);
        tabPanel.addTab("Cálculo Simple", panelSimple);
        add(tabPanel);
        /**/
        
        /****************************
         * Fin de la primera pestaña
         ****************************/        
        
        //Iniciamos el JPanel de los botones e iniciamos el panel
        botonResultado.addActionListener(this);  
        setVisible(true);
        /****************************************************************
         * Iniciamos la segunda pestaña y añadimos los componentes a ella
         * Esta será más completa.
         ****************************************************************/
            
    
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
            };
            
        }
    
}
