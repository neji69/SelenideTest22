package com.github.neji69.Cucumber.stepdefs;

import com.codeborne.selenide.Selenide;
import com.github.neji69.BspbRuAuth;
import com.github.neji69.Home;
import com.github.neji69.OverviewPage;
import com.github.neji69.TwoFactAuth;
import io.cucumber.java.ru.*;

import static com.codeborne.selenide.Selenide.open;

public class SpbBankSteps {

    BspbRuAuth bspbRuAuth = new BspbRuAuth();
    TwoFactAuth twoFactAuth = new TwoFactAuth();
    Home home = new Home();
    OverviewPage overviewPage = new OverviewPage();


    //Данные для теста (логин,пароль и смс для авторизации)
    private static final String LOGIN = "demo";
    private static final String PASSWORD = "demo";
    private static final String SMS_CODE = "0000";


    @Дано("пользователь входит на сайт {string}")
    public void userConnectToSite(String link) {
        open(link);
    }

    @Тогда("открывается страница Авторизации и пользователь авторизируется используя логин и пароль")
    public void userAuthorization() {
        bspbRuAuth.authorize(LOGIN, PASSWORD);

    }

    @Затем("открывается страница двухфакторной авторизации где пользователь вводит смс код и кнопку подтверждения")
    public void userSmsAuthorization() {
        twoFactAuth.smsAuth(SMS_CODE);
    }

    @Тогда("открывается домашняя страница где пользователь кликает по кнопке Обзор")
    public void openHomePageAndClickButtonOverview() {
        home.buttonOverviewClick();
    }

    @Затем("проверяем что открылась страница Обзор")
    public void checkOverviewPageOpening() {
        overviewPage.checkPageOpeningByTitle();
    }

    @Затем("проверяем что на странице отобразился блок Финансовая свобода и рядом отображаеться сумма в нужном формате")
    public void checkValueContentFinanceFree() {
        overviewPage.checkValueContentFinanceFree();
    }

    @Затем("наводим курсор на сумму и проверяем появление строки мои средства с суммой в нужном формате")
    public void moveToElementAndCheckValueContentFinanceFree() {
        overviewPage.moveToElementAndCheckValueContentFinanceFree();
    }
}
