package day06_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'Oppo' yazıp aratın
    // ilk ürüne tıklayın
    // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
    // ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
      String sayfaBirHandle =  driver.getWindowHandle();
        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo"+ Keys.ENTER);
        bekle(2);
        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        bekle(2);
        Set<String> windowHandleSeti= driver.getWindowHandles();
        String sayfa2Handle="";
        for (String each:windowHandleSeti){
            if (!each.equals(sayfaBirHandle)){
                sayfa2Handle=each;
            }
        }
        System.out.println("sayfa2 handle:"+sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        // driver'ı yeni acılan sekmeye gecirdik





        bekle(2);
        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin
        String ikinciSayfaTitle=driver.getTitle();
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfaBirHandle);
        //driver i ilk sayfaya gecirdik
        System.out.println("sayfa birin title'i: "+driver.getTitle());

    }
}
