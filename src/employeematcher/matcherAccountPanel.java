package employeematcher;

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


    }
}
