package EmployeeMatcher;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The "My Account" Panel in the Graphical User Interface.
 *
 * <p>This class creates and populates the "My Account" tab of the application. Since this
 * portion of the application only displays information on the current user, it has no buttons or
 * other user inputs. The information it displays depends on the current user, correctly adjusting
 * the labels on its text to display the correct information.
 * @author Luke Bonner, Sim Grewal, Zackary Klimek, Adam Weaver
 * @version 12/6/2019
 */
public class MatcherAccountPanel extends JPanel {

  /**
   * Create a panel to display information on the current user.
   *
   * <p>Given an EmployeeMatcherUser, create and populate a panel containing the
   * profile information of the provided EmployeeMatcherUser. The specific information displayed
   * changes based on the type of the provided user.
   * @param user  an EmployeeMatcherUser object passed to the panel by the UI. The information for
   *              populating this panel comes from the fields of this object.
   */
  public MatcherAccountPanel(EmployeeMatcherUser user) {
    System.out.println("Current User: " + user);

    this.setLayout(new GridLayout(7, 1));


    JLabel accountDetail1 = new JLabel("");
    JLabel accountDetail2 = new JLabel("");
    JLabel accountDetail3 = new JLabel("");
    JLabel accountDetail4 = new JLabel("");
    JLabel accountDetail5 = new JLabel("");
    JLabel accountDetail6 = new JLabel("");
    JLabel accountDetail7 = new JLabel("");


    if (user.getType() == 0) {
      MatcherSeeker s = (MatcherSeeker) user;
      // show seekers
      accountDetail1.setText("Name: " + s.getFullName());
      accountDetail2.setText("Industry: " + s.getIndustry());
      accountDetail3.setText("Personal Statement: " + s.getPersonalStatement());
      accountDetail4.setText("Education: " + s.getEducation());
      accountDetail5.setText("Experience: " + s.getExperience());
      accountDetail6.setText("Links: " + s.getUrls());
    } else {
      // show employers
      MatcherEmployer e = (MatcherEmployer) user;

      accountDetail1.setText("Company name: " + e.getCompanyName());
      accountDetail2.setText("Location: " + e.getLocation());
      accountDetail3.setText("Size: " + e.getSize());
      accountDetail4.setText("Industry: " + e.getIndustry());
      accountDetail5.setText("Position: " + e.getPosition());
      accountDetail6.setText("Job Description: " + e.getJobDescription());
      accountDetail7.setText("About us: " + e.getCompanyDescription());
    }

    this.add(accountDetail1);
    this.add(accountDetail2);
    this.add(accountDetail3);
    this.add(accountDetail4);
    this.add(accountDetail5);
    this.add(accountDetail6);
    this.add(accountDetail7);
  }
}