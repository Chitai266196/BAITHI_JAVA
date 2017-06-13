package com.example.kevin.game_kiem_tra_mat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Kevin on 24/05/2017.
 */

public class textview extends TextView {


    public textview(Context context) {
        super(context);
    }

    public textview(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public textview(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override //lấy ra chiều dài, chiều rộng của các cột,các hàng
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai,dai);// truyền vào chiều dài, chiều rộng để cài đặt
    }
}
