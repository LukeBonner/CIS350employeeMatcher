package employeeMatcher;

import javax.swing.*;
import java.awt.*;

public class matcherAccountPanel extends JPanel {

  private JLabel accountDetails;
  private JLabel matches;


  public matcherAccountPanel(){
    this.accountDetails = new JLabel();
    this.matches = new JLabel();
    JPanel accountPanel = new JPanel();
    accountPanel.setLayout(new GridLayout(2,1));
    accountPanel.add(accountDetails);
    accountPanel.add(matches);

    private JLabel accountDetails;
    private JLabel matches;
    private JPanel accountInfoPanel;


    public matcherAccountPanel(){
        this.accountDetails = new JLabel();
        this.matches = new JLabel();
        this.accountInfoPanel = new JPanel();


        accountInfoPanel.setLayout(new GridLayout(2,1));







        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new GridLayout(2,1));
        accountPanel.add(accountDetails);
        accountPanel.add(matches);
        accountInfoPanel.add(accountPanel);



        this.add(accountInfoPanel,BorderLayout.CENTER);



  }
}