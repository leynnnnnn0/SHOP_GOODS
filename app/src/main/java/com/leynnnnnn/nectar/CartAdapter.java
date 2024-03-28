package com.leynnnnnn.nectar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Context context;
    ItemInfo[] itemInfo;

    public CartAdapter(Context context, ItemInfo[] itemInfo) {
        this.context = context;
        this.itemInfo = itemInfo;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_box, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(itemInfo[position].getItemImage());
        holder.name.setText(itemInfo[position].getItemName());
        holder.quantity.setText(String.valueOf(itemInfo[position].getItemPieces()));
        holder.price.setText("$".concat(String.valueOf(itemInfo[position].getItemPrice())));
    }

    @Override
    public int getItemCount() {
        return itemInfo.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, quantity, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cartItemImage);
            name = itemView.findViewById(R.id.cartItemName);
            quantity = itemView.findViewById(R.id.cartItemQuantity);
            price = itemView.findViewById(R.id.cartItemPrice);
        }
    }
}