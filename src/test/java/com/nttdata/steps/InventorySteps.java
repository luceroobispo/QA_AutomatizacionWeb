package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventorySteps {

    private WebDriver driver;
    private WebDriverWait wait;

    //constructor
    public InventorySteps(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    /**
     * Navega a la categoría especificada por el usuario
     * @param category la categoría a la que se quiere navegar
     */
    public void navigateToCategory(String category) {
        List<WebElement> categories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(InventoryPage.categoriesList));

        for (WebElement categoryElement : categories) {
            WebElement linkElement = categoryElement.findElement(By.tagName("a"));
            String categoryText = linkElement.getText().trim().toUpperCase();
            String categoryToMatch = category.trim().toUpperCase();

            if (categoryText.equals(categoryToMatch)) {
                linkElement.click();
                return;
            }
        }

        throw new RuntimeException("Categoría no encontrada: " + category);
    }

    /**
     * Navega a la subcategoría especificada por el usuario
     * @param subcategory la subcategoría a la que se quiere navegar
     */
    public void navigateToSubcategory(String subcategory) {
        List<WebElement> subcategories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(InventoryPage.subCategoryList));

        for (WebElement subCategoryElement : subcategories) {
            WebElement linkElement = subCategoryElement.findElement(By.tagName("a"));
            String subCategoryText = linkElement.getText().trim().toUpperCase();
            String subCategoryToMatch = subcategory.trim().toUpperCase();

            if (subCategoryText.equals(subCategoryToMatch)) {
                linkElement.click();
                return;
            }
        }

        throw new RuntimeException("Subcategoría no encontrada: " + subcategory);
    }

    /**
     * Selecciona el producto
     */
    public void selectProduct() {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.productCard));
        productElement.click();
    }

    /**
     * Edita la cantidad del producto que se quiere agregar al carrito
     * @param quantity la cantidad del producto
     */
    public void editQuantityProduct(int quantity) {
        WebElement quantityElement = driver.findElement(InventoryPage.quantityInput);
        quantityElement.clear();
        quantityElement.sendKeys(Keys.BACK_SPACE);
        quantityElement.sendKeys(String.valueOf(quantity));
    }

    /**
     * Agrega el producto al carrito
     */
    public void addProductToCart() {
        WebElement addToCartElement = driver.findElement(InventoryPage.addToCartButton);
        addToCartElement.click();
    }

    /**
     * Obtiene el mensaje del popup
     * @return el mensaje del popup
     */
    public String getPopupMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.popupMessage));

        WebElement popupElement = driver.findElement(InventoryPage.popupMessage);
        return popupElement.getText();
    }

    /**
     * Obtiene el precio del producto
     * @return el precio del producto
     */
    public float getProductPrice() {
        String priceText = this.driver.findElement(InventoryPage.productPrice).getText();
        String cleanedPriceText = priceText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedPriceText);
    }

    /**
     * Obtiene la cantidad del producto
     * @return la cantidad del producto
     */
    public float getProductQuantity() {
        String quantityText = this.driver.findElement(InventoryPage.productQuantity).getText();
        String cleanedQuantityText = quantityText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedQuantityText);
    }

    /**
     * Obtiene los impuestos del producto
     * @return los impuestos del producto
     */
    public float getTaxes() {
        String taxesText = this.driver.findElement(InventoryPage.taxes).getText();
        String cleanedTaxesText = taxesText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedTaxesText);
    }

    /**
     * Obtiene el precio total del producto que se quiere comprar
     * @return el precio total del producto
     */
    public float getTotal() {
        String totalText = this.driver.findElement(InventoryPage.total).getText();
        String cleanedTotalText = totalText.replaceAll("\\D", "");
        return Float.parseFloat(cleanedTotalText);
    }

    /**
     * Finaliza la compra
     */
    public void finishPurchase() {
        WebElement finishPurchaseElement = driver.findElement(InventoryPage.finishPurchaseButton);
        finishPurchaseElement.click();
    }
}
