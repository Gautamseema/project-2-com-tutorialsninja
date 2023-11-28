package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotesBookTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // Select sort by Price(High>Low)
        selectByVisibleTextFromDropDown(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price(High>Low)");
        // Verify the Product will arrange in High>Low order.
        List<WebElement> List = driver.findElements(By.xpath("//select[@id='input-sort']"));
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i).getText());
            String exp = List.get(i).getText();
            String actual = List.get(i).getText();
            Assert.assertEquals("Price not ordered : High to Low ", exp, actual);
            System.out.println("Produts display in High>Low order");
        }}

        @Test
        public void verifyThatUserPlaceOrderSuccessfully () {

            //Mouse hover on Laptops & Notebooks Tab and click
            mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
            // Select sort by Price(High>Low)
      //      selectByVisibleTextFromDropDown(By.id("input-sort") , "Price (High>Low)");
            // select Product
            clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
            //Verify the text
            String expectedText = "MacBook";
            String actualText = getTextFromElement(By.xpath("//h1[text()='MacBook']"));
            Assert.assertEquals(expectedText, actualText);
            //Click on add cart button
            clickOnElement(By.xpath("//button[text()='Add to Cart']") );
            // Verify  text message
            String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
                    "×";

            String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            Assert.assertEquals(expectedText1 ,actualText1 );
            //Click on link “shopping cart” display into success messageg
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']") );
            //Verify the text "Shopping Cart"
            Assert.assertEquals("Product ", "Shopping Cart  (0.00kg)", getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")));
            Assert.assertEquals("Product name not matched", "MacBook", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));
            sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");
            clickOnElement(By.xpath("//button[contains(@data-original-title, 'Update')]"));
            Assert.assertTrue("Cart not modified", getTextFromElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"));
        //    Assert.assertEquals("Total not matched", "£737.45", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));
 // Click on “Checkout” button
            clickOnElement(By.xpath("Click on “Checkout” button") );
// Verify the text Checkout
            Assert.assertEquals("Verify message","Checkout",getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']")));
//Verify the text new Customer
            Assert.assertEquals("New Customer",getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']")) );
 //Click on guest checkout
            clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']") );
//Click on “Continue” tab
            clickOnElement(By.id("button-account"));
  // After fill mandatory field click on continue
            clickOnElement(By.xpath("button-register"));
                }



    @After
    public void tearDown() {
        closeBrowser();
    }
    }
