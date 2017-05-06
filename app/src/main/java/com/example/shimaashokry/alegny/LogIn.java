package com.example.shimaashokry.alegny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.shimaashokry.alegny.Adapter.LoginUserAdapter;
import com.example.shimaashokry.alegny.Adapter.RegisterUserAdapter;

public class LogIn extends AppCompatActivity {

    EditText txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        txt1 = (EditText) findViewById(R.id.Name);
        txt2 = (EditText) findViewById(R.id.passeord);

    }

    public void logIn(View view){
        String name = txt1.getText().toString();
        String pass = txt2.getText().toString();
        LoginUserAdapter r =new LoginUserAdapter(this);
        r.execute(name,pass);
    }

    public void register(View view){
        String name = txt1.getText().toString();
        String pass = txt2.getText().toString();
        RegisterUserAdapter r =new RegisterUserAdapter(this);
        r.execute(name,pass);
    }
    public void display(){
        Intent i = new Intent(this,SearchPage.class);
        startActivity(i);
    }


}
