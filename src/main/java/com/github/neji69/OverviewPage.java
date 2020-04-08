package com.github.neji69;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class OverviewPage {
    private SelenideElement financeFreeLocator = $(By.id("can-spend"));

    public OverviewPage checkPageOpeningByTitle() {
        assertThat(Selenide.title())
                .as("Открылась страница «Обзор»")
                .contains("Обзор");
        return this;
    }

    public OverviewPage checkValueContentFinanceFree(Pattern pattern) {
        assertThat(financeFreeLocator.getText())
                .as("На странице отображается блок «Финансовая свобода» и сумма в блоке 'финансовая свобода' в формате 123 456 789.00 ")
                .contains("Финансовая свобода")
                .containsPattern(pattern);
        return this;
    }

    public OverviewPage moveToElementAndCheckValueContentFinanceFree(Pattern pattern) {
        assertThat(financeFreeLocator.hover().getText())
                .as("Появляется надпись: «Моих средств» с указанием суммы в формате 123 456 789.00 ")
                .contains("Моих средств")
                .containsPattern(pattern);
        return this;
    }

}
