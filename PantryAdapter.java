package com.example.smartpantry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {
    public interface OnEditClickListener { void onEdit(PantryItem item); }

    private ArrayList<PantryItem> items;
    private final OnEditClickListener listener;

    public PantryAdapter(ArrayList<PantryItem> items, OnEditClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public void setItems(ArrayList<PantryItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = items.get(position);
        holder.name.setText(item.getName());
        holder.quantity.setText(item.getQuantity() + " " + item.getUnit());
        holder.edit.setOnClickListener(v -> listener.onEdit(item));
    }

    @Override
    public int getItemCount() { return items.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, quantity;
        Button edit;
        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvName);
            quantity = view.findViewById(R.id.tvQuantity);
            edit = view.findViewById(R.id.btnEdit);
        }
    }
}
