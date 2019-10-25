package employeematcher;

import java.awt.*;
import javax.swing.*;


public class EmployeeMatcherUI extends JFrame {
  public EmployeeMatcherUI(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.getContentPane().add(new EmployeeMatcherPanel());
    this.setSize(500,500);
    this.setPreferredSize(new Dimension(500,500));
    this.setVisible(true);
  }




  public static void main(String[] args) {
    new EmployeeMatcherUI("Employment Matcher!");
  }

}

