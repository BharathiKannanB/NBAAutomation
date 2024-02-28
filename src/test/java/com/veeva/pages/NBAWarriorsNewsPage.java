package com.veeva.pages;

import com.veeva.NBAWarriorsHomePageObjects;
import com.veeva.NBAWarriorsNewsPageObjects;
import com.veeva.utility.WebElementUtility;

import org.openqa.selenium.WebElement;

import java.time.LocalDate;

/**
 * Class containing actions that can be performed on the NBA Warriors News page.
 * Extends GenericKeywords to leverage common web interaction methods.
 */
public class NBAWarriorsNewsPage extends WebElementUtility {

 
    public NBAWarriorsNewsPage(){}

    private final NBAWarriorsNewsPageObjects nbaWarriorsNewsPageObjects = new NBAWarriorsNewsPageObjects();


    public int getAllVideosSize(){
        waitUntilVisible(nbaWarriorsNewsPageObjects.videos_modal);
        return getElements(nbaWarriorsNewsPageObjects.videos_modal).size();
    }


    public int videosPostedInRange(String range){
        int count = 0;
        for (WebElement element : getElements(nbaWarriorsNewsPageObjects.videos_modal)) {
            if (dateCompare(range, dateDifference(formattedDate(getAttributeValue(element.findElement(getByElement(nbaWarriorsNewsPageObjects.datePosted_text)), "datetime"), "EEE MMM dd yyyy"), LocalDate.now())))
                count++;
        }
        return count;
    }


    private boolean dateCompare(String condition, long validateNumber) {
        String[] parts = condition.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        return switch (parts[0]) {
            case ">=" -> validateNumber >= Integer.parseInt(parts[1]);
            case "<=" -> validateNumber <= Integer.parseInt(parts[1]);
            case ">" -> validateNumber > Integer.parseInt(parts[1]);
            case "<" -> validateNumber < Integer.parseInt(parts[1]);
            case "==" -> validateNumber == Integer.parseInt(parts[1]);
            default -> throw new IllegalArgumentException("Invalid operator: " + parts[0]);
        };
    }
}
