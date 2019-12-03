package employeeMatcher;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class MatcherEmployer extends EmployeeMatcherUser {
  private String companyName;

  private String location;

  private String size;

  private String industry;

  private String position;

  private String jobDescription;

  private String companyDescription;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherEmployer() {
    companyName = "EMPTY";
    location = "";
    size = "";
    industry = "";
    position = "";
    jobDescription = "";
    companyDescription = "";
    type = 1;
  }

  public MatcherEmployer(String companyName, String location,
                         String size, String industry, String position,
                         String jobDescription, String companyDescription,
                         ArrayList<ImageIcon> images) {
    this.companyName = companyName;
    this.location = location;
    this.size = size;
    this.industry = industry;
    this.position = position;
    this.jobDescription = jobDescription;
    this.companyDescription = companyDescription;
    this.type = 1;
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

  public String toString() {
    return companyName;
  }

}