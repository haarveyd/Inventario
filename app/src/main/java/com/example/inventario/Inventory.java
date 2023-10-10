package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class Inventory extends AppCompatActivity {

    Spinner categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

    }


    public void nextActivity2(View v){
        Intent accionar3=new Intent(this, ProductEntry.class);
        startActivity(accionar3);



    }

    public void nextActivity3(View v){
        Intent accionar3=new Intent(this, ProductOutput.class);
        startActivity(accionar3);
    }

    public void nextActivity4(View v){
        Intent accionar3=new Intent(this, Table.class);
        startActivity(accionar3);
    }

    public void nextActivity5(View v){
        Intent accionar3=new Intent(this, Sales.class);
        startActivity(accionar3);
    }



}