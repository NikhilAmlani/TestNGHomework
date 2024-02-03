import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestNG {
    WebDriver driver;

@Test(priority = 1)
    void OpenBrowser(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com");
    }

    @Test(priority = 2)
    void registerUser(){

        System.out.println("register User");
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("Data");
        driver.findElement(By.id("Email")).sendKeys("mail@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@123");
        driver.findElement(By.id("register-button")).click();
    }
    @Test(priority = 3)
    void loginUser(){
        System.out.println("Login User");
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.id("Email")).sendKeys("mail@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }
    @Test(priority = 4)
    void shoppingUser() {

        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/h2/a")).click();
        driver.findElement(By.id("add-to-cart-button-3")).click();
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a")).click();


    }
    @Test(priority = 5)
        void iteamQuantity(){
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

    }
    @Test(priority = 6)
        void Billing() {

        driver.findElement(By.id("BillingNewAddress_CountryId")).click();
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]/option[228]")).click();
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Leicester");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("cathrine st");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("le4");
        driver.findElement((By.id("BillingNewAddress_PhoneNumber"))).sendKeys("9999999999");
        driver.findElement((By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"))).click();
        driver.findElement((By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"))).click();






    }
    @Test(priority = 7)
    void closeBrowser(){
   driver.quit();


    }
}
