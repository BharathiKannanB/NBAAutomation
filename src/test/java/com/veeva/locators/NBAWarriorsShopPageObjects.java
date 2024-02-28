package com.veeva.locators;

import com.veeva.utility.WebElementUtility;

/**
 * Repository class for object locators of the NBA Warrior Shop page.
 * This class holds the locators for various elements on the NBA Warrior Shop page.
 */
public class NBAWarriorsShopPageObjects {

    public NBAWarriorsShopPageObjects(){}
    public WebElementUtility productName_radioButton = new WebElementUtility(Locators.XPATH, "//div[@data-trk-id='all-departments']//ul//span[text()='ProductName']", "ProductName product type");
    public WebElementUtility yourSelection_list = new WebElementUtility(Locators.XPATH, "//ul[@data-trk-id = 'remove-filter']//span[text()='ProductName']", "Your Selection - ProductName");
    public WebElementUtility eachProduct_element = new WebElementUtility(Locators.CLASSNAME, "column", "Product element");
    public WebElementUtility eachProductCost_text = new WebElementUtility(Locators.CLASSNAME, "sr-only", "Product amount");
    public WebElementUtility eachProductTitle_text = new WebElementUtility(Locators.CLASSNAME, "product-card-title", "Product Title");
    public WebElementUtility eachProductTopSellerMessage_text = new WebElementUtility(Locators.CLASSNAME, "top-seller-vibrancy-message", "Top seller message");
    public WebElementUtility nextPage_button = new WebElementUtility(Locators.XPATH, "//li[@class='next-page']", "Next page pagination");
}