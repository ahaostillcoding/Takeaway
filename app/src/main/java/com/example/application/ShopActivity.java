package com.example.application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        // 找到Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        // 设置Toolbar标题
        toolbar.setTitle("欢迎来到我的米奇妙妙屋");
        // 将Toolbar作为ActionBar
        setSupportActionBar(toolbar);

        //设置ListView
        //1、绑定控件
        ListView listView=(ListView)findViewById(R.id.list_view);
        //2、准备数据
        List<Shop> shopList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Shop apple = new Shop(R.drawable.apple,"苹果","2元");
            shopList.add(apple);
            Shop milktea = new Shop(R.drawable.milktea,"奶茶","18元");
            shopList.add(milktea);
            Shop chicken = new Shop(R.drawable.chicken,"炸鸡","30元");
            shopList.add(chicken);
        }
        //3、创建适配器 连接数据源和控件的桥梁
        //参数 1：当前的上下文环境
        //参数 2：当前列表项所加载的布局文件
        //参数 3：数据源
        ShopAdapter adapter=new ShopAdapter(ShopActivity.this,R.layout.shop_item,shopList);
        //4、将适配器加载到控件中
        listView.setAdapter(adapter);
        //5、为列表中选中的项添加单击响应事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shop selectedShop = shopList.get(position); // 获取选中的 Shop 对象
                String selectedName = selectedShop.getName(); // 获取选中的商品名称
                Toast.makeText(ShopActivity.this, "您选择的商品是：" + selectedName, Toast.LENGTH_SHORT).show();
            }
        });
    }
}


