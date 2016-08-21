package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class CompanyHistoryPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[text()='Thomson Reuters Company History']");

    @FindBy(xpath = "//h1[@class='heading-1']")
    private WebElement topicName;

    public CompanyHistoryPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public String getTopicName(){
        return topicName.getText();
    }
}
