package com.veeva.pages;

import com.veeva.locators.NBASixersPageObjects;
import com.veeva.utility.WebElementUtility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/**
 * Page actions class for the NBA Sixers page.
 * This class contains methods to interact with and perform actions on the NBA Sixers page.
 */
public class NBASixersPage extends WebElementUtility {

  
   public NBASixersPage(){}

   private final NBASixersPageObjects nbaSixersPageObjects = new NBASixersPageObjects();

  
   public int totalNumberOfSlides(){
      return getElements(nbaSixersPageObjects.slide_modal).size()-2;
   }


   public void moveToFirstSlide(){
      for(WebElement ele : getElements(nbaSixersPageObjects.slide_modal)){
         if(!ele.getAttribute("aria-label").startsWith("2 /"))
            click(nbaSixersPageObjects.slide_moveLeft_button);
      }
   }


   public void validateTeamTitle(String title, String teamName) {
      for(WebElement element: getElements(nbaSixersPageObjects.slide_modal)){
         List<WebElement> teamNames = element.findElements(getByElement(nbaSixersPageObjects.slide_modal_teamsName_text));
         if(teamNames.size()!= 0 && teamName.equalsIgnoreCase(teamNames.get(0).getText() +" vs "+teamNames.get(1).getText())){
            Assert.assertTrue(element.findElement(getByElement(nbaSixersPageObjects.slide_modal_teamsTitle_text)).getText().equalsIgnoreCase(title));
            break;
         }else click(nbaSixersPageObjects.slide_moveRight_button);
      }
   }


   public void clickWatchReplay(){
      getElement(nbaSixersPageObjects.activeSlide_modal).findElement(getByElement(nbaSixersPageObjects.watchReplay)).click();
   }


   public void clickOnRecap(){
      click(nbaSixersPageObjects.gameRecap_button);
   }


   public void waitTillADGetsOver(){
      waitUntilPresent(nbaSixersPageObjects.advertiser_link, Duration.ofSeconds(20));
      waitUntilInvisible(nbaSixersPageObjects.advertiser_link, Duration.ofMinutes(5));
   }


   public void validateIsVideoPlaying() {
      waitUntilAttributePresent(nbaSixersPageObjects.video, Duration.ofSeconds(30), "data-playback", "playing");
   }
}