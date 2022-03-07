package ru.gb.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public MainPage login(String login, String password){

        $(By.name("Login")).sendKeys(login);
        $(By.name("Password")).sendKeys(password);
        $x(".//input[@value='ВОЙТИ']").click();
        return new MainPage();
    }

    public LoginPage checkError(){
        $x(".//div[@class='validation-summary-errors text-danger']")
        .shouldBe(Condition.visible.because("Должен появиться текст ошибки"), Duration.ofSeconds(5));
        return this;
    }

}
