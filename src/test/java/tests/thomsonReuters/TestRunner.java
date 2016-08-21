package tests.thomsonReuters;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.thomsonReuters.forms.*;
import webdriver.BaseTest;

public class TestRunner extends BaseTest {

    @Test
    public void openProductsListLoginPage(){
        MainPage mainPage = new MainPage();
        mainPage.clickTopMenuLink("Login");
        AllProductsLoginPage allProductsLoginPage = new AllProductsLoginPage();
        Assert.assertTrue(allProductsLoginPage.getProductsNumber() != 0, "the number of products is equal to 0");
    }

    @Test
    public void runSearch(){
        MainPage mainPage = new MainPage();
        mainPage.runSearch("test request");
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isSearchResultPresent(), "the search result is empty");
    }

    @Test
    public void browseTopics(){
        String topicName = "Legal";
        MainPage mainPage = new MainPage();
        mainPage.clickTopic(topicName);
        TopicPage topicPage = new TopicPage();
        Assert.assertTrue(topicName.equals(topicPage.getTopicName()), "not correct topic was opened");
    }

    @Test
    public void companyHistory(){
        String expectedTopicName = "thomson reuters company history";
        MainPage mainPage = new MainPage();
        mainPage.clickNavigationMenuLink("About Us");
        AboutUsPage aboutUsPage = new AboutUsPage();
        aboutUsPage.clickDropList("Our Company", "Company History");
        CompanyHistoryPage companyHistoryPage = new CompanyHistoryPage();
        Assert.assertTrue(expectedTopicName.equals(companyHistoryPage.getTopicName().toLowerCase()), "About Thomson Reuters page was not opened");
    }
}
