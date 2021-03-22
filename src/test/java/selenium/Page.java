package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.*;


public class Page {

    private int timeOut = 15;

    public WebDriver driver;
    public WebDriverWait wait;

    //Pages
    private ButtonsPage buttonsPage;
    private DisappearPage disappearPage;
    private ChangePage changePage;
    private RadioButtonPage radioButtonPage;
    private CheckboxPage checkboxPage;

    //Constructor
    public Page(WebDriver driver) {
        this.driver = driver;

        //Create wait object for all pages.
        wait = new WebDriverWait(this.driver, timeOut);
    }

    public ButtonsPage buttonsPage() {
        return (buttonsPage == null) ? (buttonsPage = new ButtonsPage(this)) : (buttonsPage);
    }

    public DisappearPage disappearPage() {
        return (disappearPage == null) ? (disappearPage = new DisappearPage(this)) : (disappearPage);
    }

    public ChangePage changePage() {
        return (changePage == null) ? (changePage = new ChangePage(this)) : (changePage);
    }

    public RadioButtonPage radioButtonPage() {
        return (radioButtonPage == null) ? (radioButtonPage = new RadioButtonPage(this)) : (radioButtonPage);
    }

    public CheckboxPage checkboxPage() {
        return (checkboxPage == null) ? (checkboxPage = new CheckboxPage(this)) : (checkboxPage);
    }



    // Open URL
    public void open(String url) {
        driver.get(url);
    }

    //Clicks by selector
    public void click(By selector) {
        driver.findElement(selector).click();
    }

    //Clicks on WebElement
    public void click(WebElement element) {
        element.click();
    }

    // Write Text to element via Selector
    public void typeText(By selector, String text) {
        driver.findElement(selector).sendKeys(text);
    }

    // Write Text to WebElement
    public void typeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Get Text from By selector
    public String getText(By selector) {
        return driver.findElement(selector).getText();
    }

    // Get Text from Webelement
    public String getText(WebElement element) {
        return element.getText();
    }

}