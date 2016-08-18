package webdriver.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverCreator extends DriverCreator {
    @Override
    public WebDriver setUp(){
        return new FirefoxDriver();
    }
}
