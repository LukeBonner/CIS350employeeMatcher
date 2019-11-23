package employeematcher;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class MatcherSeeker extends EmployeeMatcherUser {
  private String firstName;

  private String industry;

  private String lastName;

  private String personalStatement;

  private ArrayList<String> education;

  private ArrayList<String> experience;

  private ArrayList<ImageIcon> images;

  private ArrayList<String> urls;

  private ArrayList<MatcherEmployer> matches;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherSeeker() {
    firstName = "EMPTY";
    industry = "";
    lastName = "";
    personalStatement = "";
    education = new ArrayList<String>();
    experience = new ArrayList<String>();
    images = new ArrayList<ImageIcon>();
    urls = new ArrayList<String>();
    type = 0;
    matches = new ArrayList<MatcherEmployer>();
  }

  public MatcherSeeker(String name){
    firstName = name;
    industry = "";
    lastName = "";
    personalStatement = "";
    education = new ArrayList<String>();
    experience = new ArrayList<String>();
    images = new ArrayList<ImageIcon>();
    urls = new ArrayList<String>();
    type = 0;

  }

  public MatcherSeeker(String firstName, String industry, String lastName,
                       String personalStatement, ArrayList<String> education,
                       ArrayList<String> experience,
                       ArrayList<ImageIcon> images, ArrayList<String> urls) {
    this.firstName = firstName;
    this.industry = industry;
    this.lastName = lastName;
    this.personalStatement = personalStatement;
    this.education = education;
    this.experience = experience;
    this.images = images;
    this.urls = urls;
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

  public ArrayList<String> getEducation() {
    return education;
  }

  public void setEducation(ArrayList<String> education) {
    this.education = education;
  }

  public ArrayList<String> getExperience() {
    return experience;
  }

  public void setExperience(ArrayList<String> experience) {
    this.experience = experience;
  }

  // returns arraylist of seeker's images
  public ArrayList<ImageIcon> getImages() {
    return images;
  }

  public void addImage(ImageIcon image) {
    images.add(image);
  }

  public ArrayList<String> getUrls() {
    return urls;
  }

  public void setUrls(ArrayList<String> urls) {
    this.urls = urls;
  }

//  public void addMatchS(MatcherEmployer e){
//    matches.add(e);
//  }

//  public ArrayList<MatcherEmployer> getUserMatches(){
//    return matches;
//  }

  public String toString(){
    return firstName;
  }


}