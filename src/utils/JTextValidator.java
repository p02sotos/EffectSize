/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Sergio Soriano
 */
public class JTextValidator extends JTextField {
    private Pattern pattern;
    private Border wrongBorder = BorderFactory.createLineBorder(Color.RED);
    private Border defaultBorder;
    /**
    * Constructor.
    * @param regEx Expresión regular para evaluar
    * [abc]                     “a”, “b”, o “c” (simple)
    * [^abc]                   Cualquier carácter excepto “a”, “b”, o “c” (negación)
    * [a-zA-Z]               De la “a” a la “z”, o de la “A” a la “Z”, ambas inclusive(rango)
    * [a-d[m-p]]            De la “a” a la “d”, o de la “m” a la “p”: [a-dm-p] (union)
    * [a-z&&[def]]        “d”, “e”, o “f” (intersección)
    * [a-z&&[^bc]]       “a” a la “z”, excepto “b” y “c”: [ad-z] (resta)
    * [a-z&&[^m-p]]     “a” a la “z”, pero no de la “m” a la “p”: [a-lq-z] (resta)
    *  
    *OTROS RANGOS 
    * [a-z][A-Z] : Por ejemplo aA
    * [a-z][A-Z][0-9] : Por ejemplo aA8
    * [a-z] : De la a la z
    * [^aeiou] : Excepto una vocal
    * Documentación oficial de rangos 
    * CARACTERES ESPECIALES
    * \\w : [a-zA-Z_0-9] : Un caracter
    * \\d. : Un numero y cualquier caracter
    * \\d.[a-z] : Un numero, un caracter cualquiera y una letra
    * \\d\.[a-z] : Un numero, un punto y una letra
    * Documentación oficial de carácteres especiales
    * CUANTIFICADORES
    * \\d{3} : Un numero 3 digitos
    * \\d{n,} : un numero al menos n veces
    * \\d{n,m} : Un numero en n y m veces
    * [aeiou]? : o nada, o solo una vocal
    * x[aeiou]? : x sola, o seguida de una vocal
    * x[aeiou]* : x sola, o x seguida de muchas vocales
    * x[aeiou]+ : x como minimo con una vocal
    * [0-9]* Números
    */
    public JTextValidator (String regEx) {
        super();
        this.defaultBorder = this.getBorder();
        this.setColumns(15);
        this.pattern = Pattern.compile(regEx);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                validateText();
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        
    }
    private void validateText() {
        Matcher matcher = pattern.matcher(this.getText());
        
            if (!matcher.matches()) {
            this.setBorder(wrongBorder);
            this.setText("0");//No deja escribir en el contenido
        } else {
            this.setBorder(defaultBorder);
        }
        
        
    }
    
}
