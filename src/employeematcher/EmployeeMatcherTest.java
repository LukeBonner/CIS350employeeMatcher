package EmployeeMatcher;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.Test;

public class EmployeeMatcherTest {

  @Test
  public void initializeMatrixTest1() {
    Hub hub = new Hub(true);
    assertEquals(0,(int)hub.getMatrix().get(0).get(0));
  }

  @Test
  public void initializeMatrixTest2() {
    Hub hub = new Hub(true);
    assertEquals(1,(int)hub.getMatrix().size());
  }

  @Test
  public void initializeMatrixTest4() {
    Hub hub = new Hub(true);
    assertEquals(1,(int)hub.getMatrix().get(0).size());
  }

  @Test
  public void setUserSeekerTest() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker();
    s1.setUName("A");
    s1.setPWord("B");
    hub.addSeeker(s1);

    EmployeeMatcherUser u1 = hub.setCurrentUser("A","B");
    assertEquals(u1,s1);
  }

  @Test
  public void setUserEmployerTest() {
    Hub hub = new Hub(true);
    MatcherEmployer e1 = new MatcherEmployer();
    e1.setUName("A");
    e1.setPWord("B");
    hub.addEmployer(e1);

    EmployeeMatcherUser u1 = hub.setCurrentUser("A","B");
    assertEquals(u1,e1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setUserInvalidTest() {
    Hub hub = new Hub(true);
    hub.setCurrentUser("A","B");
  }

  @Test
  public void getSeekersTest1() {
    Hub hub = new Hub(true);
    assertEquals(hub.getSeekers().size(),1);
  }

  @Test
  public void getSeekersTest2() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker();
    hub.addSeeker(s1);
    assertEquals(hub.getSeekers().size(),2);
  }

  @Test
  public void getEmployersTest1() {
    Hub hub = new Hub(true);
    assertEquals(hub.getEmployers().size(),1);
  }

  @Test
  public void getEmployersTest2() {
    Hub hub = new Hub(true);
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addEmployer(e1);
    assertEquals(hub.getEmployers().size(),2);
  }

  @Test
  public void getNumSeekersTest1() {
    Hub hub = new Hub(true);
    assertEquals(hub.getNumSeekers(),1);
  }

  @Test
  public void getNumSeekersTest2() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherSeeker s2 = new MatcherSeeker();
    hub.addSeeker(s1);
    hub.addSeeker(s2);

    assertEquals(hub.getNumSeekers(),3);
  }

  @Test
  public void getNumEmployersTest1() {
    Hub hub = new Hub(true);
    assertEquals(hub.getNumEmployers(),1);
  }

  @Test
  public void getNumEmployersTest2() {
    Hub hub = new Hub(true);
    MatcherEmployer e1 = new MatcherEmployer();
    MatcherEmployer e2 = new MatcherEmployer();
    hub.addEmployer(e1);
    hub.addEmployer(e2);

    assertEquals(hub.getNumEmployers(),3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void addInvalidLikeSeekersTest() {
    Hub hub = new Hub(true);
    hub.addLikeMatrix(new MatcherSeeker(),new MatcherSeeker());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addInvalidLikeEmployersTest() {
    Hub hub = new Hub(true);
    hub.addLikeMatrix(new MatcherEmployer(),new MatcherEmployer());
  }

  @Test
  public void addLikeMatrixSeekerTest() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker("A","B","C","D","E","F",new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    MatcherEmployer e1 = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G",
        "H", "I", new ArrayList<String>(), new ArrayList<String>());
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertEquals(7, (int)hub.getMatrix().get(1).get(1));
  }

  @Test
  public void addLikeMatrixEmployerTest() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker("A","B","C","D","E","F",new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    MatcherEmployer e1 = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(e1,s1);
    assertEquals(5, (int)hub.getMatrix().get(1).get(1));
  }

  @Test
  public void usersMatchedFalseTest1() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertFalse(hub.usersMatched(s1,e1));
  }

  @Test
  public void usersMatchedFalseTest2() {
    Hub hub = new Hub(true);
    MatcherSeeker s1 = new MatcherSeeker();
    MatcherEmployer e1 = new MatcherEmployer();
    hub.addSeeker(s1);
    hub.addEmployer(e1);
    hub.addLikeMatrix(s1,e1);
    assertFalse(hub.usersMatched(e1,s1));
  }

  @Test
  public void seekerGetUNameTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("A", s.getUName());
  }

  @Test
  public void seekerGetPWordTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("B", s.getPWord());
  }

  @Test
  public void seekerGetFirstNameTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("C", s.getFirstName());
  }

  @Test
  public void seekerGetIndustryTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("D", s.getIndustry());
  }

  @Test
  public void seekerGetLastNameTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("E", s.getLastName());
  }

  @Test
  public void seekerGetPersonalStatementTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("F", s.getPersonalStatement());
  }

  @Test
  public void seekerGetEducationTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("", s.getEducation());
  }

  @Test
  public void seekerGetExperienceTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("", s.getExperience());
  }

  @Test
  public void seekerGetImagesTest() {
    ArrayList<String> images = new ArrayList<String>();
    images.add("filelocation.png");
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        images, new ArrayList<String>(), new ArrayList<String>());
    assertEquals(images, s.getImagesSeeker());
  }

  @Test
  public void seekerGetUrlsTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    assertEquals("", s.getUrls());
  }

  @Test
  public void seekerSetFirstNameTest() {
    MatcherSeeker s = new MatcherSeeker();
    s.setFirstName("A");
    assertEquals("A", s.getFirstName());
  }

  @Test
  public void seekerSetIndustryTest() {
    MatcherSeeker s = new MatcherSeeker();
    s.setIndustry("A");
    assertEquals("A", s.getIndustry());
  }

  @Test
  public void seekerSetLastNameTest() {
    MatcherSeeker s = new MatcherSeeker();
    s.setLastName("A");
    assertEquals("A", s.getLastName());
  }

  @Test
  public void seekerSetPersonalStatementTest() {
    MatcherSeeker s = new MatcherSeeker();
    s.setPersonalStatement("A");
    assertEquals("A", s.getPersonalStatement());
  }

  @Test
  public void seekerSetEducationTest() {
    MatcherSeeker s = new MatcherSeeker();
    ArrayList<String> edu = new ArrayList<>();
    edu.add("A");
    s.setEducation(edu);
    assertEquals("A", s.getEducation());
  }

  @Test
  public void seekerSetExperienceTest() {
    MatcherSeeker s = new MatcherSeeker();
    ArrayList<String> exp = new ArrayList<>();
    exp.add("A");
    s.setExperience(exp);
    assertEquals("A", s.getExperience());
  }

  @Test
  public void seekerSetUrlsTest() {
    MatcherSeeker s = new MatcherSeeker();
    ArrayList<String> urls = new ArrayList<>();
    urls.add("A");
    s.setUrls(urls);
    assertEquals("A", s.getUrls());
  }

  @Test
  public void seekerGetFullNameTest() {
    MatcherSeeker s = new MatcherSeeker();
    s.setFirstName("A");
    s.setLastName("B");
    assertEquals("A B", s.getFullName());
  }

  @Test
  public void employerGetUNameTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("A", e.getUName());
  }

  @Test
  public void employerGetPWordTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("B", e.getPWord());
  }

  @Test
  public void employerGetCompanyNameTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("C", e.getCompanyName());
  }

  @Test
  public void employerGetLocationTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("D", e.getLocation());
  }

  @Test
  public void employerGetSizeTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("E", e.getSize());
  }

  @Test
  public void employerGetIndustryTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("F", e.getIndustry());
  }

  @Test
  public void employerGetPositionTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("G", e.getPosition());
  }

  @Test
  public void employerGetJobDescriptionTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("H", e.getJobDescription());
  }

  @Test
  public void employerGetCompanyDescriptionTest() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    assertEquals("I", e.getCompanyDescription());
  }

  @Test
  public void employerSetCompanyNameTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setCompanyName("A");
    assertEquals("A", e.getCompanyName());
  }

  @Test
  public void employerSetLocationTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setLocation("A");
    assertEquals("A", e.getLocation());
  }

  @Test
  public void employerSetSizeTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setSize("A");
    assertEquals("A", e.getSize());
  }

  @Test
  public void employerSetIndustryTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setIndustry("A");
    assertEquals("A", e.getIndustry());
  }

  @Test
  public void employerSetPositionTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setPosition("A");
    assertEquals("A", e.getPosition());
  }

  @Test
  public void employerSetJobDescriptionTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setJobDescription("A");
    assertEquals("A", e.getJobDescription());
  }

  @Test
  public void employerSetCompanyDescriptionTest() {
    MatcherEmployer e = new MatcherEmployer();
    e.setCompanyDescription("A");
    assertEquals("A", e.getCompanyDescription());
  }

  @Test
  public void seekerTestToWrite() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
    String toWrite = s.toWrite();
    assertEquals("0,A,B,C,E,F,D,BLANK|BLANK|BLANK|BLANK|BLANK|*", toWrite);
  }

  @Test
  public void employerTestToWrite() {
    ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    String toWrite = e.toWrite();
    assertEquals("1,A,B,C,D,E,F,G,H,I|BLANK|BLANK|*", toWrite);
  }

  @Test
  public void employerGetImagesTest() {
    ArrayList<String> images = new ArrayList<String>();
    images.add("filelocation.png");
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        images, new ArrayList<String>());
    assertEquals(images, e.getImagesEmployer());
  }

  @Test
  public void employerGetImagesIncorrectTest() {
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<String> images2 = new ArrayList<String>();
    images.add("filelocation.png");
    images2.add("filelocation.jpg");
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        images, new ArrayList<String>());
    assertNotEquals(images2, e.getImagesEmployer());
  }

  @Test
  public void employerAddImagesTest() {
    ArrayList<String> images = new ArrayList<String>();
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        images, new ArrayList<String>());
    String image = "a";
    images.add(image);
    assertEquals(image, e.getImagesEmployer().get(0));

  }

  @Test
  public void employerToStringTest() {
    MatcherEmployer e = new MatcherEmployer("A", "B", "C", "D", "E", "F", "G", "H", "I",
        new ArrayList<String>(), new ArrayList<String>());
    String companyName = "A";
    e.setCompanyName(companyName);
    assertEquals(companyName, e.toString());
  }

  @Test
  public void seekerAddExperienceTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String exp = "A";
    s.addExperience(exp);
    assertEquals(exp, s.getExperience());
  }

  @Test
  public void seekerAddMultipleExperienceTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String exp = "A";
    s.addExperience(exp);
    s.addExperience(exp);
    assertEquals(exp + ", " + exp, s.getExperience());
  }


  @Test
  public void seekerAddEducationTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String edu = "A";
    s.addEducation(edu);
    assertEquals(edu, s.getEducation());
  }

  @Test
  public void seekerAddMultipleEducationTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String edu = "A";
    s.addEducation(edu);
    s.addEducation(edu);
    assertEquals(edu + ", " + edu, s.getEducation());
  }

  @Test
  public void seekerAddUrlTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String url = "A";
    s.addUrl(url);
    assertEquals(url, s.getUrls());
  }

  @Test
  public void seekerAddMultipleUrlsTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F", new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    String url = "A";
    s.addUrl(url);
    s.addUrl(url);
    assertEquals(url + ", " + url, s.getUrls());
  }

  @Test
  public void seekerGetImagesIncorrectTest() {
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<String> images2 = new ArrayList<String>();
    images.add("filelocation.png");
    images2.add("filelocation.jpg");
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",images,new ArrayList<String>(),
        images, new ArrayList<String>(), new ArrayList<String>());
    assertNotEquals(images2, s.getImagesSeeker());
  }

  @Test
  public void getSeekerMatchesTest() {
    MatcherSeeker s = new MatcherSeeker("A","B","C","D","E","F",new ArrayList<String>(),
        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
        new ArrayList<String>());
    ArrayList<String> matches = new ArrayList<String>();
    matches.add("A");
    s.addMatch("A");
    assertEquals(matches.get(0),s.getUserMatches().get(0));
  }




}
