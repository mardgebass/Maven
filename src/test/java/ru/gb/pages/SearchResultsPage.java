package ru.gb.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage extends BasePage{


    public SearchResultsPage assertResults(String searchRequest){

        $$x(".//a[@class='material-anons__title']")
                .stream()
                .forEach(el -> el.shouldHave(text(searchRequest)));

        return this;
    }








}
