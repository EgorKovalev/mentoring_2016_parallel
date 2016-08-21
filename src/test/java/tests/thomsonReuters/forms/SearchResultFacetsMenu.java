package tests.thomsonReuters.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.BaseForm;

public class SearchResultFacetsMenu extends BaseForm {
    private final static By titleLocator = By.xpath("//div[contains(@class,'search-results-filter-set-wrapper')]");
    private static String linkPath = "//div[@class='search-results-category-list']/span[text()='%s']/following-sibling::ul/li/a[text()='%s']";
    private static String facetPath = "//div[@class='search-results-category-list']/ul/li/a[text()='%s']/span";

    public SearchResultFacetsMenu() {
        super(titleLocator);
        PageFactory.initElements(driver, this);
    }

    public void clickTypeFromType(String type, String link){
        driver.findElement(By.xpath(String.format(linkPath, type, link))).click();
    }

    public int getDocsNumberInFacet(String facetname){
        String number = driver.findElement(By.xpath(String.format(facetPath, facetname))).getText();
        return Integer.parseInt(number);
    }
}
