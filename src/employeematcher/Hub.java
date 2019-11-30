package employeeMatcher;

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

  // objects passed when either user likes the other
  public void addLikeMatrixOlld(MatcherEmployer e, MatcherSeeker s) {
    int seekerIndex = seekers.indexOf(s);
    int employerIndex = employers.indexOf(e);
    int newVal = matrix.get(seekerIndex).get(employerIndex) + 1;
    matrix.get(seekerIndex).set(employerIndex, newVal);


    System.out.println(newVal);
    if(newVal == 2){
      // FIXME adds each user to the other user's list of matches
      //s.addMatchS(e);
      //e.addMatchE(s);

    }
  }

  public void addLikeMatrix(EmployeeMatcherUser liker, EmployeeMatcherUser receiver) {
    int seekerIndex;
    int employerIndex;
    int newVal = 0;
    System.out.println("Liker Type: " + liker.getType());
    System.out.println("Receiver Type: " + receiver.getType());
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
      System.out.println("Match!!");
      liker.addMatch(receiver);
      receiver.addMatch(liker);
    }

//    System.out.println(newVal);
//    if(newVal == 2){
//      // FIXME adds each user to the other user's list of matches
//      //s.addMatchS(e);
//      //e.addMatchE(s);
//
//    }
  }

  public void printMatrix(){
    System.out.println("Seekers:");
    for(MatcherSeeker s: seekers){
      System.out.println(s.getFirstName());
    }
    System.out.println();

    System.out.println("Employers:");
    for(MatcherEmployer e: employers){
      System.out.println(e.getCompanyName());
    }
    System.out.println();

    System.out.println("Number of Employers/Columns:  " + matrix.get(0).size());
    System.out.println("Number of Seekers/Rows:  " + matrix.size());

    for (int i = 0; i < matrix.size(); ++i) {
      for (int j = 0; j < matrix.get(0).size(); ++j) {
        System.out.print(matrix.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }


   //driver for the program, for testing purposes
  public static void main(String[] args){
//    Hub hub = new Hub();
//
//    MatcherSeeker s1 = new MatcherSeeker("Seeker 1");
//    MatcherSeeker s2 = new MatcherSeeker("Seeker 2");
//    MatcherEmployer e1 = new MatcherEmployer("Employer 1");
//    MatcherEmployer e2 = new MatcherEmployer("Employer 2");
//    MatcherEmployer e3 = new MatcherEmployer("Employer 3");
//
//    hub.addSeeker(s1);
//    hub.addSeeker(s2);
//    hub.addEmployer(e1);
//    hub.addEmployer(e2);
//    hub.addEmployer(e3);
//
//    hub.printMatrix();
//
//    hub.addLikeMatrix(s1,e1);
//    hub.printMatrix();
//    hub.addLikeMatrix(s1,e2);
//    hub.printMatrix();
//    hub.addLikeMatrix(e1,s1);
//    hub.printMatrix();
//
//    hub.addSeeker(new MatcherSeeker("Seeker 3"));
//    hub.addSeeker(new MatcherSeeker("Seeker 4"));
//    hub.addSeeker(new MatcherSeeker("Seeker 5"));
//    hub.addEmployer(new MatcherEmployer("Employer 4"));
//    hub.addEmployer(new MatcherEmployer("Employer 5"));
//    hub.addEmployer(new MatcherEmployer("Employer 6"));
//
//    hub.printMatrix();
//
//    System.out.println();
//
////    hub.addLikeMatrix(e3,s2);
////    System.out.println("E3's matches: " + e3.getUserMatches());
////    hub.addLikeMatrix(e3,s2);
////    System.out.println("E3's matches: " + e3.getUserMatches().get(0));




    Hub hub1 = new Hub();
    //ArrayList<EmployeeMatcherUser> list = new ArrayList<EmployeeMatcherUser>();
    MatcherSeeker se1 = new MatcherSeeker("Seeker");
    //list.add(se1);
    MatcherEmployer em1 = new MatcherEmployer("Employer");
    MatcherEmployer em2 = new MatcherEmployer("Google");
    //list.add(em1);

    hub1.printMatrix();
    hub1.addSeeker(se1);
    hub1.addEmployer(em1);
    hub1.addEmployer(em2);
    hub1.printMatrix();
    hub1.addLikeMatrix(se1, em1);
    hub1.printMatrix();
    hub1.addLikeMatrix(em1, se1);
    hub1.addLikeMatrix(em2, se1);
    hub1.addLikeMatrix(se1, em2);
    hub1.printMatrix();

    System.out.println(se1.getUserMatches());





  }
}
