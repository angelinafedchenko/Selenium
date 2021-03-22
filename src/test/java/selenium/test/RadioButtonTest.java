package selenium.test;

import selenium.BaseTest;
import org.testng.annotations.Test;


public class RadioButtonTest extends BaseTest {

    @Test
    public void TestRadioButtonPage() throws InterruptedException {
        page.open(baseURL);
        page.radioButtonPage().goToRadioButtonPage();
        page.radioButtonPage().clickRadioButtons();

    }

}

