package com.example.ptud_themanh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> arrayName;
    TextView txtdiemso;
    ImageView imgGoc,imgNhan;
    int Request_code_image = 123, sodiem = 100;
    String tenHinhGoc = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ánh xạ
        txtdiemso = (TextView)findViewById(R.id.tvdiemso);
        imgGoc = (ImageView) findViewById(R.id.imageView);
        imgNhan = (ImageView) findViewById(R.id.imageView2);
        String [] mangTen = getResources().getStringArray(R.array.list_name);
        arrayName = new ArrayList<>(Arrays.asList(mangTen));
        txtdiemso.setText(sodiem + "");
        // trộn mảng
        Collections.shuffle(arrayName);
        // biến ngẫu nhiên n
//        Random s = new Random();
//        int n = s.nextInt(17);
//        int idHinh = getResources().getIdentifier(arrayName.get(n),"drawable",getPackageName());
//        imgGoc.setImageResource(idHinh);
        tenHinhGoc = arrayName.get(5);
        int idHinh = getResources().getIdentifier(arrayName.get(5),"drawable",getPackageName());
        imgGoc.setImageResource(idHinh);
        imgNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,Image_activity.class),Request_code_image);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Request_code_image && resultCode == RESULT_OK && data != null){
            String tenHinhNhan = data.getStringExtra("tenhinhchon");
            int idHinhNhan = getResources().getIdentifier(tenHinhNhan,"drawable",getPackageName());

            imgNhan.setImageResource(idHinhNhan);
            // ss theo tên hình
            if(tenHinhGoc.equals(tenHinhNhan)){
                sodiem += 10;
                Toast.makeText(this, "cái gi nó đúng thì thôi chứ !", Toast.LENGTH_SHORT).show();
                
            }else {
                sodiem -= 5;
                Toast.makeText(this, "Cái chiiiiiii", Toast.LENGTH_SHORT).show();
            }
            txtdiemso.setText(sodiem + "");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.Reload){
            Collections.shuffle(arrayName);
            // biến ngẫu nhiên n
//        Random s = new Random();
//        int n = s.nextInt(17);
//        int idHinh = getResources().getIdentifier(arrayName.get(n),"drawable",getPackageName());
//        imgGoc.setImageResource(idHinh);
            tenHinhGoc = arrayName.get(5);
            int idHinh = getResources().getIdentifier(arrayName.get(5),"drawable",getPackageName());
            imgGoc.setImageResource(idHinh);
        }
        return super.onOptionsItemSelected(item);
    }
}