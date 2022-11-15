import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    //Using static variables to use in class
    static String browser = "Firefox";
    static String targetUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {
        // 1. Using Switch statement to set up and select between browsers
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser selection");
        }
        //Using exception handling to ensure the invalid input doesn't generate exception
        try {
            //2. Open given URL for selected browser
            driver.get(targetUrl);
        } catch (Exception e) {
            System.out.println("End of program due to invalid browser selection");
            System.exit(0);
        }
        //Maximise window size
        driver.manage().window().maximize();

        //Timeout request for page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print Page title
        System.out.println("Page title is: " + driver.getTitle());

        //4. Print the current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("The source code is: " + driver.getPageSource());

        //6. Get and enter email in email field
        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.sendKeys("nik11@gmail.com");

        //7. Get and enter password in password field
        WebElement passField = driver.findElement(By.id("Password"));
        passField.sendKeys("pass123");

        //8. Closing the browser
        driver.quit();

    }

}
