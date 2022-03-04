package ru.gb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.gb.config.TestConfig;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header{

    public LoginPage clickLoginButton(){

        $x(".//span[contains(text(),'Вход')]").click();
        return new LoginPage();

    }

    public MainPage logout() {

        $(By.cssSelector(".new-user-panel__avatar_mobile-no")).click();
        $(By.linkText("Выход")).click();
        return new MainPage();

    }

    public MainPage checkLogin(){

        $x(".//span[contains(@class, 'new-user-panel__name_with-shadow')]")
        .shouldBe(Condition.visible.because("Должен появиться элемент никнейма"), Duration.ofSeconds(5));
        return new MainPage();

    }

    public MainPage checkLogout() {

        $x(".//span[contains(text(),'Вход')]")
                .shouldBe(Condition.visible.because("Должен появиться элемент входа"), Duration.ofSeconds(5));
        return new MainPage();
    }


    public AllRecipesPage chooseMenu(){

        $x(".//span[@id='js-new-header__top-nav']").click();
        By menuLocator = By.id("mCSB_1_container");
        WebElement menu = $(menuLocator);
        ((SelenideElement) menu).$x(".//a[contains(text(),'РЕЦЕПТЫ')]").click();
        return new AllRecipesPage();

    }

    public SearchPage search(String searchRequest){
        $x(".//input[@id='js-search-input']").sendKeys(searchRequest);
        $x(".//input[contains(@class,'new-header__search-submit')]").click();
        return new SearchPage();
    }



}
