package ru.gb.tests;

import org.aeonbits.owner.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.config.TestConfig;
import ru.gb.extensions.SelenideExtension;
import ru.gb.pages.MainPage;
import static com.codeborne.selenide.Selenide.page;

@ExtendWith({SelenideExtension.class})
public class SearchTest {

    @ParameterizedTest
    @ValueSource(strings = {"груш", "печен", "торт"})
    @DisplayName("Поиск")
    public void searchTest(String searchRequest){

        page(MainPage.class)
                .getHeader()
                .search(searchRequest)
                .chooseRubric()
                .assertResults(searchRequest);
    }

}
