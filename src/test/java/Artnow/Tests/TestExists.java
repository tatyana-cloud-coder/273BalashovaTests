package Artnow.Tests;

import Artnow.Pages.EmbroideredPicturesPage;
import Artnow.Pages.HomePage;
import Artnow.Pages.SceneryPage;
import Artnow.Settings.WebDriverSettings;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;


public class TestExists extends WebDriverSettings {

    //2.1
    @Test
    public void testExists () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Вышитые картины"
        homePage.goToEmbroideredPictures();
        EmbroideredPicturesPage embroideredPicturesPage = new EmbroideredPicturesPage(chromeDriver);
        //выбрать "Городской пейзаж"
        embroideredPicturesPage.checkCityShape();
        //нажать на "Применить"
        embroideredPicturesPage.clickOnApplyButton();
   //     SceneryPage sceneryPage = new SceneryPage(chromeDriver);
      //  sceneryPage.checkWay("Трамвайный путь");
    }

    //2.2
    @Test
    public void testStyle () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Вышитые картины"
        homePage.goToEmbroideredPictures();
        EmbroideredPicturesPage embroideredPicturesPage = new EmbroideredPicturesPage(chromeDriver);
        //выбрать "Городской пейзаж"
        embroideredPicturesPage.checkCityShape();
        //нажать на "Применить"
        embroideredPicturesPage.clickOnApplyButton();
        SceneryPage sceneryPage = new SceneryPage(chromeDriver);
        sceneryPage.goToDetailsWay();

    }

    //2.3
    @Test
    public void testFavorites () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Батик"
        homePage.goToBatik();
    }

    //2.4
    @Test
    public void testSearch () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        //заполнить поисковую строку словом "Жираф"
        homePage.SearchPictures("жираф");
    }

    //2.5
    @Test
    public void testBasket () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Ювелирное искусство"
        homePage.goToJewelryArt();
    }
}
