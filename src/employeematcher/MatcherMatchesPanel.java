package EmployeeMatcher;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The "Matches" Panel in the Graphical User Interface.
 *
 * <p>This class creates and populates the "Matches" tab of the application. Since this
 * portion of the application only displays information on the current user, it has no buttons or
 * other user inputs. If the current user has matched with no other users, it will appear as an
 * empty panel.
 * @author Luke Bonner, Sim Grewal, Zackary Klimek, Adam Weaver
 * @version 12/6/2019
 */
public class MatcherMatchesPanel extends JPanel {

  /**
   * Creates the panel based on a provided user and the current data.
   *
   * <p>This constructor creates a panel, then populates it with a visual listing
   * of matches that the provided user has made. These matches are displayed in the format
   * "Match i: name", where i is the number of the match and name is either the full name
   * of the job seeker with whom the current user has matched or the name of a company with
   * whom the current user has matched. Since a user can only match with users of the opposite
   * type, which is displayed is determined by the type of the user. If the provided user
   * is a MatcherSeeker, it displays matches as company names. If the provided user is a
   * MatcherEmployer, it displays matches as the full names of the job seekers.
   * @param user  An EmployeeMatcherUser representing the current user. The matches list
   *              of this user determines what users, if any, will appear in this panel.
   * @param storage  An ArrayList of EmployeeMatchers. This is extracted from the state of the
   *                 data contained by the Hub class when the application is launched.
   */
  public MatcherMatchesPanel(EmployeeMatcherUser user, ArrayList<EmployeeMatcherUser> storage) {
    JLabel label;
    ArrayList<String> matches = user.getUserMatches();

    System.out.println("Current user: " + user.getUName());
    System.out.println("Matches: " + matches);
    for (int i = 0; i < user.getUserMatches().size(); i++) {
      label = labelBlueprint();
      for (EmployeeMatcherUser e : storage) {
        if (e.getUName().equals(matches.get(i))) {
          if (e.type == 1) {
            label.setText("Match " + (i + 1) + ": " + ((MatcherEmployer)e).getCompanyName());
          } else {
            label.setText("Match " + (i + 1) + ": " + ((MatcherSeeker) e).getFullName());
          }
        }
      }

      this.add(label);
    }

    JPanel accountPanel = new JPanel();
    this.setLayout(new GridLayout(5,5));

    JPanel accountInfoPanel = new JPanel();

    accountInfoPanel.setLayout(new GridLayout(2, 1));

    accountPanel.setLayout(new GridLayout(2, 1));
    accountInfoPanel.add(accountPanel);
  }

  /**
   * Creates and sets the size of a JLabel.
   *
   * <p>This private helper method is called by the constructor as it populates the panel.
   * The method simply encapsulates code to create and set the size of JLabels, returning
   * the JLabel it created.
   * @return label  The JLabel created by the method.
   */
  private JLabel labelBlueprint() {
    JLabel label = new JLabel();

    label.setPreferredSize(new Dimension(50,50));

    return label;
  }
}