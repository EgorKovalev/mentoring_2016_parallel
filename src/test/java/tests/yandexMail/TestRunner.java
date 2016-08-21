package tests.yandexMail;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.yandexMail.forms.MailPage;
import tests.yandexMail.forms.MainPage;
import tests.yandexMail.forms.NewMessagePage;
import webdriver.BaseForm;
import webdriver.BaseTest;

public class TestRunner extends BaseTest {

    @Test (priority = 1)
    public void successfulAuthorization(){
        final String username = BaseForm.getUserName();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        Assert.assertTrue(mailPage.getCurrentEmailBoxName().contains(username));

        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void createNewMessage(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage();
        newMessagePage.clickTopmenuItem("Почта");

        mailPage.saveChanges();
        mainPage.logOutUser();
    }
}
