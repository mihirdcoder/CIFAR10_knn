import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:8080/OddEven/";
        driver.get(baseUrl);
        String expected = "JSP Page";
        String actual = "";
        driver.manage().window().maximize();
        actual = driver.getTitle();
        if (actual.equals(expected)) {
            System.out.println("Title test passed");
        } else {
            System.out.println("Title test failed");}
            WebElement text=driver.findElement(By.name("no0"));
            text.sendKeys("5");
            WebElement text1=driver.findElement(By.name("no1"));
            text1.sendKeys("25");
            WebElement text2=driver.findElement(By.name("no2"));
            text2.sendKeys("50");
            WebElement text3=driver.findElement(By.name("no3"));
            text3.sendKeys("56");
            WebElement text4=driver.findElement(By.name("no4"));
            text4.sendKeys("23");
            WebElement text5=driver.findElement(By.name("no5"));
            text5.sendKeys("90");
            WebElement btn=driver.findElement(By.name("btn"));
            btn.click();
            System.out.println(" test script sucessful");
            driver.close();
    
    }
}
