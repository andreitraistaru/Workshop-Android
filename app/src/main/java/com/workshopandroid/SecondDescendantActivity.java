package com.workshopandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondDescendantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_descendant);
    }

    public void goToFirstDescendantActivity(View view) {
        startActivity(new Intent(this, FirstDescendantActivity.class));
    }
}