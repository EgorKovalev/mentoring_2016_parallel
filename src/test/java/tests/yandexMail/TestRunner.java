package tests.yandexMail;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.yandexMail.forms.MailPage;
import tests.yandexMail.forms.MainPage;
import tests.yandexMail.forms.NewMessagePage;
import webdriver.BaseForm;
import webdriver.BaseTest;

import java.util.List;

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
    public void createNewMessageAndSaveInDraft(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage();
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") != itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void createNewMessageAndDoNotSave(){
        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage();
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.doNotSaveChanges();

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") == itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void verifyDraftTopic(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        List<String> topics = mailPage.getMessageTopics();

        Assert.assertTrue(topics.contains(topicName), "Can't find \"" + topicName + "\" in the topics");
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void sendMessageFromDraft(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Черновики");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        mailPage.clickMessage(topicName);
        mailPage.sendMessage(to);

        Assert.assertTrue(mailPage.getItemsNumber("Черновики") != itemsNumber);
        mainPage.logOutUser();
    }

    @Test (priority = 2)
    public void verifySentMessage(){
        String to = "test@mail.ru";
        String topicName = "verify new message topic " + getRandomNumber();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        int itemsNumber = mailPage.getItemsNumber("Отправленные");
        mailPage.clickToolbarItem("Написать");

        NewMessagePage newMessagePage = new NewMessagePage();
        newMessagePage.createNewMessage(to, topicName);
        newMessagePage.clickTopmenuItem("Почта");
        mailPage.saveChanges();

        mailPage.clickSidebarItem("Черновики");
        mailPage.clickMessage(topicName);
        mailPage.sendMessage(to);

        Assert.assertTrue(mailPage.getItemsNumber("Отправленные") == itemsNumber);
        mainPage.logOutUser();
    }
}
