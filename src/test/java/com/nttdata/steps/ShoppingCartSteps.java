package com.nttdata.steps;

import com.nttdata.page.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ShoppingCartSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public ShoppingCartSteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    /**
     * Obtiene el título de la pagina del carrito de compras
     * @return el título de la pagina del carrito de compras
     */
    public String getShoppingCartTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartPage.pageTitle));
        return titleElement.getText();
    }

    /**
     * Obtiene el precio del producto
     * @return el precio del producto
     */
    public float getProductPrice() {
        String priceText = this.driver.findElement(ShoppingCartPage.productPrice).getText();
        String cleanedPriceText = priceText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedPriceText);
    }

    /**
     * Obtiene la cantidad del producto
     * @return la cantidad del producto
     */
    public float getProductQuantity() {
        String quantityText = this.driver.findElement(ShoppingCartPage.productQuantity).getAttribute("value");
        String cleanedQuantityText = quantityText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedQuantityText);
    }

    /**
     * Obtiene el precio total del carrito de compras
     * @return el precio total del carrito de compras
     */
    public float getTotal() {
        String totalText = this.driver.findElement(ShoppingCartPage.total).getText();
        String cleanedTotalText = totalText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedTotalText);
    }

}
