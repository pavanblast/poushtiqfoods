package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.CommonMethods;
import org.testng.annotations.*;

import java.time.Duration;


public class userFunctionalTestCases {

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

        driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("Oil") || productText.contains("Ghee")), STR."Invalid product category found for \{productText}");
        }

        driver.navigate().back();
        actions = new Actions(driver);
        actions.scrollByAmount(-500, -500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sweets & snacks']")));
        driver.findElement(By.xpath("//*[text()='Sweets & snacks']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")));
        int size2 = driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/div/div")).size();

        for (int i = 1; i < size2 - 1; i++) {
            String xpath = STR."//*[@id='root']/div[2]/div[2]/div/div[\{i}]/a/div[2]/h3";
            String productText = driver.findElement(By.xpath(xpath)).getText();

            Assert.assertTrue((productText.contains("Millet") || productText.contains("Cookies")), STR."Invalid product category found for \{productText}");
        }

        driver.navigate().back();
        actions.scrollByAmount(-500, -500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Pickles & Powders'])[2]")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sweets & snacks']")));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Pickles & Powders'])[2]")));
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
    public void TC3AddIemToCart() {

        driver.get("https://poushtiqfoods.netlify.app/");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(-500, -500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Cooking Oil & Ghee']")));
        driver.findElement(By.xpath("//*[text()='Cooking Oil & Ghee']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element1 = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[1]")));
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[1]")).click();
        int count = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/nav[1]/div/div[4]/a/span")).getText());
        Assert.assertEquals(count, 1, "Item not added to the cart");

        WebElement element2 = driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]"));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[2]")));
        driver.findElement(By.xpath("(//*[text()='Add to Cart'])[2]")).click();
        count = Integer.parseInt(driver.findElement(By.xpath("//*[@id='root']/div/nav[1]/div/div[4]/a/span")).getText());
        Assert.assertEquals(count, 2, "Item not added to the cart");

    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
