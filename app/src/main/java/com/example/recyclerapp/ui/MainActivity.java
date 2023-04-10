package com.example.recyclerapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerapp.common.recycler.adapter.BaseAdapter;
import com.example.recyclerapp.common.recycler.delegate.DelegateItem;
import com.example.recyclerapp.databinding.ActivityMainBinding;
import com.example.recyclerapp.domain.model.User;
import com.example.recyclerapp.ui.model.Title;
import com.example.recyclerapp.ui.recycler.title.TitleAdapterDelegate;
import com.example.recyclerapp.ui.recycler.user.UserAdapterDelegate;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final BaseAdapter adapter = new BaseAdapter();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter.addDelegate(new UserAdapterDelegate((item, position) -> {
            adapter.submitList(getNewUsers());
        }));

        adapter.submitList(getUsers());

        binding.recycler.setAdapter(adapter);
    }

    private List<DelegateItem> getUsers() {
        return Arrays.asList(
                new Title("Users"),
                new User("0", "Name1", "mail1@mail.com", ""),
                new User("1", "Name2", "mail2@mail.com", ""),
                new User("2", "Name3", "mail3@mail.com", ""),
                new User("3", "Name4", "mail4@mail.com", ""),
                new User("4", "Name5", "mail5@mail.com", ""),
                new User("5", "Name6", "mail6@mail.com", ""),
                new Title("Just a title"),
                new User("6", "Name7", "mail7@mail.com", ""),
                new User("7", "Name8", "mail8@mail.com", ""),
                new User("8", "Name9", "mail9@mail.com", ""),
                new Title("Another title"),
                new User("9", "Name10", "mail10@mail.com", ""),
                new User("10", "Name11", "mail11@mail.com", "")
        );
    }

    private List<DelegateItem> getNewUsers() {
        return Arrays.asList(
                new User("0", "Name1", "mail1@mail.com", ""),
                new User("1", "Name2", "mail2@mail.com", ""),
                new User("2", "Name3", "mail3@mail.com", ""),
                new User("3", "Name4", "mail4@mail.com", ""),
                new User("4", "Name5dfgdfg", "dfgdfg@mail.com", ""),
                new User("5", "dfgdfg", "mail6@dfgdfg.com", ""),
                new User("6", "Name7", "mail7@mail.com", ""),
                new User("7", "Name8", "mail8@mail.com", ""),
                new User("8", "Name9", "mail9@mail.com", ""),
                new User("9", "Name10", "mail10@mail.com", ""),
                new User("10", "Name11", "mail11@mail.com", "")
        );
    }
}
