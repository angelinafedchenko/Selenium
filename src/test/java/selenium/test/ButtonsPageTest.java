package selenium.test;

import selenium.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ButtonsPageTest extends BaseTest {

    @Test
    public void TestButtonsPage() throws InterruptedException {
        page.open(baseURL);
        page.buttonsPage().clickButtonsSection();
        page.buttonsPage().clickOnGetPositionButton();
        String buttonColor = page.buttonsPage().extractButtonColor();
        page.buttonsPage().extractButtonSize();

        Assert.assertNotNull(
                buttonColor,
                "Color not founded");
    }
    }


