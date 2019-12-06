package EmployeeMatcher;

import java.util.ArrayList;

/**
 * Holds the information for a Employer user and provides access for other functions.
 *
 * <p>Holds the information for a Seeker user and provides access for other functions.
 * This class holds the information for the Seeker type of MatcherUser,
 * providing functions to both modify and access these values in other
 * points of the program. Additionally, the class generates a String used
 * by DataReadWriter to save and recover information for multiple runs.</p>
 *
 * @author Luke Bonner, Sim Grewal, Zachary Klimek, Adam Weaver
 * @version 12/6/19
 */
public class MatcherSeeker extends EmployeeMatcherUser {

  /**
   * The first name of the seeker.
   *
   * <p> This string contains the MatcherSeeker's first name, contained
   * in their user profile </p>
   */
  private String firstName;

  /**
   * The industry of the seeker.
   *
   * <p> This string contains the MatcherSeeker's industry, contained
   * in their user profile. </p>
   */
  private String industry;

  /**
   * The last name of the seeker.
   *
   * <p> This string contains the MatcherSeeker's last name, contained
   * in their user profile. </p>
   */
  private String lastName;

  /**
   * The pesonal statement of the seeker.
   *
   * <p> This string contains the MatcherSeeker's personal statement,
   * contained in their user profile. </p>
   */
  private String personalStatement;

  /**
   * The education entries of a seeker.
   *
   * <p> This string contains the MatcherSeeker's list of entries for
   * education contained in their user profile. </p>
   */
  private ArrayList<String> education;

  /**
   * The experience entries of a seeker.
   *
   * <p> This string contains the MatcherSeeker's list of entries for
   * job experience contained in their user profile. </p>
   */
  private ArrayList<String> experience;

  /**
   * The url entries of a seeker.
   *
   * <p> This string contains the MatcherSeeker's list of entries for
   * url(s) contained in their user profile. </p>
   */
  private ArrayList<String> urls;


  /**
   * Default constructor for matcher seeker.
   *
   * <p> Initializes the MatcherSeeker class with default values for all
   * instance variables. </p>
   */
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

