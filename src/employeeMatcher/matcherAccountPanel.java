package employeeMatcher;

import javax.swing.*;
import java.awt.*;

public class matcherAccountPanel extends JPanel {
  private JPanel accountDetails;
  private JPanel accountInfoPanel;
  private JLabel accountDetail1;
  private JLabel accountDetail2;
  private JLabel accountDetail3;
  private JLabel accountDetail4;
  private JLabel accountDetail5;
  private JLabel accountDetail6;
  private JLabel accountDetail7;
  private EmployeeMatcherUser currentUser;
  private Hub hubInfo;


  public matcherAccountPanel(EmployeeMatcherUser user) {
    hubInfo = new Hub(true);
    hubInfo.createSampleList();
    currentUser = user;
    System.out.println("Current User: " + currentUser);

    this.accountDetails = new JPanel();
    this.setLayout(new GridLayout(7,1));


    this.accountInfoPanel = new JPanel();






    this.accountDetail1 = new JLabel("");
    this.accountDetail2 = new JLabel("");
    this.accountDetail3 = new JLabel("");
    this.accountDetail4 = new JLabel("");
    this.accountDetail5 = new JLabel("");
    this.accountDetail6 = new JLabel("");
    this.accountDetail7 = new JLabel("");

    this.accountDetails = new JPanel();

    if (currentUser.getType() == 0) {
      MatcherSeeker s = (MatcherSeeker) currentUser;
      // show seekers
      accountDetail1.setText("Name: " + s.getFullName());
      accountDetail2.setText("Industry: " + s.getIndustry());
      accountDetail3.setText("Personal Statement: " + s.getPersonalStatement());
      accountDetail4.setText("Education: " + s.getEducation());
      accountDetail5.setText("Experience: " + s.getExperience());
      accountDetail6.setText("Links: " + s.getUrls());
    } else {
      // show employers
      MatcherEmployer e = (MatcherEmployer) currentUser;

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