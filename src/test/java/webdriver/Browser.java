package webdriver;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 10L;

    static final String PROPERTIES_FILE = "selenium.properties";

    private static Browser instance;
    private static WebDriver driver;

    public static PropertiesManager props;
    public static Browsers currentBrowser;
    protected static Logger logger = Logger.getInstance();

    private Browser() {  }

    public static String getBaseUrl(){
        return System.getProperty("urlLoginPage", props.getProperty("urlLoginPage"));
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
        driver = BrowserFactory.setUp(browserName);
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
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
        return instance != null;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public static String getBrowserName(){
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
