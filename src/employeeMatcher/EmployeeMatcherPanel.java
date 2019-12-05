package employeeMatcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 */
public class EmployeeMatcherPanel extends JPanel {
  private JButton acceptButton;
  private JButton declineButton;
  private JButton slideNextImage;
  private JButton slideLastImage;
  private JLabel accountDetail1;
  private JLabel accountDetail2;
  private JLabel accountDetail3;
  private JLabel accountDetail4;
  private JLabel accountDetail5;
  private JLabel accountDetail6;
  private JLabel accountDetail7;
  private JLabel emptyAccountDetail;

  //private JTextArea noMatchesLeft;

  private JLabel displayAccountImages;
  private JLabel emptyArea;
  private ImageIcon[] accountImages;
  private String[] fileLocations = {"/Images/letterExample.png","/Images/resumeTemplate.png","/Images/commitHistory.png"};
  //private ArrayList<ImageIcon> accountImages = new ArrayList<ImageIcon>();
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
  public EmployeeMatcherPanel(EmployeeMatcherUser user) {
    this.setLayout(new GridLayout(3,1));
    JPanel displayArea = new JPanel();
    JPanel buttonArea = new JPanel();
    JPanel accountArea = new JPanel();

    hubInfo = new Hub(false);

    //hubInfo.createSampleList();
/*
    fileLocations = currentUser.getImages().toArray(new String[0]);
    if(currentUser.getType() == 0)
      fileLocations = currentSeeker.getImages().toArray(new String[0]);
    else
      fileLocations = currentEmployer.getImages().toArray(new String[0]);
*/
    currentUser = user;
    this.accountImages = new ImageIcon[fileLocations.length];


    this.seekerList = hubInfo.getSeekers();
    this.employerList = hubInfo.getEmployers();
    System.out.println("Panel's Current User: " + currentUser);
    System.out.println("Panel's Display: " + seekerList.get(arrayIndex) + " " + seekerList.get(arrayIndex).getType());



    ButtonListener theListener = new ButtonListener();

    this.acceptButton = new JButton("Interested");
    this.declineButton = new JButton("Not Interested");
    this.slideLastImage = new JButton("<--");
    this.slideNextImage = new JButton("-->");
    this.emptyArea = new JLabel();
    this.displayAccountImages = new JLabel();

    displayArea.setPreferredSize(new Dimension(200, 200));

    buttonArea.setLayout(new GridLayout(2, 2));
    displayArea.setLayout(new GridLayout(1, 1));
    accountArea.setLayout(new GridLayout(2, 4));


    buttonArea.add(slideLastImage);
    //buttonArea.add(emptyArea);
    buttonArea.add(slideNextImage);
    buttonArea.add(declineButton);
   // buttonArea.add(emptyArea);
    buttonArea.add(acceptButton);

    this.accountDetail1 = new JLabel();
    this.accountDetail2 = new JLabel();
    this.accountDetail3 = new JLabel();
    this.accountDetail4 = new JLabel();
    this.accountDetail5 = new JLabel();
    this.accountDetail6 = new JLabel();
    this.accountDetail7 = new JLabel();
    this.emptyAccountDetail = new JLabel();

    //this.noMatchesLeft = new JTextArea();
   // noMatchesLeft.setVisible(false);

//    System.out.println(this.currentUser.getType());
  //  System.out.println(this.currentUser);

    displayCurrentUser();

    accountArea.add(accountDetail1);
    accountArea.add(accountDetail2);
    accountArea.add(accountDetail3);
    accountArea.add(accountDetail4);
    accountArea.add(accountDetail5);
    accountArea.add(accountDetail6);
    accountArea.add(accountDetail7);
    accountArea.add(emptyAccountDetail);
    //accountArea.add(noMatchesLeft);

    slideNextImage.addMouseListener(theListener);
    declineButton.addMouseListener(theListener);
    acceptButton.addMouseListener(theListener);
    slideLastImage.addMouseListener(theListener);

    displayArea.add(displayAccountImages);


    this.add(displayArea);
    this.add(accountArea);
    this.add(buttonArea);

    displaySetup();

  }


