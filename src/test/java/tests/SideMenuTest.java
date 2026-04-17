package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BuzzPage;
import pages.ClaimPage;
import pages.DashboardPage;
import pages.MaintenancePage;
import pages.ModulePage;
import pages.MyInfoPage;
import pages.TimePage;

public class SideMenuTest extends BaseTest {

    @DataProvider(name = "sideMenuModules")
    public Object[][] sideMenuModules() {
        return new Object[][] {
                { "Admin", "Admin", "System Users" },
                { "PIM", "PIM", "Employee Information" },
                { "Leave", "Leave", "Leave List" },
                { "Recruitment", "Recruitment", "Candidates" },
                { "Performance", "Performance", "Employee Reviews" },
                { "Directory", "Directory", "Directory" },
        };
    }

    @Test(dataProvider = "sideMenuModules")
    public void adminUserShouldOpenEachVisibleSideMenuModule(String moduleName, String expectedHeader,
            String expectedPageTitle) {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        ModulePage modulePage = openModule(dashboardPage, moduleName);

        Assert.assertTrue(modulePage.isLoaded(), moduleName + " page should load successfully.");
        Assert.assertEquals(modulePage.getHeader(), expectedHeader,
                moduleName + " top bar header should match.");
        Assert.assertEquals(modulePage.getPageTitle(), expectedPageTitle,
                moduleName + " page title should match.");
    }

    @Test
    public void adminUserShouldOpenMyInfoModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        MyInfoPage myInfoPage = dashboardPage.menu().openMyInfo();

        Assert.assertTrue(myInfoPage.isLoaded(), "My Info page should load successfully.");
        Assert.assertEquals(myInfoPage.getHeader(), "PIM");
        Assert.assertEquals(myInfoPage.getPageTitle(), "Personal Details");
    }

    @Test
    public void adminUserShouldOpenTimeModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        TimePage timePage = dashboardPage.menu().openTime();

        Assert.assertTrue(timePage.isLoaded(), "Time page should load successfully.");
        Assert.assertEquals(timePage.getHeader(), "Time");
    }

    @Test
    public void adminUserShouldOpenClaimModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        ClaimPage claimPage = dashboardPage.menu().openClaim();

        Assert.assertTrue(claimPage.isLoaded(), "Claim page should load successfully.");
        Assert.assertEquals(claimPage.getHeader(), "Claim");
        Assert.assertEquals(claimPage.getPageTitle(), "Employee Claims");
    }

    @Test
    public void adminUserShouldOpenMaintenanceModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        MaintenancePage maintenancePage = dashboardPage.menu().openMaintenance();

        Assert.assertTrue(maintenancePage.isLoaded(), "Maintenance page should load successfully.");
        Assert.assertEquals(maintenancePage.getPageTitle(), "Administrator Access");
    }

    @Test
    public void adminUserShouldOpenBuzzModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        BuzzPage buzzPage = dashboardPage.menu().openBuzz();

        Assert.assertTrue(buzzPage.isLoaded(), "Buzz page should load successfully.");
        Assert.assertEquals(buzzPage.getHeader(), "Buzz");
    }

    @Test
    public void adminUserShouldOpenDashboardModule() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        DashboardPage reopenedDashboardPage = dashboardPage.menu().openDashboard();

        Assert.assertTrue(reopenedDashboardPage.isLoaded(), "Dashboard page should load successfully.");
        Assert.assertEquals(reopenedDashboardPage.getHeaderText(), "Dashboard");
    }

    private ModulePage openModule(DashboardPage dashboardPage, String moduleName) {
        switch (moduleName) {
        case "Admin":
            return dashboardPage.menu().openAdmin();
        case "PIM":
            return dashboardPage.menu().openPim();
        case "Leave":
            return dashboardPage.menu().openLeave();
        case "Recruitment":
            return dashboardPage.menu().openRecruitment();
        case "Performance":
            return dashboardPage.menu().openPerformance();
        case "Directory":
            return dashboardPage.menu().openDirectory();
        default:
            throw new IllegalArgumentException("Unsupported module: " + moduleName);
        }
    }
}
