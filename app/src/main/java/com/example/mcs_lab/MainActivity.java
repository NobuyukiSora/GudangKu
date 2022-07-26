package com.example.mcs_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.LoginEmail);
        password = findViewById(R.id.LoginPassword);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(view -> {
            String emailLogin = email.getText().toString();
            String passwordLogin = password.getText().toString();

            if (emailLogin.length() == 0){
                email.setError("Email must be filled in");

            }
            else if (passwordLogin.length() == 0){
                password.setError("Password must be filled in");
            }
            else {
                Intent i = new Intent(MainActivity.this, HomePage.class);
                startActivity(i);
            }
//            else {
//                Toast.makeText(MainActivity.this, "Email is filled", Toast.LENGTH_SHORT).show();
//            }

//            else {
//                Toast.makeText(MainActivity.this, "Email is filled", Toast.LENGTH_SHORT).show();
//            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        if (v == login){
//            Intent i = new Intent(MainActivity.this, HomePage.class);
//            startActivity(i);
//
//        }
//    }

}
