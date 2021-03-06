//
// TestUtils.java: utilities to test Java swing UIs
//
// From http://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
//
package counter_test;

import java.awt.*;
import javax.swing.*;

public class TestUtils {

   static int counter;

   public static Component getChildNamed(Component parent, String name) {

      // Debug line
      // System.out.println("Class: " + parent.getClass() +
      // " Name: " + parent.getName());

      if (name.equals(parent.getName())) {
         return parent;
      }

      if (parent instanceof Container) {
         Component[] children = (parent instanceof JMenu) ? ((JMenu) parent)
               .getMenuComponents() : ((Container) parent).getComponents();

         for (int i = 0; i < children.length; ++i) {
            Component child = getChildNamed(children[i], name);
            if (child != null) {
               return child;
            }
         }
      }

      return null;
   }

   public static Component getChildIndexed(Component parent, String klass,
         int index) {
      counter = 0;

      // Step in only owned windows and ignore its components in JFrame
      if (parent instanceof Window) {
         Component[] children = ((Window) parent).getOwnedWindows();

         for (int i = 0; i < children.length; ++i) {
            // take only active windows
            if (children[i] instanceof Window
                  && !((Window) children[i]).isActive()) {
               continue;
            }

            Component child = getChildIndexedInternal(children[i], klass, index);
            if (child != null) {
               return child;
            }
         }
      }

      return null;
   }

   private static Component getChildIndexedInternal(Component parent,
         String klass, int index) {

      // Debug line
      // System.out.println("Class: " + parent.getClass() +
      // " Name: " + parent.getName());

      if (parent.getClass().toString().endsWith(klass)) {
         if (counter == index) {
            return parent;
         }
         ++counter;
      }

      if (parent instanceof Container) {
         Component[] children = (parent instanceof JMenu) ? ((JMenu) parent)
               .getMenuComponents() : ((Container) parent).getComponents();

         for (int i = 0; i < children.length; ++i) {
            Component child = getChildIndexedInternal(children[i], klass, index);
            if (child != null) {
               return child;
            }
         }
      }

      return null;
   }
}
