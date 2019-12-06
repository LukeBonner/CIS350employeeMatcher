package EmployeeMatcher;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.net.URL;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *The "Feed" Panel in the Graphical User Interface
 *
 * <p>This class creates and manages the feed section of the EmployeeMatcherGUI
 * class. To do so, it creates and manages several text labels containing information
 * on users the current user can match with. To provide interactions with that user,
 * it also features buttons to express interest and disinterest in the currently
 * displayed buttons. The functions of these buttons, as well as the content of
 * the labels, is determined and managed by its instance of the Hub class, which itself
 * accesses the latest version of the information from its storage files.
 * @author Luke Bonner, Sim Grewal, Zackary Klimek, Adam Weaver
 * @version 12/6/2019
 */
public class EmployeeMatcherPanel extends JPanel {
  /**
   * The button to "like" a presented user.
   *
   * <p>This button is used to express interest in the currently presented user.
   * If clicking this button causes an update in the hub's records, it will save the hub's
   * current state.
   */
  private JButton acceptButton;

  /**
   * The button to "dislike" a presented user.
   *
   * <p>This button is used to express disinterest in the currently presented user.
   * If clicking this button causes an update in the hub's records, it will save the hub's
   * current state.
   */
  private JButton declineButton;

  /**
   * The button to move to the next image.
   *
   * <p>This button is used to change the currently displayed image to the next image.
   * If there is no next image, the button has no effect.
   */
  private JButton slideNextImage;

  /**
   * The button to move to the previous image.
   *
   * <p>This button is used to change the currently displayed image to the previous image.
   * If there is no previous image, the button has no effect.
   */
  private JButton slideLastImage;

  /**
   * The first text label.
   *
   * <p>This text label displays either the name of the presented job seeker or company, or
   * nothing if there is no presented user.
   */
  private JLabel accountDetail1;

  /**
   * The second text label.
   *
   * <p>This text label displays either the field of the presented job seeker, the location
   * of the company, or nothing if there is no presented user.
   */
  private JLabel accountDetail2;

  /**
   * The third text label.
   *
   * <p>This text label displays either the personal statement of the presented job seeker, the size
   * of the company, or nothing if there is no presented user.
   */
  private JLabel accountDetail3;

  /**
   * The fourth text label.
   *
   * <p>This text label displays either the education experience of the presented job seeker, the
   * industry of the company, or nothing if there is no presented user.
   */
  private JLabel accountDetail4;

  /**
   * The fifth text label.
   *
   * <p>This text label displays either the experience of the presented job seeker, the available
   * position at the company, or nothing if there is no presented user.
   */
  private JLabel accountDetail5;

  /**
   * The sixth text label.
   *
   * <p>This text label displays either the urls provided by the presented job seeker, the
   * description of the position at the company, or nothing if there is no presented user.
   */
  private JLabel accountDetail6;

  /**
   * The seventh text label.
   *
   * <p>This text label displays either the description of the presented employer
   * or nothing if there is no presented user or the presented user is a job seeker.
   */
  private JLabel accountDetail7;

  /**
   * The label in which images are placed.
   *
   * <p>This JLabel is where any images found are displayed. These
   * images are stored as strings for their image paths. They are
   * then loaded into the panel as ImageIcons, and can be scrolled through
   * using the provided buttons.
   */
  private JLabel displayAccountImages;

  /**
   * The images to be displayed.
   *
   * <p>In order to populate the displayAccountImages label, the
   * panel creates and maintains an array of ImageIcons. These ImageIcons
   * are generated in the constructor based on the fileLocations provided.
   */
  private ImageIcon[] accountImages;

  /**
   * The paths of the images to be displayed.
   *
   * <p>In order to populate the accountImages, the panel attempts to open
   * ImageIcons found at certain paths. These paths are encoded as Strings,
   * which are then converted into ImageIcons in the constructor.
   */
  private String[] fileLocations = {"/Images/letterExample.png",
      "/Images/resumeTemplate.png", "/Images/commitHistory.png"};

  /**
   * A counter of what image the panel is displaying.
   *
   * <p>The images to be displayed are stored in an array. To keep track
   * of what image is displayed, and allow the panel to move between them,
   * this integer counter is used. Its value will always be between 0 and the
   * size of the image array.
   */
  private int imageTracker = 0;

