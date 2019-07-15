//=============================================================================
// ~File Name: AthleticStats.java
//
// ~Author: APhillips
//
// ~Purpose: Scrapes html from Athletic.net and stores all times run by an 
//           athlete into a .txt file. Prints their name and personal record.
//=============================================================================

// Imports
import java.io.*;

public class AthleticStats {
    public static void main(String[] args) throws IOException{
        // Athletes on Dominican's cross country team
        Athlete athlete1 = new Athlete("Aidan", "https://www.athletic.net/CrossCountry/Athlete.aspx?AID=12206710#!/L0");
        Athlete athlete2 = new Athlete("Myles", "https://www.athletic.net/CrossCountry/Athlete.aspx?AID=13975847#!/L0");
        Athlete athlete3 = new Athlete("Kenny", "https://www.athletic.net/CrossCountry/Athlete.aspx?AID=10428082#!/L0");
        Athlete athlete4 = new Athlete("Catherine", "https://www.athletic.net/CrossCountry/Athlete.aspx?AID=8654385#!/L0");
        Athlete[] dominican = {athlete1, athlete2, athlete3, athlete4};
        
        // Iterates through the team and prints name and fastest time
        for(int i=0;  i<dominican.length; i++){
            System.out.println(dominican[i].getName().substring(0, 5)+"\t"+dominican[i].getPR());
        }
    }
}
