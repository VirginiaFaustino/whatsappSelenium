import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumExample {

    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){

        if(System.getProperty("webdriver.chrome.driver") != null)
            driver = new ChromeDriver();
        else if(System.getProperty("phantomjs_binary_path") != null)
            driver = new PhantomJSDriver();
        else
            throw new RuntimeException("Unknown web driver specified.");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

 

    @Test()
    public void browserInitTest() throws InterruptedException {
        driver.get("https://web.whatsapp.com/");
        
        
    	driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/label/input")).sendKeys("Emmanuel Gomez");
    	
    	driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[3]/div/div/div[2]/div[1]/div[1]/span/span")).click();
    	
    	driver.findElement(By.className("_3u328 copyable-text selectable-text")).sendKeys("Hola");
    	driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div[3]")).click();
        

        Assert.assertEquals(driver.getTitle(),"Google");
    }
    
    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
