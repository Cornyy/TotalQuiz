package com.hfad.totalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity
{
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
         intent= new Intent(CategoryActivity.this,GameActivity.class);
    }

    public void buttonSportOnClick(View view)
    {
         intent.putExtra(GameActivity.Category_Number,1);
         startActivity(intent);
    }

    public void buttonMuzykaOnClick(View view)
    {
        intent.putExtra(GameActivity.Category_Number,2);
        startActivity(intent);
    }

}
