package com.example.application;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        toolbar.setTitle("欢迎来到我的米奇妙妙商店");
        // 将Toolbar作为ActionBar
        setSupportActionBar(toolbar);


//设置ListView
        //1、绑定控件
        ListView listView=(ListView)findViewById(R.id.list_view);
        //2、准备数据
        List<Shop> shopList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Shop apple = new Shop(R.drawable.apple,"水果很忙","月售10");
            shopList.add(apple);
            Shop milktea = new Shop(R.drawable.milktea,"茶千道","月售1000+");
            shopList.add(milktea);
            Shop chicken = new Shop(R.drawable.chicken,"塔斯基","月售0");
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
//                int selectedImage = selectedShop.getImage(); // 获取选中的商品图片资源

                // 创建 Intent 对象，并指定当前 Activity 作为上下文，目标 Activity 为 shop_detail.class
                Intent intent = new Intent(ShopActivity.this, shop_detail.class);
                intent.putExtra("name", selectedName); // 将选中的商品名称作为参数传递给 shop_detail
//                intent.putExtra("image", selectedImage); // 将选中的商品图片资源作为参数传递给 shop_detail
                startActivity(intent);
            }
        });

    }

}


