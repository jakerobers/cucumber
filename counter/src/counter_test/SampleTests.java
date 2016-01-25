package counter_test;

import org.junit.*;
import static org.junit.Assert.*;
import javax.swing.JButton;
import counter_ui.*;

public class SampleTests {
   
   private FrameSample fs;
   private JButton xIncrButton, yIncrButton, exitButton;
   private IntField xcount, ycount;
   
   @Before
   public void setUp() throws Exception {
      fs = new FrameSample();
      xIncrButton = (JButton)TestUtils.getChildNamed(fs, "x_incr");
      yIncrButton = (JButton)TestUtils.getChildNamed(fs, "y_incr");
      exitButton  = (JButton)TestUtils.getChildNamed(fs, "exit");
      xcount = (IntField)TestUtils.getChildNamed(fs, "xcount");
      ycount = (IntField)TestUtils.getChildNamed(fs, "ycount");
      assertNotNull(xIncrButton);
      assertNotNull(yIncrButton);
      assertNotNull(xcount);
      assertNotNull(ycount);
      
      //
      // note: clicking exitButton makes the application exit, so it's not clear how
      //       to test this
      //
   }

   @Test
   public void testIncrementX() {      
      xIncrButton.doClick();
      xIncrButton.doClick();
      assertEquals(2, xcount.intValue());
      assertEquals(0, ycount.intValue());
   }

   @Test
   public void testIncrementY() {      
      yIncrButton.doClick();
      yIncrButton.doClick();
      yIncrButton.doClick();
      assertEquals(0, xcount.intValue());
      assertEquals(3, ycount.intValue());
   }
   
   @Test
   public void testExit() {
   }

}
