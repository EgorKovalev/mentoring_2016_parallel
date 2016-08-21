package webdriver;

import org.testng.annotations.*;

public class BaseTest {
    protected static Browser browser;

    @Parameters("browser")
    @BeforeClass
    public void before(String browserName) {
        browser = Browser.getInstance(browserName);
        browser.windowMaximise();

        if (browserName.equals("chrome")){
            browser.navigate(Browser.getBaseChromeUrl());
        }
        else{
            browser.navigate(Browser.getBaseFirefoxUrl());
        }
    }

    @AfterSuite
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
