package com.veeva.locators;

import com.veeva.utility.WebElementUtility;

/**
 * Repository class for object locators of the NBA Warrior News page.
 * This class holds the locators for various elements on the NBA Warrior News page.
 */
public class NBAWarriorsNewsPageObjects {

    public NBAWarriorsNewsPageObjects(){}
    public WebElementUtility videos_modal = new WebElementUtility(Locators.XPATH, "//h3[text()='VIDEOS']/../..//ul[@data-testid='content-grid-']//li", "Videos modal");
    public WebElementUtility datePosted_text = new WebElementUtility(Locators.TAGNAME, "time", "Date/Time video posted");
}
