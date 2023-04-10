package browserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest
{

    // default browser open

    static String browser = "Edge";

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name please select Other");
        }

        //maximize browser size
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Get the Title of the Page
        String title = driver.getTitle();
        System.out.println(title);

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Get page Source
        System.out.println("Page Source: " +driver.getPageSource());

        //find the Email Element
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith");

        //find the Password Field Element and Type the Password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //close the Browser
        driver.close();
    }
}
