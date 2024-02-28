package com.veeva.locators;

import com.veeva.utility.WebElementUtility;


/**
 * Repository class for object locators of the NBA Sixers page.
 * This class holds the locators for various elements on the NBA Sixers page.
 */
public class NBASixersPageObjects {

    public NBASixersPageObjects(){}


    public WebElementUtility slide_modal = new WebElementUtility(Locators.XPATH, "//div[contains(@class, 'swiper-slide-active')]/../div", "Slide modal");
    public WebElementUtility activeSlide_modal = new WebElementUtility(Locators.XPATH, "//div[contains(@class, 'swiper-slide-active')]", "Active Slide modal");
    public WebElementUtility slide_modal_teamsName_text = new WebElementUtility(Locators.XPATH, ".//img/following-sibling::span", "Slide modal team's name");
    public WebElementUtility slide_modal_teamsTitle_text = new WebElementUtility(Locators.XPATH, ".//div[contains(@class,'Game_gameHeader')]", "Slide modal team's title");
    public WebElementUtility slide_moveRight_button = new WebElementUtility(Locators.XPATH, "//button[@aria-label='Move right']", "Move Right button");
    public WebElementUtility watchReplay = new WebElementUtility(Locators.XPATH, ".//a", "Watch replay button");
    public WebElementUtility gameRecap_button = new WebElementUtility(Locators.XPATH, "//button[text()='Game Recap']", "Game recap button");
    public WebElementUtility video = new WebElementUtility(Locators.XPATH, "//video[@class]", "video");
    public WebElementUtility advertiser_link = new WebElementUtility(Locators.LINKTEXT, "Visit advertiser", "AD");
}
