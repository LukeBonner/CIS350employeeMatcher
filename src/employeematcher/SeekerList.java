/**
 * Holds every job-seeker in a list used for presentation to companies.
 * Visibility of individual job-seekers to the companies will depend on
 * on a boolean value indicating whether or not the company has
 * already liked/rejected them in the past. Only job-seekers without an
 * interaction will be visible to the viewing company, but all are contained
 * in the list.
 */

package employeematcher;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SeekerList {
  private SeekerNode top;

  public SeekerList() {
    top = null;
  }

  public int getLen() {
    int nodeCounter = 0;
    SeekerNode temp = top;

    while (temp != null) {
      temp = temp.getNext();
      nodeCounter++;
    }

    return nodeCounter;
  }

  public void insertBefore(int index, String firstName, String industry, String lastName,
               String personalStatement, ArrayList<String> education,
               ArrayList<String> experience,
               ArrayList<BufferedImage> images, ArrayList<String> urls) {
    SeekerNode current = top;
    SeekerNode temp = new SeekerNode(firstName, industry, lastName,
        personalStatement, education, experience, images, urls, null);

    if (top == null) {
      top = new SeekerNode(firstName, industry, lastName,
          personalStatement, education, experience, images, urls, null);
    }

    if (index < 0 || index >= getLen()) {
      throw new IllegalArgumentException("Invalid index");
    }

    if (current.getNext() == null) {
      temp.setNext(current);
      top = temp;
      return;
    }

    for (int i = 0; i < index - 1; ++i) {
      current = current.getNext();
    }

    temp.setNext(current.getNext());
    current.setNext(temp);
  }

  public void insertAfter(int index, String firstName, String industry, String lastName,
              String personalStatement, ArrayList<String> education,
              ArrayList<String> experience,
              ArrayList<BufferedImage> images, ArrayList<String> urls) {
    SeekerNode current = top;
    SeekerNode temp = new SeekerNode(firstName, industry, lastName,
        personalStatement, education, experience, images, urls, null);

    if (top == null) {
      top = new SeekerNode(firstName, industry, lastName,
          personalStatement, education, experience, images, urls, null);
      return;
    }

    if (index < 0 || index >= getLen()) {
      throw new IllegalArgumentException("Invalid index");
    }

    for (int i = 0; i < index; ++i) {
      current = current.getNext();
    }

    temp.setNext(current.getNext());
    current.setNext(temp);

  }

  public String removeTop() {
    if (top == null) {
      throw new RuntimeException("No list");
    }

    SeekerNode formerTop = top;
    top = top.getNext();
    return formerTop.getFirstName() + " " + formerTop.getLastName();
  }

  public boolean delAt(int index) {
    SeekerNode current = top;

    if (index < 0 || index >= getLen()) {
      throw new IllegalArgumentException("Invalid index.");
    }

    if (index == 0) {
      removeTop();
    }

    for (int i = 0; i < index - 1; ++i) {
      current = current.getNext();
    }

    SeekerNode toDelete = current.getNext();
    current.setNext(current.getNext().getNext());
    toDelete.setNext(null);
    return true;

  }

  public void changeNode(int index, String firstName, String industry, String lastName,
               String personalStatement, ArrayList<String> education,
               ArrayList<String> experience,
               ArrayList<BufferedImage> images, ArrayList<String> urls) {
    // replaces the node at an index with updated data
    // verify that the node is from the same user (check companyName & jobDescription)
    // and throw exception if it is not the same
  }
}
