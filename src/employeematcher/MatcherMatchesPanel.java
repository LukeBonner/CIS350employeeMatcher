package employeeMatcher;

import javax.swing.*;
import java.awt.*;

public class MatcherMatchesPanel extends JPanel {
  private JLabel matches;
  private JPanel accountInfoPanel;


  public MatcherMatchesPanel() {
    this.matches = new JLabel();
    JPanel accountPanel = new JPanel();
    accountPanel.setLayout(new GridLayout(2, 1));
    accountPanel.add(matches);


    this.matches = new JLabel();
    this.accountInfoPanel = new JPanel();


    accountInfoPanel.setLayout(new GridLayout(2, 1));


    accountPanel.setLayout(new GridLayout(2, 1));
    accountPanel.add(matches);
    accountInfoPanel.add(accountPanel);


    this.add(accountInfoPanel, BorderLayout.CENTER);


  }
}