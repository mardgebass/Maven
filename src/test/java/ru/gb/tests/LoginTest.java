package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.LoginPage;
import ru.gb.pages.MainPage;

public class LoginTest extends BaseTest {

        @Test
        @DisplayName("Авторизация")
        void LoginTest() {

                webDriver.get(URL);

                new MainPage(webDriver)
                        .getHeader()
                        .clickLoginButton()
                        .login(login,password)
                        .getHeader()
                        .checkLogin();

        }

        @Test
        @DisplayName("Авторизация с неверным паролем")
        void falseLoginTest() {

                webDriver.get(URL);

                new MainPage(webDriver)
                        .getHeader()
                        .clickLoginButton()
                        .login(login,falsePassword);
                new LoginPage(webDriver).checkError();

        }

}

