package ru.gb.pages;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class EventPage extends BasePage{

    public EventPage addToCart(){
    $x(".//a[@class='form__button  js-added-to-cart']").click();
    return this;
    }

    public EventPage checkBooking(){
        $x(".//a[@class='form__button form__button_disabled']")
                .shouldBe(Condition.visible.because("Кнопка должна изменить вид на добавлено к бронированию"), Duration.ofSeconds(5));
        $x(".//a[@id='jsbasket-reserv']")
                .shouldBe(Condition.visible.because("Должа появиться корзина с добавленным мероприятием"), Duration.ofSeconds(5));
        return this;

    }


}
