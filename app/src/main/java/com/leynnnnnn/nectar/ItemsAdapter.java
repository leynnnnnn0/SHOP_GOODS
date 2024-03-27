package com.leynnnnnn.nectar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    Context context;
    ItemInfo[] itemInfo;

    public ItemsAdapter(Context context, ItemInfo[] itemInfo) {
        this.context = context;
        this.itemInfo = itemInfo;
    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        holder.itemImage.setImageResource(itemInfo[position].getItemImage());
        holder.itemName.setText(itemInfo[position].getItemName());
        holder.itemPieces.setText(String.valueOf(itemInfo[position].getItemPieces()));
        holder.itemPrice.setText(String.valueOf(itemInfo[position].getItemPrice()));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemPieces, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPieces = itemView.findViewById(R.id.itemPieces);
            itemPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
