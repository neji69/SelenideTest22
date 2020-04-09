package com.github.neji69;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;

public class TestCaseHomework {

    @Test
    @Owner(value = "Ленчевский Ян")
    @Severity(value = SeverityLevel.MINOR)
    public void testCase22() {
        //Данные для теста (логин,пароль и смс для авторизации)
        String login = "demo";
        String password = "demo";
        String smsCode = "0000";
        Pattern pattern = Pattern.compile("[0-9]{1,3} [0-9]{1,3} [0-9]{1,3}[.][0-9][0-9] [₽]"); //Проверка формата суммы на странице "обзор"

        open("https://idemo.bspb.ru", BspbRuAuth.class)
                .authorize(login, password)
                .smsAuth(smsCode)
                .buttonOverviewClick()
                .checkPageOpeningByTitle()
                .checkValueContentFinanceFree(pattern)
                .moveToElementAndCheckValueContentFinanceFree(pattern);
    }
}

