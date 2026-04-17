package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {

    private final By topbarHeader = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    public MyInfoPage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/pim/viewPersonalDetails");
        waitForVisible(personalDetailsHeader);
    }

    public boolean isLoaded() {
        return isVisible(personalDetailsHeader);
    }

    public String getHeader() {
        return textOf(topbarHeader);
    }

    public String getPageTitle() {
        return textOf(personalDetailsHeader);
    }
}
