package com.example.recyclerapp.common.recycler.delegate;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface AdapterDelegate {

    ViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(ViewHolder holder, DelegateItem item);

    Boolean isOfViewType(DelegateItem item);
}
