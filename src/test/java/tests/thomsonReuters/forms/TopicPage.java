package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class TopicPage extends BaseForm {
    private final static By titleLocator = By.xpath("//*[@class='parsys T12_region5']");

    @FindBy(xpath = "//h1[@class='heading-1']")
    private WebElement topicName;

    public TopicPage() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public String getTopicName(){
        return topicName.getText();
    }
}
