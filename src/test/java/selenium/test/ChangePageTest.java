package selenium.test;

        import selenium.BaseTest;
        import org.testng.annotations.Test;


public class ChangePageTest extends BaseTest {

    @Test
    public void TestChangePage() throws InterruptedException {
        page.open(baseURL);
        page.changePage().goToTextChangePage();
        page.changePage().waitForTextChange();

    }

}


