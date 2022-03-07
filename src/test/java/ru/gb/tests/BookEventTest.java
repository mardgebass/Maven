package ru.gb.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.pages.AllEventsPage;

@DisplayName("Добавить мероприятие в бронирование")
public class BookEventTest extends BaseTest{

    @Test
    @DisplayName("Добавить мероприятие в бронирование")
    @Severity(SeverityLevel.CRITICAL)
    void addEventTest(){

        webDriver.get("https://www.gastronom.ru/school/schedule");

        new AllEventsPage(webDriver).selectEvent()
                .addToCart()
                .checkBooking();
    }

}
