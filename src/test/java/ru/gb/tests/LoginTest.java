package ru.gb.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.LoginPage;
import ru.gb.pages.MainPage;

@DisplayName("Войти в профиль")
public class LoginTest extends BaseTest {

        @Test
        @DisplayName("Авторизация с верными логином и паролем")
        @Severity(SeverityLevel.CRITICAL)
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
        @Severity(SeverityLevel.NORMAL)
        void falseLoginTest() {

                webDriver.get(URL);

                new MainPage(webDriver)
                        .getHeader()
                        .clickLoginButton()
                        .login(login,falsePassword);
                new LoginPage(webDriver).checkError();

        }

}

