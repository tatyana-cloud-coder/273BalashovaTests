package Artnow.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SceneryPage {

    WebDriver driver;
    private WebDriverWait wait;

    public SceneryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath = "//img[@alt= 'Трамвайный путь. Гвоздецкая Татьяна']")
  //  @FindBy(xpath = "//div[contains(string(),'Трамвайный путь') and @class='post']/a")
    private WebElement Way;
    private List<WebElement> Scenaries;






    public void goToDetailsWay () {
        wait.until(ExpectedConditions.visibilityOf(Way));
        Way.click();
    }

    public void checkWay (String s) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@itemprop='name']")));

        Boolean factResult = false;
        List <WebElement> sceneries = driver.findElements(By.xpath("//div[@itemprop='name']"));
        for (WebElement scenery: sceneries) {
            System.out.println(scenery.getText());
            if (scenery.getText().contains(s)) {
                factResult = true;
                break;
            }
        }
        Assert.assertEquals(true, factResult);

    }
}
