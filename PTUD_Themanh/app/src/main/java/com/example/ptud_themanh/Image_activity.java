package com.example.ptud_themanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;

public class Image_activity extends AppCompatActivity {
    TableLayout MyTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        MyTable = (TableLayout) findViewById(R.id.tableLayoutImage);
        int soDong = 6;
        int soCot = 3;
        // trộn mảng
        Collections.shuffle(MainActivity.arrayName);
        // tạo dòng và cột
        for(int i = 1  ; i <= soDong ; i++){
            TableRow tableRow = new TableRow(this);
            //tạo cột -> imageview
            for(int j = 1; j <= soCot;j++){
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(240,220);
                imageView.setLayoutParams(layoutParams);
                int vitri = soCot *( i - 1 ) + j - 1;
                // 
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idHinh);
                // add imageview vào tablerow
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon",MainActivity.arrayName.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            // add tablerow vào table
            MyTable.addView(tableRow);
        }
    }
}