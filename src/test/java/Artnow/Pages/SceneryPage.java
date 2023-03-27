package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SceneryPage {

    WebDriver driver;
    private WebDriverWait wait;

    public SceneryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//div[@class='post']")
    private WebElement sceneries;

    @FindBy(xpath = "//div[contains(string(),'Трамвайный путь') and @class='post']/a")
    private WebElement Way;




  /*  public void checkWay (String s) {
        for (WebElement item :
             sceneries) {
 //подумать как вернуть коллекцию
            
        }
        Assert.assertEquals(s, Way.getText());
        System.out.print("Ок");
    } */

    public void goToDetailsWay () {
        Way.click();
    }
}
