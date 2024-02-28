package com.veeva.stepDefinition;


import io.cucumber.java.en.Then;
import org.testng.Assert;

import com.veeva.pages.NBAWarriorsShopPage;
import com.veeva.utility.WebElementUtility;

import java.time.Duration;
import java.util.Set;

/**
 * Step definitions for Cucumber scenarios targeting the NBA Warriors Shop page.
 * This class provides the steps to select products, navigate between windows, and collect product data.
 */
public class NBAWarriorsShopPageStepDefinition extends WebElementUtility {


    private final NBAWarriorsShopPage nbaWarriorsShopPageActions = new NBAWarriorsShopPage();

    @Then("Select {string} product")
    public void selectProduct(String productType) {
        nbaWarriorsShopPageActions.selectProduct(productType);
        nbaWarriorsShopPageActions.validateSelectedProducts(productType);
    }


    @Then("Navigate to newly opened window from {string}")
    public void navigateToNewlyOpenedWindow(String name) {
        Set<String> getAllWindow = getAllWindows();
        getAllWindow.remove(getWindowName());
        switchWindow(getAllWindow.iterator().next(), name.equals("Warrior") ? "Shop tab" : "Match tab");
        waitUntilURLIsNotEmpty(Duration.ofSeconds(30));
        Assert.assertTrue(name.equals("Warrior") ? getCurrentUrl().startsWith("https://shop.warriors.com/") : getCurrentUrl().endsWith("watch"));
    }

    @Then("Collect data for {string} {string} in {string}")
    public void collectDataOfEachProduct(String category, String productType, String browser) {
        String filePath = category + " " + productType + " product details in " + browser + ".txt";
        nbaWarriorsShopPageActions.getAllProductData(filePath);
        nbaWarriorsShopPageActions.attachToReport(filePath);
    }
}