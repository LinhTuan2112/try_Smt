package com.example.list_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Khởi tạo danh sách trái cây
    String[] fruits = {"Táo","Mận","Lê","Nhãn","Dưa hấu"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Tìm listview trong layout
        ListView listView = findViewById(R.id.lv_fruit);

        // Tạo Adapter để kết nối dữ liệu với listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_fruit,R.id.tv_fruit, fruits);
        listView.setAdapter(adapter);

        // Taạo sự kiện click vào mục danh sách
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Lấy tên trái cây được chọn ra
                String selectedFruit = fruits[position];
                //hiển thị thông báo khi click vào mục
                Toast.makeText(MainActivity.this,"Bạn chọn: " + selectedFruit, Toast.LENGTH_SHORT).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}