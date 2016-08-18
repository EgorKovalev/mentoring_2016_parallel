package webdriver.browserFactory;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverCreator {
    protected RemoteWebDriver driver = null;

    public abstract RemoteWebDriver setUp();
}
