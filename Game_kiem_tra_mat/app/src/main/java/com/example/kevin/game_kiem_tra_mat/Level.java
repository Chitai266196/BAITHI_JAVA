package com.example.kevin.game_kiem_tra_mat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevin on 24/05/2017.
 */

public class Level extends AppCompatActivity {
    TextView txvTime, txvDiem;
    GridView gdvMau;
    Tools tools = new Tools();
    ArrayList arr;
    int diem,soO,kt=0;
    CountDownTimer time = new CountDownTimer(5000, 10) {

        public void onTick(long millisUntilFinished) {
            txvTime.setText(millisUntilFinished / 10+" ");
        }

    public void onFinish() {
        kt=1;
        txvTime.setText("0");
        AlertDialog.Builder builder = new AlertDialog.Builder(Level.this);
        builder.setMessage("Điểm của bạn: " + diem);
        MainActivity.diemPublic = diem;
        builder.setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(),Level.class);
                startActivity(i);
            }
        });
        builder.setNegativeButton("Tiến hành chuẩn đoán mắt", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(),Chuandoan.class);
                startActivity(i);
            }
        });
        builder.show();
    }
}.start();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_choi);// liên kết tới layout màn chơi
        anhxa();
        caidat();
        setdulieu();
        setSukien();
    }
    private void anhxa(){
        gdvMau=(GridView)findViewById(R.id.gdvMau);
        txvDiem=(TextView)findViewById(R.id.txvDiem);
        diem=0;
        txvTime=(TextView)findViewById(R.id.txvTime);
    }
    private void caidat()
    {
        if (diem<10) {
            gdvMau.setNumColumns(2);
            soO=4;
        }
        else
        {
            gdvMau.setNumColumns(diem / 10+2);
            soO=(diem/10+2)*(diem/10+2);
        }

    }
    private void setdulieu()
    {
        arr = new ArrayList(tools.taomau(soO));
        Adapter adapter = new Adapter(Level.this,R.layout.man_choi,arr);
        gdvMau.setAdapter(adapter);
        txvDiem.setText(Integer.toString(diem));
    }
    private void setSukien()
    {
        gdvMau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
if (position==Tools.dapan&&kt==0)
{
    caidat();
    time.start();
    diem++;
    setdulieu();
}
            }
        });
    }
}
