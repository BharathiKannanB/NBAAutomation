package com.veeva.pages;

import com.veeva.locators.NBAWarriorsHomePageObjects;
import com.veeva.utility.WebElementUtility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.time.Duration;

/**
 * Class containing actions that can be performed on the NBA Warriors Home page.
 * Extends GenericKeywords to leverage common web interaction methods.
 */
public class NBAWarriorsHomePage extends WebElementUtility {

    
    public NBAWarriorsHomePage(){}

    private final NBAWarriorsHomePageObjects nbaWarriorsHomePageObjects = new NBAWarriorsHomePageObjects();


    public void waitForAds(){
        waitUntilVisible(nbaWarriorsHomePageObjects.ads_iframe, Duration.ofSeconds(15));
    }

    public void hoverToMenu(){
        hoverOn(nbaWarriorsHomePageObjects.menu_options);
    }

    public void clickNewsAndFeatures(){
        click(nbaWarriorsHomePageObjects.newsAndFeatures_link);
        Assert.assertTrue(getCurrentUrl().endsWith("/news"));
    }

    public void acceptCookies(){
        click(nbaWarriorsHomePageObjects.accept_cookies_Button, Duration.ofSeconds(25));
    }

    public void clickPreSalesClose(){
        try {
            click(nbaWarriorsHomePageObjects.preSales_Modal_CloseButton);
        } catch (NoSuchElementException | TimeoutException ignored){}
    }

    public void hoverOnShop(){
        hoverOn(nbaWarriorsHomePageObjects.shop_dropdown);
    }

    public void clickOnShopOptions(String category){
        click(nbaWarriorsHomePageObjects.shop_dropdownOption.updateCustomWebElement(
                nbaWarriorsHomePageObjects.shop_dropdownOption.getElement().replace("DropDownCategory",category),
                nbaWarriorsHomePageObjects.shop_dropdownOption.getComment().replace("DropDownCategory",category)));
    }
}
