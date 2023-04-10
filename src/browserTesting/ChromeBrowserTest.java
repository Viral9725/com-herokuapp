package browserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    public static void main(String[] args) {
        String baseUrl = "http://the-internet.herokuapp.com/login";

        //Launch the Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        //maximise the Browser
        driver.manage().window().maximize();

        //we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Get the title of the Page
        String title = driver.getTitle();
        System.out.println(title);

        //Get the Current Url
        System.out.println("Current url: " + driver.getCurrentUrl());

        //Get Page Source
        System.out.println("Page Source: " + driver.getPageSource());

        //find the Email Element
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith");

        //find the Password Field Element and Type the Password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //close the Browser
        driver.close();
    }
}
