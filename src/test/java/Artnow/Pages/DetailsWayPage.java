package Artnow.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DetailsWayPage {
    WebDriver driver;
    private WebDriverWait wait;

    public DetailsWayPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[span[contains(string(),'Стиль: ')]]/a")
    private WebElement stylePicture;


    public void checkStyle(String style) {
        String txt = stylePicture.getText();
        Boolean factResult =  txt.equals(style);
        Assert.assertTrue(factResult);
    }

}

