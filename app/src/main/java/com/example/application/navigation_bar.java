package com.example.application;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

public class navigation_bar extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton tab1, tab2, tab3;  //三个单选按钮
    private List<View> mViews;   //存放视图

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_bar);

        initNavView();//初始化底部导航栏

        //对单选按钮进行监听，选中、未选中
        mRadioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.rb_shop) {
                mViewPager.setCurrentItem(0);
            }
            else if (i == R.id.rb_orders) {
                mViewPager.setCurrentItem(1);
            }
            else if (i == R.id.rb_my) {
                mViewPager.setCurrentItem(2);
            }
        });
    }

    @SuppressLint("InflateParams")
    private void initNavView() {
        //初始化控件
        mViewPager=findViewById(R.id.viewpager);
        mRadioGroup=findViewById(R.id.rg_tab);
        tab1=findViewById(R.id.rb_shop);
        tab2=findViewById(R.id.rb_orders);
        tab3=findViewById(R.id.rb_my);

        //加载，添加视图
        mViews= new ArrayList<>();//加载，添加视图

        mViews.add(LayoutInflater.from(this).inflate(R.layout.activity_shop,null));
        mViews.add(LayoutInflater.from(this).inflate(R.layout.orders,null));
        mViews.add(LayoutInflater.from(this).inflate(R.layout.my,null));

        mViewPager.setAdapter(new MyViewPagerAdapter());//设置一个适配器
        //对viewpager监听，让分页和底部图标保持一起滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tab1.setChecked(true);
                        tab2.setChecked(false);
                        tab3.setChecked(false);
                        break;
                    case 1:
                        tab1.setChecked(false);
                        tab2.setChecked(true);
                        tab3.setChecked(false);
                        break;
                    case 2:
                        tab1.setChecked(false);
                        tab2.setChecked(false);
                        tab3.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    //ViewPager适配器
    private class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mViews.size();
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViews.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mViews.get(position));
            return mViews.get(position);
        }
    }
}


