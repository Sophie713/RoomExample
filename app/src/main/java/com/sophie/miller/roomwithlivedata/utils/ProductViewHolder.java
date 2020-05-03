package com.sophie.miller.roomwithlivedata.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sophie.miller.roomwithlivedata.databinding.ItemProductBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

ItemProductBinding binding;

    public ProductViewHolder(@NonNull ItemProductBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
