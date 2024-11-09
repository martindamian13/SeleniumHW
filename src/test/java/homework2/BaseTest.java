package homework2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Driver instance
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Espera implícita para elementos
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); // Tiempo de espera para cargas de página

        driver.get("https://demo.applitools.com/");
        // Iniciar sesión
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("admin");
        loginPage.setPassword("admin");
        loginPage.clickLogin();

        HomePage homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}