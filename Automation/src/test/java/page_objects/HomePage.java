package page_objects;

import browerDriver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BrowserDriver {
    @Test(priority = 1)
    public void doSomethingTest() throws Exception {
        driver.findElement(By.id("search_query_top")).sendKeys("Hello", Keys.ENTER);
        // Thread.sleep(3000);
        // Clicking Search button
        //driver.findElement(By.name("submit_search")).click();
        // Get Tag value from the specific location/tag
        String actualValue = driver.findElement(By.className("heading-counter")).getText();
        System.out.println(actualValue);
        Assert.assertEquals(actualValue, "0 results have been found.");
        Thread.sleep(3000);


    }
    @Test(priority = 3)
    public void path() throws InterruptedException {
        driver.findElement(By.xpath("/html//div[@id='columns']")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='block_top_menu']")).click();
        Thread.sleep(2000);
    }

}
