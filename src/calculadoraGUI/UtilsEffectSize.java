/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author biblioteca
 */
public class UtilsEffectSize extends JPanel {
    private JTextField textConvertirD,textConvertirT, textConvertirR, textResultadoConvertirD
            ,textResultadoConvertirT, textResultadoConvertirR;
    private ButtonGroup botonesGrupo;
    private JButton btnConvetirD;
    private JRadioButton rbtnD, rbtnT, rbtnR;

    private boolean d,r,t;

    public UtilsEffectSize() {
        super();
        d = true;
        r = false;
        t = false;
        //Bordes
        Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bordeNegro = BorderFactory.createLineBorder(Color.black);
        Border bordeCompuesto = BorderFactory.createCompoundBorder(padding, bordeNegro);
        //Layout
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        //Grupo de Radio Buttons
        botonesGrupo = new ButtonGroup();
        rbtnD = new JRadioButton("Convertir d de Cohen a t de Student");
        rbtnD.setSelected(true);
        rbtnR = new JRadioButton("Convertir d de Cohen eta cuadrado");
        rbtnT = new JRadioButton("Convertir d de Cohen a ");
        botonesGrupo.add(rbtnD);
        botonesGrupo.add(rbtnR);
        botonesGrupo.add(rbtnT);
        
        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        panelBotones.add(rbtnD);
        panelBotones.add(rbtnR);
        panelBotones.add(rbtnT);
        panelBotones.setPreferredSize(new Dimension(370, 100));
        panelBotones.setBorder(bordeCompuesto);
        add(panelBotones);
        btnConvetirD = new JButton("Convertir");
        add(btnConvetirD);
    
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
