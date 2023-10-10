package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    EditText user;
    TextView nombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);



        nombre=(TextView)findViewById(R.id.usuario);
        user=(EditText) findViewById(R.id.editTextText);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String usuarioinicial= user.getText().toString();
                nombre.setText(usuarioinicial);

            }
        });





    }


    public void nextActivity(View v){
        Intent accionar1=new Intent(this,Inventory.class);
        startActivity(accionar1);

    }


}