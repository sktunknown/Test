package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Selproject {
    private static WebDriver driver;
    private static final Random ran = new Random();
    private int random;
    private static WebDriverWait wait;
    private static WebElement ele;
    private static Robot r;
    private static final String path = "C:\\Users\\sanjay kumar T\\Downloads\\chromedriver.exe";
    @Test(priority = 1)
    public void test1_driver() {
        System.setProperty("webdriver.chrome.driver",path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test(priority = 2)
    public void test2_website() {
        driver.get("http://www.youtube.com/");
        driver.manage().window().fullscreen();
    }
    @Test(priority = 3)
    public void test3_signin_click() {
        driver.findElement(By.xpath("//tp-yt-paper-button[@aria-label = 'Sign in']")).click();
    }
    @Test(priority = 4)
    public void test4_username() {
        driver.findElement(By.xpath("//input[@class = 'whsOnd zHQkBf'][@autocomplete='username']")).sendKeys("test2021.selenium@gmail.com");
        driver.findElement(By.cssSelector("button[class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
    }
    @Test(priority = 5)
    public void test5_password() throws InterruptedException
    {
        driver.findElement(By.xpath("//input[@class = 'whsOnd zHQkBf'][@name='password']")).sendKeys("selenium2021");
        //driver.findElement(By.cssSelector("//div[@class='VfPpkd-Jh9lGc']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class = 'VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")).click();
    }
    @Test(priority = 6)
    public void test6_gettitle() {
        System.out.println(driver.getTitle());
    }
    @Test(priority = 7)
    public void test7_selectrandom1() throws InterruptedException {
        random = ran.nextInt(1,10);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//iron-selector[@id ='chips']//child::yt-chip-cloud-chip-renderer["+random+"]")).click();
    }
    @Test(priority = 8)
    public void test8_selectrandom2() throws InterruptedException
    {
        random = ran.nextInt(1,5 );
        Thread.sleep(5000);

        driver.findElement(By.xpath(" //ytd-rich-grid-row[\"+random+\"]/div[@id ='contents']//child::ytd-rich-item-renderer")).click();
    }
    @Test(priority = 10)
    public void test9_playback() throws AWTException, InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        r = new Robot();
        r.keyPress(KeyEvent.VK_F);
        Thread.sleep(10000);
        r.keyRelease(KeyEvent.VK_F);
        r.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(10000);
        r.keyRelease(KeyEvent.VK_SPACE);
        r.keyPress(KeyEvent.VK_RIGHT);
        r.keyRelease(KeyEvent.VK_RIGHT);
        //driver.findElement(By.xpath("//div[@class = 'ytp-chrome-bottom']//child::div[2][@class = 'ytp-progress-bar'][@aria-valuetext='0 Minutes 0 Seconds of 0 Minutes 28 Seconds']"));
        Actions builder = new Actions(driver);
        WebElement statusbar = driver.findElement(By.xpath("//div[@class = 'ytp-chrome-bottom']//child::div[2][@class = 'ytp-progress-bar']"));
        builder.moveToElement(statusbar,100,0).perform();
        statusbar.click();
        Thread.sleep(10000);

    }
    @Test(priority = 9)
    public void test10_skip() {
        wait = new WebDriverWait(driver,30);
        ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='skip-button:6']/span/button")));
        ele.click();
    }
    @Test(priority = 11)
    public void test11_homepage() throws InterruptedException
    {
        r.keyPress(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//yt-icon[@id = 'guide-icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id = 'endpoint'][@title = 'Home']")).click();
    }
    @Test(priority = 12)
    public void test12_search() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("liverpool fc");
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

        driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer'][1]")).click();
    }
    @Test(priority = 13)
    public void test13_savetoplaylist() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label = 'Save to playlist']")).click();
        Thread.sleep(2000);
        wait = new WebDriverWait(driver,30);
        ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//yt-formatted-string[@id='label'][@title='Watch later']")));
        ele.click();
        driver.findElement(By.xpath("//yt-icon[@icon='close']")).click();
    }
    @Test(priority = 14)
    public void test14_watchlater() throws InterruptedException {
        driver.findElement(By.xpath("//yt-icon[@id = 'guide-icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id = 'endpoint'][@title = 'Watch later']")).click();
    }
    //@Test(priority = 15)
    public void test15_goback_close() throws InterruptedException {
        driver.navigate().to("http://www.youtube.com/");
        Thread.sleep(3000);
        driver.close();
    }
}
