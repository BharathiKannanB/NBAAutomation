package com.veeva.stepDefinition;


import com.veeva.pages.NBAWarriorsHomePage;
import com.veeva.utility.ReporterUtilities;
import com.veeva.utility.WebElementUtility;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.model.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

/**
 * Step definitions for scenarios dealing with the NBA Warriors Home page.
 * This class defines steps for various actions like opening URLs, accepting cookies,
 * navigating to specific sections, and handling post-scenario activities.
 */
public class NBAWarriorsHomePageStepDefinition extends WebElementUtility {

    private final NBAWarriorsHomePage nbaWarriorsHomePageActions = new NBAWarriorsHomePage();

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()) {
            ReporterUtilities.updateTestStatus(Status.FAILED);
        } else {
            ReporterUtilities.updateTestStatus(Status.PASSED);
        }
        closeBrowsers();
    }


    @Given("Open {string} and load {string} URL")
    public void loadNBAURL(String browser, String productName){
        invokeBrowser(browser);
        if ("NBA Warrior".equals(productName)) {
            loadUrl(getProperty("warriorUrl"));
        } else if("NBA Bulls".equals(productName)) {
            loadUrl(getProperty("bullsURL"));
        }else if("NBA Sixers".equals(productName)) {
            loadUrl(getProperty("sixersURL"));
        }
    }

    @Given("Open {string}")
    public void loadNBAURL(String browser) throws InterruptedException {
        invokeBrowser(browser);
        Thread.sleep(10000);
    }

    @When("Page is Loaded")
    public void pageIsLoaded() {
        nbaWarriorsHomePageActions.acceptCookies();
        try {
            nbaWarriorsHomePageActions.waitForAds();
        } catch (TimeoutException | NoSuchElementException ignored){}
    }


    @Then("Navigate to {string} shop now")
    public void navigateToCategoryShopNow(String category) {
        nbaWarriorsHomePageActions.hoverOnShop();
        nbaWarriorsHomePageActions.clickOnShopOptions(category);
    }

    @Then("Navigate to menu and to {string}")
    public void navigateToMenuAndToNewsAndFeatures(String menu) {
        nbaWarriorsHomePageActions.hoverToMenu();
        if(menu.equals("News and Features")) {
            nbaWarriorsHomePageActions.clickNewsAndFeatures();
        }
    }
}
