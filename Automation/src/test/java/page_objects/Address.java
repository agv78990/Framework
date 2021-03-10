package page_objects;

import browerDriver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Locale;

public class Address extends BrowserDriver {
    @Test
    public void addressPage() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=stores");
   Thread.sleep(3000);
    }
    @Test
    public void goToZip(){
        driver.findElement(By.xpath("//*[@id='addressInput']")).click();
    }
    @Test
    public void enterZip() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='addressInput']")).sendKeys("98059", Keys.ENTER);

   Thread.sleep(3000); }
   @Test
    public void radius() throws InterruptedException {
       WebElement chooseRadius = driver.findElement(By.xpath("//*[@id='radiusSelect']"));
       Select drop = new Select(chooseRadius);
       drop.selectByIndex(1);
       Thread.sleep(3000);
   }}


