package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class TakeScreenShot {
    public static String reportDir = "target" + File.separator + "screenshots";

    public static String getScreenShot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String sDate = sdf.format(date);
        FileUtils.copyFile(src, new File(reportDir + File.separator + "image_" + sDate + ".png"));
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        String screen = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        return screen;
    }
}
