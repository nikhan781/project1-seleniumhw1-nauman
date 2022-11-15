import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args) {
        //Declaring a String variable
        String webUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

        //1. Setting up properties for Chrome web driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //Creating Interface Object
        WebDriver driverChrome = new ChromeDriver();

        //2. Opening given URL
        driverChrome.get(webUrl);

        //Maximise browser upon opening
        driverChrome.manage().window().maximize();

        //Time given to driver to wait until page is loaded completely
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Get & print title page in console
        String title = driverChrome.getTitle();
        System.out.println("Page title is: " + title);

        //4. Get & print the current page URL in console
        String currentUrl = driverChrome.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        //5. Print the page source code in console
        System.out.println("The source code is : " + driverChrome.getPageSource());

        //6. Getting and entering email in email field
        WebElement emailField = driverChrome.findElement(By.id("Email"));
        emailField.sendKeys("nik@gmail.com");

        //7. Getting and entering password in password field
        WebElement passwordField = driverChrome.findElement(By.id("Password"));
        passwordField.sendKeys("pass_123");

        //8. Closing the Chrome browser
        driverChrome.quit();

    }
}
