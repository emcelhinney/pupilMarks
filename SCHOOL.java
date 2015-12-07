import javax.swing.JOptionPane;
import java.io.*;
public class SCHOOL
{
    //array of PUPIL objects
    private PUPIL pupilList[];
    //number of pupil to be called
    int noOfPupils;
    FILEREADCSV pupilmarkfile;
    private int topmark;
    private int maxDataPosition;
    public SCHOOL()
    {
        pupilmarkfile = new FILEREADCSV();
    }

    // top level algorithm
    public void processpupils() throws IOException
    {

        setUpPupilList();
        findmaxData();

    }

    private void setUpPupilList() throws IOException
    {
        // first user member
        System.out.println("School: Pupil mark update");
        System.out.println("** Preparing to read data file");
        // read file, fetch data as String array containing the rows
        String[] dataRows = pupilmarkfile.readCSVtable ();
        // calculate the number of member rows, skip headings
        noOfPupils = dataRows.length ;
        // update user with number of rows with pupil details
        System.out.println("** " + noOfPupils + " rows read.\n\n");
        pupilList = new PUPIL [noOfPupils];
        for (int i = 0; i < noOfPupils; i++)
        {
            pupilList[i] = new PUPIL();
            pupilList[i].readPupilDetails(dataRows[i]);
        }
    }

    public void findmaxData()  {
        // choose position of first value
        int maxDataPosition = 0;

        // repeat for the REST of the array
        for (int i=1; i< noOfPupils; i++) {

            //compare current value with best value
            if (pupilList[i].getpupilmark() > pupilList[maxDataPosition].getpupilmark()) {
                // update the position of the best value
                maxDataPosition = i;
            }
        }

    
        System.out.print("Top Mark:-" + maxDataPosition);
        pupilList[maxDataPosition].displayDetails();
        System.out.println();
    }
}
