package com.hfad.totalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void LogoutButtonOnclick(View view)
    {
        getApplicationContext().getSharedPreferences("loginPref",0).edit().clear().commit();
        Toast.makeText(MenuActivity.this, "Wylogowano!",
                Toast.LENGTH_SHORT).show();
        finish();
    }

    public void buttonStartOnClick(View view)
    {
        Intent intent = new Intent(MenuActivity.this,CategoryActivity.class);
        startActivity(intent);
    }
}
