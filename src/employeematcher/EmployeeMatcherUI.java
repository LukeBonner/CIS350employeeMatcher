package EmployeeMatcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * The Graphical User Interface for this application.
 *
 * <p>Creating an instance of this class launches the application. To do so, it creates instances
 * of the EmployeeMatcherPanel, MatcherAccountPanel, and MatcherMatchesPanel classes to represent
 * the three tabs of the window. The program prompts the user for a username and password.
 * Upon entering a valid combination, the main application is launched, and the application can be
 * used. When the application is closed, the program is terminated.
  * @author Luke Bonner, Sim Grewal, Zackary Klimek, Adam Weaver
  * @version 12/6/2019
 */
public class EmployeeMatcherUI extends JFrame {

  /**
   * Create the window for the application.
   *
   * <p>By running this constructor, the user will be prompted for a username and password.
   * If they input "!Q" for either entry, the program terminates. If the username is invalid,
   * the user is prompted again until they enter a valid username/password combination. Once a
   * valid combination of username and password has been entered, the application is launched.
   * @param title  The title to display at the top of the window.
   * @param hubInfo  An instance of the Hub class from which the application can authenticate
   *                 and access the current user.
   */
  public EmployeeMatcherUI(String title, Hub hubInfo) {
    super(title);

    EmployeeMatcherUser user = new EmployeeMatcherUser();
    Boolean isValid = false;
    while (!isValid) {
      try {
        String username = JOptionPane.showInputDialog("Please enter your username, or !Q to quit");
        if (username.equals("!Q")) {
          return;
        }
        String password = JOptionPane.showInputDialog("Please enter you password, or !Q to quit.");
        if (password.equals("!Q")) {
          return;
        }
        user = hubInfo.setCurrentUser(username, password);
        isValid = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
      }
    }

    JTabbedPane tabs = new JTabbedPane();
    EmployeeMatcherPanel matcherPanel = new EmployeeMatcherPanel(user);
    MatcherAccountPanel accountPanel = new MatcherAccountPanel(user);
    MatcherMatchesPanel matchesPanel = new MatcherMatchesPanel(user, matcherPanel.getStorage());

    tabs.add("Feed", matcherPanel);
    tabs.setMnemonicAt(0, KeyEvent.VK_1);

    tabs.add("My Account", accountPanel);
    tabs.setMnemonicAt(1, KeyEvent.VK_2);

    tabs.add("Matches", matchesPanel);
    tabs.setMnemonicAt(2, KeyEvent.VK_3);

    this.add(tabs, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setSize(830, 500);
    this.setPreferredSize(new Dimension(830, 500));
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    Hub hubInfo = new Hub(false);
    new EmployeeMatcherUI("Employment Matcher 9000", hubInfo);
  }
}
