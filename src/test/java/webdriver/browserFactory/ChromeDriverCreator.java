package webdriver.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends DriverCreator {
    @Override
    public WebDriver setUp(){
        System.setProperty("webdriver.chrome.driver", "grid\\chromedriver.exe");
        return new ChromeDriver();
    }
}
