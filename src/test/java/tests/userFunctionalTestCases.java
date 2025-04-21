package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.CommonMethods;
import org.testng.annotations.*;

import java.time.Duration;


public class userFunctionalTestCases {

    private static final Logger log = LoggerFactory.getLogger(userFunctionalTestCases.class);
    CommonMethods CommonMethods = new CommonMethods();
    WebDriver driver;
    Actions actions;

    @BeforeTest
    public void setupDriver() {
        driver = CommonMethods.getWebDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void TC1Verifyproductsarelistedbycategory() throws InterruptedException {
        driver.get("https://poushtiqfoods.netlify.app/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cooking Oil & Ghee']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element1);

        driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("Oil") || productText.contains("Ghee")), STR."Invalid product category found for \{productText}");
        }

        driver.navigate().back();
        actions = new Actions(driver);
        actions.scrollByAmount(-500, -500);

        WebElement element2 = driver.findElement(By.xpath("//*[text()='Sweets & snacks']"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sweets & snacks']")));
        driver.findElement(By.xpath("//*[text()='Sweets & snacks']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size2 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size2 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("Millet") || productText.contains("Cookies")), STR."Invalid product category found for \{productText}");
        }

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Pickles & Powders'])[2]")));

        WebElement element3 = driver.findElement(By.xpath("(//*[text()='Pickles & Powders'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element3);
        driver.findElement(By.xpath("(//*[text()='Pickles & Powders'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size3 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size3 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue(productText.contains("Masala"), STR."Invalid product category found for \{productText}");
        }

        /*driver.findElement(By.xpath("//*[text()='Breakfast']")).click();

        int size4 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size4;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }*/

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Superfood & Millets'])[2]")));
        WebElement element5 = driver.findElement(By.xpath("(//*[text()='Superfood & Millets'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element5);
        driver.findElement(By.xpath("(//*[text()='Superfood & Millets'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size5 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size5 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("Millet") || productText.contains("Cookies")), STR."Invalid product category found for \{productText}");
        }

        /*driver.findElement(By.xpath("//*[text()='Dry Fruits, Nuts & Berries']")).click();

        int size6 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size6;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }

        driver.findElement(By.xpath("//*[text()='Combos']")).click();

        int size7 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size7;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }*/
    }

    @Test(priority = 2)
    public void TC2VerifyEachProductHasNameImageDescriptionPriceAndStatus() throws InterruptedException {
        driver.get("https://poushtiqfoods.netlify.app/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cooking Oil & Ghee']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element1);

        driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            String xpath2 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productDescription = driver.findElement(By.xpath(xpath2)).getText();

            String xpath3 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productPrice = driver.findElement(By.xpath(xpath3)).getText();

            Assert.assertTrue((productText.contains("Oil") || productText.contains("Ghee")), STR."Invalid product category found for \{productText}");
            Assert.assertFalse(productDescription.isEmpty(), STR."Product Description not found for \{productText}");
            Assert.assertFalse(productPrice.isEmpty(), STR."Product Price not found for \{productText}");
        }

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);

        WebElement element2 = driver.findElement(By.xpath("//*[text()='Sweets & snacks']"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element2);

        driver.findElement(By.xpath("//*[text()='Sweets & snacks']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size2 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size2 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            String xpath2 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productDescription = driver.findElement(By.xpath(xpath2)).getText();

            String xpath3 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productPrice = driver.findElement(By.xpath(xpath3)).getText();

            Assert.assertTrue((productText.contains("Millet") || productText.contains("Cookies")), STR."Invalid product category found for \{productText}");
            Assert.assertFalse(productDescription.isEmpty(), STR."Product Description not found for \{productText}");
            Assert.assertFalse(productPrice.isEmpty(), STR."Product Price not found for \{productText}");
        }

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);

        WebElement element3 = driver.findElement(By.xpath("(//*[text()='Pickles & Powders'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element3);

        driver.findElement(By.xpath("(//*[text()='Pickles & Powders'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size3 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size3 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            String xpath2 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productDescription = driver.findElement(By.xpath(xpath2)).getText();

            String xpath3 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productPrice = driver.findElement(By.xpath(xpath3)).getText();

            Assert.assertTrue(productText.contains("Masala"), STR."Invalid product category found for \{productText}");
            Assert.assertFalse(productDescription.isEmpty(), STR."Product Description not found for \{productText}");
            Assert.assertFalse(productPrice.isEmpty(), STR."Product Price not found for \{productText}");
        }

        /*driver.findElement(By.xpath("//*[text()='Breakfast']")).click();

        int size4 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size4;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }*/

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Superfood & Millets'])[2]")));

        WebElement element5 = driver.findElement(By.xpath("(//*[text()='Superfood & Millets'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element5);
        driver.findElement(By.xpath("(//*[text()='Superfood & Millets'])[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size5 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size5 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            String xpath2 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productDescription = driver.findElement(By.xpath(xpath2)).getText();

            String xpath3 = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productPrice = driver.findElement(By.xpath(xpath3)).getText();

            Assert.assertTrue((productText.contains("Millet") || productText.contains("Cookies")), STR."Invalid product category found for \{productText}");
            Assert.assertFalse(productDescription.isEmpty(), STR."Product Description not found for \{productText}");
            Assert.assertFalse(productPrice.isEmpty(), STR."Product Price not found for \{productText}");
        }

        /*driver.findElement(By.xpath("//*[text()='Dry Fruits, Nuts & Berries']")).click();

        int size6 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size6;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }

        driver.findElement(By.xpath("//*[text()='Combos']")).click();

        int size7 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for(int i=0;i<size7;i++){
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("oil") || productText.contains("ghee")), STR."Invalid product category found for \{productText}");
        }*/
    }

    @Test(priority = 3)
    public void TC3AddIemToCart() throws InterruptedException {

        driver.get("https://poushtiqfoods.netlify.app/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cooking Oil & Ghee']")));

        driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[1]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element1);
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")));
        Thread.sleep(2000);
        int count1 = Integer.parseInt(driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")).getText());
        Assert.assertEquals(count1, 1, "Item not added to the cart");


        WebElement element2 = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[2]")));
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")));
        Thread.sleep(2000);
        int count2 = Integer.parseInt(driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")).getText());
        Assert.assertEquals(count2, 2, "Item not added to the cart");


        Thread.sleep(2000);
        WebElement element3 = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[3]")));
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[3]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")));
        Thread.sleep(3000);
        int count3 = Integer.parseInt(driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")).getText());
        Assert.assertEquals(count3, 3, "Item not added to the cart");

    }

    @Test(priority = 4)
    public void TC5AdjustItemQuantity() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")));
        driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[1]/div[1]/div[2]/button[2]")).click();
        int count1 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[1]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count1, 2, "Item quantity not incremented");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/button[2]")).click();
        int count2 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count2, 2, "Item quantity not incremented");


        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[3]/div[1]/div[2]/button[2]")).click();
        int count3 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[3]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count3, 2, "Item quantity not incremented");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
        int count4 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[1]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count4, 1, "Item quantity not decremented");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/button[1]")).click();
        int count5 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[2]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count5, 1, "Item quantity not decremented");


        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[3]/div[1]/div[2]/button[1]")).click();
        int count6 = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[3]/div[1]/div[2]/span")).getText());
        Assert.assertEquals(count6, 1, "Item quantity not decremented");

    }

    @Test(priority = 5, dependsOnMethods = {"TC3AddIemToCart"})
    public void TC4RemoveItemsFromCart() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element1);
        driver.findElement(By.xpath("//*[@placeholder='Search entire store here...']/../../div[4]/a/span")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div/div[2]/button")).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div/div[2]/button")).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div[1]/div[2]/button")));
        driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[1]/div/div[2]/button")).click();
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
