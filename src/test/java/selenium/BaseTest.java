package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private final static int SECONDSTOWAIT = 10;
    public WebDriver driver;
    //public WebDriverWait wait;
    public String baseURL;// "http://www.leafground.com/home.html";
    public Page page;

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        //driver = WebDriverFactory.GetDriver("Chrome");
        //driver = WebDriverFactory.GetDriver(FileUtils.getConfigProperty("browser"));

        //baseURL = FileUtils.getConfigProperty("baseUrl");

        baseURL = "http://www.leafground.com/home.html";

        driver.manage().timeouts().implicitlyWait(SECONDSTOWAIT, TimeUnit.SECONDS);

        //Maximize Window
        driver.manage().window().maximize();

        //Instantiate the selenium.Page Class
        page = new Page(driver);
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
}
