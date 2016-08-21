package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseForm {
    private final long DEFAULT_WAIT_SEC = 30L;
    protected By titleLocator;
    protected static Logger logger = Logger.getInstance();
    protected static WebDriver driver = Browser.getDriver();
    protected static String userName = Browser.getUsername();
    protected static String password = Browser.getPassword();

    protected BaseForm(final By titleLoc){
        waitForPageToLoad();
        titleLocator = titleLoc;
    }

    public static String getUserName(){
        return userName;
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_SEC);
            wait.until(expectation);
        } catch (Throwable error) {
            logger.error("Page loading error");
        }
    }

    public void clickViaJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
