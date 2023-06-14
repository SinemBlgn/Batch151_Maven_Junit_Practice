package day04_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C01_DropdownMenu extends TestBase {
    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com");
        // dropdown'dan "Books" secenegini secin
      WebElement ddm= driver.findElement(By.xpath("//select[@name='url']"));
        Select select= new Select(ddm);
        select.selectByVisibleText("Books");
        // 3- optionlardan bir tanesi secilir
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
       // select.selectByValue("search-alias=stripbooks-intl-ship");
        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edin
      WebElement aramaSonucElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucElementi.getText().contains("Java"));
    }

}
