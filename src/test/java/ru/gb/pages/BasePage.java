package ru.gb.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class BasePage extends BaseView {

    @Getter
    private Header header = new Header(webDriver);

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

}