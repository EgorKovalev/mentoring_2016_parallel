package webdriver;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 10L;

    static final String PROPERTIES_FILE = "selenium.properties";

    private static Browser instance;
    private static WebDriver driver;
    private static List<WebDriver> driverslist = new ArrayList<WebDriver>();

    public static PropertiesManager props;
    public static Browsers currentBrowser;
    protected static Logger logger = Logger.getInstance();

    private Browser() {  }

    public static String getBaseChromeUrl(){
        return System.getProperty("urlChrome", props.getProperty("urlChrome"));
    }

    public static String getBaseFirefoxUrl(){
        return System.getProperty("urlFirefox", props.getProperty("urlFirefox"));
    }

    public static Browser getInstance(String browserName) {
        initProperties(browserName);
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        instance = new Browser();
        return instance;
    }

    private static void initProperties(String browserName){
        props = new PropertiesManager(PROPERTIES_FILE);
        currentBrowser = Browsers.valueOf(browserName.toUpperCase());
        driver = BrowserFactory.setUp(currentBrowser);
        driverslist.add(driver);
    }

    public void exit() {
        for (WebDriver dr:driverslist) {
            dr.quit();
        }
        driverslist.clear();
    }

    protected void info(final String message) {
        logger.info(message);
    }

    public void windowMaximise() {
        driver.manage().window().maximize();
    }

    public void navigate(final String url) {
        driver.navigate().to(url);
    }

    public boolean isBrowserAlive() {
        return !driverslist.isEmpty();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public String getBrowserName(){
        return currentBrowser.toString();
    }

    public enum Browsers {
        FIREFOX("firefox"),
        IEXPLORE("iexplore"),
        CHROME("chrome"),
        OPERA("opera"),
        SAFARI("safari");

        public String value;

        Browsers(final String values) {
            value = values;
        }

        public String toString() {
            return value;
        }
    }
}
