package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    private List<Shop> shopList;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        listView = view.findViewById(R.id.list_view);

        initData();
        setAdapter();
        setListener();

        return view;
    }

    private void initData() {
        shopList = new ArrayList<>();
        shopList.add(new Shop(R.drawable.apple, "苹果", "2元"));
        shopList.add(new Shop(R.drawable.milktea, "奶茶", "18元"));
        shopList.add(new Shop(R.drawable.chicken, "炸鸡", "30元"));
    }

    private void setAdapter() {

        ShopAdapter adapter = new ShopAdapter(
                getContext(),
                R.layout.shop_item,
                shopList
        );

        listView.setAdapter(adapter);

    }

    private void setListener() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Shop shop = shopList.get(position);
            String name = shop.getName();
            Toast.makeText(getActivity(), "您选择的商品是:" + name, Toast.LENGTH_SHORT).show();
        });
    }

}