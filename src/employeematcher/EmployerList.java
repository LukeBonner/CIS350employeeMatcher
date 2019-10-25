/**
 * Holds every company's job posting in a list used for presentation to job-seekers.
 * Visibility of individual postings to the seekers will depend on
 * on a boolean value indicating whether or not the seeker has
 * already liked/rejected them in the past. Only postings without an
 * interaction from the seeker will be visible to the seeker,
 * but all are contained in the list.
 */

package employeematcher;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EmployerList {
  private EmployerNode top;

  public EmployerList() {
    top = null;
  }

  public int getLen() {
    int nodeCounter = 0;
    EmployerNode temp = top;

    while (temp != null) {
      temp = temp.getNext();
      nodeCounter++;
    }

    return nodeCounter;
  }

  public void insertBefore(int index, String companyName, String location,
               String size, String industry, String position,
               String jobDescription, String companyDescription,
               ArrayList<BufferedImage> images) {
    EmployerNode current = top;
    EmployerNode temp = new EmployerNode(companyName, location, size,
        industry, position, jobDescription, companyDescription,
        images, null);

    if (top == null) {
      top = new EmployerNode(companyName, location, size,
          industry, position, jobDescription, companyDescription,
          images, null);
      return;
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

  public void insertAfter(int index, String companyName, String location,
              String size, String industry, String position,
              String jobDescription, String companyDescription,
              ArrayList<BufferedImage> images) {

    EmployerNode current = top;
    EmployerNode temp = new EmployerNode(companyName, location, size,
        industry, position, jobDescription, companyDescription,
        images, null);

    if (top == null) {
      top = new EmployerNode(companyName, location, size,
          industry, position, jobDescription, companyDescription,
          images, null);
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
    EmployerNode formerTop = top;
    top = top.getNext();
    return formerTop.getCompanyName();
  }

  public boolean delAt(int index) {
    EmployerNode current = top;

    if (index < 0 || index >= getLen()) {
      throw new IllegalArgumentException("Invalid index.");
    }

    if (index == 0) {
      removeTop();
    }

    for (int i = 0; i < index - 1; ++i) {
      current = current.getNext();
    }

    EmployerNode toDelete = current.getNext();
    current.setNext(current.getNext().getNext());
    toDelete.setNext(null);
    return true;
  }

  public void changeNode(int index, String companyName, String location,
               String size, String industry, String position,
               String jobDescription, String companyDescription,
               ArrayList<BufferedImage> images) {
    // replaces the node at an index with updated data
    // verify that the node is from the same user (check companyName & jobDescription)
    // and throw exception if it is not the same
  }


}
