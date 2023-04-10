package com.example.recyclerapp.ui.recycler.user;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.recyclerapp.common.recycler.delegate.AdapterDelegate;
import com.example.recyclerapp.common.recycler.delegate.DelegateItem;
import com.example.recyclerapp.databinding.ViewUserBinding;
import com.example.recyclerapp.domain.model.User;

public class UserAdapterDelegate implements AdapterDelegate {

    private UserClickListener listener;

    public UserAdapterDelegate() {
        // default
    }

    public UserAdapterDelegate(UserClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        ViewUserBinding binding = ViewUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, DelegateItem item) {
        ((UserViewHolder) holder).bind((User) item);
    }

    @Override
    public Boolean isOfViewType(DelegateItem item) {
        return item instanceof User;
    }
}

class UserViewHolder extends ViewHolder {
    private final ViewUserBinding binding;
    private final UserClickListener listener;

    public UserViewHolder(ViewUserBinding binding, UserClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(User item) {
        binding.name.setText(item.getName());
        binding.email.setText(item.getEmail());
        binding.getRoot().setOnClickListener(v -> listener.onClick(item, getAdapterPosition()));
    }
}

