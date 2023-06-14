package day04_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class C02_WindowHandle extends TestBase {
    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
      String sayfaBirHandle=driver.getWindowHandle();
// 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
// 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
      String sayfa2Handle=driver.getWindowHandle();

// 4- title'in 'Best Buy' icerdigini test edelim
      String bestByTitle=driver.getTitle();
      Assert.assertTrue(bestByTitle.contains("Best Buy"));
// 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfaBirHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
// 6- arama sonuclarının 'Java' icerdigini test edelim
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        String sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(sonuc.contains("Java"));
// 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);

// 8- logonun gorundugunu test edelim
      WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
      Assert.assertTrue(logo.isDisplayed());

    }
}
