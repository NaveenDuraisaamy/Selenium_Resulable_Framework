package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class MainMenuComponent extends BasePage {

    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com";

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    public ModulePage openAdmin() {
        return openModule("Admin", "/web/index.php/admin/viewSystemUsers", "Admin", "System Users");
    }

    public ModulePage openPim() {
        return openModule("PIM", "/web/index.php/pim/viewEmployeeList", "PIM", "Employee Information");
    }

    public ModulePage openLeave() {
        return openModule("Leave", "/web/index.php/leave/viewLeaveList", "Leave", "Leave List");
    }

    public TimePage openTime() {
        openMenu("Time", "/web/index.php/time/viewEmployeeTimesheet");
        return new TimePage(driver);
    }

    public ModulePage openRecruitment() {
        return openModule("Recruitment", "/web/index.php/recruitment/viewCandidates", "Recruitment", "Candidates");
    }

    public MyInfoPage openMyInfo() {
        openMenu("My Info", "/web/index.php/pim/viewPersonalDetails");
        return new MyInfoPage(driver);
    }

    public ModulePage openPerformance() {
        return openModule("Performance", "/web/index.php/performance/searchEvaluatePerformanceReview",
                "Performance", "Employee Reviews");
    }

    public DashboardPage openDashboard() {
        openMenu("Dashboard", "/web/index.php/dashboard/index");
        return new DashboardPage(driver);
    }

    public ModulePage openDirectory() {
        return openModule("Directory", "/web/index.php/directory/viewDirectory", "Directory", "Directory");
    }

    public MaintenancePage openMaintenance() {
        openMenu("Maintenance", "/web/index.php/maintenance/purgeEmployee");
        return new MaintenancePage(driver);
    }

    public ClaimPage openClaim() {
        openMenu("Claim", "/web/index.php/claim/viewAssignClaim");
        return new ClaimPage(driver);
    }

    public BuzzPage openBuzz() {
        openMenu("Buzz", "/web/index.php/buzz/viewBuzz");
        return new BuzzPage(driver);
    }

    private ModulePage openModule(String menuLabel, String fallbackPath, String expectedHeader, String expectedPageTitle) {
        openMenu(menuLabel, fallbackPath);
        return new ModulePage(driver, expectedHeader, expectedPageTitle, fallbackPath);
    }

    private void openMenu(String menuLabel, String fallbackPath) {
        By menuItem = By.xpath("//aside//span[normalize-space()='" + menuLabel + "']");
        click(menuItem);

        try {
            wait.until(driver -> !driver.getCurrentUrl().contains("/dashboard") || "Dashboard".equals(menuLabel));
        } catch (TimeoutException e) {
            driver.get(BASE_URL + fallbackPath);
        }
    }
}
