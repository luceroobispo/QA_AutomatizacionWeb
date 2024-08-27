package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    //Localizadores de elementos
    public static By categoriesList = By.id("top-menu");
    public static By subCategoryList = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul");
    public static By productCard = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
    public static By quantityInput = By.id("quantity_wanted");
    public static By addToCartButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By popupMessage = By.id("myModalLabel");

    public static By productPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By productQuantity = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By taxes = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[5]/span");
    public static By total = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By finishPurchaseButton = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");

}