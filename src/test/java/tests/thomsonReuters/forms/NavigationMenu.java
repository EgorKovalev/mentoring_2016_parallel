package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class NavigationMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//*[contains(@class, 'site-specific-header')]");
    private final static String linkPath = "//div[@class='primary-navigation-list-wrapper']/ul/li/*[contains(text(),'%s')]";

    public NavigationMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickLink(String name){
        driver.findElement(By.xpath(String.format(linkPath, name))).click();
    }
}
