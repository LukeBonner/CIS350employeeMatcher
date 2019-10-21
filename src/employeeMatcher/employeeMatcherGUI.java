package employeeMatcher;

import javax.swing.*;
import java.awt.*;

public class employeeMatcherGUI extends JFrame {
    public employeeMatcherGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(new employeeMatcherPanel());
        this.setSize(500,500);
        this.setPreferredSize(new Dimension(500,500));
        this.setVisible(true);
    }




    public static void main(String[] args){

    }

}

