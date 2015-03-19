package com.androidbasic.jascalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends ActionBarActivity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);
        
        Button button = (Button) findViewById(R.id.BackButton);
        button.setOnClickListener(this);
        
        Intent a = getIntent();
        Integer res = a.getExtras().getInt("Test");
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(tv.getText() + " " + res);
    }

    @Override
    public void onClick(View src) {
      Intent i = new Intent(this, CalculatorMainActivity.class);
      startActivity(i);
    }

}
