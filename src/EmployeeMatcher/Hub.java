package EmployeeMatcher;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Maintains and updates the lists of users and matrix, handles storage to a file.
 *
 * This class is based around containing two ArrayLists of both
 * MatcherSeeker and MatcherEmployer objects, as well as the
 * two-dimensional ArrayList of Integers containing information
 * tracking the relationships between users. The matrix is mutable,
 * changing in size upon each change to either the seekers or
 * employers list, making the indices of intersections in the matrix
 * directly correspond to the indices of each user in their
 * respective list. A method then exists to check whether users
 * matched with each other upon each modification to the matrix,
 * then adding the username of the user's match to a list of their
 * matches held in their own class.
 *
 * Additionally, this class is responsible for saving and loading
 * the matrix to a file upon each run of our program, maintaining
 * data between sessions.
 *
 * @author Luke Bonner, Sim Grewal, Zachary Klimek, Adam Weaver
 * @version 12/6/19
 */
public class Hub {
  public ArrayList<MatcherSeeker> seekers;

  public ArrayList<MatcherEmployer> employers;

  public ArrayList<ArrayList<Integer>> matrix;

  public DataReadWriter storage;

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
      }
      else if (e.type == 1) {
        this.addEmployer((MatcherEmployer) e);
      }
    }
    this.restoreMatrix("matrix.txt");

  }

  public ArrayList getSeekers() {
    return seekers;
  }

  public ArrayList getEmployers() {
    return employers;
  }

  public ArrayList<ArrayList<Integer>> getMatrix(){
    return matrix;
  }

  public EmployeeMatcherUser setCurrentUser(String userName, String password){
    for(MatcherEmployer e: employers){

      if(e.getUName().equals(userName) && e.getPWord().equals(password)){
        return e;
      }
    }

    for(MatcherSeeker s: seekers){
      if(s.getUName().equals(userName) && s.getPWord().equals(password)){
        return s;
      }
    }

    throw new IllegalArgumentException("User does not exist");

  }

  public void initializeMatrix() {
    matrix.add(new ArrayList<Integer>());
    matrix.get(0).add(0);
  }

  public void addSeeker(MatcherSeeker s) {
    // add a seeker to the linkedlist when account is created
    seekers.add(s);
    addSeekerMatrix();
  }

  public void addSeekerMatrix() {
    // updates the matrix
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int i = 0; i < matrix.get(0).size(); ++i) {
      a.add(0);
    }
    matrix.add(a);
  }

  public void addEmployer(MatcherEmployer e) {
    // add a employer to the linkedlist when account is created
    employers.add(e);
    addEmployerMatrix();
  }

  public void addEmployerMatrix() {
    // updates the matrix
    for (ArrayList<Integer> a : matrix) {
      a.add(0);
    }
  }

  public int getNumSeekers(){
    return seekers.size();
  }

  public int getNumEmployers(){
    return employers.size();
  }

  public boolean addLikeMatrix(EmployeeMatcherUser liker, EmployeeMatcherUser receiver) {
    int seekerIndex = -1;
    int employerIndex = -1;
    int newVal = 0;
    if(liker.getType() == receiver.getType()){
      throw new IllegalArgumentException("Cannot like user of the same type.");
    }
    boolean likerIsSeeker = false;
    // seeker liking employer
    if(liker.getType() == 0){
      likerIsSeeker = true;
      seekerIndex = 0;
      for(int i = 0; i < seekers.size(); ++i){
        if(seekers.get(i).getUName().equals(liker.getUName())){
          seekerIndex = i;
          break;
        }
      }
      employerIndex = employers.indexOf(receiver);
      if (matrix.get(seekerIndex).get(employerIndex) != 7 && matrix.get(seekerIndex).get(employerIndex) != 12) {
        newVal = matrix.get(seekerIndex).get(employerIndex) + 7;
        matrix.get(seekerIndex).set(employerIndex, newVal);
      }
    }
    // employer liking seeker
    else if(liker.getType() == 1){
      seekerIndex = seekers.indexOf(receiver);
      employerIndex = 0;
      for(int i = 0; i < employers.size(); ++i){
        if(employers.get(i).getUName().equals(liker.getUName())){
          employerIndex = i;
          break;
        }
      }
      if(matrix.get(seekerIndex).get(employerIndex) != 5 && matrix.get(seekerIndex).get(employerIndex) != 12){
        newVal = matrix.get(seekerIndex).get(employerIndex) + 5;
        matrix.get(seekerIndex).set(employerIndex, newVal);
      }
    }

    this.saveMatrix("matrix.txt");

    // if newVal equals 12, users liked each other
    if(newVal == 12){
      // adds each user to the other's list of matches
      boolean newMatch = false;
      if ((liker.getUserMatches()).indexOf(receiver.getUName()) == -1) {
        if (likerIsSeeker) {
          seekers.get(seekerIndex).addMatch(receiver.getUName());
        }
        else {
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

  public boolean usersMatched(EmployeeMatcherUser u1, EmployeeMatcherUser u2){
    int seekerIndex, employerIndex;
    if (u1.getType() == 0) {
      seekerIndex = 0;
      for(int i = 0; i < seekers.size(); ++i){
        if(seekers.get(i).getUName().equals(u1.getUName())){
          seekerIndex = i;
        }
      }
      employerIndex = employers.indexOf(u2);
      if(matrix.get(seekerIndex).get(employerIndex) == 12){
        return true;
      }
      return false;
    }
    else{
      seekerIndex = seekers.indexOf(u2);
      employerIndex = 0;
      for(int i = 0; i < employers.size(); ++i){
        if(employers.get(i).getUName().equals(u1.getUName())){
          employerIndex = i;
        }
      }

      if(matrix.get(seekerIndex).get(employerIndex) == 12){
        return true;
      }
      return false;
    }
  }

  // testing/visualization only
  public String printMatrix(){
    String output = "";
    for (int i = 0; i < matrix.size(); i++) {
      for (int j = 0; j < matrix.get(0).size(); j++) {
        if (i == 0 && j == 0) {
          output += (matrix.get(i)).get(j);
        }
        else {
          output += "," + (matrix.get(i)).get(j);
        }

      }
    }
    return output;
  }

  public void saveMatrix(String path) {
    try{
      File fout = new File(path);
      FileWriter out = new FileWriter(fout);
      out.write(this.printMatrix());
      out.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public void restoreMatrix(String path) {
    File in = null;
    Scanner scnr;

    int numToks = 1;
    try {
      in = new File(path);
      scnr = new Scanner(in);
      String curr = scnr.nextLine();
      StringTokenizer st = new StringTokenizer(curr, ", |", false);
      String cTok = st.nextToken();
      for (int i = 0; i < matrix.size(); ++i) {
        for (int j = 0; j < matrix.get(0).size(); ++j) {
          matrix.get(i).set(j, Integer.parseInt(cTok));
          if (st.hasMoreTokens()) {
            cTok = st.nextToken();
            numToks += 1;
            continue;
          }
        }
      }
      if (st.hasMoreTokens()) {
        throw new Exception("Matrix size was not equal to expected");
      }
    }
    catch(Exception e) {
      System.out.println(e);
      System.out.println(matrix.size() * matrix.get(0).size());
      System.out.println(numToks);
    }
    finally {
      if (in != null) {
        in = null;
      }
    }
  }
}