  /**
   * A counter of what profile the feed is viewing.
   *
   * <p>To keep track of what user the panel is currently presenting, the panel
   * uses the hub's ArrayList of MatcherSeekers and MatcherEmployers. In order to
   * effectively manage what user to display from these lists, the panel maintains
   * an integer index of the current entry in that list. This value will always
   * remain between 0 and the size of the lists read and stored from the hub.
   */
  private int arrayIndex = 0;

  /**
   * The current user for whom the panel is being constructed.
   *
   * <p>The panel stores the user who has logged in to the application. Using this
   * user's information, this class populates its text fields appropriately.
   */
  private EmployeeMatcherUser currentUser;

  /**
   *The matching manager used by the panel.
   *
   * <p>This hubInfo variable accesses the information needed for the panel to operate.
   * It allows the panel to handle such functions as matching users, moving past users that
   * the current user has already matched with, and getting the information to display for
   * the panel's text fields.
   * @see Hub
   */
  private Hub hubInfo;

  /**
   * A list of job seekers to potentially display.
   *
   * <p>This list is populated using values from the hubInfo object. It stores
   * the MatcherSeekers found by the hubInfo into an ArrayList to allow for access
   * without having to continually consult the hubInfo. The information in this list is
   * used to help make matches and display information.
   */
  private ArrayList<MatcherSeeker> seekerList;

  /**
   * A list of employers to potentially display.
   *
   * <p>This list is populated using values from the hubInfo object. It stores
   * the MatcherEmployers found by the hubInfo into an ArrayList to allow for access
   * without having to continually consult the hubInfo. The information in this list is
   * used to help make matches and display information.
   */
  private ArrayList<MatcherEmployer> employerList;


  /**
   * Create the Feed panel for the current user provided.
   *
   * <p>Given an EmployeeMatcherUser object representing the current, user, set up
   * the Feed section of the GUI to contain the necessary information.
   * @param user  the current user, provided by the EmployeeMatcherUI
   */
  public EmployeeMatcherPanel(EmployeeMatcherUser user) {
    this.setLayout(new GridLayout(3, 1));

    hubInfo = new Hub(false);

    currentUser = user;
    this.accountImages = new ImageIcon[fileLocations.length];


    this.seekerList = hubInfo.getSeekers();
    this.employerList = hubInfo.getEmployers();
    System.out.println("Panel's Current User: " + currentUser);
    System.out.println("Panel's Display: " + seekerList.get(arrayIndex)
        + " " + seekerList.get(arrayIndex).getType());

    this.acceptButton = new JButton("Interested");
    this.declineButton = new JButton("Not Interested");
    this.slideLastImage = new JButton("<--");
    this.slideNextImage = new JButton("-->");
    JLabel emptyArea = new JLabel();
    this.displayAccountImages = new JLabel();

    JPanel displayArea = new JPanel();
    JPanel buttonArea = new JPanel();
    JPanel accountArea = new JPanel();

    buttonArea.setLayout(new GridLayout(2, 2));
    displayArea.setLayout(new GridLayout(1, 1));
    accountArea.setLayout(new GridLayout(2, 4));

    displayArea.setPreferredSize(new Dimension(200, 200));



    buttonArea.add(slideLastImage);
    buttonArea.add(slideNextImage);
    buttonArea.add(declineButton);
    buttonArea.add(acceptButton);

    this.accountDetail1 = new JLabel();
    this.accountDetail2 = new JLabel();
    this.accountDetail3 = new JLabel();
    this.accountDetail4 = new JLabel();
    this.accountDetail5 = new JLabel();
    this.accountDetail6 = new JLabel();
    this.accountDetail7 = new JLabel();


    displayCurrentUser();

    accountArea.add(accountDetail1);
    accountArea.add(accountDetail2);
    accountArea.add(accountDetail3);
    accountArea.add(accountDetail4);
    accountArea.add(accountDetail5);
    accountArea.add(accountDetail6);
    accountArea.add(accountDetail7);

    JLabel emptyAccountDetail = new JLabel();
    accountArea.add(emptyAccountDetail);


    ButtonListener theListener = new ButtonListener();
    slideNextImage.addMouseListener(theListener);
    declineButton.addMouseListener(theListener);
    acceptButton.addMouseListener(theListener);
    slideLastImage.addMouseListener(theListener);

    displayArea.add(displayAccountImages);


    this.add(displayArea);
    this.add(accountArea);
    this.add(buttonArea);

    displaySetup();
    advanceList();

  }

