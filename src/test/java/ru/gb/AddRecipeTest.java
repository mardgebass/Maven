package ru.gb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AddRecipeTest extends BaseTest {

    @Test
    @DisplayName("Добавить в кулинарную книгу")
    public void addRecipeTest(){

    webDriver.findElement(By.xpath(".//span[@id='js-new-header__top-nav']")).click();

    By menuLocator = By.id("mCSB_1_container");
    WebElement menu = webDriver.findElement(menuLocator);

        menu.findElement(By.xpath(".//a[contains(text(),'РЕЦЕПТЫ')]")).click();

        List<WebElement> products = webDriver.findElements(By.xpath(".//article[contains(@class, 'block-anons col-sm-6 col-md-3')]"));
        products.get(1).click();

        webDriver.findElement(By.xpath(".//a[contains(@class, 'controller-add__cover-link')]")).click();

        assertThat(webDriver.findElement(By.xpath(".//div[contains(@class, 'js-controller-add_active controller-add_active')]")));

        webDriver.findElement(By.xpath(".//a[contains(@class, 'controller-add__cover-link')]")).click();

    }

}
