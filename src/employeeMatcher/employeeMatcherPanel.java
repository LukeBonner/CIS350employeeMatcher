package employeeMatcher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class employeeMatcherPanel extends JPanel {
    private JButton acceptButton;
    private JButton declineButton;
    private JButton extremeInterestButton;
    private JButton slideNextImage;
    private JButton slideLastImage;
    private JLabel emptyArea;


    public employeeMatcherPanel(){
        JPanel displayArea = new JPanel();
        JPanel buttonArea = new JPanel();
   /*
        File in = null;
        ArrayList<employeeMatcherUser> storage = new ArrayList<employeeMatcherUser>();
        Scanner scnr;
        try {
            in = new File("db.txt");
            scnr = new Scanner(in);
            String curr = "";
            String cName = "";
            String cPass = "";
            ArrayList<String> cInterest = new ArrayList<String>();
            String cAddress = "";
            int i = 0;
            while (scnr.hasNext()) {
                curr = scnr.nextLine();
                StringTokenizer st = new StringTokenizer(curr, ",|", true);
                //System.out.println(st.toString());
                String cTok = "";
                while (st.hasMoreTokens()) {
                    cTok = st.nextToken();
                    if (cTok.equals(",")) {
                        //System.out.println("Skipping a comma...");
                        continue;
                    }
                    if (cTok.equals("|")) {
                        boolean valid = true;
                        for (int j = 0; j < storage.size(); j++) {
                            if (cName.equals((storage.get(j)).getUName())) {
                                System.out.println("Username " + cName + " is taken! New User Rejected!");
                                valid = false;
                            }
                        }
                        if (valid) {
                            employeeMatcherUser toAdd = new employeeMatcherUser(cName, cPass, cInterest, cAddress);
                            storage.add(toAdd);
                        }
                        i = 0;
                        cInterest.clear();
                        continue;
                    }
                    if (i == 0) {
                        cName = cTok;
                        i++;
                    } else if (i == 1) {
                        cPass = cTok;
                        i++;
                    } else if (i == 2) {
                        cAddress = cTok;
                        i++;
                    } else {
                        cInterest.add(cTok);
                        i++;
                    }
                    //System.out.println(cTok);
                }
            }


            System.out.println("Now attempting to print storage");
            if (storage.size() == 0) {
                System.out.println("Storage EMPTY! Read Failed!");
            }
            System.out.println(storage);

            File fout = new File("db.txt");
            FileWriter out = new FileWriter(fout);
            for (int j = 0; j < storage.size(); j++) {
                String toPrint = (storage.get(j)).toString();
                if (toPrint.equals("")) {
                    System.out.printf("ToString failed");
                }
                out.write(toPrint);
            }
            out.flush();
            out.close();
        }

        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if (in != null) {
                in = null;
            }
        }


    */


        this.acceptButton = new JButton("interested");
        this.declineButton = new JButton("not interested");
        this.extremeInterestButton = new JButton("very interested");
        this.slideLastImage = new JButton("<--");
        this.slideNextImage = new JButton("-->");
        this.emptyArea = new JLabel();
        buttonArea.setLayout(new GridLayout(2,3));
        displayArea.setLayout(new GridLayout(1,1));


        buttonArea.add(slideLastImage);
        buttonArea.add(emptyArea);
        buttonArea.add(slideNextImage);
        buttonArea.add(declineButton);
        buttonArea.add(extremeInterestButton);
        buttonArea.add(acceptButton);




        this.add(displayArea, BorderLayout.CENTER);
        this.add(buttonArea, BorderLayout.SOUTH);

    }

    private class buttonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==slideLastImage){

            }else if(e.getSource() == slideNextImage){

            }else if(e.getSource()== declineButton){

            }else if(e.getSource()==extremeInterestButton){

            }else if(e.getSource()==acceptButton){

            }
        }
    }



}
