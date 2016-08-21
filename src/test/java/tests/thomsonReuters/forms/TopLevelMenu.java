package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class TopLevelMenu extends BaseForm{
    private final static By titleLocator = By.className("global-site-header-nav");
    private final static String linkPath = "//div/ul[@id='global-site-header-nav']/li/a[contains(text(),'%s')]";

    public TopLevelMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickLink(String name){
        driver.findElement(By.xpath(String.format(linkPath, name))).click();
    }
}
