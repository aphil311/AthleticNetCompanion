//=============================================================================
// ~File Name: Athlete.java
//
// ~Author: Aphillips
//
// ~Purpose: Represents a single athlete. Stores name and times, as well as PR
//=============================================================================

// Imports
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;

public class Athlete{
    // Instance Data
    private final Document doc;           // Full html file
    private final String fileName;        // Name of the file times are written to
    private String name;
    private final Time time1;
    
    //-------------------------------------------------------------------------
    // Constructor -- Wrtites all times to a file stored in the resources
    // folder.
    //-------------------------------------------------------------------------
    public Athlete(String athName, String url) throws IOException{
        // Objects and Variables
        name = athName;
        time1 = new Time();
        // Gets  the html file
        doc = Jsoup.connect(url).get();
        // Gets all elements based on class
        Elements timeLineEs = doc.select("h5:contains(5,000 Meters)").next();
        // Stores thoses elements as a string
        String timeLineS = timeLineEs.toString();
        // Converts that string as a Document class
        Document timeLineD = Jsoup.parse(timeLineS);
        // Stores only text as string variable
        String timeStrings = timeLineD.body().text();
        String temp = "";       // Where times are temporarily stored
        
        // Creates a massive string of all times and stores in a variable
        for(int i = 0; i<timeStrings.length();i++){
            if(timeStrings.charAt(i) == ':'){
               temp+=(""+timeStrings.charAt(i-2)+timeStrings.charAt(i-1)+":"+timeStrings.charAt(i+1)+timeStrings.charAt(i+2)+" ");  
               String temp1=(""+timeStrings.charAt(i-2)+timeStrings.charAt(i-1)+":"+timeStrings.charAt(i+1)+timeStrings.charAt(i+2)+" "); 
               time1.addTime(temp1);
            }
        }
        
        fileName = "resources/"+name.toLowerCase()+".txt";
        writeFile(temp);
    }
    
    // Writes all times to a file in case the computer does not have access to
    // internet. This also allows for easier data management
    private void writeFile(String data){
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            ex.printStackTrace();
        }
    }
    
    // Gets fastest time
    public String getPR(){
        return time1.toString();
    }
    
    // Returns athlete's name
    public String getName(){
        return name;
    }
    
    // This will print out the entire file associated with the current athlete
    public String toString(){
        String line = null;
        String content = "";
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                content+=(line+"\n");
            }
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            ex.printStackTrace();
        }
        
        return name+"\n"+content;
    }
}
