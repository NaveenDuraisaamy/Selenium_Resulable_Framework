package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimPage extends BasePage {

    private final By topbarHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By pageTitle = By.cssSelector(".oxd-text.oxd-text--h5");

    public ClaimPage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/claim/");
        waitForText(topbarHeader, "Claim");
        waitForText(pageTitle, "Employee Claims");
    }

    public boolean isLoaded() {
        return isVisible(pageTitle);
    }

    public String getHeader() {
        return textOf(topbarHeader);
    }

    public String getPageTitle() {
        return textOf(pageTitle);
    }
}
