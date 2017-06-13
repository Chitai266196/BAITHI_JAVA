package com.example.kevin.game_kiem_tra_mat;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kevin on 24/05/2017.
 */
//#F9EBEA#F2D7D5#E6B0AA#E6B0AA#CD6155#C0392B#922B21
public class Tools {
    static int dapan;
    Random r = new Random();
    String string2[]=new String[]{"#ffb3b3","#ff8080","#ff4d4d","#ff1a1a","#e60000","#b30000","#800000","#4d0000"};
    String string3[]=new String[]{"#b3ffb3","#80ff80","#4dff4d","#1aff1a","#00e600","#00b300","#008000","#004d00"};
    String string5[]=new String[]{"#ffb3b3","#ff8080","#ff4d4d","#ff1a1a","#e60000","#b30000","#800000","#4d0000"};
    String string7[]=new String[]{"#b3b3ff","#8080ff","#4d4dff","#1a1aff","#0000e6","#0000b3","#000080","#00004d"};
    String string11[]=new String[]{"#ffb3ff","#ff80ff","#ff4dff","#ff1aff","#e600e6","#b300b3","#800080","#4d004d"};
    String string13[]=new String[]{"#ffd9b3","#ffbf80","#ffa64d","#ff8c1a","#e67300","#b35900","#804000","#4d2600"};
    String string15[]=new String[]{"#ecc6c6","#df9f9f","#d27979","#c65353","#ac3939","#862d2d","#602020","#391313"};
// int n: quy định số phần tử trong arraylist
    public ArrayList<String> taomau(int n){
        int x,y;
        ArrayList<String> a = new ArrayList<>();
        x = r.nextInt(n);// 0-> n-1, tạo ra màu khác trong bảng,
        // ví dụ: khi truyền vào n=4 thì sẽ có 3 ô khác giống nhau, 1 ô khác
        dapan=x;
        y = r.nextInt(7);// tạo ra 1 trong 7 màu ở dãy string ở trên
        int ca = 1+(int)(Math.random()*(100-1)+1);
        for (int i = 0; i<n; i++)
        {
            if (i==x){
                /////
                if(ca%15==0) a.add(string15[y]);
                else if(ca%13==0) a.add(string13[y]);
                else if(ca%11==0) a.add(string11[y]);
                else if(ca%7==0) a.add(string7[y]);
                else if(ca%5==0) a.add(string5[y]);
                else if(ca%3==0) a.add(string3[y]);
                else a.add(string2[y]);
                //////



            }
            else
            {
                if(ca%15==0) a.add(string15[y+1]);
                else if(ca%13==0) a.add(string13[y+1]);
                else if(ca%11==0) a.add(string11[y+1]);
                else if(ca%7==0) a.add(string7[y+1]);
                else if(ca%5==0) a.add(string5[y+1]);
                else if(ca%3==0) a.add(string3[y+1]);
                else a.add(string2[y+1]);
            }

        }
        return a;
    }
}
