package employeeMatcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatcherSeeker extends EmployeeMatcherUser {

  private String firstName;

  private String industry;

  private String lastName;

  private String personalStatement;

  private ArrayList<String> education;

  private ArrayList<String> experience;

  private ArrayList<String> urls;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherSeeker() {
    uname = "";
    pword = "";
    firstName = "EMPTY";
    industry = "";
    lastName = "";
    personalStatement = "";
    education = new ArrayList<String>();
    experience = new ArrayList<String>();
    images = new ArrayList<String>();
    urls = new ArrayList<String>();
    type = 0;
  }

  public MatcherSeeker(String name) {
    uname = "";
    pword = "";
    firstName = name;
    industry = "";
    lastName = "";
    personalStatement = "";
    education = new ArrayList<String>();
    experience = new ArrayList<String>();
    images = new ArrayList<String>();
    urls = new ArrayList<String>();
    matches = new ArrayList<String>();
    type = 0;
  }

  public MatcherSeeker(String uname, String pword, String firstName, String industry, String lastName,
                       String personalStatement, ArrayList<String> education,
                       ArrayList<String> experience,
                       ArrayList<String> paths, ArrayList<String> urls, ArrayList<String> matches) {
    this.uname = uname;
    this.pword = pword;
    this.firstName = firstName;
    this.industry = industry;
    this.lastName = lastName;
    this.personalStatement = personalStatement;
    this.education = education;
    this.experience = experience;
    this.images = paths;
    this.matches = matches;
    this.urls = urls;
    type = 0;
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

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  public String getPersonalStatement() {
    return personalStatement;
  }

  public void setPersonalStatement(String personalStatement) {
    this.personalStatement = personalStatement;
  }

  public String getEducation() {
    String edu = "";
    for (int i = 0; i < education.size(); i++) {
      if (i == 0) {
        edu = education.get(0);
        continue;
      }
      edu += ", " + education.get(i);
    }
    return edu;
  }

  public void setEducation(ArrayList<String> education) {
    this.education = education;
  }

  public String getExperience() {
    String exp = "";
    for (int i = 0; i < experience.size(); i++) {
      if (i == 0) {
        exp = experience.get(0);
        continue;
      }
      exp += ", " + experience.get(i);
    }
    return exp;
  }

  public void setExperience(ArrayList<String> experience) {
    this.experience = experience;
  }

  public void addExperience(String toAdd) {
    this.experience.add(toAdd);
  }

  public void addEducation(String toAdd) {
    this.education.add(toAdd);
  }

  public void addUrl(String toAdd) {
    this.urls.add(toAdd);
  }

  // returns arraylist of seeker's images
  public ArrayList<String> getImagesSeeker() {
    return images;
  }

  public void addImage(String image) {
    images.add(image);
  }

  public String getUrls() {
    String url = "";
    for (int i = 0; i < urls.size(); i++) {
      if (i == 0) {
        url = urls.get(0);
        continue;
      }
      url += ", " + urls.get(i);
    }
    return url;
  }

  public void setUrls(ArrayList<String> urls) {
    this.urls = urls;
  }

  public String toString() {
    return firstName;
  }

  public String toWrite() {
    String output = "0" + "," + uname + "," + pword + "," + firstName + "," + lastName + ",";
    output += personalStatement + "," + industry + ",";
    if (education.size() == 0) {
      output += "BLANK|";
    } else {
      output += education.get(0);
      for (int i = 1; i < (this.education).size(); i++) {
        output += "," + education.get(i);
      }
      output += "|";
    }

    if (experience.size() == 0) {
      output += "BLANK|";
    } else {
      output += experience.get(0);
      for (int i = 1; i < (this.experience).size(); i++) {
        output += "," + experience.get(i);
      }
      output += "|";
    }

    if (urls.size() == 0) {
      output += "BLANK|";
    } else {
      output += urls.get(0);
      for (int i = 1; i < (this.urls).size(); i++) {
        output += "," + urls.get(i);
      }
      output += "|";
    }

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
      output += "|";
    } else {
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
      output += "|*";
    } else {
      output += "BLANK|*";
    }
    return output;
  }
}
