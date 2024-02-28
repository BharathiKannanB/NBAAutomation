package com.veeva.utility;

import com.veeva.wrapper.WrapperMethods;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementUtility {
	
	public enum Locators {
	    ID,
	    CLASSNAME,
	    TAGNAME,
	    LINKTEXT,
	    XPATH,
	    CSS
	}


	 Locators locatorType;
	    String element;
	    String comment;

	    public WebElementUtility(){
	        this.locatorType = locatorType;
	        this.element = element;
	        this.comment = comment;
	    }


	    public WebElementUtility updateCustomWebElement(String element, String comment){
	        this.element = element.isEmpty() ? this.element : element;
	        this.comment = comment.isEmpty() ? this.comment : comment;
	        return this;
	    }

	    public String getElement() {
	        return this.element;
	    }

	    private WebElement webElement;
	    private By byElement;


	    public WebElement getWebElement() {
	        return generateWebElement();
	    }

	    public List<WebElement> getWebElements() {
	        return generateWebElements();
	    }

	    public String getComment() {
	        return this.comment;
	    }

	    public WebElement reloadWebElement(){
	        return generateWebElement();
	    }

	    private WebElement generateWebElement(){
	        return new WrapperMethods().getDriver().findElement(setByElement());
	    }

	    /**
	     * Generates a list of WebElements based on the current locator.
	     *
	     * @return The list of generated WebElements.
	     */
	    private List<WebElement> generateWebElements(){
	        return new WrapperMethods().getDriver().findElements(setByElement());
	    }

	    public By getByElement(){
	        return byElement == null ? setByElement() : byElement;
	    }

	    /**
	     * Sets the By element based on the current locator type and value.
	     *
	     * @return The By element for the locator.
	     */
	    private By setByElement(){
	        return  switch (locatorType){
	            case ID -> By.id(element);
	            case XPATH -> By.xpath(element);
	            case CLASSNAME -> By.className(element);
	            case CSS -> By.cssSelector(element);
	            case TAGNAME -> By.tagName(element);
	            case LINKTEXT-> By.linkText(element);
	        };
	    }
}
