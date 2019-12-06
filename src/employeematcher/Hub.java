package EmployeeMatcher;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Maintains and updates the lists of users and matrix, handles storage to a file.
 *
 * <p>This class is based around containing two ArrayLists of both
 * MatcherSeeker and MatcherEmployer objects, as well as the
 * two-dimensional ArrayList of Integers containing information
 * tracking the relationships between users. The matrix is mutable,
 * changing in size upon each change to either the seekers or
 * employers list, making the indices of intersections in the matrix
 * directly correspond to the indices of each user in their
 * respective list. A method then exists to check whether users
 * matched with each other upon each modification to the matrix,
 * then adding the username of the user's match to a list of their
 * matches held in their own class.</p>
 *
 * <p>Additionally, this class is responsible for saving and loading
 * the matrix to a file upon each run of our program, maintaining
 * data between sessions.</p>
 *
 * @author Luke Bonner, Sim Grewal, Zachary Klimek, Adam Weaver
 * @version 12/6/19
 */
public class Hub {

  /**
   * The ArrayList of MatcherSeeker objects.
   *
   * <p>This ArrayList contains the list of MatcherSeekers used by the
   * program, purposed to be able to add users and correspond to the matrix
   * holding information about matches.</p>
   */
  public ArrayList<MatcherSeeker> seekers;

  /**
   * The ArrayList of MatcherEmployer objects.
   *
   * <p>This ArrayList contains the list of MatcherEmployer used by the
   * program, purposed to be able to add users and correspond to the matrix
   * holding information about matches.</p>
   */
  public ArrayList<MatcherEmployer> employers;

  /**
   * The two-dimensional ArrayList of Integer values
   *
   * <p>This two-dimensional ArrayList contains Integer objects directly
   * correlating to MatcherSeeker and MatcherEmployer objects based on index.
   * The matrix values are assigned in a way directly corresponding with
   * the seekers and employers lists, such that changes in each list
   * are reflected in the size of the matrix.</p>.
   *
   *
   */
  public ArrayList<ArrayList<Integer>> matrix;

  /**
   * The storage of the current data.
   *
   * <p>This DataReadWriter is used to read in the initial user data, which then
   * is used to populate this class's internal lists. It also is used to write to
   * a file, saving the current state of the data when a change is made.
   * @see DataReadWriter
   */
  public DataReadWriter storage;

  /**
   * Constructor for the hub class.
   *
   * <p>Initializes fields used in the Hub class so they can be further
   * modified later in the sequence of the program. Initializes the matrix
   * so it can still be accessed when the seekers and employers lists are
   * empty.</p>
   *
   * @param testing whether or not the class is being tested
   */
  public Hub(Boolean testing) {
    seekers = new ArrayList<MatcherSeeker>();
    employers = new ArrayList<MatcherEmployer>();
    seekers.add(new MatcherSeeker());
    employers.add(new MatcherEmployer());
    matrix = new ArrayList<ArrayList<Integer>>();
    initializeMatrix();
    if (testing) {
      return;
    }

    storage = new DataReadWriter();

    for (EmployeeMatcherUser e : storage.getStorage()) {
      if (e.type == 0) {
        this.addSeeker((MatcherSeeker) e);
      } else if (e.type == 1) {
        this.addEmployer((MatcherEmployer) e);
      }
    }
    this.restoreMatrix("matrix.txt");

  }

  /**
   * Gets the ArrayList of MatcherSeeker user objects.
   *
   * <p>This method returns the comprehensive list of MatcherSeeker users on the
   * platform for access by the matrix.</p>
   *
   * @return the list of seekers
   */
  public ArrayList getSeekers() {
    return seekers;
  }

  /**
   * Gets the ArrayList of MatcherEmployer user objects.
   *
   * <p>This method returns the comprehensive list of MatcherEmployer users on the
   * platform for access by the matrix.</p>
   *
   * @return the list of employers
   */
  public ArrayList getEmployers() {
    return employers;
  }

  /**
   * The ArrayList of MatcherEmployer user objects.
   *
   * <p>This method returns the Integer object values held in the matrix,
   * keeping track of interactions (likes) between the two different types
   * of users.
   *
   * @return the matrix
   */
  public ArrayList<ArrayList<Integer>> getMatrix() {
    return matrix;
  }

  /**
   * Sets the current user based on passed login information.
   *
   * <p>This method takes a user of either type's username and password, searches
   * each type list to attempt to find the user, returns the user object once a
   * match is found, and throws an exception if the user does not exist.</p>
   *
   * @param userName the username of the current user
   * @param password the password of the current user
   * @return the EmployerMatcherUser object of the current user
   */
  public EmployeeMatcherUser setCurrentUser(String userName, String password) {
    for (MatcherEmployer e: employers) {

      if (e.getUName().equals(userName) && e.getPWord().equals(password)) {
        return e;
      }
    }

    for (MatcherSeeker s: seekers) {
      if (s.getUName().equals(userName) && s.getPWord().equals(password)) {
        return s;
      }
    }

    throw new IllegalArgumentException("User does not exist");

  }

