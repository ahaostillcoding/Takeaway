package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.R;

public class shop_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        // 获取传递的参数
        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);

        // 找到对应的控件
        TextView shopNameTextView = findViewById(R.id.shop_name);
        ImageView shopImageView = findViewById(R.id.shop_image);
        Toolbar toolbar = findViewById(R.id.toolbar);

        // 设置显示的数据
        shopNameTextView.setText(name);
        shopImageView.setImageResource(image);

        toolbar.setTitle("店家详细");
        // 设置返回按钮点击事件
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 关闭当前 Activity，返回到上一个 Activity
            }
        });
    }
}