package com.github.neji69;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    public WebElement financeFreeLocator = $(By.id("can-spend"));
    public WebElement financeFreeBalanceLocator = $(By.className("amount"));
}
