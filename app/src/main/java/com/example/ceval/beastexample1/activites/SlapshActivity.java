package com.example.ceval.beastexample1.activites;

import android.content.Intent;
import android.os.Bundle;

public class SlapshActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
