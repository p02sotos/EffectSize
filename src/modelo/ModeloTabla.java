package modelo;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author p02sotos
 */
public class ModeloTabla  extends AbstractTableModel  {
    
    private Muestras filaMuestra;
    private ArrayList muestras;
    private ModeloTabla modeloTabla;
    private Muestras muestraBase;
    public String[] columnNames = {"Media", "Desviación", "Tamaño"};

    public ModeloTabla() {
        super();
        muestraBase = new Muestras();
        muestras = new ArrayList();
        muestras.add(muestraBase);
        addTableModelListener(null);
    }
    public void addFila(Muestras nuevaFila) {
          muestras.add(nuevaFila);
          fireTableDataChanged();
            
        }
    public void removeFila() {
          int temp = getRowCount();
          if (temp>0){
          
          muestras.remove(temp-1);
          fireTableDataChanged();
          }
          else {
              JOptionPane.showMessageDialog(new JFrame("Error"),
                "No hay filas para eliminar");
          }            
        }
    public void limpiarTabla(){
        while (getRowCount()!=0) {
             removeFila();
        }
    }       
    public void addMuestras (ArrayList<Muestras> val) {
         for (int i = 0; i<val.size() ; i++ ) {
                addFila(val.get(i));
            }
    }    
    public Muestras getMuestras (int rowIndex) {
        Muestras aux = (Muestras)muestras.get(rowIndex);        
         return aux;
            }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }  
    @Override
    public int getRowCount() {
        int temp;
        temp = muestras.size();
        return temp;
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col) {
      return columnNames[col];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Muestras aux = (Muestras)muestras.get(rowIndex);
        String aux2;
        switch (columnIndex) {
            case 0:
                return String.valueOf(aux.getM());                
            case 1:
                return String.valueOf(aux.getD());
            case 2:
                return String.valueOf(aux.getN());
            default:
                return null;        
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Muestras aux = (Muestras)muestras.get(rowIndex);         
        switch(columnIndex){ 
            case 0: 
                 aux.setM(aValue.toString());  
                break;
            case 1: 
                 aux.setD(aValue.toString());  
                break;
            case 2: 
                  aux.setN(aValue.toString());  
                break;
        }
        // Disparamos el Evento TableDataChanged (La tabla ha cambiado) 
        fireTableDataChanged(); 
    } 
}
