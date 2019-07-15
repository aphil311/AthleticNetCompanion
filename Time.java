//=============================================================================
// ~File Name: Time.java
//
// ~Author: APhillips
//
// ~Purpose: Acts as a handler for new times found on Athletic.net
//=============================================================================

public class Time {
    // Variables
    private String fastestTime = "99:99";   // Temporary max value
    private String currentTime;
    private int fastestMin;
    private int fastestSec;
    private int currentMin;
    private int currentSec;
    final static double FIVE_K=3.1;     // Makes life easier
    
    public Time(){
        fastestMin = Integer.parseInt(fastestTime.substring(0, 2));
        fastestSec = Integer.parseInt(fastestTime.substring(3, 5));
    }
    
    /* Each time a new time is found on Athletic.net, it is checked to see if 
        it is a faster time than the others.
    */
    public void addTime(String time){
        currentTime = time;
        currentMin = Integer.parseInt(currentTime.substring(0, 2));
        currentSec = Integer.parseInt(currentTime.substring(3, 5));
        
        if(currentMin<fastestMin){
            updateTime();
        }
        if(currentMin==fastestMin){
            if(currentSec<fastestSec)
                updateTime();
        }
    }
    
    // Helper method to set variables when a better time is found
    private void updateTime(){
        fastestTime = currentTime;
        currentTime = null;
        fastestMin = currentMin;
        currentTime = null;
        fastestSec = currentSec;
        currentTime = null;
    }
    
    /*  Overrides toString to print fastest time. Used in Athlete class to get
        individual PRs
    */
    public String toString(){
        return fastestTime;
    }
}
