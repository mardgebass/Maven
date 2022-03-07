package ru.gb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecipePage extends BasePage{


    public RecipePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Клик на кнопку добавления рецепта")
    public RecipePage addRecipe(){
    webDriver.findElement(By.xpath(".//a[contains(@class, 'controller-add__cover-link')]")).click();
    return this;
    }

    @Step("Клик на кнопку удаления рецепта")
    public RecipePage checkAddingRecipe(){
    new WebDriverWait(webDriver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'js-controller-add_active controller-add_active')]")));

        webDriver.findElement(By.xpath(".//a[contains(@class, 'controller-add__cover-link')]")).click();
        return this;
    }
}
