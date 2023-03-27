package Artnow.Tests;

import Artnow.Pages.*;
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
        SceneryPage sceneryPage = new SceneryPage(chromeDriver);
        sceneryPage.checkWay("Трамвайный путь");
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
        //перейти в детали картины "Трамвайный путь"
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
        BatikPage batikPage = new BatikPage(chromeDriver);
        //получить название картины, добавляемой в избранное
        String name = batikPage.getSrcOfFavoritePicture();
        //добавить первую картинку в "Избранное"
        batikPage.addToFavorite();
        //перейти в "Избранное"
        batikPage.goToFavorite();
        FavoritePage favoritePage = new FavoritePage(chromeDriver);
        //проверить, что картина с полученным названием сохранилась в избранном
        favoritePage.reviewFavorite(name);
    }

    //2.4
    @Test
    public void testSearch () {
        HomePage homePage=new HomePage(chromeDriver);
        //открыть сайт
        homePage.openSite();
        String s = "Жираф";
        //заполнить поисковую строку словом "Жираф"
        homePage.SearchPictures(s);
        SearchPage searchPage = new SearchPage(chromeDriver);
        //проверить, что название первой картины содержит слово "Жираф"
        searchPage.checkContainsFirstPictureInputName(s);

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
        JewerlyArtPage jewerlyArtPage = new JewerlyArtPage(chromeDriver);
        //получить src первого изделия
        String src = jewerlyArtPage.getSrcOfFirstProduct();
        //получить стоимость первого изделия
        String cost = jewerlyArtPage.getCostOfFirstProduct();
        //добавить первое изделие в корзину
        jewerlyArtPage.addToBacket();
        //перейти в корзину
        jewerlyArtPage.goToBacket();
        BasketPage basketPage = new BasketPage(chromeDriver);
        //проверить, что товар есть в корзине и его стоимость совпадает
        basketPage.reviewBasket(src, cost);



    }
}
