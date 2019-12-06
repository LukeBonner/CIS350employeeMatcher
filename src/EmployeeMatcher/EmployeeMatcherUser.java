package EmployeeMatcher;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The base class for holding a user of the software.
 *
 * This class contains the basic functionality shared among both user types. Of note are
 * the username, the password, a list of the usernames of users the current user has matched
 * with, an integer representing its type, and a list of image paths. Though not very
 * useful on its own, this class acts to tie together the MatcherSeeker and MatcherEmployer
 * classes, allowing other classes to treat the two as one.
 *
 * @author Luke Bonner, Sim Grewal, Zackary Klimek, Adam Weaver
 * @version 12/6/2019
 */
public class EmployeeMatcherUser {

  /**
   * The Username of the current user.
   *
   * This string contains the unique username of the user. It is used by other
   * classes to identify the user.
   */
  protected String uname;

  /**
   * The Password of the user
   *
   * This string contains the password of the user. It is not necessarily unique
   * among users. It is used exclusively for allowing a user to log in.
   */
  protected String pword;

  /**
   * A list of the users with whom the current user has matched.
   *
   * This ArrayList of strings contains the usernames of all users with whom the
   * current user has matched.
   */
  protected ArrayList<String> matches;

  /**
   * An integer encoding the type of the user.
   *
   * If the user is a MatcherSeeker, the type has a value of 0. Otherwise, it has
   * a value of 1.
   */
  protected int type;

  /**
   * An ArrayList of Strings containing file paths for any images the user has included.
   *
   * These images are converted to ImageIcons as needed throughout the package.
   */
  protected ArrayList<String> images;

  /**
   * Gets the current user's username.
   *
   * This method returns the current user's username as a String.
   *
   * @return the current user's username as a String
   */
  public String getUName() {
    return this.uname;
  }

  /**
   * Return the current user's password.
   *
   * This method returns the current user's password as a String.
   *
   * @return the current user's password as a String.
   */
  public String getPWord() {
    return this.pword;
  }

  /**
   * Set the current user's username to the provided value.
   *
   * Given a string containing the desired new username, set the current
   * user's username to be that string.
   *
   * @param toSet, a string containing the new username.
   */
  public void setUName(String toSet) {
    this.uname = toSet;
  }

/**
 * Set the current user's password to the provided value.
 *
 * Given a string containing the desired new password, set the current
 * user's password to be that string.
 *
 * @param toSet, a string containing the new password.
 */
  public void setPWord(String toSet) {
    this.pword = toSet;
  }


  /**
   * Get the type of the current user.
   *
   * Return the current type of the user as an integer. If the current user is
   * a MatcherSeeker, this method will return 0. If the current user is a MatcherEmployer,
   * this method will return 1.
   * @return type, an integer that encodes the current user's type.
   * @see MatcherSeeker, MatcherEmployer.
   */
  public int getType(){
    return type;
  }

  /**
   * Get the current user's matches.
   *
   * Returns an ArrayList of strings containing the usernames of all users with whom
   * the current user has matched.
   *
   * @return matches, an ArrayList of strings containing usernames.
   */
  public ArrayList<String> getUserMatches(){
    return matches;
  }

  /**
   * Add a new username to the list of matches.
   *
   * Given a string containing a username, add the username to the current user's list
   * of matches.
   *
   * @param u, the string containing the new username to be added.
   */
  public void addMatch(String u){
    matches.add(u);
  }

  /**
   * Get the current user's list of image paths.
   *
   * Returns an ArrayList of Strings representing the file paths for image icons.
   *
   * @return images, an ArrayList of Strings containing the file paths for image icons.
   */
  public ArrayList<String> getImages() {
    return images;
  }

  /**
   * Create a string to represent the user's information.
   *
   * This method creates a string to store the user's information for the purposes of
   * writing the user's information to a file. For the EmployeeMatcherUser class, this simply
   * returns an empty string, but the MatcherSeeker and MatcherEmployer classes utilize this
   * method to allow them to store their information in files.
   * @return an empty string.
   * @see MatcherSeeker.toWrite(), MatcherEmployer.toWrite()
   */
  public String toWrite() {
    return "";
  }

}