package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.norefactoring.BaseTest;
import ru.gb.pages.MainPage;

public class AddRecipeTest extends BaseTest {

    @Test
    @DisplayName("Добавить в кулинарную книгу")
    public void addRecipeTest(){

        webDriver.get(URL);

        new MainPage(webDriver)
                .getHeader()
                .chooseMenu()
                .chooseRecipe()
                .addRecipe()
                .checkAddingRecipe();

    }

}
