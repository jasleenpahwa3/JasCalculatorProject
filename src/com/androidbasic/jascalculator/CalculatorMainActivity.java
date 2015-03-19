package com.androidbasic.jascalculator;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CalculatorMainActivity extends ActionBarActivity {

    char op;
    TextView calResult;
    Integer result = 0;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	//getMenuInflater().inflate(R.menu.calculator_main, menu);
    	getMenuInflater().inflate(R.menu.calmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        CharSequence ansText = "Here's your answer::";
        System.out.printf("%d", result);
        if(result != 0) { 
        	ansText = "Here's your answer::" + result.toString(); 
        } 
        System.out.printf("%s", ansText);
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.MENU_ITEM_ANS) {
        	Toast.makeText(getApplicationContext(),ansText, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void calAdd(View v) {
    	op = '+';
    }
    
    public void calSub(View v) {
    	op = '-';
    }
    
    public void calMul(View v) {
    	op = '*';
    }
    
    public void calDiv(View v) {
    	op = '/';
    }
    
    public void calClear(View v) {
    	calResult = (TextView)findViewById(R.id.textView2);
    	calResult.setText("");
    }
   
    public void calAnswer(View v){
    	
    	
    	EditText edit_operand1 = (EditText)findViewById(R.id.edit_operand);
    	EditText edit_operand2 = (EditText)findViewById(R.id.edit_operand2);
    	calResult = (TextView)findViewById(R.id.textView2);
    	
    	Integer calLeftOperand = Integer.parseInt(edit_operand1.getText().toString());
    	Integer calRightOperand = Integer.parseInt(edit_operand2.getText().toString());
    	
        if(op == '+')
    	     result = calLeftOperand + calRightOperand;
    	else if(op == '-')
    	     result = calLeftOperand - calRightOperand;
    	else if(op == '/')
    	     result = calLeftOperand / calRightOperand;
    	else if(op == '*')
    	     result = calLeftOperand * calRightOperand;
        
    	
    	calResult.setText(result.toString());
    	
    	//Send Intent
    	Intent i = new Intent(this, ResultActivity.class);
    	i.putExtra("Test", result);
    	startActivity(i);
    	
    }
}
