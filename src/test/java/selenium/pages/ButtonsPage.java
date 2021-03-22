package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import selenium.Page;

public class ButtonsPage {

    private final Page page;

    private final int WAIT_TIME = 10;
    private final int PAUSE_TIME = 500;

    public By buttonsPage = By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[2]/a");
    public By getPositionButton = By.xpath("//*[@id=\"position\"]");
    public By extractButtonColor = By.xpath("//*[@id=\"color\"]");
    public By extractButtonSize = By.xpath("//*[@id=\"size\"]");
    public By returnToMainPage = By.xpath("//img[@alt='logo Testleaf']");


    //*********Constructor*********
    public ButtonsPage(Page p) {
        page = p;
    }

    public ButtonsPage clickButtonsSection() throws InterruptedException {
        page.click(buttonsPage);
        pause(PAUSE_TIME);
        return this;
    }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public ButtonsPage clickOnGetPositionButton() throws InterruptedException {
        WebElement element = page.driver.findElement(getPositionButton);
        Point position = element.getLocation();
        System.out.printf("Get Position button's position: %s, %s\n", position.getX(), position.getY());
        new Actions(page.driver).moveByOffset(position.getX(), position.getY()).click().build().perform();
        pause(PAUSE_TIME);
        return this;
    }

    public String extractButtonColor() throws InterruptedException {
        String hexColor = page.driver.findElement(extractButtonColor).getCssValue("background-color");
        String textColor = page.driver.findElement(extractButtonColor).getAttribute("style");

        System.out.printf("Background text style and hex code 'What color am I?' button: %s(%s)\n",
                textColor.substring(18, textColor.length() - 1), Color.fromString(hexColor).asHex());

        pause(PAUSE_TIME);
        return hexColor;
    }

    public ButtonsPage extractButtonSize() throws InterruptedException {
        WebElement element = page.driver.findElement(extractButtonSize);
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        System.out.println("My size button's width: " + elementWidth + " , height: " + elementHeight);
        page.click(returnToMainPage);
        pause(PAUSE_TIME);
        return this;
    }


}




