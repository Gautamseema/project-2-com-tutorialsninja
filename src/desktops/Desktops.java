package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.time.Duration;
import java.util.List;

public class Desktops extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));

        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // Verify the Product will arrange in Descending order.
        List<WebElement> List = driver.findElements(By.xpath("//select[@id='input-sort']"));
        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i).getText());
            String exp = List.get(i).getText();
            String actual = List.get(i).getText();
            Assert.assertEquals("Price not ordered : High to Low ", exp, actual);
            System.out.println("Produts display in descending order");
        }
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {

        //Mouse hover on Currency Dropdown and click
        mouseHoverToElement(By.xpath("//span[text()='Currency']"));
       // clickOnElement(By.xpath("//ul[@class='dropdown-menu']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
       mouseHoverToElementAndClick(By.linkText("Desktops"));
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        String expectedText ="HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals(expectedText ,actualText );
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button") );
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
               e.click();
                break;
            }
        }
        //Enter Qty "1” using Select class.
        sendTextToElement(By.id("input-quantity"), "1");
        //Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
        //Verify text message
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("add in cart",expectedText1,actualText1  );
       //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
//        String expectedText2= "Shopping Cart";
//        String actualText2 = getTextFromElement(By.xpath("//div[@id='content' and @class='col-sm-12']//h1[text()='Shopping Cart     (5.00kg) ']"));
//        Assert.assertEquals("message display",expectedText2 ,actualText2 );
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='content']//h1")).contains("Shopping Cart"));
       Assert.assertEquals("Product name not matched", "HP LP3065", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));
        Assert.assertTrue("Delivery date not matched", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2023-11-30"));
        Assert.assertEquals("Model not matched", "Product 21", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")));
       Assert.assertEquals("Total not matched", "£74.73", getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));
    }

    @After
    public void tearDown() {
       closeBrowser();
   }

}


