package employeeMatcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

public class MatcherEmployer extends EmployeeMatcherUser {


  private String companyName;

  private String location;

  private String size;

  private String industry;

  private String position;

  private String jobDescription;

  private String companyDescription;

  private ArrayList<String> images;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherEmployer() {
    uname = "";
    pword = "";
    companyName = "EMPTY";
    location = "";
    size = "";
    industry = "";
    position = "";
    jobDescription = "";
    companyDescription = "";
    images = new ArrayList<String>();
    type = 1;
  }

  public MatcherEmployer(String name){
    uname = "";
    pword = "";
    companyName = name;
    location = "";
    size = "";
    industry = "";
    position = "";
    jobDescription = "";
    companyDescription = "";
    images = new ArrayList<String>();
    type = 1;
    super.matches = new ArrayList<String>();
  }

  public MatcherEmployer(String uname, String pword, String companyName, String location,
                         String size, String industry, String position,
                         String jobDescription, String companyDescription,
                         ArrayList<String> imagepaths, ArrayList<String> matches) {
    this.uname = uname;
    this.pword = pword;
    this.companyName = companyName;
    this.location = location;
    this.size = size;
    this.industry = industry;
    this.position = position;
    this.jobDescription = jobDescription;
    this.companyDescription = companyDescription;
    this.images = imagepaths;
    this.matches = matches;
    type = 1;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public String getCompanyDescription() {
    return companyDescription;
  }

  public void setCompanyDescription(String companyDescription) {
    this.companyDescription = companyDescription;
  }

  // returns arraylist of employer's images
  public ArrayList<String> getImagesEmployer() {
    return images;
  }

  public void addImage(String image) {
    images.add(image);
  }

  public void createProfile(){
    // initial creation of the node
  }

  public void updateProfile(){

  }

  public String toString(){
    return companyName;
  }

  public String toWrite() {
    String output = "1" + "," + uname + "," + pword + "," + companyName + "," + location + ",";
    output += size + "," + industry + "," + position + "," + jobDescription + "," + companyDescription + "|";

    if (images.size() > 0) {
      boolean first = true;
      for (String path : images) {
        if (first) {
          output += path;
          first = false;
          continue;
        }
        output += "," + path;
      }
      output +="|";
    }
    else {
      output += "BLANK|";
    }

    if (matches.size() > 0) {
      boolean first = true;
      for (String match : matches) {
        if (first) {
          output += match;
          first = false;
          continue;
        }
        output += "," + match;
      }
      output +="|*";
    }
    else {
      output += "BLANK|*";
    }
    return output;
  }

}