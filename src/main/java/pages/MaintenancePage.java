package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaintenancePage extends BasePage {

    private final By pageTitle = By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title");
    private final By passwordInput = By.xpath("//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    public MaintenancePage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/maintenance/");
        waitForVisible(passwordInput);
    }

    public boolean isLoaded() {
        return isVisible(passwordInput);
    }

    public String getPageTitle() {
        return textOf(pageTitle);
    }
}
