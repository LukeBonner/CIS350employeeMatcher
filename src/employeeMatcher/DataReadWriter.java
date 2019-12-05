package employeeMatcher;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Reads in user information from a file, stores it, and writes it back to files.
 *
 * This class maintains a list of all users in the Employee Matcher's data, called storage.
 * Upon construction of an object of type DataReadWriter, the object attempts to populate its
 * storage using what information it can read in the file at the provided path. If no path is
 * provided, it defaults to looking for a "db.txt" file in the same directory.
 *
 * The DataReadWriter also supports manually adding users to the storage, overwriting the storage
 * to a provided ArrayList of users, and adding any users in a provided list that are not already
 * in the storage to the storage. Finally, the DataReadWriter is able to write its data to a file
 * at the provided path, storing the information in the same format it looks for when reading.
 *
 * @author Adam Weaver
 * @version 12/2/2019
 */

public class DataReadWriter {

    /**
     * Stores all users found.
     *
     * This list of EmployeeMatcherUsers holds all the users that the DataReadWriter has read
     * or will write. It stores them in the order they were found/added.
     */
    private ArrayList<EmployeeMatcherUser> storage = new ArrayList<EmployeeMatcherUser>();

    /**
     * The Default constructor.
     *
     * If provided no arguments, the DataReadWriter will attempt to read from "db.txt" in the
     * current project's directory. Calls the DataReadWriter(String path) constructor.
     *
     * @see DataReadWriter(String path)
     */
    public DataReadWriter() {
        this("db.txt");
    }

