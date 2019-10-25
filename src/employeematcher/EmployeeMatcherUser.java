package employeematcher;

import java.util.ArrayList;

public class EmployeeMatcherUser {
  private String uname;
  private String pword;
  private ArrayList<String> desired;
  private String email;

  public EmployeeMatcherUser() {
    uname = "";
    pword = "";
    desired = null;
    email = "";
  }

  public EmployeeMatcherUser(String userName, String password,
                             ArrayList<String> interest, String email) {
    uname = userName;
    pword = password;
    this.desired = (ArrayList<String>) interest.clone();
    System.out.println(desired);
    this.email = email;
    System.out.println(this.toString());
  }
  /*
  public void printUser() {
    System.out.println(uname + " " + pword + " " + desired);
  }
   */

  public String getUName() {
    return this.uname;
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
    String output = uname + "," + pword + "," + email + ",";
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