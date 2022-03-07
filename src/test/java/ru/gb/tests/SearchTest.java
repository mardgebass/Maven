package ru.gb.tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.pages.MainPage;

@DisplayName("Поиск по сайту")
public class SearchTest extends BaseTest {

    @DisplayName("Позитивные проверки")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest(name = "Поиск по запросу {0}")
    @ValueSource(strings = {"груш", "печен", "торт"})
    public void searchTest(String searchRequest){

        Allure.parameter("Поисковые запросы: ", searchRequest);

        webDriver.get(URL);

        new MainPage(webDriver)
                .getHeader()
                .search(searchRequest)
                .chooseRubric()
                .assertResults(searchRequest);
    }

}
