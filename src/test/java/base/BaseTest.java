package base;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    private static final String DEFAULT_DRIVER_PATH =
            "C:\\Users\\Kamali\\.cache\\selenium\\chromedriver\\win64\\146.0.7680.165\\chromedriver.exe";

    @BeforeMethod
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        Path chromeProfile = Files.createTempDirectory("orangehrm-chrome-");

        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--user-data-dir=" + chromeProfile.toAbsolutePath());

        driver = new ChromeDriver(buildChromeService(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    private ChromeDriverService buildChromeService() {
        String configuredPath = System.getProperty("webdriver.chrome.driver", DEFAULT_DRIVER_PATH);

        return new ChromeDriverService.Builder()
                .usingDriverExecutable(Path.of(configuredPath).toFile())
                .build();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
