package ru.gb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Деавторизация")
    public void logoutTest(){

        webDriver.findElement(By.cssSelector(".new-user-panel__avatar_mobile-no")).click();
        webDriver.findElement(By.linkText("Выход")).click();

        assertThat(webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")));

    }

    }

