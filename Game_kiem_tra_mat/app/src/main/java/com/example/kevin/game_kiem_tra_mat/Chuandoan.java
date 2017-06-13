package com.example.kevin.game_kiem_tra_mat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Chuandoan extends AppCompatActivity {

    Button btnTacgia, btnChoilai, btnThoat;
    ImageView img;
    TextView tv;
    String ConDoi = "Sắc giác của bạn không có gì để viết về nó. Dơi sống trong bóng tối và sử dụng các giác quan khác chứ không phải thị giác, nguy cơ là bạn cũng vậy.";
    String ChuotChui = "Bạn có sắc giác tạm ổn. Bạn nhìn thấy bức tường gần nhất nhưng không được đi xa vì có thể chui nhầm vào bẫy chuột.";
    String ConCho = "Bạn khá lanh mắt, khó có vật gì có thể lọt qua mắt bạn. Chỉ có lâu lâu nhìn nhầm thôi.";
    String ConMeo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuandoan);
        Anhxa();
        SuKien();
        Hinhanh(MainActivity.diemPublic);
        thongtin(MainActivity.diemPublic);
    }

    private void SuKien() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnChoilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Level.class);
                startActivity(i);
            }
        });
        btnTacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Tacgia.class);
                startActivity(i);
            }
        });
    }


    private void thongtin(int diemPublic) {
        if(diemPublic <= 10)
            tv.setText(ConDoi);
        else if (diemPublic <= 30)
            tv.setText(ChuotChui);
        else if (diemPublic <= 50)
            tv.setText(ConCho);
        else if (diemPublic <= 70)
            tv.setText(ConMeo);
    }

    private void Anhxa() {
        img = (ImageView) findViewById(R.id.imageviewconvat);
        tv = (TextView) findViewById(R.id.textviewchuandoan);
        btnTacgia = (Button) findViewById(R.id.Buttontacgia);
        btnChoilai = (Button) findViewById(R.id.Buttonchoilai);
        btnThoat = (Button) findViewById(R.id.Buttonthoat);
    }


    private void Hinhanh(int diemPublic) {
        if(diemPublic <= 10)
            img.setImageResource(R.drawable.bat);
        else if (diemPublic <= 30)
            img.setImageResource(R.drawable.mole);
        else if (diemPublic <= 50)
            img.setImageResource(R.drawable.dog);
        else if (diemPublic <= 70)
            img.setImageResource(R.drawable.cat);

    }

}
