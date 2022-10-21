package com.google.taoapptonghopvdn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoTa extends AppCompatActivity {
    TextView txt_tenmonan,txt_giatien, txt_mota;
    ImageView imgAnhmota, arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_ta);

        Button btnoder=findViewById(R.id.btnoder);

        arrow = (ImageView) findViewById(R.id.arrow);
        imgAnhmota =(ImageView) findViewById(R.id.img_mota) ;
        txt_tenmonan =(TextView) findViewById(R.id.txt_motatenmonan) ;
        txt_giatien =(TextView) findViewById(R.id.txt_motagiatien);
        txt_mota =(TextView) findViewById(R.id.txt_mota);
        Intent intent  = getIntent();
        imgAnhmota.setImageResource(intent.getIntExtra("key1",0));
        txt_tenmonan.setText(intent.getStringExtra("key2"));
        txt_giatien.setText(intent.getStringExtra("key3"));
        txt_mota.setText(intent.getStringExtra("key4"));

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MoTa.this, Activity_MonAn.class));
            }
        });
        btnoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MoTa.this, Activity_MonAn.class));
                Toast.makeText(MoTa.this, "Order Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
