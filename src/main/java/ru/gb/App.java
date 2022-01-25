package ru.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.gastronom.ru/");
        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath(".//span[contains(text(),'Вход')]")).click();
        webDriver.findElement(By.name("Login")).sendKeys("bonita_scavo");
        webDriver.findElement(By.name("Password")).sendKeys("12280912");
        webDriver.findElement(By.xpath(".//input[@value='ВОЙТИ']")).click();

        Thread.sleep(5000);

        webDriver.findElement(By.xpath(".//span[@id='js-new-header__top-nav']")).click();

        By menuLocator = By.id("mCSB_1_container");
        WebElement menu = webDriver.findElement(menuLocator);

        menu.findElement(By.xpath(".//a[contains(text(),'РЕЦЕПТЫ')]")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//h1[contains(text(),'РЕЦЕПТЫ')]")));

        List<WebElement> products = webDriver.findElements(By.xpath("//article[contains(@class, 'block-anons col-sm-6 col-md-3')]"));
        products.get(1).click();

        webDriver.findElement(By.xpath(".//a[contains(@class, 'controller-add__cover-link')]")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[contains(@class, 'controller-add controller-add_position js-controller-add_active controller-add_active')]")));

        webDriver.findElement(By.cssSelector(".new-user-panel__avatar_mobile-no")).click();
        webDriver.findElement(By.linkText("Выход")).click();

        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(),'Вход')]")));
        webDriver.quit();


    }
}
