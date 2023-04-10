package com.example.recyclerapp.ui.recycler.user;

import com.example.recyclerapp.domain.model.User;

public interface UserClickListener {

    void onClick(User item, int position);
}
