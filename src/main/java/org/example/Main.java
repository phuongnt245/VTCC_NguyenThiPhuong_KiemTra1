package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang web
        driver.get("https://cms.anhtester.com/login");

        //Login trang web
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("123456");
        //Click button Login
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
        Thread.sleep(3000);

        //Mở Category trong mục Products
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()=\"Category\"]")).click();

        //Click button Add new category
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        Thread.sleep(2000);

        //Name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Danhmuc1");

        //Parent Category
        driver.findElement(By.xpath("//div[contains(text(),'No Parent')]")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Drink");
        Actions action = new Actions(driver);

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        //Ordering Number
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");

        //Type
        driver.findElement(By.xpath("//button[@title='Physical']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Physical']")).click();
        Thread.sleep(3000);

        //Add Banner
        driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Drink");
        driver.findElement(By.xpath("//div[@title='drink-on-a-plate-with-a-book-behind-it.jpg']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(3000);

        //Add Icon
        driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//div[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Cosy");
        driver.findElement(By.xpath("//div[@data-value=\"521\"]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        Thread.sleep(3000);
        //Meta Type
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Test123");
        Thread.sleep(2000);

        //Meta description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("mo ta");
        Thread.sleep(2000);

        //Filtering Attributes
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        //Click button Save
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
        Thread.sleep(3000);

        //Search and Verify
        WebElement src_category = driver.findElement(By.id("search"));
        src_category.sendKeys("Danhmuc1");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        //Tắt browser
        driver.quit();
    }
}