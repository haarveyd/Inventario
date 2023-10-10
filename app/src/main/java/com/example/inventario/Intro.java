package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_intro);
    }

    public void nextActivity(View v){
        Intent accionar = new Intent(this, Login.class);
        startActivity(accionar);

    }

    public void nextActivity6(View v){
        Intent accionar3=new Intent(this, Inventory.class);
        startActivity(accionar3);
    }

}