package com.leynnnnnn.nectar;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ItemInfo implements Parcelable {
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

    protected ItemInfo(Parcel in) {
        itemImage = in.readInt();
        itemName = in.readString();
        itemPieces = in.readInt();
        itemPrice = in.readDouble();
    }

    public static final Creator<ItemInfo> CREATOR = new Creator<ItemInfo>() {
        @Override
        public ItemInfo createFromParcel(Parcel in) {
            return new ItemInfo(in);
        }

        @Override
        public ItemInfo[] newArray(int size) {
            return new ItemInfo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeInt(itemImage);
        dest.writeString(itemName);
        dest.writeInt(itemPieces);
        dest.writeDouble(itemPrice);
    }
}
