package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class AboutUsPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[text()='About Thomson Reuters']");
    private AboutUsDropMenu aboutUsDropMenu = new AboutUsDropMenu();

    public AboutUsPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickDropList(String name, String subItem){
        aboutUsDropMenu.selectDropItem(name, subItem);
    }
}