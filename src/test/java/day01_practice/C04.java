package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    @Test
    public void tes01() {

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        // arama motorunda nutella yazip aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın
        List <WebElement> urunler= driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (int i = 0; i < urunler.size(); i++) {
             urunler= driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            urunler.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();


        }

    }
}
