
public class PUPIL
{
    //list of properties
    private String fname;
    private String sname;
    private int pupilmark;

    public PUPIL()
    {
        // initialise instance variables
        fname = "";
        sname = "";
        pupilmark = 0;
      
    }
    // file handling store details from file
    public void readPupilDetails(String dataItems)
    {
        // unpack string of row data into fileds
        String[] rowItems = dataItems.split(",");
        // store each data item as instance property
        fname = rowItems[0];
        sname = rowItems[1];
        pupilmark = Integer.parseInt(rowItems[2]);
    }

    public String writeDetails()
    { 
        // join up data into a string to output as a row
        // use "," to seperate csv columns
        String pupilData = "";
        pupilData = pupilData.concat(fname);
        pupilData = pupilData.concat(",");
        pupilData = pupilData.concat(sname);
        pupilData = pupilData.concat(",");
        pupilData = pupilData.concat(Integer.toString(pupilmark));
        return pupilData;
    }

    public int getpupilmark()
    {
        return pupilmark;
    }

    public void displayDetails()
    {
        // output basic details
        System.out.print(fname +" " + sname);
        System.out.print(" pupil mark is " + pupilmark);
        System.out.println();
    }
}