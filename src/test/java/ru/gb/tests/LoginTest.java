package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.gb.extensions.SelenideExtension;
import ru.gb.pages.LoginPage;
import ru.gb.pages.MainPage;
import static com.codeborne.selenide.Selenide.page;
import ru.gb.config.TestConfig;

@ExtendWith({SelenideExtension.class})
public class LoginTest {

        @Test
        @DisplayName("Авторизация")
        void LoginTest() {

                page(MainPage.class)
                        .getHeader()
                        .clickLoginButton()
                        .login(TestConfig.testConfig.login(),TestConfig.testConfig.password())
                        .getHeader()
                        .checkLogin();

        }

        @Test
        @DisplayName("Авторизация с неверным паролем")
        void falseLoginTest() {

                page(MainPage.class)
                        .getHeader()
                        .clickLoginButton()
                        .login(TestConfig.testConfig.login(),TestConfig.testConfig.falsePassword());
                page(LoginPage.class).checkError();

        }

}

