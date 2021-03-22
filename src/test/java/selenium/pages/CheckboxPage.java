package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.Page;

public class CheckboxPage {

    private final Page page;

    private final int WAIT_TIME = 10;
    private final int PAUSE_TIME = 500;

    public By returnToMainPage = By.xpath("//img[@alt='logo Testleaf']");
    public By checkboxPage = By.xpath("//h5[contains(text(), 'Checkbox')]");
    public By javaCheckbox = By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]");
    public By unselectedCheckbox = By.xpath("//*[@class='example'][3]/div[2]/input");
    public By optionCheckboxOne = By.xpath("//*[@class='example'][4]/div[1]/input");
    public By optionCheckboxFive = By.xpath("//*[@class='example'][4]/div[5]/input");

    //*********Constructor*********
    public CheckboxPage(Page p) {
        page = p;
    }


    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }


    public CheckboxPage goToCheckboxPage() throws InterruptedException {
        pause(PAUSE_TIME);
        WebElement element = page.driver.findElement(checkboxPage);
        element.click();
        return this;
    }

    public CheckboxPage selectCheckboxes() throws InterruptedException {
        page.driver.findElement(javaCheckbox).click();
        page.driver.findElement(unselectedCheckbox).click();
        page.driver.findElement(optionCheckboxOne).click();
        page.driver.findElement(optionCheckboxFive).click();
        pause(PAUSE_TIME);
        page.driver.findElement(returnToMainPage);
        return this;
    }

}





