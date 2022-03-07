package ru.gb.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.MainPage;

@DisplayName("Добавить рецепт в кулинарную книгу")
public class AddRecipeTest extends BaseTest {

    @Test
    @DisplayName("Добавить в кулинарную книгу")
    @Severity(SeverityLevel.NORMAL)
    public void addRecipeTest(){

        webDriver.get(URL);

        new MainPage(webDriver)
                .getHeader()
                .clickLoginButton()
                .login(login,password)
                .getHeader()
                .chooseMenu()
                .chooseRecipe()
                .addRecipe()
                .checkAddingRecipe();

    }

}
