package com.sophie.miller.roomwithlivedata.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sophie.miller.roomwithlivedata.database.ProductDatabase;
import com.sophie.miller.roomwithlivedata.objects.Product;
import com.sophie.miller.roomwithlivedata.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    ProductDatabase database;
    List<Product> products = new ArrayList<Product>();

    public DatabaseAdapter(Context context){
        database = ProductDatabase.getInstance(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemProductBinding binding = ItemProductBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.itemDescription.setText(product.getProductDescription());
        holder.binding.itemName.setText(product.getProductName());
        holder.binding.itemPrice.setText(String.format("%s",product.getPrice()));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setItems(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}
