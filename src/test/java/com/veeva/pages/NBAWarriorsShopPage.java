package com.veeva.pages;

import com.veeva.locators.NBAWarriorsShopPageObjects;
import com.veeva.utility.ReporterUtilities;
import com.veeva.utility.WebElementUtility;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Class containing actions that can be performed on the NBA Warriors Shop page.
 * Extends GenericKeywords to leverage common web interaction methods.
 */
public class NBAWarriorsShopPage extends WebElementUtility {

    public NBAWarriorsShopPage(){}

    private final NBAWarriorsShopPageObjects nbaWarriorsShopPageObjects = new NBAWarriorsShopPageObjects();

    public void selectProduct(String product) {
        click(nbaWarriorsShopPageObjects.productName_radioButton.updateCustomWebElement(
                nbaWarriorsShopPageObjects.productName_radioButton.getElement().replace("ProductName", product),
                nbaWarriorsShopPageObjects.productName_radioButton.getComment().replace("ProductName", product)));
    }

    public void validateSelectedProducts(String product) {
        Assert.assertNotNull(getElement(nbaWarriorsShopPageObjects.yourSelection_list.updateCustomWebElement(
                nbaWarriorsShopPageObjects.yourSelection_list.getElement().replace("ProductName", product),
                nbaWarriorsShopPageObjects.yourSelection_list.getComment().replace("ProductName", product))));
    }

    public void getAllProductData(String filePathWithName){
        StringBuilder builder = new StringBuilder();
        builder.append("Price, Title, Top Seller Comments \n");
        builder.append("Price, Title, Top Seller Comments \n");
        while(true){
            for(WebElement getElement: getElements(nbaWarriorsShopPageObjects.eachProduct_element)){
                builder.append(getElement.findElement(nbaWarriorsShopPageObjects.eachProductCost_text.getByElement()).getText());
                builder.append(",");
                builder.append(getElement.findElement(nbaWarriorsShopPageObjects.eachProductTitle_text.getByElement()).getText());
                builder.append(",");
                try{
                    builder.append(getElement.findElement(nbaWarriorsShopPageObjects.eachProductTopSellerMessage_text.getByElement()).getText());
                    builder.append(",");
                }catch (TimeoutException | NoSuchElementException ignored){}
                builder.append("\n");
            }
            try{
                click(nbaWarriorsShopPageObjects.nextPage_button);
            }catch (TimeoutException | NoSuchElementException exception){
                break;
            }
        }
        writeToFile(builder.toString(), filePathWithName);
    }

    public void attachToReport(String path){
        ReporterUtilities.attachFileToAllureReport(path, path);
    }
}
