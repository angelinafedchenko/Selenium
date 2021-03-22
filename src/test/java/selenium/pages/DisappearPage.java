package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Page;


public class DisappearPage {

    private final Page page;

    private final int WAIT_TIME = 10;
    private final int PAUSE_TIME = 500;

    public By disappearPage = By.xpath("//h5[contains(text(), 'Wait to Disappear')]");
    public By returnToMainPage = By.xpath("//img[@alt='logo Testleaf']");
    public By waitForDisappear = By.xpath("//button[@id='btn']");


    //*********Constructor*********
    public DisappearPage(Page p) {
        page = p;
    }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public DisappearPage goToDisappearPage() throws InterruptedException {
        WebElement element = page.driver.findElement(disappearPage);
        element.click();
        pause(PAUSE_TIME);
        return this;
    }

    public DisappearPage waitForDisappear() {
        page.wait = new WebDriverWait(page.driver, WAIT_TIME);
        if (page.wait.until(ExpectedConditions.invisibilityOfElementLocated(waitForDisappear))) {
            System.out.println("Button 'I'm going to disappear...' is disappeared.");
       } else {
           System.out.println("Button is NOT disappeared.");
       }
       page.click(returnToMainPage);
        return this;
    }

}





