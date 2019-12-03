package employeeMatcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
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


  private JLabel displayAccountImages;
  private JLabel emptyArea;
  //private String[] fil eLocations = {"/Images/commitHistory.png","resumeTemplate.png","letterExample.png"};
  private ArrayList<ImageIcon> accountImages = new ArrayList<ImageIcon>();
  private int imageTracker = 0;
  private int arrayIndex = 1;

  // user currently using the platform
  private EmployeeMatcherUser currentUser;
  private MatcherSeeker currentSeeker;
  private MatcherEmployer currentEmployer;

  private Hub hubInfo;

  private ArrayList<MatcherSeeker> seekerList;
  private ArrayList<MatcherEmployer> employerList;


  /**
   *
   */
  public EmployeeMatcherPanel() {
    JPanel displayArea = new JPanel();
    JPanel buttonArea = new JPanel();
    JPanel accountArea = new JPanel();

    hubInfo = new Hub();
    hubInfo.createSampleList();
    currentUser = (MatcherSeeker) hubInfo.getSeekers().get(1);

    this.seekerList = hubInfo.getSeekers();
    this.employerList = hubInfo.getEmployers();

    this.accountImages = currentUser.getImages();

    ButtonListener theListener = new ButtonListener();

    this.acceptButton = new JButton("Interested");
    this.declineButton = new JButton("Not Interested");
    this.extremeInterestButton = new JButton("Very Interested");
    this.slideLastImage = new JButton("<--");
    this.slideNextImage = new JButton("-->");
    this.emptyArea = new JLabel();
    this.displayAccountImages = new JLabel();

    displayArea.setPreferredSize(new Dimension(200, 200));
    buttonArea.setLayout(new GridLayout(2, 3));
    displayArea.setLayout(new GridLayout(1, 1));
    accountArea.setLayout(new GridLayout(4, 2));


    buttonArea.add(slideLastImage);
    buttonArea.add(emptyArea);
    buttonArea.add(slideNextImage);
    buttonArea.add(declineButton);
    buttonArea.add(extremeInterestButton);
    buttonArea.add(acceptButton);

    this.accountDetail1 = new JLabel();
    this.accountDetail2 = new JLabel();
    this.accountDetail3 = new JLabel();
    this.accountDetail4 = new JLabel();
    this.accountDetail5 = new JLabel();
    this.accountDetail6 = new JLabel();
    this.accountDetail7 = new JLabel();

    System.out.println(this.currentUser.getType());

    displayCurrentUser();

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
    this.add(accountArea, BorderLayout.CENTER);
    this.add(buttonArea, BorderLayout.SOUTH);

    displaySetup();

  }


  public void displaySetup() {
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

    //accountImages = currentUser.getImages();

    //this.displayAccountImages.setIcon(accountImages.get(imageTracker));

  }

  public void displayCurrentUser() {
    // current user is a seeker
    if (currentUser.getType() == 1) {
      // show seekers
      accountDetail1.setText(seekerList.get(arrayIndex).getFullName());
      accountDetail2.setText(seekerList.get(arrayIndex).getIndustry());
      accountDetail3.setText(seekerList.get(arrayIndex).getPersonalStatement());
      accountDetail4.setText(seekerList.get(arrayIndex).getEducation());
      accountDetail5.setText(seekerList.get(arrayIndex).getExperience());
      accountDetail6.setText(seekerList.get(arrayIndex).getUrls());
    } else {
      // show employers
      accountDetail1.setText(employerList.get(arrayIndex).getCompanyName());
      accountDetail2.setText(employerList.get(arrayIndex).getLocation());
      accountDetail3.setText(employerList.get(arrayIndex).getSize());
      accountDetail4.setText(employerList.get(arrayIndex).getIndustry());
      accountDetail5.setText(employerList.get(arrayIndex).getPosition());
      accountDetail6.setText(employerList.get(arrayIndex).getJobDescription());
      accountDetail7.setText(employerList.get(arrayIndex).getCompanyDescription());
    }
  }

  public EmployeeMatcherUser getCurrentUser() {
    return currentUser;
  }

  public void advanceList() {

    if (currentUser.getType() == 0) {
      if (arrayIndex < hubInfo.getNumEmployers() - 1) {
        arrayIndex++;
        if (hubInfo.usersMatched(currentUser, employerList.get(arrayIndex))) {
          advanceList();
        }
        displayCurrentUser();
      }
    } else {
      if (arrayIndex < hubInfo.getNumSeekers()) {
        arrayIndex++;
        if (hubInfo.usersMatched(currentUser, seekerList.get(arrayIndex))) {
          advanceList();
        }
        displayCurrentUser();
      }
    }
  }

  public void slideLast(MouseEvent e) {
    System.out.println("Back button");
    if (imageTracker - 1 > 0) {
      displayAccountImages.setIcon(accountImages.get(imageTracker - 1));
      //need to add a conditional for employer/seeker


      displaySetup();
    } else {
      System.out.println("At beginning of list, can't go back further");
    }
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
        System.out.println("Previous image");
        if (imageTracker - 1 > 0) {
          slideLast(e);
        }
      } else if (e.getSource() == slideNextImage) {
        System.out.println("Next Image");
        if (!(imageTracker + 1 > accountImages.size())) {
          slideNext(e);
        }

      } else if (e.getSource() == declineButton) {
        advanceList();
      } else if (e.getSource() == extremeInterestButton) {
        System.out.println("Clicked Extreme Interest");
        advanceList();
        //currentUser.
      } else if (e.getSource() == acceptButton) {
        System.out.println("Clicked Accept");
        System.out.println(currentUser.getType());
        hubInfo.addLikeMatrix(currentUser, employerList.get(arrayIndex));
        advanceList();

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
    //displayAccountImages.setIcon(accountImages.get(imageTracker+1));

    if (currentUser.getType() == 1) {
      // show seekers
      accountDetail1.setText(seekerList.get(arrayIndex).getFullName());
      accountDetail2.setText(seekerList.get(arrayIndex).getIndustry());
      accountDetail3.setText(seekerList.get(arrayIndex).getPersonalStatement());
      accountDetail4.setText(seekerList.get(arrayIndex).getEducation());
      accountDetail5.setText(seekerList.get(arrayIndex).getExperience());
      accountDetail6.setText(seekerList.get(arrayIndex).getUrls());
    } else {
      // show employers
      accountDetail1.setText(employerList.get(arrayIndex).getCompanyName());
      accountDetail2.setText(employerList.get(arrayIndex).getLocation());
      accountDetail3.setText(employerList.get(arrayIndex).getSize());
      accountDetail4.setText(employerList.get(arrayIndex).getIndustry());
      accountDetail5.setText(employerList.get(arrayIndex).getPosition());
      accountDetail6.setText(employerList.get(arrayIndex).getJobDescription());
      accountDetail7.setText(employerList.get(arrayIndex).getCompanyDescription());
    }
    displaySetup();
  }


}