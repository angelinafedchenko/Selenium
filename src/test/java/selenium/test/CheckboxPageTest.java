package selenium.test;

import selenium.BaseTest;
import org.testng.annotations.Test;


public class CheckboxPageTest extends BaseTest {

    @Test
    public void TestCheckboxPage() throws InterruptedException {
        page.open(baseURL);
        page.checkboxPage().goToCheckboxPage();
        page.checkboxPage().selectCheckboxes();
    }

}

