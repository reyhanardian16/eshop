package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        String pageTitle = driver.getTitle();

        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void testInputProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");
        WebElement nameInput=driver.findElement(By.id("nameInput"));
        nameInput.clear();

        String productName= "Test";
        nameInput.sendKeys(productName);

        WebElement quantityInput=driver.findElement(By.id("quantityInput"));
        quantityInput.clear();

        String productQuantity= "100";
        quantityInput.sendKeys(productQuantity);

        WebElement submitButton=driver.findElement(By.tagName("button"));
        submitButton.click();

        assertEquals("Product List", driver.getTitle());

        WebElement productNameTable = driver.findElement(By.tagName("td"));
        assertEquals("Test", productNameTable.getText());
    }

    @Test
    void TestInputProduct_Negative(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/create");

        String productName;
        String productQuantity;
        WebElement nameInput=driver.findElement(By.id("nameInput"));
        WebElement quantityInput=driver.findElement(By.id("quantityInput"));
        WebElement submitButton=driver.findElement(By.tagName("button"));

        nameInput.clear();
        quantityInput.clear();

        productName = "";
        productQuantity = "100";
        nameInput.sendKeys(productName);
        quantityInput.sendKeys(productQuantity);

        submitButton.click();
        assertEquals("Create New Product", driver.getTitle());

        nameInput.clear();
        quantityInput.clear();

        productName = "Test";
        productQuantity = "-100";
        nameInput.sendKeys(productName);
        quantityInput.sendKeys(productQuantity);

        submitButton.click();
        assertEquals("Create New Product", driver.getTitle());
    }
}
