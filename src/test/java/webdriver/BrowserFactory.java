package webdriver;

import org.openqa.selenium.WebDriver;
import webdriver.browserFactory.ChromeDriverCreator;
import webdriver.browserFactory.DriverCreator;
import webdriver.browserFactory.FireFoxDriverCreator;

public abstract class BrowserFactory {

    public static WebDriver setUp(String browser) {
        DriverCreator driverCreator;

        if (browser.equalsIgnoreCase("chrome")){
            driverCreator = new ChromeDriverCreator();
        }
        else {
            System.setProperty("webdriver.chrome.driver", "grid\\chromedriver.exe");
            driverCreator = new FireFoxDriverCreator();
        }
        return driverCreator.setUp();
    }
}
