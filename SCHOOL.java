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
        countpupilmark();

    }

    private void setUpPupilList() throws IOException
    {
        // first user member
        System.out.println("School: Pupil mark update");
        System.out.println("** Preparing to read data file");
        // read file, fetch data as String array containing the rows
        String[] dataRows = pupilmarkfile.readCSVtable ();
        // calculate the number of member rows, skip headings
        noOfPupils = dataRows.length - 1;
        // update user with number of rows with pupil details
        System.out.println("** " + noOfPupils + " rows read.\n\n");
        pupilList = new PUPIL [noOfPupils];
        for (int i = 0; i < noOfPupils; i++)
        {
            pupilList[i] = new PUPIL();
            pupilList[i].readPupilDetails(dataRows[i=1]);
        }
    }

    public void countpupilmark() throws IOException
    {
        for (int i = 0; i < noOfPupils; i++)
        {
            if (pupilList[i].getpupilmark() > pupilList [maxDataPosition].getpupilmark())
            {
                maxDataPosition = 1;
            }
        }

    
        System.out.print("Top Mark is" + maxDataPosition);
        pupilList[maxDataPosition].displayDetails();
        System.out.println();
    }
}
