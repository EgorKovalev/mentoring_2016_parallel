package parallelTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import parallelTests.forms.MailPage;
import parallelTests.forms.MainPage;
import webdriver.BaseForm;
import webdriver.BaseTest;

public class ParallelTests1 extends BaseTest {

    @Test
    public void successfulAuthorization(){
        final String username = BaseForm.getUserName();

        MainPage mainPage = new MainPage();
        mainPage.authorizeUser();

        MailPage mailPage = new MailPage();
        Assert.assertTrue(mailPage.getCurrentEmailBoxName().contains(username));
    }
}
