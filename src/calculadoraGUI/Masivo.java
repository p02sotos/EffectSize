/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

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
import utils.ReadFileTXT;

/**
 *
 * @author p02sotos
 */
public class Masivo extends JPanel implements ActionListener, MouseListener, WindowListener {

    private File fichero;
    private JFileChooser seleccionarFichero;
    private JTable tabla;
    private JButton btnCargar = new JButton("Cargar");
    private JScrollPane scroll;
    private ArrayList listaCargada;

    public Masivo() {
        String[] columnNames = {
            "Media",
            "Desviación",
            "Tamaño Muestral"};
        Object[][] datosIniciales = {
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"},
            {"1", "2", "3"}
        };

        Border bordeNormalNegro = BorderFactory.createLineBorder(Color.black);
        Border bordeTituloNegro = BorderFactory.createTitledBorder("Título");
        setBorder(bordeTituloNegro);
        tabla = new JTable(datosIniciales, columnNames);
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(270, 185));
        tabla.setFillsViewportHeight(true);
        add(scroll);

        add(btnCargar); //Boton al panel de la segunda pestaña
        btnCargar.addActionListener(this);  //Evento del botón

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

        };


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
