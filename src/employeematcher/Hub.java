package employeematcher;

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
  public void addLikeMatrix(MatcherEmployer e, MatcherSeeker s) {
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


  // driver for the program, for testing purposes
//  public static void main(String[] args){
//    Hub hub = new Hub();
//
//    ArrayList<Integer> a = new ArrayList<Integer>();
//    a.add(1);
//    a.add(2);
//    System.out.println(a.size());
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
//    hub.printMatrix();
//
//    hub.addLikeMatrix(e3,s2);
//    System.out.println("E3's matches: " + e3.getUserMatches());
//    hub.addLikeMatrix(e3,s2);
//    System.out.println("E3's matches: " + e3.getUserMatches().get(0));
//
//
//
//  }
}