  /**
   * Initializes the Integer ArrayList.
   *
   * <p>Initializes the Integer ArrayList with an empty element at the
   * beginning in order for the list to be initialized once it expands
   * with the addition of users. At this index, no actual users in either
   * list have an intersection, accounted for in other methods.</p>
   */
  public void initializeMatrix() {
    matrix.add(new ArrayList<Integer>());
    matrix.get(0).add(0);
  }

  /**
   * Adds a seeker to the list of seekers.
   *
   * <p>From a passed MatcherSeeker object (created first through the constructor,
   * the seeker in added to the list of seekers and the Integer matrix
   * keeping track of interactions grows in size accordingly. </p>
   *
   * @param s MatcherSeeker object being added to list
   */
  public void addSeeker(MatcherSeeker s) {
    // add a seeker to the linkedlist when account is created
    seekers.add(s);
    addSeekerMatrix();
  }

  /**
   * Changes the Integer matrix to accommodate for the addition of a new Seeker.
   *
   * </p>This method adds a row to the Integer matrix, with the index of the
   * new row directly corresponding to the index of the seeker object in the
   * seekers list.</p>
   */
  public void addSeekerMatrix() {
    // updates the matrix
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int i = 0; i < matrix.get(0).size(); ++i) {
      a.add(0);
    }
    matrix.add(a);
  }

  /**
   * Adds a seeker to the list of employers.
   *
   * <p>From a passed MatcherEmployer object (created first through the constructor,
   * the seeker in added to the list of seekers and the Employer matrix
   * keeping track of interactions grows in size accordingly. </p>
   *
   * @param e MatcherEmployer object being added to list
   */
  public void addEmployer(MatcherEmployer e) {
    // add a employer to the linkedlist when account is created
    employers.add(e);
    addEmployerMatrix();
  }

  /**
   * Changes the Integer matrix to accommodate for the addition of a new employer.
   *
   * <p>This method adds a row to the Integer matrix, with the index of the
   * new row directly corresponding to the index of the employer object in the
   * employers list.</p>
   */
  public void addEmployerMatrix() {
    // updates the matrix
    for (ArrayList<Integer> a : matrix) {
      a.add(0);
    }
  }

  /**
   * Gets the number of MatcherSeekers.
   *
   * <p>Returns the size of the seekers list, indicating how many job seekers
   * are currently using the platform.</p>
   *
   * @return size of seekers
   */
  public int getNumSeekers() {
    return seekers.size();
  }

  /**
   * Gets the number of MatcherEmployers.
   *
   * <p>Returns the size of the employers list, indicating how many  employers
   * are currently using the platform.</p>
   *
   * @return size of employers
   */
  public int getNumEmployers() {
    return employers.size();
  }

  /**
   * Adds a like to the matrix.
   *
   * </p>This method adds a like to the matrix based on two user objects passed,
   * throws an exception if the two users are of the same type. If the users
   * are not of the same type, the method figures out which type the liker is
   * in order to find the exact indices of the seeker and employer in the
   * seekers and employers lists and adds a like at that intersection in
   * the matrix.</p>
   *
   * @param liker user who liked the other user
   * @param receiver user receiving the like
   * @return boolean result of if users matched.
   * @throws IllegalArgumentException cannot like user of the same type
   */
  public boolean addLikeMatrix(EmployeeMatcherUser liker, EmployeeMatcherUser receiver) {
    int seekerIndex = -1;
    int employerIndex = -1;
    int newVal = 0;
    if (liker.getType() == receiver.getType()) {
      throw new IllegalArgumentException("Cannot like user of the same type.");
    }
    boolean likerIsSeeker = false;
    // seeker liking employer
    if (liker.getType() == 0) {
      likerIsSeeker = true;
      seekerIndex = 0;
      for (int i = 0; i < seekers.size(); ++i) {
        if (seekers.get(i).getUName().equals(liker.getUName())) {
          seekerIndex = i;
          break;
        }
      }
      employerIndex = employers.indexOf(receiver);
      if (matrix.get(seekerIndex).get(employerIndex) != 7 && matrix.get(seekerIndex)
          .get(employerIndex) != 12) {
        newVal = matrix.get(seekerIndex).get(employerIndex) + 7;
        matrix.get(seekerIndex).set(employerIndex, newVal);
      }
    } else if (liker.getType() == 1) {
      seekerIndex = seekers.indexOf(receiver);
      employerIndex = 0;
      for (int i = 0; i < employers.size(); ++i) {
        if (employers.get(i).getUName().equals(liker.getUName())) {
          employerIndex = i;
          break;
        }
      }
      if (matrix.get(seekerIndex).get(employerIndex) != 5 && matrix.get(seekerIndex)
          .get(employerIndex) != 12) {
        newVal = matrix.get(seekerIndex).get(employerIndex) + 5;
        matrix.get(seekerIndex).set(employerIndex, newVal);
      }
    }

    this.saveMatrix("matrix.txt");

    // if newVal equals 12, users liked each other
    if (newVal == 12) {
      // adds each user to the other's list of matches
      boolean newMatch = false;
      if ((liker.getUserMatches()).indexOf(receiver.getUName()) == -1) {
        if (likerIsSeeker) {
          seekers.get(seekerIndex).addMatch(receiver.getUName());
        } else {
          employers.get(employerIndex).addMatch(receiver.getUName());
        }
        newMatch = true;
      }
      if ((receiver.getUserMatches()).indexOf(liker.getUName()) == -1) {
        receiver.addMatch(liker.getUName());
        newMatch = true;
      }
      if (newMatch) {
        ArrayList<EmployeeMatcherUser> newStor = new ArrayList<>();
        for (int i = 1; i < seekers.size(); i++) {
          newStor.add(seekers.get(i));
        }
        for (int i = 1; i < employers.size(); i++) {
          newStor.add(employers.get(i));
        }
        this.storage.overrideStorage(newStor);
        this.storage.saveStorage();
      }
      return true;
    }
    return false;
  }

  /**
   * Method returning whether two users matched.
   *
   * <p>This method checks whether the intersection of two users in the matrix
   * indicates a match, returning true if each user liked each other, and
   * false if they did not.</p>
   *
   * @param u1 first user
   * @param u2 second user
   * @return whether each user liked each other
   */
  public boolean usersMatched(EmployeeMatcherUser u1, EmployeeMatcherUser u2) {
    int seekerIndex;
    int employerIndex;
    if (u1.getType() == 0) {
      seekerIndex = 0;
      for (int i = 0; i < seekers.size(); ++i) {
        if (seekers.get(i).getUName().equals(u1.getUName())) {
          seekerIndex = i;
        }
      }
      employerIndex = employers.indexOf(u2);
      if (matrix.get(seekerIndex).get(employerIndex) == 12) {
        return true;
      }
      return false;
    } else {
      seekerIndex = seekers.indexOf(u2);
      employerIndex = 0;
      for (int i = 0; i < employers.size(); ++i) {
        if (employers.get(i).getUName().equals(u1.getUName())) {
          employerIndex = i;
        }
      }

      if (matrix.get(seekerIndex).get(employerIndex) == 12) {
        return true;
      }
      return false;
    }
  }

  /**
   * Convert the matrix to a String.
   *
   * <p>This method creates a String representation of the current state
   * of the matrix. To do so, it goes row by row through the matrix, adding
   * each element to an output string. It separates all entries with commas.
   * Once this string is generated, it can be used to do tasks incuding writing
   * the matrix to a file for recovery at a later time.
   * @return  A string containing the entries in the matrix separated by commas.
   */
  public String printMatrix() {
    String output = "";
    for (int i = 0; i < matrix.size(); i++) {
      for (int j = 0; j < matrix.get(0).size(); j++) {
        if (i == 0 && j == 0) {
          output += (matrix.get(i)).get(j);
        } else {
          output += "," + (matrix.get(i)).get(j);
        }

      }
    }
    return output;
  }

  /**
   * Write the contents of the matrix to a file.
   *
   * <p>Given a String containing the path of a file to which the matrix will be saved, write
   * the matrix to a file. To do so, this method converts the matrix to a String using the
   * printMatrix method. If an error occurs in writing to the file, this method will output
   * the error to the command line.
   * @param path  A String containing a path to a file in which to save the matrix.
   */
  public void saveMatrix(String path) {
    try {
      File fout = new File(path);
      FileWriter out = new FileWriter(fout);
      out.write(this.printMatrix());
      out.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Given a path to a file holding a previously saved matrix, set the current matrix to equal
   * the one in the file.
   *
   * <p>This method repopulates the current object's matrix. To do so, it reads in a comma-separated
   * listing of integers representing the current state of the matrix. If it encounters a problem in
   * reading the file, or if the matrix it reads is not of the same size as the one it has prepared,
   * it will print a message saying as much to the console.
   * @param path  A String containing the file path of the file to be read.
   */
  public void restoreMatrix(String path) {
    File in = null;
    Scanner scnr;

    int numToks = 1;
    try {
      in = new File(path);
      scnr = new Scanner(in);
      String curr = scnr.nextLine();
      StringTokenizer st = new StringTokenizer(curr, ", |", false);
      String currTok = st.nextToken();
      for (int i = 0; i < matrix.size(); ++i) {
        for (int j = 0; j < matrix.get(0).size(); ++j) {
          matrix.get(i).set(j, Integer.parseInt(currTok));
          if (st.hasMoreTokens()) {
            currTok = st.nextToken();
            numToks += 1;
            continue;
          }
        }
      }
      if (st.hasMoreTokens()) {
        throw new Exception("Matrix size was not equal to expected");
      }
    } catch (Exception e) {
      System.out.println(e);
      System.out.println(matrix.size() * matrix.get(0).size());
      System.out.println(numToks);
    } finally {
      if (in != null) {
        in = null;
      }
    }
  }
}
