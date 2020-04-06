package com.github.neji69;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TwoFactAuth {
    public WebElement smsCodeLocator = $(By.id("otp-code"));
    public WebElement smsButtonLocator = $(By.id("login-otp-button"));
}