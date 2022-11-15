import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {
    public static void main(String[] args) {
        //Declaring the String type variable to store target URL
        String edgeUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        //1.Setting up the browser webdriver
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        //Creating Interface object
        WebDriver driverE = new EdgeDriver();

        //2. Opening given URL
        driverE.get(edgeUrl);

        //Maximising Edge window upon opening
        driverE.manage().window().maximize();

        //Timeout for page to load completely
        driverE.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of page
        System.out.println("The title of page is: " + driverE.getTitle());

        //4. Print the current URL
        System.out.println("The current URL is: " + driverE.getCurrentUrl());

        //5. Print the page source
        String sourcePage = driverE.getPageSource();
        System.out.println("Source code of page: " + sourcePage);

        //6. Enter the email in email field
        WebElement emailId = driverE.findElement(By.id("Email"));
        emailId.sendKeys("nik@hotmail.com");

        //7. Enter the password in the password field
        WebElement passField = driverE.findElement(By.name("Password"));
        passField.sendKeys("pass_123");

        //8. Closing the Edge browser
        driverE.quit();

    }
}
