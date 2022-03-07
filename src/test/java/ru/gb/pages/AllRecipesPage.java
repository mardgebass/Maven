package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllRecipesPage extends BasePage{


    public AllRecipesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Выбрать рецепт")
    public RecipePage chooseRecipe(){
    List<WebElement> products = webDriver.findElements(By.xpath(".//article[contains(@class, 'block-anons col-sm-6 col-md-3')]"));
        products.get(1).click();
        return new RecipePage(webDriver);
    }
}
