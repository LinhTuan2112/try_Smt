package com.example.list_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] fruits;
    private int[] images;
public CustomAdapter(Context context, String[] fruits, int[] images){
    this.context = context;
    this.images = images;
    this.fruits = fruits;
}


    @Override
    public int getCount() {
        return fruits.length;
    }

    @Override
    public Object getItem(int position) {
        return fruits.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Khi convertView == null thì có nghĩa là k có view nào có sẵn để tái sử dụng => tạo mới 1 view = LayoutInflater (và ngược lại)
        //LayoutInflater là 1 đối tượng được suwer dụng để chuyển đổi(inflate) từ XML -> View
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_fruit,null);
            //lấy LayoutInflater từ hệ thống của android
        }
        //Gán tên trái cây cho TextView
        TextView fruitName = convertView.findViewById(R.id.tv_fruit);
        fruitName.setText(fruits[position]);
        //gán ảnh cho ứng dụng cho ImgView
        ImageView fruitImage = convertView.findViewById(R.id.img_fruit);
        fruitImage.setImageResource(images[position]);

        return convertView;
    }
}