    /**
     * Given a path to a text file, populate the current object's storage with the contents.
     *
     * This constructor contains the logic needed to read users in from a file. If the file path
     * is invalid, or if the read otherwise fails to find any users, it will print a message
     * stating what has gone wrong to the console.
     *
     * @param path, the location of the text file to attempt to read.
     */
    public DataReadWriter(String path) {
            File in = null;
            Scanner scnr;
            try {
                in = new File(path);
                scnr = new Scanner(in);
                String curr = "";
                int i = 0;
                while (scnr.hasNext()) {
                    curr = scnr.nextLine();
                    StringTokenizer st = new StringTokenizer(curr, ",|", true);
                    String cTok = "";
                    while (st.hasMoreTokens()) {
                        cTok = st.nextToken();
                        if (cTok.equals(",")) {
                            continue;
                        }
                        if (cTok.equals("0")) {
                            String cUName = "";
                            String cPass = "";
                            String cFName = "";
                            String cLName = "";
                            String cPStatement = "";
                            String cIndustry = "";
                            ArrayList<String> cEducation = new ArrayList<String>();
                            ArrayList<String> cExp = new ArrayList<String>();
                            ArrayList<String> cUrls = new ArrayList<String>();
                            ArrayList<String> cIPaths = new ArrayList<String>();
                            ArrayList<String> cMatches = new ArrayList<String>();

                            cTok = st.nextToken();
                            while (!cTok.equals("*") && st.hasMoreTokens()) {
                                if (cTok.equals(",")) {
                                    cTok = st.nextToken();
                                    continue;
                                }
                                switch (i) {
                                    case 0:
                                        cUName = cTok;
                                        i += 1;
                                        break;
                                    case 1:
                                        cPass = cTok;
                                        i += 1;
                                        break;
                                    case 2:
                                        cFName = cTok;
                                        i += 1;
                                        break;
                                    case 3:
                                        cLName = cTok;
                                        i += 1;
                                        break;
                                    case 4:
                                        cPStatement = cTok;
                                        i += 1;
                                        break;
                                    case 5:
                                        cIndustry = cTok;
                                        i += 1;
                                        break;
                                    case 6:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cEducation.add(cTok);
                                        break;
                                    case 7:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cExp.add(cTok);
                                        break;
                                    case 8:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cUrls.add(cTok);
                                        break;
                                    case 9:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cIPaths.add(cTok);
                                        break;
                                    case 10:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cMatches.add(cTok);
                                        break;
                                    default:
                                        break;
                                }
                                cTok = st.nextToken();
                            }
                            storage.add(new MatcherSeeker(cUName, cPass, cFName, cIndustry, cLName, cPStatement,
                                    cEducation, cExp, cIPaths, cUrls, cMatches));
                            i = 0;
                        }
                        else if (cTok.equals("1")) {
                            String cUName = "";
                            String cPass = "";
                            String cCName = "";
                            String cLoc = "";
                            String cSize = "";
                            String cIndustry = "";
                            String cPos = "";
                            String cJDesc = "";
                            String cCDesc = "";
                            ArrayList<String> cIPaths = new ArrayList<String>();
                            ArrayList<String> cMatches = new ArrayList<String>();

                            cTok = st.nextToken();
                            while (!cTok.equals("*") && st.hasMoreTokens()) {
                                if (cTok.equals(",")) {
                                    cTok = st.nextToken();
                                    continue;
                                }
                                switch (i) {
                                    case 0:
                                        cUName = cTok;
                                        i += 1;
                                        break;
                                    case 1:
                                        cPass = cTok;
                                        i += 1;
                                        break;
                                    case 2:
                                        cCName = cTok;
                                        i += 1;
                                        break;
                                    case 3:
                                        cLoc = cTok;
                                        i += 1;
                                        break;
                                    case 4:
                                        cSize = cTok;
                                        i += 1;
                                        break;
                                    case 5:
                                        cIndustry = cTok;
                                        i += 1;
                                        break;
                                    case 6:
                                        cPos = cTok;
                                        i += 1;
                                        break;
                                    case 7:
                                        cJDesc = cTok;
                                        i += 1;
                                        break;
                                    case 8:
                                        cCDesc = cTok;
                                        i += 1;
                                        break;
                                    case 9:
                                        if (cTok.equals("|")) {
                                            if (cIPaths.size() > 0) {
                                                i += 1;
                                            }
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cIPaths.add(cTok);
                                        break;
                                    case 10:
                                        if (cTok.equals("|")) {
                                            i += 1;
                                            break;
                                        }
                                        if (cTok.equals("BLANK")) {
                                            cTok = st.nextToken();
                                            i += 1;
                                            break;
                                        }
                                        cMatches.add(cTok);
                                        break;
                                    default:
                                        break;
                                }
                                cTok = st.nextToken();
                            }
                            storage.add(new MatcherEmployer(cUName, cPass, cCName, cLoc, cSize,
                                    cIndustry, cPos, cJDesc, cCDesc, cIPaths, cMatches));
                            i = 0;
                        }
                    }
                }
                if (storage.size() == 0) {
                    throw new Exception("Storage EMPTY! Read Failed!");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
            finally {
                if (in != null) {
                    in = null;
                }
            }
        }

    /**
     * Gets the current contents of the storage.
     *
     * @return storage, an ArrayList of EmployeeMatcherUsers.
     */
    public ArrayList<EmployeeMatcherUser> getStorage() {
        return this.storage;
    }

    /**
     * Overrides the existing storage with a new storage list.
     *
     * Given an ArrayList of EmployeeMatcherUsers, replace the currently stored
     * list of users with the provided list.
     *
     * This method is only to be used when the user is certain that the new storage is valid.
     * This method performs no checks to see if the new storage is valid beyond guaranteeing
     * the type. If the user calls saveStorage() into the same path as the old storage but with
     * storage contents containing storage set by this method, the old data will be lost.
     *
     * @param newStor, an ArrayList of EmployeeUserMatchers to set as the current storage.
     */
    public void overrideStorage(ArrayList<EmployeeMatcherUser> newStor) {
        this.storage = newStor;
    }

    /**
     * Adds elements from a provided list to storage if they are not already there.
     *
     * Given an ArrayList of EmployeeMatcherUsers, add any elements that are in the provided
     * list but not in storage to storage.
     *
     * @param updated, an ArrayList of EmployeeMatcherUsers
     */
    public void updateStorage(ArrayList<EmployeeMatcherUser> updated) {
        for (EmployeeMatcherUser up : updated) {
            String upUN = up.getUName();
            boolean valid = true;
            for (EmployeeMatcherUser curr : this.storage) {
                String currUN = curr.getUName();
                if (!valid) {
                    continue;
                }
                if (currUN.equals(upUN)) {
                    valid = false;
                    continue;
                }
            }
            if (valid) {
                this.storage.add(up);
            }
        }
    }

    /**
     * The default saveStorage method.
     *
     * Given no arguments, the saveStorage method automatically attempts to write the
     * current state of the database to a "db.txt" file at the project's home directory.
     *
     * @see saveStorage(String path)
     */
    public void saveStorage() {
        this.saveStorage("db.txt");
    }

    /**
     * Given a path in which to store the data, save the storage list to a file.
     *
     * This method writes each element in storage to a file, using the MatcherSeeker
     * and MatcherEmployer classes' toWrite() methods to generate the correct format.
     * The format of information in the resulting file is the same as that which the
     * constructor searches for. As a result, the DataReadWriter class can save its
     * storage to a file in one execution of a program, then read it back in on the
     * next execution of the program, allowing it to preserve its data between executions
     * of a program.
     *
     * @param path, a String containing the desired path of the file to be written to.
     */
    public void saveStorage(String path) {
        ArrayList<String> written = new ArrayList<String>();
        written.add("");
        File fout = new File(path);
        try{
            FileWriter out = new FileWriter(fout);
            for (EmployeeMatcherUser e : storage) {
                out.write(e.toWrite());
                out.write("\n");
                out.flush();
            }
            out.close();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println(storage.size());
        }
    }
}






































