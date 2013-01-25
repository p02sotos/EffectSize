/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import modelo.EditorTabla;
import modelo.Muestras;
import modelo.ModeloTabla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import controller.ReadFileTXT;

/**
 *
 * @author p02sotos
 */
public class Masivo extends JPanel implements ActionListener {

    private File fichero;
    private JFileChooser seleccionarFichero;
    private JTable tabla;
    private JButton btnCargar = new JButton("Cargar");
    private JButton btnAdd = new JButton("Añadir");
    private JButton btnRemove = new JButton("Eliminar");
    private JScrollPane scroll;
    private ArrayList listaCargada;
    private ModeloTabla modeloTabla;
    private EditorTabla editor;
    
    

    public Masivo() {
        
        
        Border bordeNormalNegro = BorderFactory.createLineBorder(Color.black);
        Border bordeTituloNegro = BorderFactory.createTitledBorder("Muestras");
        setBorder(bordeTituloNegro);
        modeloTabla = new ModeloTabla();
        tabla = new JTable(modeloTabla);
        editor = new EditorTabla();
        tabla.setDefaultEditor(Object.class, editor);
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(270, 185));
        tabla.setFillsViewportHeight(true);
        add(scroll);
        add(btnRemove);
        add(btnCargar); //Boton al panel de la segunda pestaña
        add(btnAdd);
        btnRemove.addActionListener(this);
        btnCargar.addActionListener(this);  //Evento del botón
        btnAdd.addActionListener(this);

        JLabel et1 = new JLabel("Etiqueta 1", JLabel.CENTER);
        JLabel et2 = new JLabel("Etiqueta 2", JLabel.CENTER);
        JLabel et3 = new JLabel("Etiqueta 3", JLabel.CENTER);
        JLabel et4 = new JLabel("Etiqueta 4", JLabel.CENTER);
}

    @Override
    public void actionPerformed(ActionEvent e) {

        seleccionarFichero = new JFileChooser();

        if (e.getSource() == btnCargar) {

            int fi = seleccionarFichero.showOpenDialog(Masivo.this);
            fichero = seleccionarFichero.getSelectedFile();

            ReadFileTXT lectura = new ReadFileTXT(fichero, " ");
            listaCargada = lectura.readFromFile();
            System.out.print("hola");

        }
        else if (e.getSource() == btnAdd) {
           modeloTabla.addFila(new Muestras());
            
        }
        else if (e.getSource() == btnRemove) {
           modeloTabla.removeFila();
            
        }
        


    }
}

  