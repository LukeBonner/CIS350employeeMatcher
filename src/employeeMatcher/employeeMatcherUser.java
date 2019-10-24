package employeeMatcher;

import java.util.ArrayList;

public class employeeMatcherUser {
    private String uName;
    private String pword;
    private ArrayList<String> desired;
    private String email;

    public employeeMatcherUser()
    {
        uName = "";
        pword = "";
        desired = null;
        email = "";
    }

    public employeeMatcherUser(String userName, String password, ArrayList<String> interest, String email) {
        uName = userName;
        pword = password;
        this.desired = (ArrayList<String>) interest.clone();
        System.out.println(desired);
        this.email = email;
        System.out.println(this.toString());
    }
    /*
    public void printUser() {
        System.out.println(uName + " " + pword + " " + desired);
    }
     */

    public String getUName() {
        return this.uName;
    }

    public String getPWord() {
        return this.pword;
    }

    public ArrayList<String> getDesired() {
        return this.desired;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString() {
        String output = uName + "," + pword + "," + email + ",";
        if (desired.size() == 0) {
            output += "BLANK|";
            return output;
        }
        output += desired.get(0);
        for (int i = 1; i < (this.desired).size(); i++) {
            output += ", " + desired.get(i);
        }
        output += "|\n";
        return output;
    }

}
