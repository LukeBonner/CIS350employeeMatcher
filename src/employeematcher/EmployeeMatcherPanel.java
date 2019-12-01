package employeeMatcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.imageio.ImageIO;
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
  private JLabel accountDetail1;
  private JLabel accountDetail2;
  private JLabel accountDetail3;
  private JLabel accountDetail4;
  private JLabel accountDetail5;
  private JLabel accountDetail6;
  private JLabel accountDetail7;
//  private JLabel
//  private JLabel
//  private JLabel
//  private JLabel

  private JLabel displayAccountImages;
  private JLabel emptyArea;
  private String[] fileLocations = {"/Images/commitHistory.png","resumeTemplate.png","letterExample.png"};
  private ImageIcon[] accountImages = new ImageIcon[fileLocations.length];
  private int imageTracker = 0;

  private EmployeeMatcherUser currentUser;


  /**
   *
   */
  public EmployeeMatcherPanel() {
    JPanel displayArea = new JPanel();
    JPanel buttonArea = new JPanel();
    JPanel accountArea = new JPanel();

    this.currentUser = new EmployeeMatcherUser();



    ButtonListener theListener = new ButtonListener();


    this.acceptButton = new JButton("interested");
    this.declineButton = new JButton("not interested");
    this.extremeInterestButton = new JButton("very interested");
    this.slideLastImage = new JButton("<--");
    this.slideNextImage = new JButton("-->");
    this.emptyArea = new JLabel();
    this.displayAccountImages = new JLabel();

    displayArea.setPreferredSize(new Dimension(200,200));
    buttonArea.setLayout(new GridLayout(2,3));
    displayArea.setLayout(new GridLayout(1,1));
    accountArea.setLayout(new GridLayout(4,2));


    buttonArea.add(slideLastImage);
    buttonArea.add(emptyArea);
    buttonArea.add(slideNextImage);
    buttonArea.add(declineButton);
    buttonArea.add(extremeInterestButton);
    buttonArea.add(acceptButton);

    accountArea.add(accountDetail1);
    accountArea.add(accountDetail2);
    accountArea.add(accountDetail3);
    accountArea.add(accountDetail4);
    accountArea.add(accountDetail5);
    accountArea.add(accountDetail6);
    accountArea.add(accountDetail7);



    slideNextImage.addMouseListener(theListener);
    declineButton.addMouseListener(theListener);
    extremeInterestButton.addMouseListener(theListener);
    acceptButton.addMouseListener(theListener);
    slideLastImage.addMouseListener(theListener);

    displayArea.add(displayAccountImages);





    this.add(displayArea, BorderLayout.NORTH);
    this.add(buttonArea, BorderLayout.SOUTH);

    displaySetup();

  }


  public void displaySetup(){
    URL url = null;


//    try{
//      for(int i =0;i<accountImages.length;i++){
//        accountImages[i] = new ImageIcon(ImageIO
//                .read(getClass()
//                .getResource(fileLocations[i]))
//                .getScaledInstance(200,100,Image.SCALE_SMOOTH));
//      }
//    }catch(Exception e){
//      System.out.println(e);
//    }

    accountImages = currentUser.getImages;
    this.displayAccountImages.setIcon(accountImages[imageTracker]);

  }

  public void slideLast(MouseEvent e){
    displayAccountImages.setIcon(accountImages[imageTracker-1]);
    //need to add a conditional for employer/seeker
    accountDetail1.setText(currentUser.getCompanyName());
    accountDetail2.setText(currentUser.getLocation());
    accountDetail3.setText(currentUser.getSize());
    accountDetail4.setText(currentUser.getIndustry());
    accountDetail5.setText(currentUser.getPosition());
    accountDetail6.setText(currentUser.getJobDescription());
    accountDetail7.setText(currentUser.getCompanyDescription()):

    displaySetup();
  }


  private class ButtonListener implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println("Click\n");
    }

    @Override
    public void mousePressed(MouseEvent e) {
      System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if (e.getSource() == slideLastImage) {
        if(imageTracker-1>0){
          slideLast(e);
        }
      } else if (e.getSource() == slideNextImage) {
        if(!(imageTracker+1 > accountImages.length)) {
          slideNext(e);
        }

      } else if (e.getSource() == declineButton) {
        System.out.println("Clicked Decline");
        //currentUser.
      } else if (e.getSource() == extremeInterestButton) {
        System.out.println("Clicked Extreme Interest");
        //currentUser.
      } else if (e.getSource() == acceptButton) {
        System.out.println("Clicked Accept");
        //currentUser.
      }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
  }

  private void slideNext(MouseEvent e) {
    displayAccountImages.setIcon(accountImages[imageTracker+1]);
      accountDetail1.setText(currentUser.getCompanyName());
      accountDetail2.setText(currentUser.getLocation());
      accountDetail3.setText(currentUser.getSize());
      accountDetail4.setText(currentUser.getIndustry());
      accountDetail5.setText(currentUser.getPosition());
      accountDetail6.setText(currentUser.getJobDescription());
      accountDetail7.setText(currentUser.getCompanyDescription()):
    displaySetup();
  }


}
