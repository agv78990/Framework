package page_objects;

import browerDriver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPage extends BrowserDriver {
    @Test(priority = 1)
    public void contactUs() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=contact");
    }
    @Test (priority = 2)
    public void email(){
        driver.findElement(By.id("email")).click();
    }
        @Test(priority = 3)
        public void enterEmail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("huma123@gmail.com",Keys.TAB);
     Thread.sleep(5000);}

     @Test(priority = 4)
     public void password() {
           driver.findElement(By.id("id_order")).sendKeys("pass");
       }
       @Test(priority = 5)
       public void message () {
           driver.findElement(By.id("message")).sendKeys("hi there");
       }
       @Test(priority = 6)
       public void drop() throws InterruptedException {
       WebElement chooseState= driver.findElement(By.id("id_contact"));
        Select drop =new Select(chooseState);
        //drop.selectByIndex(1);
        drop.selectByVisibleText("Customer service");
        Thread.sleep(3000);

    }
}
