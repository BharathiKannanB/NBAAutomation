package com.veeva.locators;

import com.veeva.utility.WebElementUtility;

/**
 * Repository class for object locators of the NBA Warrior Home page.
 * This class holds the locators for various elements on the NBA Warrior Home page.
 */
public class NBAWarriorsHomePageObjects {

    public NBAWarriorsHomePageObjects(){}

    public WebElementUtility preSales_Modal_CloseButton = new WebElementUtility(Locators.XPATH, "//div[text()='x']", "Pre-Sales modal close button");
    public WebElementUtility accept_cookies_Button = new WebElementUtility(Locators.ID, "onetrust-accept-btn-handler", "Accept Cookies button");
    public WebElementUtility shop_dropdown = new WebElementUtility(Locators.XPATH, "//span[text()='Shop']", "Shop Dropdown");
    public WebElementUtility shop_dropdownOption = new WebElementUtility(Locators.LINKTEXT, "DropDownCategory", "Dropdown option - DropDownCategory");
    public WebElementUtility ads_iframe = new WebElementUtility(Locators.XPATH, "//iframe[@title='3rd party ad content']", "ADs iframe");
    public WebElementUtility menu_options = new WebElementUtility(Locators.XPATH, "//ul[@role='menubar']//span[text()='...']", "Menu options");
    public WebElementUtility newsAndFeatures_link = new WebElementUtility(Locators.LINKTEXT, "News & Features", "Option - News & Features");
}
