package com.example.recyclerapp.common.recycler.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.recyclerapp.common.recycler.delegate.AdapterDelegate;
import com.example.recyclerapp.common.recycler.delegate.DelegateItem;
import com.example.recyclerapp.common.recycler.delegate.DelegateItemCallback;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends ListAdapter<DelegateItem, ViewHolder> {

    private List<AdapterDelegate> delegates = new ArrayList<>();

    public BaseAdapter() {
        super(new DelegateItemCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType >= 0) {
            return delegates.get(viewType).onCreateViewHolder(parent);
        } else {
            return new EmptyViewHolder(parent.getContext());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            delegates.get(getItemViewType(position)).onBindViewHolder(holder, getItem(position));
        } catch (IndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public int getItemViewType(int position) {
        for (int i = 0; i < delegates.size(); i++) {
            if (delegates.get(i).isOfViewType(getCurrentList().get(position))) {
                return i;
            }
        }
        return -1;
    }

    public void addDelegate(AdapterDelegate delegate) {
        delegates.add(delegate);
    }
}

class EmptyViewHolder extends ViewHolder {

    public EmptyViewHolder(Context context) {
        super(new View(context));
    }
}
