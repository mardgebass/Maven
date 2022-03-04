package ru.gb.pages;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage extends BasePage{


    public SearchResultsPage chooseRubric(){
        $$x(".//a[@class='material-anons__title']")
        .get(0).click();
    return new SearchResultsPage();
    }

}
