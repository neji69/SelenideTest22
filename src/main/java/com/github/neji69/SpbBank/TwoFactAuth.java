package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class TwoFactAuth {
    private SelenideElement smsCodeLocator = $(byId("otp-code"));
    private SelenideElement smsButtonLocator = $(byId("login-otp-button"));

    public TwoFactAuth inputSmsCode(String smsCode) {
        smsCodeLocator.setValue(smsCode);
        return this;
    }

    public Home clickButtonSmsAuthorization() {
        smsButtonLocator.click();
        return new Home();
    }

    public Home smsAuth(String smsCode) {
        return inputSmsCode(smsCode).clickButtonSmsAuthorization();
    }
}