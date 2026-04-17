package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuzzPage extends BasePage {

    private final By topbarHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By sharePostBox = By.cssSelector(".orangehrm-buzz-newsfeed-posts textarea");
    private final By pageTitle = By.cssSelector(".oxd-buzz-post-input");

    public BuzzPage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/buzz/viewBuzz");
        waitForVisible(sharePostBox);
    }

    public boolean isLoaded() {
        return isVisible(sharePostBox);
    }

    public String getHeader() {
        return textOf(topbarHeader);
    }
}
