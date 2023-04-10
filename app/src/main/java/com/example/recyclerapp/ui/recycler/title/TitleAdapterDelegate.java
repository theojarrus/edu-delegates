package com.example.recyclerapp.ui.recycler.title;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.recyclerapp.common.recycler.delegate.AdapterDelegate;
import com.example.recyclerapp.common.recycler.delegate.DelegateItem;
import com.example.recyclerapp.databinding.ViewTitleBinding;
import com.example.recyclerapp.ui.model.Title;

public class TitleAdapterDelegate implements AdapterDelegate {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ViewTitleBinding binding = ViewTitleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TitleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, DelegateItem item) {
        ((TitleViewHolder) holder).bind((Title) item);
    }

    @Override
    public Boolean isOfViewType(DelegateItem item) {
        return item instanceof Title;
    }
}

class TitleViewHolder extends ViewHolder {
    private final ViewTitleBinding binding;

    public TitleViewHolder(ViewTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Title item) {
        binding.text.setText(item.getText());
    }
}

