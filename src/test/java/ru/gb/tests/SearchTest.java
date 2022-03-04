package ru.gb.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.pages.MainPage;

public class SearchTest extends BaseTest {

    @DisplayName("Поиск")
    @ParameterizedTest
    @ValueSource(strings = {"груш", "печен", "торт"})
    public void searchTest(String searchRequest){

        webDriver.get(URL);

        new MainPage(webDriver)
                .getHeader()
                .search(searchRequest)
                .chooseRubric()
                .assertResults("searchRequest");
    }

}
