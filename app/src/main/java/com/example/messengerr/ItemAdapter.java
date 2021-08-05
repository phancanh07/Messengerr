package com.example.messengerr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.messengerr.databinding.ItemBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterHolder> {
    List<Chatbot> messes;

    public ItemAdapter() {
    }

    public void setMesses(List<Chatbot> messes) {
        this.messes = messes;
        notifyDataSetChanged();
    }

    @Override
    public ItemAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBinding itemBookBinding = ItemBinding.inflate(layoutInflater, parent, false);
        return new ItemAdapterHolder(itemBookBinding);
    }

    @Override
    public void onBindViewHolder(ItemAdapterHolder holder, int position) {
        holder.itemBookBinding.setItem(messes.get(position));
        holder.itemBookBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (messes != null) {
            return messes.size();
        }
        return 0;

    }

    public class ItemAdapterHolder extends RecyclerView.ViewHolder {
        ItemBinding itemBookBinding;

        public ItemAdapterHolder(ItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBookBinding = itemView;
        }
    }
}
