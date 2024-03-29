package com.leynnnnnn.nectar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class CartDbHelper extends SQLiteOpenHelper {
    public CartDbHelper(@Nullable Context context) {
        super(context, "cart.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE cart_items (image INT, name TEXT, pieces INT, price NUMERIC)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cart_items");
    }

    public Boolean addItem(int image, String name, int pieces, double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("image", image);
        cv.put("name", name);
        cv.put("pieces", pieces);
        cv.put("price", price);

        long result = db.insert("cart_items", null, cv);
        return result > 0;
    };

    public boolean getCartItems(String itemName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart_items WHERE name = '" + itemName + "'", null);
        if (cursor.moveToNext()) {
            int quantity = cursor.getInt(2) + 1;
            ContentValues cv = new ContentValues();
            cv.put("pieces", quantity);
            db.update("cart_items", cv, "name = '" + itemName + "'", null);
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public void deleteEverything() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM cart_items");
    }

    public List<ItemInfo> getAllItems() {
        List<ItemInfo> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart_items", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int image = cursor.getInt(0);
                String name = cursor.getString(1);
                int quantity = cursor.getInt(2);
                double price = cursor.getDouble(3);
                ItemInfo itemInfo = new ItemInfo(image, name, quantity, price);
                itemList.add(itemInfo);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return itemList;
    }

    public int getCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart_items", null);
        int count = cursor.getCount();
        cursor.close();
        return count;

    }

    public boolean removeFromCart(String itemName) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("cart_items", "name = ?", new String[] {itemName}) > 0;
    }
}
