package ru.gb.pages;

import org.openqa.selenium.WebDriver;

public class BaseView {

    protected WebDriver webDriver;

    public BaseView(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
