package employeeMatcher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class employeeMatcherPanel extends JPanel {
    private JButton acceptButton;
    private JButton declineButton;
    private JButton extremeInterestButton;
    private JButton slideNextImage;
    private JButton slideLastImage;
    private JLabel emptyArea;


    /**
     *
     */
    public employeeMatcherPanel(){
        JPanel displayArea = new JPanel();
        JPanel buttonArea = new JPanel();



        buttonListener theListener = new buttonListener();


        this.acceptButton = new JButton("interested");
        this.declineButton = new JButton("not interested");
        this.extremeInterestButton = new JButton("very interested");
        this.slideLastImage = new JButton("<--");
        this.slideNextImage = new JButton("-->");
        this.emptyArea = new JLabel();
        displayArea.setPreferredSize(new Dimension(200,200));
        buttonArea.setLayout(new GridLayout(2,3));
        displayArea.setLayout(new GridLayout(1,1));


        buttonArea.add(slideLastImage);
        buttonArea.add(emptyArea);
        buttonArea.add(slideNextImage);
        buttonArea.add(declineButton);
        buttonArea.add(extremeInterestButton);
        buttonArea.add(acceptButton);


        slideNextImage.addActionListener(theListener);
        declineButton.addActionListener(theListener);
        extremeInterestButton.addActionListener(theListener);
        acceptButton.addActionListener(theListener);
        slideLastImage.addActionListener(theListener);





        this.add(displayArea, BorderLayout.CENTER);
        this.add(buttonArea, BorderLayout.SOUTH);

    }

    private class buttonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==slideLastImage){
                //to be placed: ability to slide to last account image

            }else if(e.getSource() == slideNextImage){
                //to be placed: ability to slide to next account image

            }else if(e.getSource()== declineButton){
                //to be placed: decline user and move on to next

            }else if(e.getSource()==extremeInterestButton){
                //to be placed: show heightened interest and allow other user to know

            }else if(e.getSource()==acceptButton){
                //to be placed: show interest and move onto next user

            }
        }
    }



}
