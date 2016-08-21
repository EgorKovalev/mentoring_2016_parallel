package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class MainPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'siteSpecificHeader')]");
    private static String pathToTopicLink = "//h6[contains(@class,'heading-featured-content')]/strong/a[contains(.,'%s')]";
    private TopLevelMenu topLevelMenu = new TopLevelMenu();
    private NavigationMenu navigationMenu = new NavigationMenu();

    @FindBy(className = "global-search-submit")
    private WebElement searchField;

    @FindBy(className = "global-search-input")
    private WebElement searchLink;

    public MainPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickTopMenuLink(String linkName){
        topLevelMenu.clickLink(linkName);
    }

    public void clickNavigationMenuLink(String linkName){
        navigationMenu.clickLink(linkName);
    }

    public void runSearch(String request){
        searchField.click();
        searchField.sendKeys(request);
        searchLink.click();
    }

    public void clickTopic(String name){
        WebElement topicLink = driver.findElement(By.xpath(String.format(pathToTopicLink, name)));
        this.clickViaJS(topicLink);
    }
}
