package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Func {

    public WebDriver initiate(String path)
    {
        System.setProperty("webdriver.chrome.driver",path);
        return new ChromeDriver();
    }

    public void gpage(String website, WebDriver driver1)
    {
        driver1.get(website);
    }

    public String gettitle(WebDriver driver2)
    {
        return driver2.getTitle();
    }
    public void closedriver(WebDriver driver3)
    {
        driver3.close();
    }


}


