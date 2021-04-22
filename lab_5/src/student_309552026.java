import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class student_309552026 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        // Navigate to a nycu
        driver.get("https://www.nycu.edu.tw/");
        // Maximize window
        driver.manage().window().maximize();
        // Click NEWS
        WebElement NEWS = driver.findElement(By.id("menu-1-9942884")).findElements(By.xpath(".//a")).get(1);
        NEWS.click();
        driver.findElement(By.id("eael-advance-tabs-7dbbb0c")).findElements(By.xpath("./div")).get(1).findElements(By.xpath(".//a")).get(0).click();
        WebElement page = driver.findElement(By.id("content")).findElements(By.xpath(".")).get(0);
        String title = page.findElements(By.xpath(".//h1")).get(0).getText();
        System.out.println("Title:");
        System.out.println(title);
        String content = page.findElements(By.xpath(".//div")).get(0).getText();
        System.out.println("Content:");
        System.out.println(content);

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("309552026\n");

        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='res']//h3"));

        String text = findElements.get(1).getText();
        System.out.println("\nGoogle Text:");
        System.out.println(text);

        driver.quit();
    }
}
