package modelo;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author biblioteca
 */
public class ModeloTablaResultado extends AbstractTableModel {   
    private int rowIndex;
    private int columnIndex;
    private Object [][] table;

    public ModeloTablaResultado(int rowIndex, int columnIndex) {
        super();
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        table = new Object[rowIndex][columnIndex+1];        
    }  
    @Override
    public int getRowCount() {
        
        return table.length;
    }
    @Override
    public int getColumnCount() {
        
        return table[0].length ;
    }
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "n1/n2";
        }
        else {
            return String.valueOf(column);
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return rowIndex +1;
        }
        else  {
            return table[rowIndex][columnIndex];
        }        
    }
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        double aux = (Double)aValue;
        table[rowIndex][columnIndex] = aux; 
       
        
        // Disparamos el Evento TableDataChanged (La tabla ha cambiado) 
        fireTableDataChanged(); 
     } 
}
