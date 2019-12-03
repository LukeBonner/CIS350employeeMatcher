package employeeMatcher;

import javax.swing.*;
import java.awt.*;

public class matcherAccountPanel extends JPanel {
  private JLabel accountDetails;
  private JPanel accountInfoPanel;
  private JLabel accountDetail1;
  private JLabel accountDetail2;
  private JLabel accountDetail3;
  private JLabel accountDetail4;
  private JLabel accountDetail5;
  private JLabel accountDetail6;
  private JLabel accountDetail7;
  private EmployeeMatcherUser currentUser;


  public matcherAccountPanel() {
    this.accountDetails = new JLabel();

    EmployeeMatcherPanel p = new EmployeeMatcherPanel();
    currentUser = p.getCurrentUser();


    JPanel accountPanel = new JPanel();
    accountPanel.setLayout(new GridLayout(2, 1));

    this.accountDetail1 = new JLabel();
    this.accountDetail2 = new JLabel();
    this.accountDetail3 = new JLabel();
    this.accountDetail4 = new JLabel();
    this.accountDetail5 = new JLabel();
    this.accountDetail6 = new JLabel();
    this.accountDetail7 = new JLabel();

    if (currentUser.getType() == 0) {
      MatcherSeeker s = (MatcherSeeker) currentUser;
      // show seekers
      accountDetail1.setText(s.getFullName());
      accountDetail2.setText(s.getIndustry());
      accountDetail3.setText(s.getPersonalStatement());
      accountDetail4.setText(s.getEducation());
      accountDetail5.setText(s.getExperience());
      accountDetail6.setText(s.getUrls());
    } else {
      // show employers
      MatcherEmployer e = (MatcherEmployer) currentUser;

      accountDetail1.setText(e.getCompanyName());
      accountDetail2.setText(e.getLocation());
      accountDetail3.setText(e.getSize());
      accountDetail4.setText(e.getIndustry());
      accountDetail5.setText(e.getPosition());
      accountDetail6.setText(e.getJobDescription());
      accountDetail7.setText(e.getCompanyDescription());
    }

    accountPanel.add(accountDetail1);
    accountPanel.add(accountDetail2);
    accountPanel.add(accountDetail3);
    accountPanel.add(accountDetail4);
    accountPanel.add(accountDetail5);
    accountPanel.add(accountDetail6);
    accountPanel.add(accountDetail7);


    this.accountDetails = new JLabel();
    this.accountInfoPanel = new JPanel();


    accountDetails.setLayout(new GridLayout(2, 1));


    accountPanel.setLayout(new GridLayout(2, 1));
    accountPanel.add(accountDetails);
    accountInfoPanel.add(accountPanel);


    this.add(accountInfoPanel, BorderLayout.CENTER);


  }
}