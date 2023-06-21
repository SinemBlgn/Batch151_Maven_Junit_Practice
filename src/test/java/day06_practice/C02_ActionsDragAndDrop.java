package day06_practice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_ActionsDragAndDrop extends TestBase {
    // https://demoqa.com/droppable adresine gidiniz
    // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
    // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz

    @Test
    public void test01() {
// https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");
        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
       WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(tasinacakElement,hedefElement).perform();

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
      WebElement dropped =  driver.findElement(By.xpath("//p[text()='Dropped!']"));
      String actualYazi=dropped.getText();
      String expectedYazi="Dropped!";
        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
