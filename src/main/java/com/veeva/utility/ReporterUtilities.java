package com.veeva.utility;

import com.veeva.utility.WebElementUtility;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.model.Status;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class provides methods for logging messages, updating test statuses, and attaching files to Allure reports.
 */
public class ReporterUtilities {

    private static final Logger logger = LoggerUtility.getLogger(ReporterUtilities.class);


    public ReporterUtilities(){    }


    public static void log(String comment){
        Allure.step(comment);
        logger.log(Level.INFO, comment);
    }


    public static void updateTestStatus(Status status){
        Allure.addAttachment("Page Screenshot", "image/png", new ByteArrayInputStream(new WebElementUtility().takeScreenshot()), ".png");
        if(status == Status.PASSED) {
            logger.log(Level.INFO,"Testcase Passed");
        } else {
            logger.log(Level.ERROR,"Testcase " + status);
        }
        Allure.step("Test Case " + status.value(), status);
    }


    public static void attachFileToAllureReport(String filePath, String attachmentName) {
        try {
            Path content = Paths.get(filePath);
            Allure.addAttachment(attachmentName, Files.newInputStream(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
