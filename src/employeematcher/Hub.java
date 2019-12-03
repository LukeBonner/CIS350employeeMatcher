package employeeMatcher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

  public Hub() {
    seekers = new ArrayList<MatcherSeeker>();
    seekers.add(new MatcherSeeker());
    employers = new ArrayList<MatcherEmployer>();
    employers.add(new MatcherEmployer());
    matrix = new ArrayList<ArrayList<Integer>>();
    initializeMatrix();
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
      if(e.getUName() == userName && e.getPWord() == password){
        return e;
      }
    }

    for(MatcherSeeker s: seekers){
      if(s.getUName() == userName && s.getPWord() == password){
        return s;
      }
    }

    throw new IllegalArgumentException("User does not exist");

  }

  public void initializeMatrix() {
    matrix.add(new ArrayList<Integer>());
    matrix.get(0).add(0);
    printMatrix();
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

  public void addLikeMatrix(EmployeeMatcherUser liker, EmployeeMatcherUser receiver) {
    int seekerIndex;
    int employerIndex;
    int newVal = 0;
    if(liker.getType() == receiver.getType()){
      throw new IllegalArgumentException("Cannot like user of the same type.");
    }

    // seeker liking employer
    if(liker.getType() == 0){
      seekerIndex = seekers.indexOf(liker);
      employerIndex = employers.indexOf(receiver);
      newVal = matrix.get(seekerIndex).get(employerIndex) + 7;
      matrix.get(seekerIndex).set(employerIndex, newVal);
    }
    // employer liking seeker
    else if(liker.getType() == 1){
      seekerIndex = seekers.indexOf(receiver);
      employerIndex = employers.indexOf(liker);
      newVal = matrix.get(seekerIndex).get(employerIndex) + 5;
      matrix.get(seekerIndex).set(employerIndex, newVal);
    }

    // if newVal equals 12, users liked each other
    if(newVal == 12){
      // adds each user to the other's list of matches
      liker.addMatch(receiver);
      receiver.addMatch(liker);
      System.out.println(liker + " and " + receiver + " matched!!");
    }

//    System.out.println(newVal);
//    if(newVal == 2){
//      // FIXME adds each user to the other user's list of matches
//      //s.addMatchS(e);
//      //e.addMatchE(s);
//
//    }
  }

  public boolean usersMatched(EmployeeMatcherUser u1, EmployeeMatcherUser u2){
    int seekerIndex, employerIndex;
    if (u1.getType() == 0) {
      seekerIndex = seekers.indexOf(u1);
      employerIndex = employers.indexOf(u2);

      if(matrix.get(seekerIndex).get(employerIndex) == 12){
        return true;
      }
      return false;
    }
    else{
      seekerIndex = seekers.indexOf(u2);
      employerIndex = employers.indexOf(u1);

      if(matrix.get(seekerIndex).get(employerIndex) == 12){
        return true;
      }
      return false;
    }
  }

  public void createSampleList(){
    ArrayList<ImageIcon> e1Images = new ArrayList<ImageIcon>();
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


    addLikeMatrix(e2,s1);
    //addLikeMatrix(s1,e2);

  }

  // testing/visualization only
  public void printMatrix(){
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

}
