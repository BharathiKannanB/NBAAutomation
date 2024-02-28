package com.veeva.wrapper;

import com.veeva.utility.WebElementUtility;
import com.veeva.utility.PropertiesUtility;
import com.veeva.utility.ReporterUtilities;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class WrapperMethods {

    private static final PropertiesUtility properties = new PropertiesUtility();
    WebDriver driver = null;
    /* The type of browser to invoke. Can be "Chrome", "Firefox", "Edge"".*/
    public void invokeBrowser(String browser) {
        
        MutableCapabilities  capabilities;
        if(browser.equals("Random")){
            String[] browsers = new String[]{"Chrome", "Firefox", "Edge"};
            browser = browsers[new Random().nextInt(browsers.length)];
        }
        switch (browser) {
            case "Chrome" : {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--start-maximized");
                capabilities = chromeOptions;
                driver = new ChromeDriver((ChromeOptions) capabilities);
            }
            case "Firefox" : {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--start-maximized");
                capabilities = firefoxOptions;
                driver = new FirefoxDriver((FirefoxOptions) capabilities);
            }
            case "Edge" : {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--start-maximized");
                capabilities = edgeOptions;
                driver = new EdgeDriver((EdgeOptions) capabilities);
            }
        }

        ReporterUtilities.log("Launch "+browser);
    }


    public void closeBrowsers() {
        ReporterUtilities.log("Close all browser");
        getDriver().quit();
    }


    public void loadUrl(String url) {
        getDriver().get(url);
        ReporterUtilities.log("load url "+url);
    }


    public WebDriver getDriver(){
        return this.driver;
    }


    public void click(WebElementUtility WebElementUtility) {
        this.click(WebElementUtility,Duration.ofSeconds(5));
    }


    public void click(WebElementUtility WebElementUtility, Duration seconds) {
        waitUntilClickable(WebElementUtility, seconds);
        try{
            getElement(WebElementUtility).click();
            ReporterUtilities.log("Clicked using selenium click on "+WebElementUtility.getComment());
        }catch (ElementClickInterceptedException e1){
            try{
                clickUsingActions(WebElementUtility);
            }catch (ElementClickInterceptedException e2){
                try{
                    clickUsingJSExecutor(WebElementUtility);
                }catch (ElementClickInterceptedException e3){
                    //todo create custom exception and fail the Testcase file
                    ReporterUtilities.log("Clicked using selenium on "+WebElementUtility.getComment());
                }
            }
        }
    }


    public void clickUsingJSExecutor(WebElementUtility WebElementUtility) {
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", getElement(WebElementUtility));
        ReporterUtilities.log("Clicked using JavaScriptExecutor on "+WebElementUtility.getComment());
    }


    public void clickUsingActions(WebElementUtility WebElementUtility) {
        new Actions(getDriver()).moveToElement(getElement(WebElementUtility)).click(getElement(WebElementUtility)).perform();
        ReporterUtilities.log("Clicked using JavaScriptExecutor on "+WebElementUtility.getComment());
    }


    public void enterValue(WebElementUtility WebElementUtility, String textToEnter) {
        waitUntilVisible(WebElementUtility);
        getElement(WebElementUtility).sendKeys(textToEnter);
        ReporterUtilities.log("Entered value "+textToEnter+" in "+WebElementUtility.getComment());
    }


    public WebElement getElement(WebElementUtility WebElementUtility) {
        return WebElementUtility.getWebElement();
    }


    public List<WebElement> getElements(WebElementUtility WebElementUtility) {
        return WebElementUtility.getWebElements();
    }

    public By getByElement(WebElementUtility WebElementUtility) {
        return WebElementUtility.getByElement();
    }


    public void waitUntilClickable(WebElementUtility WebElementUtility) {
        waitUntilPresent(WebElementUtility);
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(getElement(WebElementUtility)));
    }


    public void waitUntilClickable(WebElementUtility WebElementUtility, Duration seconds) {
        waitUntilPresent(WebElementUtility, seconds);
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(getElement(WebElementUtility)));
    }


    public void waitUntilVisible(WebElementUtility WebElementUtility) {
        waitUntilPresent(WebElementUtility);
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(getByElement(WebElementUtility)));
    }


    public void waitUntilVisible(WebElementUtility WebElementUtility, Duration seconds) {
        waitUntilPresent(WebElementUtility, seconds);
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(getByElement(WebElementUtility)));
    }


    public void waitUntilPresent(WebElementUtility WebElementUtility) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(getByElement(WebElementUtility)));
    }

    public void waitUntilPresent(WebElementUtility WebElementUtility, Duration seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(getByElement(WebElementUtility)));
    }

    public void waitUntilInvisible(WebElementUtility WebElementUtility, Duration seconds) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.invisibilityOfElementLocated(getByElement(WebElementUtility)));
    }

    public void waitUntilAttributePresent(WebElementUtility WebElementUtility, Duration seconds,String attribute, String value) {
        new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.domAttributeToBe(WebElementUtility.getWebElement(), attribute, value));
    }


    public void waitUntilURLIsNotEmpty(Duration seconds){
        int count = (int) (seconds.toMillis()/500);
        do{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!getDriver().getCurrentUrl().contains("//") && count-- >= 0);
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public Set<String> getAllWindows(){
        return getDriver().getWindowHandles();
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public String getWindowName(){
        return getDriver().getWindowHandle();
    }

    public void hoverOn(WebElementUtility WebElementUtility){
        new Actions(getDriver()).moveToElement(WebElementUtility.getWebElement()).perform();
        ReporterUtilities.log("Moved to/Hover on "+WebElementUtility.getComment());
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }


    public String getText(WebElement element){
        return element.getText();
    }

    public void switchWindow(String window,String name){
        getDriver().switchTo().window(window);
        ReporterUtilities.log("Switching to window "+name);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }


    public void writeToFile(String content, String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReporterUtilities.log("Writing to a file in "+filePath);
    }


    public LocalDate formattedDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }


    public LocalDate formattedDate(String date) {
        return LocalDate.parse(date);
    }



    public long dateDifference(LocalDate date1, LocalDate date2) {
        return  ChronoUnit.DAYS.between(date1, date2);
    }


    public void generateCSV(String[][] csvData,String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String[] row : csvData) {
                writer.append(String.join(",", row)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReporterUtilities.log("Generated "+fileName);
    }

    public void scrollTo(WebElementUtility WebElementUtility){
     new Actions(getDriver()).scrollToElement(WebElementUtility.getWebElement()).perform();
     ReporterUtilities.log("Scrolling to "+WebElementUtility.getComment());
    }
}