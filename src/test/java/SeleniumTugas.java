import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SeleniumTugas {

        WebDriver driver;
        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://saucedemo.com");
        }

        @Test
        public void firstCase() throws Exception {

            WebDriverWait wait = new WebDriverWait(driver, 3);
            WebElement fieldUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
            WebElement fieldPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement buttonLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login-button")));

            fieldUsername.sendKeys("usernameTesting");
            fieldPassword.sendKeys("password123");
            buttonLogin.click();

            WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-button")));
            assertTrue(errorMessage.isDisplayed());

        }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}

