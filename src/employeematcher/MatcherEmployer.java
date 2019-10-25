package employeematcher;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MatcherEmployer extends EmployeeMatcherUser {
  public String companyName;

  public String location;

  public String size;

  public String industry;

  public String position;

  public String jobDescription;

  public String companyDescription;

  public ArrayList<BufferedImage> images;

  // add ArrayList containing every seeker, and a boolean
  // indicating whether user liked (True) or disliked (False) them
  // determines whether users can message each other

  public MatcherEmployer() {
    companyName = "";
    location = "";
    size = "";
    industry = "";
    position = "";
    jobDescription = "";
    companyDescription = "";
    images = new ArrayList<BufferedImage>();
  }

  public MatcherEmployer(String companyName, String location,
               String size, String industry, String position,
               String jobDescription, String companyDescription,
               ArrayList<BufferedImage> images) {
    this.companyName = companyName;
    this.location = location;
    this.size = size;
    this.industry = industry;
    this.position = position;
    this.jobDescription = jobDescription;
    this.companyDescription = companyDescription;
    this.images = images;
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

  public void createProfile(){
    // initial creation of the node
  }

  public void updateProfile(){

  }
}