package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String LOGIN_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By loginTitle = By.cssSelector(".orangehrm-login-branding img");
    private final By errorMessage = By.cssSelector(".oxd-alert-content-text");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(LOGIN_URL);
        waitForVisible(loginTitle);
        waitForVisible(usernameInput);
    }

    public DashboardPage loginAs(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new DashboardPage(driver);
    }

    public boolean isLoaded() {
        return isVisible(usernameInput) && isVisible(passwordInput);
    }

    public String getErrorMessage() {
        return textOf(errorMessage);
    }
}
