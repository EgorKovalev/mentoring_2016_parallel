package webdriver;

import org.testng.annotations.*;

import java.util.Random;

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

    public static int getRandomNumber(){
        Random rn = new Random();
        int max = 999;
        int min = 100;

        return rn.nextInt(max - min + 1) + min;
    }
}
