package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginShouldOpenDashboard() {
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");

        Assert.assertTrue(dashboardPage.isLoaded(), "Dashboard page should be displayed after login.");
    }
}
