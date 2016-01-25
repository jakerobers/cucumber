//
//IntField.java: text field specialized for storing, getting integers
//

package counter_ui;

import javax.swing.*;
import javax.swing.text.*;

public class IntField extends JTextField {
   private static final long serialVersionUID = 1L;

   public IntField(int cols) {
      super(cols);
   }

   public int intValue() {
      if (getText().equals(""))
         return 0;
      int result;
      try {
         result = Integer.parseInt(getText());
      } catch (NumberFormatException e) {
         throw new IllegalStateException("Non-digit in IntField.");
      }
      return result;
   }

   protected Document createDefaultModel() {
      return new IntDocument();
   }

   static class IntDocument extends PlainDocument {
      private static final long serialVersionUID = 1L;

      public void insertString(int offs, String str, AttributeSet attribs)
            throws BadLocationException {
         if (str == null) {
            return;
         }
         char[] input = str.toCharArray();
         String toInsert = new String("");
         for (int i = 0; i < input.length; i++) {
            if (Character.isDigit(input[i]))
               toInsert = toInsert + input[i];
         }
         super.insertString(offs, toInsert, attribs);
      }
   }
}
