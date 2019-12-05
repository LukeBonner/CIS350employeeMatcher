package employeeMatcher;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * when the user likes another user, this class needs to be passed the
 * seeker and employer objects from the interaction - use the
 * updateMatrix() method
 *
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

    printTheMatrix();
    System.out.println("\n\n\n\n\n");
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
      System.out.println("Username: " + s.getUName());
      System.out.println("Password: " + s.getPWord() + "\n");
      if(s.getUName().equals(userName) && s.getPWord().equals(password)){
        return s;
      }
    }

    throw new IllegalArgumentException("User does not exist");

  }

  public void initializeMatrix() {
    matrix.add(new ArrayList<Integer>());
    matrix.get(0).add(0);
    //printMatrix();
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
//      seekerIndex = seekers.indexOf((MatcherSeeker)liker);
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
          break;
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
          break;
        }
      }

      if(matrix.get(seekerIndex).get(employerIndex) == 12){
        return true;
      }
      return false;
    }
  }

  public void createSampleList(){
    /*ArrayList<ImageIcon> e1Images = new ArrayList<ImageIcon>();
    e1Images.add(new ImageIcon("Images/ao_logo.png"));
    e1Images.add(new ImageIcon("Images/ao_office.jpg"));

    ArrayList<ImageIcon> e2Images = new ArrayList<ImageIcon>();
    e2Images.add(new ImageIcon("Images/gaa_logo.jpg"));
    e2Images.add(new ImageIcon("Images/gaa_office.jpg"));

    ArrayList<ImageIcon> s1Images = new ArrayList<ImageIcon>();
    s1Images.add(new ImageIcon("Images/jd_profile.png"));
    s1Images.add(new ImageIcon("Images/resumeTemplate.png"));
    s1Images.add(new ImageIcon("Images/letterExample.png"));
    s1Images.add(new ImageIcon("Images/commitHistory.png"));

    MatcherEmployer e1 = new MatcherEmployer("Atomic Object", "Grand Rapids, MI",
        "200", "Computer Software,", "Senior Software Developer", "Job",
        "Company", e1Images);
    MatcherEmployer e2 = new MatcherEmployer("Google","Ann Arbor, MI", "450",
        "Information Services",
        "Account Speicalist", "Marketing, Sales", "Google", e2Images);
    MatcherEmployer e3 = new MatcherEmployer("My company", "Allendale, MI", "1", "Making money", "CEO", "Do cool stuff", "Enterprise", e1Images);
    MatcherSeeker s1 = new MatcherSeeker("John","Doe","Computer Software", "I am good at my job", "GVSU", "Internship: Bissel (2018)", s1Images, "linkedin.com");

    addSeeker(s1);
    addEmployer(e1);
    addEmployer(e2);
    addEmployer(e3);


    addLikeMatrix(e2,s1);*/
    //addLikeMatrix(s1,e2);

  }

  public void printTheMatrix(){
    //System.out.println("Seekers:");
    for(MatcherSeeker s: seekers){
      System.out.println(s.getFirstName());
    }
    System.out.println();

    //System.out.println("Employers:");
    for(MatcherEmployer e: employers){
      System.out.println(e.getCompanyName());
    }
    System.out.println();

//    System.out.println("Number of Employers/Columns:  " + matrix.get(0).size());
//    System.out.println("Number of Seekers/Rows:  " + matrix.size());

    for (int i = 0; i < matrix.size(); ++i) {
      for (int j = 0; j < matrix.get(0).size(); ++j) {
        System.out.print(matrix.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  // testing/visualization only
  public String printMatrix(){
    printTheMatrix();
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
