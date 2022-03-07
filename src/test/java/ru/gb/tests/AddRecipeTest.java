package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.gb.config.TestConfig;
import ru.gb.extensions.SelenideExtension;
import ru.gb.pages.MainPage;
import static com.codeborne.selenide.Selenide.page;

@DisplayName("Добавить в кулинарную книгу")
@ExtendWith({SelenideExtension.class})
public class AddRecipeTest {

    @Test
    @DisplayName("Добавить в кулинарную книгу")
    public void addRecipeTest(){

        page(MainPage.class)
                .getHeader()
                .clickLoginButton()
                .login(TestConfig.testConfig.login(),TestConfig.testConfig.password())
                .getHeader()
                .chooseMenu()
                .chooseRecipe()
                .addRecipe()
                .checkAddingRecipe();
    }

}
