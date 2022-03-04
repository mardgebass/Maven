package ru.gb.pages;

import static com.codeborne.selenide.Selenide.$$x;

public class AllRecipesPage extends BasePage{

    public RecipePage chooseRecipe(){
    $$x(".//article[contains(@class, 'block-anons col-sm-6 col-md-3')]")
        .get(1).click();
        return new RecipePage();
    }
}
