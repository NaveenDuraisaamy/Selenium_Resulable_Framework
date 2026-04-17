package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimePage extends BasePage {

    private final By topbarHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    public TimePage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/time/viewEmployeeTimesheet");
        waitForVisible(employeeNameInput);
    }

    public boolean isLoaded() {
        return isVisible(employeeNameInput);
    }

    public String getHeader() {
        return textOf(topbarHeader);
    }
}
