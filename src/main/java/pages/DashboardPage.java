package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private final By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutLink = By.xpath("//a[text()='Logout']");
    private final MainMenuComponent mainMenu;

    public DashboardPage(WebDriver driver) {
        super(driver);
        waitForUrlContains("/dashboard");
        waitForVisible(dashboardHeader);
        this.mainMenu = new MainMenuComponent(driver);
    }

    public boolean isLoaded() {
        return isVisible(dashboardHeader);
    }

    public String getHeaderText() {
        return textOf(dashboardHeader);
    }

    public MainMenuComponent menu() {
        return mainMenu;
    }

    public LoginPage logout() {
        click(userDropdown);
        click(logoutLink);
        return new LoginPage(driver);
    }
}
