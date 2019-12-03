package employeeMatcher;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import javax.swing.*;


public class EmployeeMatcherUI extends JFrame {

  public EmployeeMatcherUI(String title) {
    super(title);

    int user = JOptionPane.showInputdialog()
    JTabbedPane tabs = new JTabbedPane();
    EmployeeMatcherPanel matcherPanel = new EmployeeMatcherPanel();
    matcherAccountPanel accountPanel = new matcherAccountPanel();
    MatcherMatchesPanel matchesPanel = new MatcherMatchesPanel();

    tabs.add("Feed", matcherPanel);
    tabs.setMnemonicAt(0, KeyEvent.VK_1);

    tabs.add("Account", accountPanel);
    tabs.setMnemonicAt(1, KeyEvent.VK_2);

    tabs.add("Matches", matchesPanel);
    tabs.setMnemonicAt(2, KeyEvent.VK_3);

    this.add(tabs, BorderLayout.CENTER);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    this.setSize(500, 500);
    this.setPreferredSize(new Dimension(500, 500));
    this.pack();
    this.setVisible(true);
  }


  public static void main(String[] args) {
    new EmployeeMatcherUI("Employment Matcher!");
  }

}
