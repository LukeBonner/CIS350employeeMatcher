package employeematcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 */
public class EmployeeMatcherPanel extends JPanel {
  private JButton acceptButton;
  private JButton declineButton;
  private JButton extremeInterestButton;
  private JButton slideNextImage;
  private JButton slideLastImage;
  private JLabel emptyArea;


  /**
   *
   */
  public EmployeeMatcherPanel() {
    JPanel displayArea = new JPanel();
    JPanel buttonArea = new JPanel();



    ButtonListener theListener = new ButtonListener();


    this.acceptButton = new JButton("interested");
    this.declineButton = new JButton("not interested");
    this.extremeInterestButton = new JButton("very interested");
    this.slideLastImage = new JButton("<--");
    this.slideNextImage = new JButton("-->");
    this.emptyArea = new JLabel();
    displayArea.setPreferredSize(new Dimension(200,200));
    buttonArea.setLayout(new GridLayout(2,3));
    displayArea.setLayout(new GridLayout(1,1));


    buttonArea.add(slideLastImage);
    buttonArea.add(emptyArea);
    buttonArea.add(slideNextImage);
    buttonArea.add(declineButton);
    buttonArea.add(extremeInterestButton);
    buttonArea.add(acceptButton);


    slideNextImage.addActionListener(theListener);
    declineButton.addActionListener(theListener);
    extremeInterestButton.addActionListener(theListener);
    acceptButton.addActionListener(theListener);
    slideLastImage.addActionListener(theListener);





    this.add(displayArea, BorderLayout.CENTER);
    this.add(buttonArea, BorderLayout.SOUTH);

  }

  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == slideLastImage) {
        System.out.println("Clicked Previous Image");
      } else if (e.getSource() == slideNextImage) {
        System.out.println("Clicked Next Image");
      } else if (e.getSource() == declineButton) {
        System.out.println("Clicked Decline");
      } else if (e.getSource() == extremeInterestButton) {
        System.out.println("Clicked Extreme Interest");
      } else if (e.getSource() == acceptButton) {
        System.out.println("Clicked Accept");
      }
    }
  }



}
