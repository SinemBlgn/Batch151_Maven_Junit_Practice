package day05_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C01_Iframe extends TestBase {


    @Test
    public void iframe() throws InterruptedException {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
       driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ ");


        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
      WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
      playTusu.click();
      Thread.sleep(3000);

 /*
        play'i dogru locate edip click yapmamiza ragmen videoyu calistirmadi.
        Bunun uzerine HTML kodlarini inceleyince Play'in aslinda bir iframe icerisinde oldugunu gorduk.
        Bu durumda once iframe'i locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */
        // videoyu durdurunuz
        WebElement pauseTusu = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        pauseTusu.click();
        bekle(3);
// videoyu tam ekran yapınız
        WebElement tamEkran = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        tamEkran.click();
        bekle(3);
// videoyu calıstırınız
        pauseTusu.click();
        bekle(3);

// videoyu kucultunuz
        tamEkran.click();
        bekle(3);
// videoyu durdurunuz
        pauseTusu.click();
        bekle(3);
// Videoyu calistirdiginizi test ediniz
    WebElement youTubeYazisi= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
    Assert.assertTrue(youTubeYazisi.isDisplayed());

// 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
   WebElement yazi=driver.findElement(By.xpath("//h1"));
   Assert.assertTrue(yazi.isDisplayed());

    }



}
