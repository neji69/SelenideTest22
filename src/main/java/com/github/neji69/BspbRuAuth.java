package com.github.neji69;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class BspbRuAuth {
    public WebElement usernameLocator = $(By.name("username"));
    public WebElement passwordLocator = $(By.name("password"));
    public WebElement loginButtonLocator = $(".btn-primary");
}
