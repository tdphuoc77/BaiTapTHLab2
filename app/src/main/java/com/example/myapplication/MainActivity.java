package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abhinav.passwordgenerator.PasswordGenerator;

public class MainActivity extends AppCompatActivity {
    EditText txtPassLength;
    CheckBox cbkLowerCase;
    CheckBox cbkUpperCase;
    CheckBox cbkNumber;
    CheckBox cbkSpecialSymbol;
    TextView txtPassword;
    Button btnGenerate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout1);
//        setContentView(R.layout.layout2);
//        setContentView(R.layout.layout3);
        setContentView(R.layout.layout4);

        txtPassLength=findViewById(R.id.passlength);
        cbkLowerCase= findViewById(R.id.lowcase);
        cbkUpperCase= findViewById(R.id.upcase);
        cbkNumber = findViewById(R.id.number);
        cbkSpecialSymbol=  findViewById(R.id.specialSymbol);
        txtPassword= findViewById(R.id.password);
        btnGenerate= findViewById(R.id.btnGenerate);

        btnGenerate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int length;
                try {
                    length= Integer.parseInt(txtPassLength.getText().toString());
                    boolean isUpperCase= cbkUpperCase.isChecked();
                    boolean isLowerCase= cbkLowerCase.isChecked();
                    boolean isSymbol= cbkSpecialSymbol.isChecked();
                    boolean isNumber= cbkNumber.isChecked();

                    PasswordGenerator generator = new PasswordGenerator(length, isUpperCase, isLowerCase, isSymbol, isNumber);
                    txtPassword.setText(generator.generatePassword());

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}