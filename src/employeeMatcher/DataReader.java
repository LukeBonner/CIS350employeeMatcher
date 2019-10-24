package employeeMatcher;

import java.util.*;
import java.io.*;

public class DataReader {
    private ArrayList<employeeMatcherUser> storage = new ArrayList<employeeMatcherUser>();
    
    public DataReader() {
        this("db.txt");
    }
    
    public DataReader(String path) {
        File in = null;
        Scanner scnr;
        try {
            in = new File(path);
            scnr = new Scanner(in);
            String curr = "";
            String cName = "";
            String cPass = "";
            ArrayList<String> cInterest = new ArrayList<String>();
            String cEmail = "";
            int i = 0;
            while (scnr.hasNext()) {
                curr = scnr.nextLine();
                StringTokenizer st = new StringTokenizer(curr, ",|", true);
                String cTok = "";
                while (st.hasMoreTokens()) {
                    cTok = st.nextToken();
                    if (cTok.equals(",")) {
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
                            employeeMatcherUser toAdd = new employeeMatcherUser(cName, cPass, cInterest, cEmail);
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
                        cEmail = cTok;
                        i++;
                    } else {
                        cInterest.add(cTok);
                    }
                }
            }


            System.out.println(storage);
            if (storage.size() == 0) {
                System.out.println("Storage EMPTY! Read Failed!");
            }

        }

        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if (in != null) {
                in = null;
            }
        }
    }

    public void saveStorage() {
        this.saveStorage("db.txt");
    }

    public void saveStorage(String path) {
        File fout = new File(path);
        try{
            FileWriter out = new FileWriter(fout);
            for (employeeMatcher.employeeMatcherUser employeeMatcherUser : storage) {
                String toPrint = employeeMatcherUser.toString();
                if (toPrint.equals("")) {
                    System.out.println("ToString failed");
                }
                out.write(toPrint);
                out.flush();
            }
            out.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
