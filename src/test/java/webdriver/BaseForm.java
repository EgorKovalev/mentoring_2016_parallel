package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseForm {
    private final long DEFAULT_WAIT_SEC = 30L;
    protected By titleLocator;
    protected static Logger logger = Logger.getInstance();
    protected static WebDriver driver = Browser.getDriver();
    protected static User user = new User();
    private static JavascriptExecutor js = (JavascriptExecutor)driver;
    private static Actions actions = new Actions(driver);

    protected BaseForm(final By titleLoc){
        waitForPageToLoad();
        titleLocator = titleLoc;
    }

    public static String getUserName(){
        return user.getUsername();
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

    public void sendKeysViaJS(WebElement element, String value){
        js.executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
    }

    public void sendKeyViaActions(String text){
        actions.sendKeys(text).build().perform();
    }

    public void clickViaJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
