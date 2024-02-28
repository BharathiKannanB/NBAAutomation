package com.veeva.stepDefinition;


import com.veeva.pages.NBAWarriorsNewsPageActions;
import com.veeva.utility.ReporterUtilities;
import io.cucumber.java.en.Then;

/**
 * Step definitions for scenarios dealing with the NBA Warriors News page.
 * This class defines steps for counting videos and determining the number of videos posted within a certain time range.
 */
public class NBAWarriorsNewsPageStepDefinition {


    private final NBAWarriorsNewsPageActions nbaWarriorsNewsPageActions = new NBAWarriorsNewsPageActions();


    @Then("Count overAll videos")
    public void countAllVideos(){
        int videoCount = nbaWarriorsNewsPageActions.getAllVideosSize();
        ReporterUtilities.log("Overall videos posted: " + videoCount);
    }
    
    @Then("Count videos {string} days")
    public void countVideosInRange(String numberOfDays){
        int videoCount = nbaWarriorsNewsPageActions.videosPostedInRange(numberOfDays);
        ReporterUtilities.log("Videos posted in " + numberOfDays + " days: " + videoCount);
    }
}
