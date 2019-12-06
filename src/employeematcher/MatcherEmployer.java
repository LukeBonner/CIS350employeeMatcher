package EmployeeMatcher;

import java.util.ArrayList;

/**
 * Holds the information for a Employer user and provides access for other functions.
 *
 * <p>This class holds the information for the Employer type of MatcherUser,
 * providing functions to both modify and access these values in other
 * points of the program. Additionally, the class generates a String used
 * by DataReadWriter to save and recover information for multiple runs.</p>
 *
 * @author Luke Bonner, Sim Grewal, Zachary Klimek, Adam Weaver
 * @version 12/6/19
 */
public class MatcherEmployer extends EmployeeMatcherUser {

  /**
   * The company name of the employer.
   *
   * <p>This string contains the MatcherEmployer's company name, contained
   * in their user profile.</p>
   */
  private String companyName;

  /**
   * The location of the employer.
   *
   * <p>This string contains the MatcherEmployer's company location, contained
   * in their user profile.</p>
   */
  private String location;

  /**
   * The size of the employer's company.
   *
   * <p>This string contains the MatcherEmployer's company size, contained
   * in their user profile.</p>
   */
  private String size;

  /**
   * The industry of the employer.
   *
   * <p>This string contains the MatcherEmployer's industry, contained
   * in their user profile.</p>
   */
  private String industry;

  /**
   * The position of the employer.
   *
   * <p>This string contains the MatcherEmployer's industry, contained
   * in their user profile.</p>
   */
  private String position;

  /**
   * The job description of the employer.
   *
   * <p>This string contains the MatcherEmployer's job description, contained
   * in their user profile.</p>
   */
  private String jobDescription;

  /**
   * The company description of the employer.
   *
   * <p>This string contains the MatcherEmployer's company description, contained
   * in their user profile.</p>
   */
  private String companyDescription;


  /**
   * The image path entries of a seeker.
   *
   * <p>This string contains the MatcherSeeker's list of image path
   * entries displayed in their user profile.</p>
   */
  private ArrayList<String> images;

  /**
   * Default constructor for the matcher employer.
   *
   * <p>Initializes the MatcherEmployer class with default values for all
   * instance variables.</p>
   */
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

  /**
   * Constructor for MatcherEmployer.
   *
   * <p>Constructor that assigns a MatcherEmployer object with values either
   * read in from the database file or passed in the code.</p>
   *
   * @param uname the MatcherEmployer's username
   * @param pword the MatcherEmployer's password
   * @param companyName the MatcherEmployer's company name
   * @param location the MatcherEmployer's location
   * @param size the size of the MatcherEmployer's company
   * @param industry the industry of the MatcherEmployer
   * @param position the MatcherEmployer's available job position
   * @param jobDescription the description of the MatcherEmployer's job
   * @param companyDescription the description of the MatcherEmployer
   * @param imagepaths the list of the MatcherEmployer's image path entries
   * @param matches - the list of the MatcherEmployer's matches
   */
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

  /**
   * Gets the current user's company name.
   *
   * <p>This method returns the current employer's company name as a String.</p>
   *
   * @return the current employer's company name as a String.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * Sets the current employer's company name to the provided value.
   *
   * <p>Given a String passed containing a new company name, update the
   * current employer's company name as that String.</p>
   *
   * @param companyName the String containing the new first name to set.
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * Gets the current employer's location.
   *
   * <p>This method returns the current employer's company name as a String.</p>
   *
   * @return the current employer's location as a String.
   */
  public String getLocation() {
    return location;
  }

  /**
   * Sets the current employer's location to the provided value.
   *
   * <p>Given a String passed containing a new location, update the
   * current employer's location as that String.</p>
   *
   * @param location the String containing the new location to set.
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Gets the current employer's company size.
   *
   * <p>This method returns the current employer's company size as a String.</p>
   *
   * @return the current employer's company size as a String.
   */
  public String getSize() {
    return size;
  }

  /**
   * Gets the current employer's company's industry.
   *
   * <p>This method returns the current employer's industry as a String.</p>
   *
   * @return the current employer's industry as a String.
   */
  public String getIndustry() {
    return industry;
  }

  /**
   * Sets the current employer's size to the provided value.
   *
   * <p>Given a String passed containing a new size, update the
   * current employer's size as that String.</p>
   *
   * @param size the String containing the new size to set.
   */
  public void setSize(String size) {
    this.size = size;
  }

  /**
   * Sets the current employer's industry to the provided value.
   *
   * <p>Given a String passed containing a new industry, update the
   * current employer's company's industry as that String.</p>
   *
   * @param industry the String containing the new industry to set.
   */
  public void setIndustry(String industry) {
    this.industry = industry;
  }

  /**
   * Gets the current employer's job position.
   *
   * <p>This method returns the current employer's available job position
   * as a String.</p>
   *
   * @return the current employer's position as a String.
   */
  public String getPosition() {
    return position;
  }

  /**
   * Sets the current employer's position to the provided value.
   *
   * <p>Given a String passed containing a new position, update the
   * current employer's company's position as that String.</p>
   *
   * @param position the String containing the new position to set.
   */
  public void setPosition(String position) {
    this.position = position;
  }

  /**
   * Gets the current employer's job description.
   *
   * <p>This method returns the current employer's job description
   * as a String.</p>
   *
   * @return the current employer's position as a String.
   */
  public String getJobDescription() {
    return jobDescription;
  }

  /**
   * Sets the current employer's job description to the provided value.
   *
   * <p>Given a String passed containing a new job description, update the
   * current employer's position's job description as that String.</p>
   *
   * @param jobDescription the String containing the new description to set.
   */
  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public String getCompanyDescription() {
    return companyDescription;
  }

  /**
   * Method updating the company's description to a new description passed as input.
   *
   * @param companyDescription updated company description
   */
  public void setCompanyDescription(String companyDescription) {
    this.companyDescription = companyDescription;
  }

  /**
   * Method returning the ArrayList of image paths.
   *
   * @return ArrayList of the MatcherEmployers's images
   */
  public ArrayList<String> getImagesEmployer() {
    return images;
  }

  /**
   * Method adding an image path to the ArrayList of images.
   *
   * @param image image path
   */
  public void addImage(String image) {
    images.add(image);
  }

  /**
   * Method returning a String representation of the MatcherSeeker.
   *
   * @return the MatcherSeeker's company name
   */
  public String toString() {
    return companyName;
  }

  /**
   * Method formatting the contents of MatcherEmployer for the database
   * text file using the "," and "|" delimiters.
   *
   * @return representation of MatcherEmployer for the database
   */
  public String toWrite() {
    String output = "1" + "," + uname + "," + pword + "," + companyName + "," + location + ",";
    output += size + "," + industry + "," + position + "," + jobDescription + ","
        + companyDescription + "|";

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