  /**
   * Constructor for MatcherSeeker.
   *
   * <p>Constructor that assigns a MatcherSeeker object with values either
   * read in from the dadabase file or passed in the code.</p>
   *
   * @param uname the MatcherSeeker's username
   * @param pword the MatcherSeeker's password
   * @param firstName the MatcherSeeker's first name
   * @param industry the MatcherSeeker's industry
   * @param lastName the MatcherSeeker's last name
   * @param personalStatement the MatcherSeeker's username
   * @param education the MatcherSeeker's education entries
   * @param experience the MatcherSeeker's experience entries
   * @param paths the MatcherSeeker's image paths
   * @param urls the MatcherSeeker's url entries
   * @param matches list of the MatcherSeeker's matches
   */
  public MatcherSeeker(String uname, String pword, String firstName,
                       String industry, String lastName,
                       String personalStatement, ArrayList<String>
                           education, ArrayList<String> experience,
                       ArrayList<String> paths, ArrayList<String> urls,
                       ArrayList<String> matches) {
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

  /**
   * Gets the current user's first name.
   *
   * <p>This method returns the current user's first name as a String.</p>
   *
   * @return the current seeker's first name as a String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the current seeker's first name to the provided value.
   *
   * <p>Given a String passed containing a new first name, update the
   * current user's first name as that String.</p>
   *
   * @param firstName the String containing the new first name to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the current user's industry.
   *
   * <p>This method returns the current user's industry as a String.</p>
   *
   * @return the current seeker's industry as a String.
   */
  public String getIndustry() {
    return industry;
  }

  /**
   * Sets the current seeker's first name to the provided value.
   *
   * <p>Given a String passed containing a new industry, update the
   * current user's industry as that String.</p>
   *
   * @param industry the String containing the new industry to set.
   */
  public void setIndustry(String industry) {
    this.industry = industry;
  }

  /**
   * Gets the current user's last name.
   *
   * <p>This method returns the current user's last name as a String.</p>
   *
   * @return the current seeker's last name as a String.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the current seeker's last name to the provided value.
   *
   * <p>Given a String passed containing a new last name, update the
   * current user's last name as that String.</p>
   *
   * @param lastName the String containing the new last name to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Method returning the MatcherSeeker's full name.
   *
   * <p>Creates a String by combining the MatcherSeeker's first and last
   * name for use by the GUI.</p>
   *
   * @return the MatcherSeeker's full name.
   */
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  /**
   * Gets the current user's personal statement.
   *
   * <p>This method returns the current user's personal statement as a
   * String.</p>
   *
   * @return the current seeker's personal statement as a String.
   */
  public String getPersonalStatement() {
    return personalStatement;
  }

  /**
   * Sets the current seeker's personal statement to the provided value.
   *
   * <p>Given a String passed containing a new personal statement,
   * update the current user's personal statement as that String.</p>
   *
   * @param personalStatement the String containing the new personal
   *                          statement to set.
   */
  public void setPersonalStatement(String personalStatement) {
    this.personalStatement = personalStatement;
  }

  /**
   * Method returning the MatcherSeeker's education.
   *
   * <p>This method converts the ArrayList entries for education to a
   * String for display in the GUI.</p>
   *
   * @return the MatcherSeeker's education.
   */
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

  /**
   * Method setting the MatcherSeeker's education.
   *
   * <p>This method sets the MatcherSeeker's education to a new ArrayList
   * of entries passed as input.</p>
   *
   * @param education ArrayList of education entries.
   */
  public void setEducation(ArrayList<String> education) {
    this.education = education;
  }

  /**
   * Method returning the MatcherSeeker's experience.
   *
   * <p>This method converts the ArrayList entries for experience to a
   * String for display in the GUI.</p>
   *
   * @return the MatcherSeeker's experience.
   */
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

  /**
   * Method setting the MatcherSeeker's experience.
   *
   * <p>This method sets the MatcherSeeker's experience to a new ArrayList
   * of entries passed as input.</p>
   *
   * @param experience ArrayList of experience entries.
   */
  public void setExperience(ArrayList<String> experience) {
    this.experience = experience;
  }

  /**
   * Method adding an entry to the ArrayList of experiences.
   *
   * @param toAdd entry being added to experience.
   */
  public void addExperience(String toAdd) {
    this.experience.add(toAdd);
  }

  /**
   * Method adding an entry to the ArrayList of education.
   *
   * @param toAdd entry being added to education
   */
  public void addEducation(String toAdd) {
    this.education.add(toAdd);
  }

  /**
   * Method adding an entry to the ArrayList of URLs.
   *
   * @param toAdd entry being added to urls
   */
  public void addUrl(String toAdd) {
    this.urls.add(toAdd);
  }

  /**
   * Method returning the ArrayList of image paths.
   *
   * @return ArrayList of the MatcherSeeker's images
   */
  public ArrayList<String> getImagesSeeker() {
    return images;
  }

  /**
   * Method adding an image path to the MatcherSeeker's list of images.
   *
   * @param image String of an image path
   */
  public void addImage(String image) {
    images.add(image);
  }

  /**
   * Method returning the MatcherSeeker's urls.
   *
   * <p>This method converts the ArrayList entries for urls to a String
   * for display in the GUI.</p>
   *
   * @return the MatcherSeeker's urls
   */
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

  /**
   * Method setting the MatcherSeeker's urls.
   *
   * <p>This method sets the MatcherSeeker's urls to a new ArrayList
   * of entries passed as input.</p>
   *
   * @param urls ArrayList of url entries
   */
  public void setUrls(ArrayList<String> urls) {
    this.urls = urls;
  }

  /**
   * Method returning a String representation of the MatcherSeeker.
   *
   * <p>This method returns the seeker's first name as a string to be
   * called in the program.</p>
   *
   * @return the MatcherSeeker's first name
   */
  public String toString() {
    return firstName;
  }

  /**
   * Method writing the seeker's data to a file.
   *
   * <p>Method formatting the contents of MatcherSeeker for the database
   * text file using the "," and "|" delimiters.</p>
   *
   * @return representation of MatcherSeeker for the database
   */
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
