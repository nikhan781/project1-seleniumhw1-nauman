import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    public static void main(String[] args) {
        //Declaring a String Variable to store target URL
        String firefoxUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //1. Setting up Firefox driver
        System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
        //Creating Interface object
        WebDriver driverFf = new FirefoxDriver();

        //2. Opening URL
        driverFf.get(firefoxUrl);

        // Maximising the browser window
        driverFf.manage().window().maximize();

        //Timeout to load the webpage
        driverFf.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Printing the page title in the console
        System.out.println("Page title is: " + driverFf.getTitle());

        //4. Print current URL
        String cUrl = driverFf.getCurrentUrl();
        System.out.println("The current URL is: " + cUrl);

        //5. Print page source code
        System.out.println("The source code is: " + driverFf.getPageSource());

        //6. Getting and entering email
        WebElement emailFiled = driverFf.findElement(By.id("Email"));
        emailFiled.sendKeys("nik@yahoo.com");

        //7. Getting and entering password
        WebElement passField = driverFf.findElement(By.id("Password"));
        passField.sendKeys("Pass_123");

        //8. Closing the FireFox browser
        driverFf.quit();


    }


}
