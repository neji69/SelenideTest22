package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class BspbRuAuth {

    private SelenideElement usernameElement = $(byName("username"));
    private SelenideElement passwordElement = $(byName("password"));
    private SelenideElement loginButtonElement = $(".btn-primary");


    public BspbRuAuth inputLogin(String login) {
        usernameElement.setValue(login);
        return this;
    }


    public BspbRuAuth inputPassword(String password) {
        passwordElement.setValue(password);
        return this;
    }


    public TwoFactAuth clickButtonAuthorization() {
        loginButtonElement.click();
        return new TwoFactAuth();
    }

    public TwoFactAuth authorize(String login, String password) {
        return inputLogin(login).inputPassword(password).clickButtonAuthorization();
    }
}
