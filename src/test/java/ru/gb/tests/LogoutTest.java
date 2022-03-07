package ru.gb.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.MainPage;

@DisplayName("Выход из профиля")
public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Деавторизация")
    @Severity(SeverityLevel.NORMAL)
    public void logoutTest(){

        webDriver.get(URL);

        new MainPage(webDriver)
                .getHeader()
                .clickLoginButton()
                .login(login,password)
                .getHeader()
                .checkLogin()
                .getHeader()
                .logout()
                .getHeader()
                .checkLogout();
    }

    }

