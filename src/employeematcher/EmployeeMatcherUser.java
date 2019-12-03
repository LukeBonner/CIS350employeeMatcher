package employeeMatcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EmployeeMatcherUser {
  private String uname;
  private String pword;
  private ArrayList<String> desired;
  private String email;
  private ArrayList<EmployeeMatcherUser> matches;
  private ArrayList<ImageIcon> images;
  protected int type;

  public EmployeeMatcherUser() {
    uname = "";
    pword = "";
    desired = null;
    email = "";
    matches = new ArrayList<EmployeeMatcherUser>();
    images = new ArrayList<ImageIcon>();
  }

  public EmployeeMatcherUser(String userName, String password,
                             ArrayList<String> interest, String email, ArrayList<ImageIcon> images) {
    uname = userName;
    pword = password;
    this.desired = (ArrayList<String>) interest.clone();
    System.out.println(desired);
    this.email = email;
    matches = new ArrayList<EmployeeMatcherUser>();
    this.images = images;
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

  public void setUName(String uname) {
    this.uname = uname;
  }

  public void setPWord(String pword){
    this.pword = pword;
  }

  public ArrayList<String> getDesired() {
    return this.desired;
  }

  public String getEmail() {
    return this.email;
  }

  public int getType() {
    return type;
  }

  public ArrayList<ImageIcon> getImages() {
    return images;
  }

  public void addImage(ImageIcon image) {
    images.add(image);
  }

  public ArrayList<EmployeeMatcherUser> getUserMatches() {
    return matches;
  }

  public void addMatch(EmployeeMatcherUser u) {
    matches.add(u);
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