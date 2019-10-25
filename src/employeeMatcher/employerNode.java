// method extracts only the data relevant to the user's profile
// to be stored in a node held in a LinkedList

package employeeMatcher;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class employerNode {
    private String companyName;
    private String location;
    private String size;
    private String industry;
    private String position;
    private String jobDescription;
    private String companyDescription;
    private ArrayList<BufferedImage> images;
    private employerNode next;

    public employerNode(String companyName, String location,
                        String size, String industry, String position,
                        String jobDescription, String companyDescription,
                        ArrayList<BufferedImage> images, employerNode next) {
        this.companyName = companyName;
        this.location = location;
        this.size = size;
        this.industry = industry;
        this.position = position;
        this.jobDescription = jobDescription;
        this.companyDescription = companyDescription;
        this.images = images;
        this.next = next;
    }

    public employerNode(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public ArrayList<BufferedImage> getImages() {
        return images;
    }

    public void setImages(ArrayList<BufferedImage> images) {
        this.images = images;
    }

    public void setNext(employerNode next){
        this.next = next;
    }

    public employerNode getNext(){
        return next;
    }

    public employerNode updateNode(){
        // updates the user's profile by changing the current state
        // of their profile in the list
        return null;
    }


}
