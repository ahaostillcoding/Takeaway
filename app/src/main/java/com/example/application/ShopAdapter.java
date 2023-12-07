package com.example.application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Layer;

public class ShopAdapter extends ArrayAdapter<Shop>{
    public ShopAdapter(@NonNull Context context, int resource, @NonNull List<Shop> objects) {
        super(context, resource, objects);
    }
    //每个子项被滚动到屏幕内时候被调用
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        Shop shop = getItem(position); //得到当前Shop实例
        // 为每一个子项加载设定的布局
        View view = LayoutInflater.from(getContext()).inflate(R.layout.shop_item,parent,false);
        // 分别获取image view 和 textview 的实例
        ImageView shopimage = view.findViewById(R.id.shop_image);
        TextView shopname = view.findViewById(R.id.shop_name);
        TextView shopprice = view.findViewById(R.id.shop_price);
        // 设置显示的图片和文字
        shopimage.setImageResource(shop.getImageID());
        shopname.setText(shop.getName());
        shopprice.setText(shop.getPrice());
        return view;
    }
}
