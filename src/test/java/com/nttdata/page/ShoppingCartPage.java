package com.nttdata.page;

import org.openqa.selenium.By;

public class ShoppingCartPage {

    //Localizadores de elementos
    public static By pageTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By productPrice = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]");
    public static By productQuantity = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");
    public static By total = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");
}
