package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.ShoppingCartSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStepsDef {

    private WebDriver driver;
    private LoginSteps loginSteps;
    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }
    private ShoppingCartSteps shoppingCartSteps(WebDriver driver){ return new ShoppingCartSteps(driver); }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }

    @Y("me logueo con mi usuario: {string} y clave: {string}")
    public void meLogueoConMiUsuarioYClave(String email, String password) {
        loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(email);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        inventorySteps(driver).navigateToCategory(category);
        inventorySteps(driver).navigateToSubcategory(subcategory);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        inventorySteps(driver).selectProduct();
        inventorySteps(driver).editQuantityProduct(quantity);
        inventorySteps(driver).addProductToCart();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        String message = inventorySteps(driver).getPopupMessage();
        message = message.replaceAll("[^\\p{IsAlphabetic}\\d\\s]", "");
        Assertions.assertEquals("Producto añadido correctamente a su carrito de compra", message);
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        float productPrice = inventorySteps(driver).getProductPrice();
        float quantity = inventorySteps(driver).getProductQuantity();
        float tax = inventorySteps(driver).getTaxes();
        float total = inventorySteps(driver).getTotal();
        Assertions.assertEquals(productPrice * quantity + tax, total);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        inventorySteps(driver).finishPurchase();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String title = shoppingCartSteps(driver).getShoppingCartTitle();
        Assertions.assertEquals("CARRITO", title);
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        float productPrice = shoppingCartSteps(driver).getProductPrice();
        float quantity = shoppingCartSteps(driver).getProductQuantity();
        float total = shoppingCartSteps(driver).getTotal();
        Assertions.assertEquals(productPrice * quantity, total);
    }
}
