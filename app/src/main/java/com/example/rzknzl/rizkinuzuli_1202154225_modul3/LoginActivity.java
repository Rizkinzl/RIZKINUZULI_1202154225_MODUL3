package com.example.rzknzl.rizkinuzuli_1202154225_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inUsername, inPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //deklarasi variabel dengan id pada layout
        inUsername = findViewById(R.id.inputUsername);
        inPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    // proses login ketika mengklik button
    public void loginClick(View view) {
        //check username dan password
        if ( inUsername.getText().toString().equals("EAD") && inPassword.getText().toString().equals("MOBILE") ) {
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, menuListActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login Failed :(", Toast.LENGTH_SHORT).show();

            //reset editText inUsername dan inPassword
            inUsername.setText("");
            inPassword.setText("");
        }
    }
}
