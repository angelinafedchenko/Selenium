package src.sel01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;


public class Homework8 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://www.leafground.com/pages/Window.html");

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).perform();

        driver.findElement(By.xpath("//button [text () = 'Open Multiple Windows']")).click();

        Thread.sleep(2000);

        //Display all windows titles in console
        Set<String> allWindowHandles = driver.getWindowHandles();
        String titleToSwitch = null;

        for (String window: allWindowHandles) {
            driver.switchTo().window(window);
            String title = driver.getTitle();
            System.out.println("Current title is: " + title);

            if (title.equals("TestLeaf - Interact with Buttons")) {
                titleToSwitch = window;
            }
        }

        //Switch to one of that windows - to ‘Interact with Buttons’ (Bond with Buttons)
        driver.switchTo().window(titleToSwitch);
        System.out.println("'Interact with Buttons' page was opened");

        //Make it full screen
        driver.manage().window().maximize();


        String text = driver.findElementByCssSelector("#size").getText();
        System.out.println("Button title is: " + text);

        Thread.sleep(2000);
        driver.quit();

    }
}
