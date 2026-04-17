package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ModulePage extends BasePage {

    private final String expectedHeader;
    private final String expectedPageTitle;
    private final String expectedPath;

    private final By topbarHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By pageTitle = By.cssSelector(".oxd-text.oxd-text--h5");

    public ModulePage(WebDriver driver, String expectedHeader, String expectedPageTitle, String expectedPath) {
        super(driver);
        this.expectedHeader = expectedHeader;
        this.expectedPageTitle = expectedPageTitle;
        this.expectedPath = expectedPath;
        waitForModule();
    }

    public String getHeader() {
        return textOf(topbarHeader);
    }

    public String getPageTitle() {
        return textOf(pageTitle);
    }

    public boolean isLoaded() {
        return isVisible(topbarHeader) && isVisible(pageTitle);
    }

    public boolean isOnExpectedPath() {
        return isUrlContaining(expectedPath);
    }

    private void waitForModule() {
        try {
            wait.until(driver -> isUrlContaining(expectedPath));
        } catch (TimeoutException e) {
            // Let the visible markers below determine readiness when the app appends dynamic route segments.
        }
        waitForText(topbarHeader, expectedHeader);
        waitForText(pageTitle, expectedPageTitle);
    }
}