  /**
   * Run initial setup on the images contained in the panel.
   *
   * <p>This method creates and displays the images for the panel based on the current user.
   */
  public void displaySetup() {
    URL url = null;
    try {
      for (int i = 0; i < accountImages.length; i++) {
        accountImages[i] = new ImageIcon(ImageIO
            .read(getClass()
                .getResource(fileLocations[i]))
            .getScaledInstance(200, 100, Image.SCALE_SMOOTH));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    this.displayAccountImages.setIcon(accountImages[imageTracker]);
  }

  /**
   * Get the hubInfo field's current storage.
   *
   * <p>This method accesses the information from the hubInfo object
   * to pass on to other classes. Specifically, it accesses the hubInfo's
   * current storage to get all users currently in its system.
   * @return an ArrayList of all users of this application currently in memory.
   */
  public ArrayList<EmployeeMatcherUser> getStorage() {
    return this.hubInfo.storage.getStorage();
  }

  /**
   * Update the text fields to display the current user.
   *
   * <p>This method accesses the seekerList and employerList in order to
   * get information from a user to show in the panel. It gets the needed
   * information from the element in these lists found at index arrayIndex.
   * Which list is accessed depends on the type of the current user. If the
   * type of the current user is MatcherEmployer, it accesses the seekerList.
   * Otherwise, it accesses the employerList.
   */
  public void displayCurrentUser() {
    // current user is a seeker
    if (currentUser.getType() == 1) {
      // show seekers
      accountDetail1.setText("Name: " + seekerList.get(arrayIndex).getFullName());
      accountDetail2.setText("Field: " + seekerList.get(arrayIndex).getIndustry());
      accountDetail3.setText("Personal Statement: "
          + seekerList.get(arrayIndex).getPersonalStatement());
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
   * <p>If the current user has exhausted their possible matches, this method
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
    acceptButton.setEnabled(false);
    declineButton.setEnabled(false);
  }

  /**
   * Advance the display of the panel.
   *
   * <p>This method updates the panel's display by moving the arrayIndex up until it either
   * exceeds the possible values or finds a user with whom the current user has not yet matched.
   * To do so, it recursively calls itself until it either exceeds the index of the list it is
   * searching or finds a user that can has not been matched yet. If the arrayIndex exceeds the
   * possible values, this method calls the displayNoneLeft method.
   */
  public void advanceList() {
    try {
      if (currentUser.getType() == 0) {
        if (arrayIndex < hubInfo.getNumEmployers()) {
          arrayIndex++;
          if (hubInfo.usersMatched(currentUser, employerList.get(arrayIndex))) {
            advanceList();
          }
          displayCurrentUser();
        } else {
          displayNoneLeft();
        }
      } else {
        if (arrayIndex < hubInfo.getNumSeekers()) {
          arrayIndex++;
          System.out.println("Matched: "
                  + hubInfo.usersMatched(currentUser, seekerList.get(arrayIndex)));
          if (hubInfo.usersMatched(currentUser, seekerList.get(arrayIndex))) {
            advanceList();
          }
          displayCurrentUser();
        } else {
          displayNoneLeft();
        }
      }
    } catch (Exception e) {
      displayNoneLeft();
    }
  }

  /**
   * Move the imageTracker back, and display the relevant image.
   */
  public void slideLast() {
    if (imageTracker - 1 > 0) {
      imageTracker--;
      ImageIcon replace = accountImages[imageTracker];
      this.displayAccountImages.setIcon(replace);
      displaySetup();
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
        if (currentUser.getType() == 0) {
          if (hubInfo.addLikeMatrix(currentUser, employerList.get(arrayIndex))) {
            JOptionPane.showMessageDialog(null,
                    "You and " + employerList.get(arrayIndex).getCompanyName() + " have Matched!");
            hubInfo.saveMatrix("matrix.txt");
          }
        } else {
          if (hubInfo.addLikeMatrix(currentUser, seekerList.get(arrayIndex))) {
            JOptionPane.showMessageDialog(null,
                    "You and " + seekerList.get(arrayIndex).getFullName() + " have Matched!");
            hubInfo.saveMatrix("matrix.txt");
          }
        }
        advanceList();

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