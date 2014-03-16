/*
*  One problem which I saw here that if we open
*   https://www.facebook.com in the window you can't
*   switch to that handle
 */



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class test {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver1 = new FirefoxDriver();
        driver1.get("http://www.google.com");
        Set handle1 = driver1.getWindowHandles();
        JavascriptExecutor js = null;
//        if (driver1 instanceof JavascriptExecutor) {
            js = (JavascriptExecutor)driver1;
//        }

        String script="window.open(\"\",\"window1\");";
        js.executeScript(script);

        script="window.open(\"\",\"window2\");";
        js.executeScript(script);

        script="window.open(\"\",\"window3\");";
        js.executeScript(script);
//        Then to switch windows, use the window handles:
        /*for (String handle : driver1.getWindowHandles()) {
            driver1.switchTo().window(handle);
        }*/
        driver1.switchTo().window("window1");
        driver1.get("http://www.google.com");
        driver1.switchTo().window("window2");
        driver1.get("http://www.google.com");
        driver1.switchTo().window("window3");
        driver1.get("http://www.google.com");
        driver1.switchTo().window("window2");
        driver1.get("http://www.gmail.com");
        driver1.switchTo().window("window1");
        driver1.get("http://www.yahoo.com");
        driver1.switchTo().window("window3");
        driver1.get("http://www.wikipedia.com");
        driver1.close();
        driver1.switchTo().window("window2");
        driver1.close();
        driver1.switchTo().window("window1");
        driver1.close();
         for (String handle : driver1.getWindowHandles()) {
            driver1.switchTo().window(handle);
        }
        driver1.get("https://www.facebook.com");
        Thread.sleep(3000);
        driver1.quit();
    }
}
