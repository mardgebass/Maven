package ru.gb.pages;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class RecipePage extends BasePage{

    public RecipePage addRecipe(){
    $x(".//a[contains(@class, 'controller-add__cover-link')]").click();
    return this;
    }

    public RecipePage checkAddingRecipe(){
    $x(".//div[contains(@class, 'js-controller-add_active controller-add_active')]")
            .shouldBe(Condition.visible.because("Кнопка должна изменить вид на в моей кулинарной книге"), Duration.ofSeconds(5));

        $x(".//a[contains(@class, 'controller-add__cover-link')]").click();
        return this;
    }
}
