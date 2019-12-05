package employeeMatcher;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.Key;
import javax.swing.*;

public class EmployeeMatcherUI extends JFrame {

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
    matcherAccountPanel accountPanel = new matcherAccountPanel(user);
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
