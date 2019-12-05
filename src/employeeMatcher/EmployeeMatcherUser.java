package employeeMatcher;

import javax.swing.*;
import java.util.ArrayList;

public class EmployeeMatcherUser {
  protected String uname;
  protected String pword;
  protected ArrayList<String> matches;
  protected int type;
  protected ArrayList<String> images;

  public String getUName() {
    return this.uname;
  }

  public String getPWord() {
    return this.pword;
  }

  public void setUName(String toSet) {
    this.uname = toSet;
  }

  public void setPWord(String toSet) {
    this.pword = toSet;
  }


  public int getType(){
    return type;
  }

  public ArrayList<String> getUserMatches(){
    return matches;
  }

  public void addMatch(String u){
    matches.add(u);
  }

  public ArrayList<String> getImages() {
    return images;
  }

  public void addImage(String image) {
    images.add(image);
  }

  public String toWrite() {
    return "";
  }

}