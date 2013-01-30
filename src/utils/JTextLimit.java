/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author http://www.java2s.com/Tutorial/Java/0240__Swing/LimitJTextFieldinputtoamaximumlength.htm
 */
public class JTextLimit extends PlainDocument {
  private int limit;
  
  
  public JTextLimit(int limit) {
    super();
    this.limit = limit;
  }

  public JTextLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
  }
@Override
  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null) {
      return;
    }
    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
