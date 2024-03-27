package com.leynnnnnn.nectar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    Context context;
    ItemInfo[] itemInfo;
    private final ItemInterface itemInterface;

    public ItemsAdapter(Context context, ItemInfo[] itemInfo, ItemInterface itemInterface) {
        this.context = context;
        this.itemInfo = itemInfo;
        this.itemInterface = itemInterface;
    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_box, parent, false);
        return new ViewHolder(view, itemInterface);
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
        public ViewHolder(@NonNull View itemView, ItemInterface itemInterface) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.itemName);
            itemPieces = itemView.findViewById(R.id.itemPieces);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemInterface != null) {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION) {
                            itemInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
