package com.veeva.stepDefinition;


import com.veeva.pages.NBASixersPage;
import com.veeva.utility.ReporterUtilities;
import io.cucumber.java.en.Then;

/**
 * Step definition class for the NBA Sixers page.
 * This class contains step definitions for various scenarios related to the NBA Sixers page.
 */
public class NBASixersPageStepDefinition {



    private final NBASixersPage nbaSixersPageActions = new NBASixersPage();

    @Then("Collect total number of slides")
    public void collectTotalNumberOfSlides() {
        ReporterUtilities.log("Total number of slides : " + nbaSixersPageActions.totalNumberOfSlides());
    }

    @Then("Validate title {string} for team {string}")
    public void validateTitle(String title, String teamName) {
        nbaSixersPageActions.moveToFirstSlide();
        nbaSixersPageActions.validateTeamTitle(title, teamName);
    }

    @Then("Click WatchReplay")
    public void clickWatchReplay() {
        nbaSixersPageActions.clickWatchReplay();
    }

    @Then("Click Game Recap")
    public void clickGameRecap() {
        nbaSixersPageActions.clickOnRecap();
    }

    @Then("Wait till AD gets over")
    public void waitTillADGetsOver() {
        nbaSixersPageActions.waitTillADGetsOver();
    }

    @Then("Validate video is playing")
    public void validateProgressBar() {
        nbaSixersPageActions.validateIsVideoPlaying();
    }
}
