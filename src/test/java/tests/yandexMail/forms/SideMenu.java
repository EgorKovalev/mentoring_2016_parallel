package tests.yandexMail.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class SideMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[@class='block-left-box']");
    private String itemsPath = "//div[@class='block-folders']/div/div/div[contains(.,'%s')]";
    private String itemsNumberPath = itemsPath + "/span/span/span";

    public SideMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public String getItemsNumber(String name){
        return driver.findElement(By.xpath(String.format(itemsNumberPath, name))).getText();
    }
}