package com.github.neji69;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class OverviewPage {
    private SelenideElement financeFreeLocator = $(By.id("can-spend"));

    @Step("Проверка, что открылась страница 'Обзор', по тайтлу ")
    public OverviewPage checkPageOpeningByTitle() {
        assertThat(Selenide.title())
                .as("Открылась страница «Обзор»")
                .contains("Обзор");
        return this;
    }

    @Step("Проверка, что на странице отображается блок «Финансовая свобода» и сумма в формате '123 456 789.00' ")
    public OverviewPage checkValueContentFinanceFree(Pattern pattern) {
        assertThat(financeFreeLocator.getText())
                .as("На странице отображается блок «Финансовая свобода» и сумма в блоке 'финансовая свобода' в формате 123 456 789.00 ")
                .contains("Финансовая свобода")
                .containsPattern(pattern);
        return this;
    }

    @Step("Наводим на элемент и проверяем, что появляется надпись: «Моих средств» с указанием суммы в формате '123 456 789.00' ")
    public OverviewPage moveToElementAndCheckValueContentFinanceFree(Pattern pattern) {
        assertThat(financeFreeLocator.hover().getText())
                .as("Появляется надпись: «Моих средств» с указанием суммы в формате 123 456 789.00 ")
                .contains("Моих средств")
                .containsPattern(pattern);
        return this;
    }

}
