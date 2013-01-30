package calculadoraGUI;

import controller.CalcularCohen;
import modelo.EditorTabla;
import modelo.Muestras;
import modelo.ModeloTabla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.ModeloTablaResultado;
import utils.JTextLimit;
 /**
 *
 * @author p02sotos
 */
public class Masivo extends JPanel implements ActionListener {
    private File fichero;
    private JFileChooser seleccionarFichero;
    private JTable tabla,tablaResultado;
    private JButton btnCargar = new JButton("Cargar");
    private JButton btnAdd = new JButton("Añadir");
    private JButton btnRemove = new JButton("Eliminar");
    private JButton btnCalcular = new JButton("Calcular");
    private JScrollPane scroll, scroll2;
    private JTextField separadorArchivo;
    private JTextArea areaResultado;
    private ArrayList listaCargada;
    private ArrayList<Muestras> listaConvertida;
    private ModeloTabla modeloTabla;
    private EditorTabla editor;
    private boolean origenDatos;
    private DefaultTableModel modeloTablaResultado;


    public Masivo() {        
        origenDatos= false;
        Border bordeNormalNegro = BorderFactory.createLineBorder(Color.black);
        Border bordeTituloNegro = BorderFactory.createTitledBorder("Muestras");
        setBorder(bordeTituloNegro);
        modeloTabla = new ModeloTabla();
        tabla = new JTable(modeloTabla);
        editor = new EditorTabla();
        modeloTablaResultado = new DefaultTableModel();
        tablaResultado = new JTable(modeloTablaResultado);
        tabla.setDefaultEditor(Object.class, editor);
        tabla.setRowHeight(30);
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(370, 285));
        scroll2 = new JScrollPane(tablaResultado);
        scroll2.setPreferredSize(new Dimension(370, 330));
        tabla.setFillsViewportHeight(true);
        tablaResultado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaResultado.doLayout();
        add(scroll);
        add(btnRemove);
        add(btnCalcular);        
        add(btnAdd);
        btnRemove.addActionListener(this);
        btnCargar.addActionListener(this);  //Evento del botón
        btnAdd.addActionListener(this);
        btnCalcular.addActionListener(this);
        //areaResultado = new JTextArea("Esperando Resultado...", 5,20 );
        add(scroll2);
        separadorArchivo = new JTextField(5);
        separadorArchivo.setDocument(new JTextLimit(1));
        add(new JLabel("Delimitador de archivo"));
        add(separadorArchivo);
        add(btnCargar); //Boton al panel de la segunda pestaña
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionarFichero = new JFileChooser();
        if (e.getSource() == btnCargar) {
            String sep;
            int fi = seleccionarFichero.showOpenDialog(Masivo.this);
            fichero = seleccionarFichero.getSelectedFile();
            System.out.print(separadorArchivo.getText());
            if ("".equals(separadorArchivo.getText())){
                sep = " ";                
            }
            else {
                sep = separadorArchivo.getText();               
            }
             ReadFileTXT lectura = new ReadFileTXT(fichero); 
            listaCargada = lectura.readFromFile(sep);
           
            listaConvertida = lectura.convertir(listaCargada);
            modeloTabla.limpiarTabla();            
            modeloTabla.addMuestras(listaConvertida);
            origenDatos = true;
        }
        else if (e.getSource() == btnAdd) {
           modeloTabla.addFila(new Muestras());            
        }
        else if (e.getSource() == btnRemove) {
           modeloTabla.removeFila();            
        }
        else if (e.getSource() == btnCalcular) {
            ModeloTablaResultado modeloNuevo = new ModeloTablaResultado(modeloTabla.getRowCount(), modeloTabla.getRowCount());
            tablaResultado.setModel(modeloNuevo);           
           //System.out.println("Columnas de la tabla " + modeloNuevo.getColumnCount());
           //System.out.println("Filas de la tabla " + modeloNuevo.getRowCount());           
           for (int i=0 ; i<modeloNuevo.getRowCount() ; i++){
                for (int j=0 ; j < modeloNuevo.getRowCount(); j++) {
                    double temp2; 
                    temp2 = CalcularCohen.calcular(modeloTabla.getMuestras(i), modeloTabla.getMuestras(j));
                    System.out.println("Valor de Cohen " + temp2);
                    System.out.println("Fila " + i + " Columna " + j);                    
                    modeloNuevo.setValueAt(temp2, i, j+1);
                    modeloNuevo.fireTableDataChanged();
                }
           }
        }
    }
}

  