package parallelTests.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class MailPage extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'b-toolbar__block_chevron')]");

    public MailPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='block-messages-title']/span/span/span[@class='js-messages-title-dropdown-name']")
    private WebElement mailBoxName;

    public String getCurrentEmailBoxName(){
        return mailBoxName.getText();
    }
}
