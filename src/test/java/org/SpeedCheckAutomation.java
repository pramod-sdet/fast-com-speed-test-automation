package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpeedCheckAutomation {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver wd = new ChromeDriver(options);
        wd.get("https://fast.com/");
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30L));

        By speedValueLocator = By.id("speed-value");
        By speedUnitsLocator = By.id("speed-units");

        String className;

        while (true) {

            WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
            WebElement speedUnitsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitsLocator));

            System.out.println(speedValueElement.getText() + " " + speedUnitsElement.getText());

            className = speedValueElement.getAttribute("class");

            if (className != null && className.contains("succeeded")) {

                break;
            }
        }

        WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
        WebElement speedUnitsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitsLocator));

        System.out.println("--------------------- Final Value ----------------------------");
        System.out.println("Final value of speed test is: " + speedValueElement.getText() + " " + speedUnitsElement.getText());


    }
}
