package employeeMatcher;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class MatcherSeeker extends EmployeeMatcherUser {
  private String firstName;

  private String industry;

  private String lastName;

  private String personalStatement;

  private String education;

  private String experience;

  private String urls;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherSeeker() {
    firstName = "EMPTY";
    industry = "";
    lastName = "";
    personalStatement = "";
    education = "";
    experience = "";
    urls = "";
    type = 0;
  }

  public MatcherSeeker(String firstName, String industry, String lastName,
                       String personalStatement, String education,
                       String experience, ArrayList<ImageIcon> images,
                       String urls) {
    this.firstName = firstName;
    this.industry = industry;
    this.lastName = lastName;
    this.personalStatement = personalStatement;
    this.education = education;
    this.experience = experience;
    this.urls = urls;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPersonalStatement() {
    return personalStatement;
  }

  public void setPersonalStatement(String personalStatement) {
    this.personalStatement = personalStatement;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public String getUrls() {
    return urls;
  }

  public void setUrls(String urls) {
    this.urls = urls;
  }

  public String toString() {
    return firstName;
  }


}