// method extracts only the data relevant to the user's profile
// to be stored in a node held in a LinkedList

package employeeMatcher;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class seekerNode {
    public String firstName;
    public String industry;
    public String lastName;
    public String personalStatement;
    public ArrayList<String> education;
    public ArrayList<String> experience;
    public ArrayList<BufferedImage> images;
    public ArrayList<String> urls;
    public seekerNode next;

    public seekerNode(String firstName, String industry, String lastName,
                      String personalStatement, ArrayList<String> education,
                      ArrayList<String> experience,
                      ArrayList<BufferedImage> images, ArrayList<String> urls,
                      seekerNode next) {

        this.firstName = firstName;
        this.industry = industry;
        this.lastName = lastName;
        this.personalStatement = personalStatement;
        this.education = education;
        this.experience = experience;
        this.images = images;
        this.urls = urls;
        this.next = next;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalStatement() {
        return personalStatement;
    }

    public void setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
    }

    public ArrayList<String> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<String> education) {
        this.education = education;
    }

    public ArrayList<String> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<String> experience) {
        this.experience = experience;
    }

    public ArrayList<BufferedImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<BufferedImage> images) {
        this.images = images;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public seekerNode getNext() {
        return next;
    }

    public void setNext(seekerNode next) {
        this.next = next;
    }

    public employerNode updateNode(){
        // updates the user's profile by changing the current state
        // of their profile in the list
        return null;
    }
}
