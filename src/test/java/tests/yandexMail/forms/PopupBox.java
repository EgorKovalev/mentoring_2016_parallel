package tests.yandexMail.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class PopupBox extends BaseForm {
    private final static By titleLocator = By.xpath("//*[@class='b-popup__box']");
    private String itemPath = "//div[@class='b-popup__confirm']/button[contains(.,'%s')]";

    public PopupBox() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public WebElement getItem(String name){
        return driver.findElement(By.xpath(String.format(itemPath, name)));
    }
}
