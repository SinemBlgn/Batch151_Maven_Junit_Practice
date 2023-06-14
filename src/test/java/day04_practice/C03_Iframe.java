package day04_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C03_Iframe extends TestBase {
    @Test
    public void tets01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
// Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
// Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

// Videoyu calistirdiginizi test ediniz
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());
// 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']")).isDisplayed());
    }
}
