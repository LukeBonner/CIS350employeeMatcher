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
    this.accountdetails = new JPanel();
    accountdetails.setLayout(new GridLayout(7,1));


    this.accountInfoPanel = new accountInfoPanel();
    accountInfoPanel.setLayout(new GridLayout(5,1));





    this.accountDetail1 = new JLabel();
    this.accountDetail2 = new JLabel();
    this.accountDetail3 = new JLabel();
    this.accountDetail4 = new JLabel();
    this.accountDetail5 = new JLabel();
    this.accountDetail6 = new JLabel();
    this.accountDetail7 = new JLabel();

    this.accountDetails = new JLabel();

    EmployeeMatcherPanel p = new EmployeeMatcherPanel();
    currentUser = p.getCurrentUser();


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


    this.add(accountDetails, BorderLayout.NORTH);
    this.add(accountInfoPanel, BorderLayout.SOUTH);




  }
}