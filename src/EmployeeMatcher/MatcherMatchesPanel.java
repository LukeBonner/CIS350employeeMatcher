package EmployeeMatcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatcherMatchesPanel extends JPanel {
  private JLabel matches;
  private JPanel accountInfoPanel;
  private Hub hubInfo;
  private EmployeeMatcherUser currentUser;


  public MatcherMatchesPanel(EmployeeMatcherUser user, ArrayList<EmployeeMatcherUser> storage) {
    currentUser = user;
    JLabel label;
    ArrayList<String> matches = currentUser.getUserMatches();

    System.out.println("Current user: " + currentUser.getUName());
    System.out.println("Matches: " + matches);
    for(int i =0;i<currentUser.getUserMatches().size();i++){
      label = labelBlueprint();
      for (EmployeeMatcherUser e : storage) {
        if (e.getUName().equals(matches.get(i))) {
          if (e.type == 1) {
            label.setText("Match " + (i + 1) + ": " + ((MatcherEmployer)e).getCompanyName());
          }
          else {
            label.setText("Match " + (i + 1) + ": " + ((MatcherSeeker) e).getFullName());
          }
        }
      }

      this.add(label);
    }
    this.matches = new JLabel();
    JPanel accountPanel = new JPanel();
    this.setLayout(new GridLayout(5,5));
    //this.add(matches);


    this.matches = new JLabel();
    this.accountInfoPanel = new JPanel();


    accountInfoPanel.setLayout(new GridLayout(2, 1));


    accountPanel.setLayout(new GridLayout(2, 1));
    //accountPanel.add(matches);
    accountInfoPanel.add(accountPanel);





  }

  public JLabel labelBlueprint(){
    JLabel label = new JLabel();

    label.setPreferredSize(new Dimension(50,50));

    return label;
  }
}