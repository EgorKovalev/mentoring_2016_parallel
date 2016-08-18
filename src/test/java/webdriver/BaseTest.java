package webdriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static Browser browser;

    @Parameters("browser")
    @BeforeClass
    public void before(String browserName) {
        browser = Browser.getInstance(browserName);
        browser.windowMaximise();
        browser.navigate(Browser.getBaseUrl());
    }

    @AfterClass
    public void after() {
        if (browser.isBrowserAlive()) {
            browser.exit();
            killProcess();
        }
    }

    public void killProcess() {
        //TODO: in progress
    }
}
