package com.example.recyclerapp.common.recycler.delegate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;

public class DelegateItemCallback extends ItemCallback<DelegateItem> {

    @Override
    public boolean areItemsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
        return oldItem.id().equals(newItem.id());
    }

    @Override
    public boolean areContentsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
        return oldItem.content().equals(newItem.content());
    }
}
