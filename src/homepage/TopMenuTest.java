package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility  {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        clickOnElement(By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']"));
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHoverToElementAndClick(By.linkText("Desktops"));
        selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[normalize-space()='Desktop"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));
        selectMenu("Show All Laptops & Notebooks");
        String expectedText1 = "Laptops & Notebooks";

        String actualText1 = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        Assert.assertEquals("Navigate to Laptops & Notebooks page",expectedText1,actualText1 );

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        mouseHoverToElementAndClick(By.linkText("Components"));
        selectMenu("Show All Components");
        String expectedText2 = "Components";
        String actualText2 = getTextFromElement(By.xpath("//h2[normalize-space()='Components')]"));
        Assert.assertEquals("Navigate to Component page",expectedText2,actualText2);
    }

    @After
    public void tearDown(){
        closeBrowser();
   }
}
