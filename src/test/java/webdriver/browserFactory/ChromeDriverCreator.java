package webdriver.browserFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverCreator extends DriverCreator {

    @Override
    public RemoteWebDriver setUp(){
        System.setProperty("webdriver.chrome.driver", "grid\\chromedriver.exe");
        DesiredCapabilities capability = new DesiredCapabilities().chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);

        try{
            driver = new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"), capability);
        }
        catch(MalformedURLException ex){
            //TODO: implement behavior
        }

        return driver;
    }
}
