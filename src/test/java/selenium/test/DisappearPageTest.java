package selenium.test;

import org.testng.annotations.Test;
import selenium.BaseTest;




public class DisappearPageTest extends BaseTest {

    @Test
    public void TestDisappearPage() throws InterruptedException {
        page.open(baseURL);
        page.disappearPage().goToDisappearPage();
        page.disappearPage().waitForDisappear();
    }

}


