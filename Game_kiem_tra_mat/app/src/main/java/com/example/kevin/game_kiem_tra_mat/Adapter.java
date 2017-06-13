package com.example.kevin.game_kiem_tra_mat;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 24/05/2017.
 */
// chuyển đổi chuỗi mã màu ở dạng string thành màu hiện thị
public class Adapter extends ArrayAdapter<String> {
    Context ct;
    ArrayList<String> arr; // nhận dữ liệu kiểu string để xét
    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.ct = context;// context = bối cảnh, dùng để hiển thị ra màn hình những gì truyền vào
        this.arr = new ArrayList<>(objects);// danh sách chuỗi string truyền vào
    }

    @NonNull
    @Override
    // hàm này được sử dụng để kết nối layout và chuyển đổi chuỗi string thành màu
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      View row = convertView;
        // chuyển đổi mã màu string vào layout item
        LayoutInflater inflater = (LayoutInflater)ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item,null);
        if(arr!=null && arr.size()>0)
        {
            com.example.kevin.game_kiem_tra_mat.textview a = (com.example.kevin.game_kiem_tra_mat.textview)row.findViewById(R.id.item);
            a.setBackgroundColor(Color.parseColor(arr.get(position)));
        }
        return row;
    }
}
