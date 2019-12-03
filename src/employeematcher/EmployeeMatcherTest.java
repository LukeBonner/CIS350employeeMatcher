package employeeMatcher;

import org.junit.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class EmployeeMatcherTest {

  @Test
  public void initializeMatrixTest1(){
    Hub hub = new Hub();
    assertEquals(0,(int)hub.getMatrix().get(0).get(0));
  }

  @Test
  public void initializeMatrixTest2(){
    Hub hub = new Hub();
    assertEquals(1,(int)hub.getMatrix().size());
  }

  @Test
  public void initializeMatrixTest4(){
    Hub hub = new Hub();
    assertEquals(1,(int)hub.getMatrix().get(0).size());
  }

  @Test
  public void setUserSeekerTest(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    s1.setUName("A");
    s1.setPWord("B");
    hub.addSeeker(s1);

    EmployeeMatcherUser u1 = hub.setCurrentUser("A","B");
    assertEquals(u1,s1);
  }

  @Test
  public void setUserEmployerTest(){
    Hub hub = new Hub();
    MatcherEmployer e1 = new MatcherEmployer();
    e1.setUName("A");
    e1.setPWord("B");
    hub.addEmployer(e1);

    EmployeeMatcherUser u1 = hub.setCurrentUser("A","B");
    assertEquals(u1,e1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setUserInvalidTest(){
    Hub hub = new Hub();
    hub.setCurrentUser("A","B");
  }

  @Test
  public void getSeekersTest1(){
    Hub hub = new Hub();
    System.out.println(hub.getSeekers());
    assertEquals(hub.getSeekers().size(),1);
  }

  @Test
  public void getSeekersTest2(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    hub.addSeeker(s1);
    assertEquals(hub.getSeekers().size(),2);
  }

  @Test
  public void getEmployersTest1(){
    Hub hub = new Hub();
    assertEquals(hub.getEmployers().size(),1);
  }

  @Test
  public void getEmployersTest2(){
    Hub hub = new Hub();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addEmployer(e1);
    assertEquals(hub.getEmployers().size(),2);
  }

  @Test
  public void getNumSeekersTest1(){
    Hub hub = new Hub();
    assertEquals(hub.getNumSeekers(),1);
  }

  @Test
  public void getNumSeekersTest2(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherSeeker s2 = new MatcherSeeker();
    hub.addSeeker(s1);
    hub.addSeeker(s2);

    assertEquals(hub.getNumSeekers(),3);
  }

  @Test
  public void getNumEmployersTest1(){
    Hub hub = new Hub();
    assertEquals(hub.getNumEmployers(),1);
  }

  @Test
  public void getNumEmployersTest2(){
    Hub hub = new Hub();
    MatcherEmployer e1 = new MatcherEmployer();
    MatcherEmployer e2 = new MatcherEmployer();
    hub.addEmployer(e1);
    hub.addEmployer(e2);

    assertEquals(hub.getNumEmployers(),3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addInvalidLikeSeekersTest(){
    Hub hub = new Hub();
    hub.addLikeMatrix(new MatcherSeeker(),new MatcherSeeker());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addInvalidLikeEmployersTest(){
    Hub hub = new Hub();
    hub.addLikeMatrix(new MatcherEmployer(),new MatcherEmployer());
  }

  @Test
  public void addLikeMatrixSeekerTest(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertEquals(7, (int)hub.getMatrix().get(1).get(1));
  }

  @Test
  public void addLikeMatrixEmployerTest(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(e1,s1);
    assertEquals(5, (int)hub.getMatrix().get(1).get(1));
  }

  @Test
  public void addLikeBothTest(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    hub.addLikeMatrix(e1,s1);
    assertEquals(12, (int)hub.getMatrix().get(1).get(1));
  }

  @Test
  public void usersMatchedTrueTest1(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    hub.addLikeMatrix(e1,s1);
    assertTrue(hub.usersMatched(s1,e1));
  }

  @Test
  public void usersMatchedTrueTest2(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    hub.addLikeMatrix(e1,s1);
    assertTrue(hub.usersMatched(e1,s1));
  }

  @Test
  public void usersMatchedFalseTest1(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertFalse(hub.usersMatched(s1,e1));
  }

  @Test
  public void usersMatchedFalseTest2(){
    Hub hub = new Hub();
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertFalse(hub.usersMatched(e1,s1));
  }

  @Test
  public void seekerGetFirstNameTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("A", s.getFirstName());
  }

  @Test
  public void seekerGetIndustryTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("B", s.getIndustry());
  }

  @Test
  public void seekerGetLastNameTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("C", s.getLastName());
  }

  @Test
  public void seekerGetPersonalStatementTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("D", s.getPersonalStatement());
  }

  @Test
  public void seekerGetEducationTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("E", s.getEducation());
  }

  @Test
  public void seekerGetExperienceTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("F", s.getExperience());
  }

  @Test
  public void seekerGetImagesTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals(images, s.getImages());
  }

  @Test
  public void seekerGetURLsTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,"G");
    assertEquals("G", s.getUrls());
  }

  @Test
  public void seekerSetFirstNameTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setFirstName("A");
    assertEquals("A", s.getFirstName());
  }

  @Test
  public void seekerSetIndustryTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setIndustry("A");
    assertEquals("A", s.getIndustry());
  }

  @Test
  public void seekerSetLastNameTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setLastName("A");
    assertEquals("A", s.getLastName());
  }

  @Test
  public void seekerSetPersonalStatementTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setPersonalStatement("A");
    assertEquals("A", s.getPersonalStatement());
  }

  @Test
  public void seekerSetEducationTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setEducation("A");
    assertEquals("A", s.getEducation());
  }

  @Test
  public void seekerSetExperienceTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setExperience("A");
    assertEquals("A", s.getExperience());
  }

  @Test
  public void seekerSetImagesTest(){
    MatcherSeeker s = new MatcherSeeker();
    ImageIcon image = new ImageIcon();
    s.addImage(image);
    assertEquals(image, s.getImages().get(0));
  }

  @Test
  public void seekerSetURLsTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setUrls("A");
    assertEquals("A", s.getUrls());
  }

  @Test
  public void seekerGetFullNameTest(){
    MatcherSeeker s = new MatcherSeeker();
    s.setFirstName("A");
    s.setLastName("B");
    assertEquals("A B", s.getFullName());
  }

  @Test
  public void employerGetCompanyNameTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("A", e.getCompanyName());
  }

  @Test
  public void employerGetLocationTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("B", e.getLocation());
  }

  @Test
  public void employerGetSizeTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("C", e.getSize());
  }

  @Test
  public void employerGetIndustryTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("D", e.getIndustry());
  }

  @Test
  public void employerGetPositionTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("E", e.getPosition());
  }

  @Test
  public void employerGetJobDescriptionTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("F", e.getJobDescription());
  }

  @Test
  public void employerGetCompanyDescriptionTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals("G", e.getCompanyDescription());
  }

  @Test
  public void employerGetImagesTest(){
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",images);
    assertEquals(images, e.getImages());
  }

  //

  @Test
  public void employerSetCompanyNameTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setCompanyName("A");
    assertEquals("A", e.getCompanyName());
  }

  @Test
  public void employerSetLocationTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setLocation("A");
    assertEquals("A", e.getLocation());
  }

  @Test
  public void employerSetSizeTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setSize("A");
    assertEquals("A", e.getSize());
  }

  @Test
  public void employerSetIndustryTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setIndustry("A");
    assertEquals("A", e.getIndustry());
  }

  @Test
  public void employerSetPositionTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setPosition("A");
    assertEquals("A", e.getPosition());
  }

  @Test
  public void employerSetJobDescriptionTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setJobDescription("A");
    assertEquals("A", e.getJobDescription());
  }

  @Test
  public void employerSetCompanyDescriptionTest(){
    MatcherEmployer e = new MatcherEmployer();
    e.setCompanyDescription("A");
    assertEquals("A", e.getCompanyDescription());
  }

  @Test
  public void employerSetImagesTest(){
    MatcherEmployer e = new MatcherEmployer();
    ImageIcon image = new ImageIcon();
    e.addImage(image);
    assertEquals(image, e.getImages().get(0));
  }

}
