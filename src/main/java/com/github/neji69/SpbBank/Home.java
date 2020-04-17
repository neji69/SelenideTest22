package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class Home {
    private SelenideElement buttonOverview = $(byId("bank-overview"));


    public OverviewPage buttonOverviewClick() {
        buttonOverview.click();
        return new OverviewPage();
    }
}

