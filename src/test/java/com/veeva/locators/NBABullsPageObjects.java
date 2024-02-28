package com.veeva.locators;


import com.veeva.utility.WebElementUtility;

/**
 * Repository class for object locators of the NBA Bulls page.
 * This class holds the locators for various elements on the NBA Bulls page.
 */
public class NBABullsPageObjects {


    public NBABullsPageObjects(){}


    public WebElementUtility footer_title = new WebElementUtility(Locators.XPATH, "//footer//h2", "Footer title");
    public WebElementUtility footer_link = new WebElementUtility(Locators.XPATH, "following-sibling::ul//a", "Hyperlink for each footer list");
}
