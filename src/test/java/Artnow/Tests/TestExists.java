package Artnow.Tests;

import Artnow.Pages.*;
import Artnow.Settings.WebDriverSettings;
import io.qameta.allure.Description;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestExists extends WebDriverSettings {

    @Test
    @Description("2.1 Перейти в “Вышитые картины”, произвести поиск по жанру \n" +
            "«Городской пейзаж», проверить, что картина “Трамвайный путь” \n" +
            "присутствует в выдаче.")
    public void testExists () {
        HomePage homePage=new HomePage(webDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Вышитые картины"
        homePage.goToEmbroideredPictures();
        EmbroideredPicturesPage embroideredPicturesPage = new EmbroideredPicturesPage(webDriver);
        //выбрать "Городской пейзаж"
        embroideredPicturesPage.checkCityShape();
        //нажать на "Применить"
        embroideredPicturesPage.clickOnApplyButton();
        SceneryPage sceneryPage = new SceneryPage(webDriver);
        sceneryPage.checkWay("Трамвайный путь");
    }

    @Test
    @Description("2.2 Перейти в “Вышитые картины”, произвести поиск по жанру \n" +
            "«Городской пейзаж», открыть подробности картины “Трамвайный путь”, \n" +
            "проверить, что стиль картины «Реализм».")
    public void testStyle () {
        HomePage homePage=new HomePage(webDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Вышитые картины"
        homePage.goToEmbroideredPictures();
        EmbroideredPicturesPage embroideredPicturesPage = new EmbroideredPicturesPage(webDriver);
        //выбрать "Городской пейзаж"
        embroideredPicturesPage.checkCityShape();
        //нажать на "Применить"
        embroideredPicturesPage.clickOnApplyButton();
        SceneryPage sceneryPage = new SceneryPage(webDriver);
        //перейти в детали картины "Трамвайный путь"
        sceneryPage.goToDetailsWay();
        DetailsWayPage detailsWayPage=  new DetailsWayPage(webDriver);
        detailsWayPage.checkStyle("Реализм2");


    }

    //
    @Test
    @Description("2.3. Перейти в “Батик”, добавить первую картину в избранное, проверить, \n" +
            "что выбранная картина сохранилась в разделе «Избранное».")
    public void testFavorites () {
        HomePage homePage=new HomePage(webDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Батик"
        homePage.goToBatik();
        BatikPage batikPage = new BatikPage(webDriver);
        //получить название картины, добавляемой в избранное
        String name = batikPage.getSrcOfFavoritePicture();
        //добавить первую картинку в "Избранное"
        batikPage.addToFavorite();
        //перейти в "Избранное"
        batikPage.goToFavorite();
        FavoritePage favoritePage = new FavoritePage(webDriver);
        //проверить, что картина с полученным названием сохранилась в избранном
        favoritePage.reviewFavorite(name);
    }

    @Test
    @Description("2.4 Ввести в поисковую строку «Жираф», проверить, что название первой \n" +
            "картины содержит слово «Жираф».")
    public void testSearch () {
        HomePage homePage=new HomePage(webDriver);
        //открыть сайт
        homePage.openSite();
        String s = "Жираф";
        //заполнить поисковую строку словом "Жираф"
        homePage.SearchPictures(s);
        SearchPage searchPage = new SearchPage(webDriver);
        //проверить, что название первой картины содержит слово "Жираф"
        searchPage.checkContainsFirstPictureInputName(s);

    }

    @Parameters("number")
    @Test
    @Description("2.5 Перейти в “Ювелирное искусство”, добавить первое изделие в \n" +
            "корзину, проверить, что выбранный товар находится в корзине, стоимость \n" +
            "товара не изменилась")
    public void testBasket (@Optional int number) {
        HomePage homePage=new HomePage(webDriver);
        //открыть сайт
        homePage.openSite();
        //нажать на кнопку "Показать еще"
        homePage.clickOnShowMore();
        //перейти в "Ювелирное искусство"
        homePage.goToJewelryArt();
        JewerlyArtPage jewerlyArtPage = new JewerlyArtPage(webDriver);
        //получить src первого изделия
        String src = jewerlyArtPage.getSrcOfFirstProduct(number);
        //получить стоимость первого изделия
        String cost = jewerlyArtPage.getCostOfFirstProduct(number);
        //добавить первое изделие в корзину
        jewerlyArtPage.addToBacket(number);
        //перейти в корзину
        jewerlyArtPage.goToBacket();
        BasketPage basketPage = new BasketPage(webDriver);
        //проверить, что товар есть в корзине и его стоимость совпадает
        basketPage.reviewBasket(src, cost);

    }
}