  public void displaySetup() {


    URL url = null;
/*    try{
      for(int i =1; i < fileLocations.length;i++){
        accountImages[i] = new ImageIcon(ImageIO.read(getClass().getResource(fileLocations[i])).getScaledInstance(200,100,Image.SCALE_SMOOTH));
      }
    }catch(Exception e){
      System.out.println(e);
    }*/
       try{
      for(int i =0;i<accountImages.length;i++){
        accountImages[i] = new ImageIcon(ImageIO
                .read(getClass()
                .getResource(fileLocations[i]))
                .getScaledInstance(200,100,Image.SCALE_SMOOTH));
      }
    }catch(Exception e){
      System.out.println(e);
   }

    //accountImages = currentUser.getImages();

    this.displayAccountImages.setIcon(accountImages[imageTracker]);

  }

  public ArrayList<EmployeeMatcherUser> getStorage() {
    return this.hubInfo.storage.getStorage();
  }

  public void displayCurrentUser() {
    // current user is a seeker
    if (currentUser.getType() == 1) {
      // show seekers
      accountDetail1.setText("Name: " + seekerList.get(arrayIndex).getFullName());
      accountDetail2.setText("Field: " + seekerList.get(arrayIndex).getIndustry());
      accountDetail3.setText("Personal Statement: " + seekerList.get(arrayIndex).getPersonalStatement());
      accountDetail4.setText("Education: " + seekerList.get(arrayIndex).getEducation());
      accountDetail5.setText("Experience: " + seekerList.get(arrayIndex).getExperience());
      accountDetail6.setText("Links: " + seekerList.get(arrayIndex).getUrls());
    } else {
      // show employers
      accountDetail1.setText("Company: " + employerList.get(arrayIndex).getCompanyName());
      accountDetail2.setText("Location: " + employerList.get(arrayIndex).getLocation());
      accountDetail3.setText("Size: " + employerList.get(arrayIndex).getSize());
      accountDetail4.setText("Industry: " + employerList.get(arrayIndex).getIndustry());
      accountDetail5.setText("Position: " + employerList.get(arrayIndex).getPosition());
      accountDetail6.setText("Description: " + employerList.get(arrayIndex).getJobDescription());
      accountDetail7.setText("About Us: " + employerList.get(arrayIndex).getCompanyDescription());
    }
  }

  /**
   * Display a message stating that no matchable users remain in the list.
   *
   * If the current user has exhausted their possible matches, this method
   * edits the accountDetail objects to state a message informing the user
   * that no matches remain.
   */

  public void displayNoneLeft() {
    accountDetail1.setText("");
    accountDetail2.setText("NO MATCHES");
    accountDetail3.setText("REMAINING");
    accountDetail4.setText("");
    accountDetail5.setText("");
    accountDetail6.setText("");
    accountDetail7.setText("");
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
      else {
        displayNoneLeft();
      }
    } else {
      if (arrayIndex < hubInfo.getNumSeekers() - 1) {
        arrayIndex++;
        if (hubInfo.usersMatched(currentUser, seekerList.get(arrayIndex))) {
          advanceList();
        }
        displayCurrentUser();
      }
      else {
        displayNoneLeft();
      }
    }
  }

  public void slideLast() {
    System.out.println("Back button");
    if (imageTracker - 1 > 0) {
      imageTracker--;
      ImageIcon replace = accountImages[imageTracker];
      this.displayAccountImages.setIcon(replace);
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
      hubInfo.printTheMatrix();
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
          slideLast();
        }
      } else if (e.getSource() == slideNextImage) {
        System.out.println("Next Image");
        if (!(imageTracker + 1 >= accountImages.length)) {
          slideNext();
        }

      } else if (e.getSource() == declineButton) {
        advanceList();
      } else if (e.getSource() == acceptButton) {
        System.out.println("Clicked Accept");
        System.out.println(currentUser.getType());
        if(currentUser.getType() == 0){
          if (hubInfo.addLikeMatrix(currentUser, employerList.get(arrayIndex))) {
            JOptionPane.showMessageDialog(null, "You and " + employerList.get(arrayIndex).getCompanyName() + " have Matched!");
            hubInfo.saveMatrix("matrix.txt");
          }
        }
        else{
          if (hubInfo.addLikeMatrix(currentUser, seekerList.get(arrayIndex))) {
            JOptionPane.showMessageDialog(null, "You and " + seekerList.get(arrayIndex).getFullName() + " have Matched!");
            hubInfo.saveMatrix("matrix.txt");
          }
        }
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

  private void slideNext() {
    //displayAccountImages.setIcon(accountImages.get(imageTracker+1));
    imageTracker++;
    ImageIcon replace = accountImages[imageTracker];
    this.displayAccountImages.setIcon(replace);


    displaySetup();
  }


}