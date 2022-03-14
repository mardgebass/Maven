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
    List<WebElement> products = webDriver.findElements(By.xpath(".//a[contains(@class, 'block-anons__title-link')]"));
        products.get(1).click();
        return new RecipePage(webDriver);
    }
}
