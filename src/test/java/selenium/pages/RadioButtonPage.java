package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Page;

public class RadioButtonPage {

    private final Page page;

    private final int WAIT_TIME = 10;
    private final int PAUSE_TIME = 500;

    public By returnToMainPage = By.xpath("//img[@alt='logo Testleaf']");
    public By radioButtonPage = By.xpath("//h5[contains(text(), 'Radio Button')]");
    public By radioElemYes = By.xpath("//input[@id='yes']");
    public By radioElemUnchecked = By.xpath("//input[@name='news' and @value='0']");
    public By radioElemAbove40 = By.xpath("//input[@name='news' and @value='0']");

    //*********Constructor*********
    public RadioButtonPage(Page p) {
        page = p;
    }


    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }


    public RadioButtonPage goToRadioButtonPage() throws InterruptedException {
        pause(PAUSE_TIME);
        WebElement element = page.driver.findElement(radioButtonPage);
        element.click();
        return this;
    }

    public RadioButtonPage clickRadioButtons() throws InterruptedException {
        WebElement elementYes = page.driver.findElement(radioElemYes);
        WebElement elementUnchecked = page.driver.findElement(radioElemUnchecked);
        WebElement elementAbove40Years = page.driver.findElement(radioElemAbove40);
        elementYes.click();
        elementUnchecked.click();
        elementAbove40Years.click();
        pause(PAUSE_TIME);
        page.click(returnToMainPage);
        return this;
    }


}




