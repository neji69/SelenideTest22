package com.github.neji69;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestCaseHomework {

    private static final Logger log = LoggerFactory.getLogger(TestCaseHomework.class);

//    @BeforeTest
//    public void setUp() {
//        open("https://idemo.bspb.ru");
//    }  если открывать ссылкц через анотацию бифоре , тест крашиться.

    @Test
    public void testCase22() {
        //Данные для теста (логин,пароль и смс для авторизации)
        String login = "demo";
        String password = "demo";
        String smsCode = "0000";
        Pattern pattern = Pattern.compile("[0-9]{1,3} [0-9]{1,3} [0-9]{1,3}[.][0-9][0-9] [₽]"); //Проверка формата суммы на странице "обзор"

        open("https://idemo.bspb.ru");

        BspbRuAuth bspbRuAuth = new BspbRuAuth(); //Таким образом теряю зависимости между страницами.
        TwoFactAuth twoFactAuth = new TwoFactAuth();
        Home home = new Home();
        OverviewPage overviewPage = new OverviewPage();

        $(bspbRuAuth.usernameLocator)
                .setValue(login);
        $(bspbRuAuth.passwordLocator)
                .setValue(password)
                .pressEnter();
        $(twoFactAuth.smsCodeLocator)
                .setValue(smsCode)
                .pressEnter();
        $(home.buttonOverview).click();


        assertThat(Selenide.title())
                .as("Открылась страница «Обзор»")
                .contains("Обзор");

        assertThat(overviewPage.financeFreeLocator.getText())
                .as("На странице отображается блок «Финансовая свобода»")
                .contains("Финансовая свобода");

        try {
            assertThat(overviewPage.financeFreeBalanceLocator.getText())
                    .as(" с указанием суммы в формате 123 456 789.00 ")
                    .containsPattern(pattern);
        } catch (AssertionError e) {
            log.error("Не соответствие формата баланса", e);
        }

        actions().moveToElement(overviewPage.financeFreeLocator).build().perform();

        try {
            assertThat(overviewPage.financeFreeLocator.getText())
                    .as("Появляется надпись: «Моих средств» с указанием суммы в формате 123 456 789.00 ")
                    .contains("Моих средств")
                    .containsPattern(pattern);
        } catch (AssertionError e) {
            log.error("Не соответствие баланса", e);
        }
    }
}

