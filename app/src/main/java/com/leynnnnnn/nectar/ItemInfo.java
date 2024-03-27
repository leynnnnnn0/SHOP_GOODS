package com.leynnnnnn.nectar;

public class ItemInfo {
    private int itemImage;
    private String itemName;
    private int itemPieces;
    private double itemPrice;

    public ItemInfo(int itemImage, String itemName, int itemPieces, double itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPieces = itemPieces;
        this.itemPrice = itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPieces() {
        return itemPieces;
    }

    public void setItemPieces(int itemPieces) {
        this.itemPieces = itemPieces;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
