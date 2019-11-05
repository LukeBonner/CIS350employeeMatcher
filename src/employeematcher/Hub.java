package employeematcher;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * when the user likes another user, this class needs to be passed the
 * seeker and employer objects from the interaction - use the
 * updateMatrix() method
 *
 */


public class Hub {
  public LinkedList<MatcherSeeker> seekers;

  public LinkedList<MatcherEmployer> employers;

  public ArrayList<ArrayList<Integer>> matrix;

  public Hub(){
    seekers = new LinkedList<MatcherSeeker>();
    employers = new LinkedList<MatcherEmployer>();
    initializeMatrix();
  }

  public LinkedList getSeekers(){
    return seekers;
  }

  public LinkedList getEmployers(){
    return employers;
  }

  public void initializeMatrix() {

  }

  public void addSeeker(){
    // add a seeker to the linkedlist when account is created
    addSeekerMatrix();
  }

  public void addSeekerMatrix(){
    // updates the matrix
  }

  public void addEmployer(){
    // add a employer to the linkedlist when account is created
    addEmployerMatrix();
  }

  public void addEmployerMatrix(){
    // updates the matrix
  }

  public void updateMatrix(MatcherEmployer e, MatcherSeeker s){

  }

  // driver for the program
  public static void main(String[] args){
    Hub hub = new Hub();
  }

}
