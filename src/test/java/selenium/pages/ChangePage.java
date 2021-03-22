package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Page;

public class ChangePage {

        private final Page page;

        private final int WAIT_TIME = 10;
        private final int PAUSE_TIME = 500;

        public By returnToMainPage = By.xpath("//img[@alt='logo Testleaf']");
        public By textChangePage = By.xpath("//h5[contains(text(), 'Wait for Text Change')]");
        public By waitForDisappear = By.xpath("//button[@id='btn']");


    //*********Constructor*********
        public ChangePage(Page p) {
                page = p;
        }


        private void pause(int i) throws InterruptedException {
                Thread.sleep(i);
        }


    public ChangePage goToTextChangePage() throws InterruptedException {
        pause(PAUSE_TIME);
        WebElement element = page.driver.findElement(textChangePage);
        element.click();
        return this;
    }

    public ChangePage waitForTextChange() throws InterruptedException {
        String originalText = page.driver.findElement(waitForDisappear).getText();
        page.wait = new WebDriverWait(page.driver, 30);
        page.wait.until(ExpectedConditions.invisibilityOfElementWithText(waitForDisappear, originalText));
        String changedText = page.driver.findElement(waitForDisappear).getText();
        System.out.println("Changed text: " + changedText);
        page.click(returnToMainPage);
        return this;
    }


}






