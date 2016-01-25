//
// FrameSample.java: sample frame gui
//

package counter_ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameSample extends JFrame implements ActionListener
{ 
   private static final long serialVersionUID = 1L;

   private JButton xButton    = new JButton("Incr. X");
   private JButton yButton    = new JButton("Incr. Y");
   private JButton exitButton = new JButton("Exit");

   // updatable field
   private IntField xcount = new IntField(5);
   // view-only field
   private IntField ycount = new IntField(5);

   private JLabel xClicked = new JLabel("X Clicked");
   private JLabel yClicked = new JLabel("Y Clicked");

   public FrameSample()
   {
      super("Sample Frame");
      setSize(650, 400); // larger than needed; resizing done below

      xButton.setName("x_incr");
      yButton.setName("y_incr");
      exitButton.setName("exit");
      xcount.setName("xcount");
      ycount.setName("ycount");
      xClicked.setName("x_label");
      yClicked.setName("y_label");
      
      // a bit of magic to halt the application if the user closes the window
      addWindowListener(
            new WindowAdapter() {
               public void windowClosing(WindowEvent event) { System.exit(0); }
            });

      // main box; everything placed in this
      JPanel box = new JPanel();
      box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
      getContentPane().add(box);

      // set up tool bar; notice buttons placed left to right against right 
      //    edge
      JPanel toolbar = new JPanel();
      toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT));
      xButton.addActionListener(this);
      toolbar.add(xButton);
      yButton.addActionListener(this);
      toolbar.add(yButton);
      exitButton.addActionListener(this);
      toolbar.add(exitButton);
      box.add(toolbar, BorderLayout.NORTH);

      // create labels and fields
      xcount.setText("0");
      ycount.setText("0");
      ycount.setEditable(false);

      JLabel xcountName = new JLabel("X Count", JLabel.RIGHT);
      JLabel ycountName = new JLabel("Y Count", JLabel.RIGHT);

      JPanel dataPanel = new JPanel();
      dataPanel.setLayout(new GridLayout(2, 2, 5, 5));

      dataPanel.add(xcountName);
      dataPanel.add(ycountName);
      dataPanel.add(xcount);
      dataPanel.add(ycount);
      box.add(dataPanel);

      JPanel responsePanel = new JPanel();
      responsePanel.setLayout(new GridLayout(1, 2, 5, 5));
      box.add(responsePanel);

      responsePanel.add(xClicked);
      responsePanel.add(yClicked);

      // resize frame
      pack();

      // hide x, y click labels
      xClicked.setVisible(false);
      yClicked.setVisible(false);
   }

   public void actionPerformed(ActionEvent event)
   {
      // hide clicked labels each time event occurs
      xClicked.setVisible(false);
      yClicked.setVisible(false);
      // handle event
      if ( event.getSource() == xButton )
         xButtonClick();
      else if ( event.getSource() == yButton )
         yButtonClick();
      else if ( event.getSource() == exitButton )
         System.exit(0);
   }

   private void xButtonClick()
   {
      xClicked.setVisible(true);
      incrementField(xcount);
   }

   private void yButtonClick()
   {
      yClicked.setVisible(true);
      incrementField(ycount);
   }

   private void incrementField(IntField fld)
   {
      int val = fld.intValue();
      fld.setText(Integer.toString(val + 1));
   }

   public static void main(String[] args)
   {
      FrameSample sample = new FrameSample();
      sample.setVisible(true);
   }
}
