package webdriver.browserFactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxDriverCreator extends DriverCreator {

    @Override
    public RemoteWebDriver setUp(){
        DesiredCapabilities capability = new DesiredCapabilities().firefox();
        capability.setBrowserName("firefox");
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
