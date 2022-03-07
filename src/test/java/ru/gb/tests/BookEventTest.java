package ru.gb.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.gb.extensions.SelenideExtension;
import ru.gb.pages.AllEventsPage;
import static com.codeborne.selenide.Selenide.page;

@ExtendWith({SelenideExtension.class})
public class BookEventTest {

    @Test
    @DisplayName("Добавить мероприятие в бронирование")
    void addEventTest(){

        Selenide.open("https://www.gastronom.ru/school/schedule");

        page(AllEventsPage.class).selectEvent()
                .addToCart()
                .checkBooking();
    }

}
