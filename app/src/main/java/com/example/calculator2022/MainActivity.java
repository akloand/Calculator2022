package com.example.calculator2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    Boolean isNew = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.CalcField);
    }

    public void clickNumber(View view) {
        if(isNew) editText.setText("");
        isNew = false;

        String number = editText.getText().toString();

        switch (view.getId()) {
            case R.id.but0: number = number+0; break;
            case R.id.but1: number = number+1; break;
            case R.id.but2: number = number+2; break;
            case R.id.but3: number = number+3; break;
            case R.id.but4: number = number+4; break;
            case R.id.but5: number = number+5; break;
            case R.id.but6: number = number+6; break;
            case R.id.but7: number = number+7; break;
            case R.id.but8: number = number+8; break;
            case R.id.but9: number = number+9; break;
            case R.id.butAC: number = "0"; isNew = true; break;

        }
        editText.setText(number);
    }

    public void operation(View view) {
        switch (view.getId()) {
            case R.id.butSum: number = number+"+"; break;
            case R.id.butSub: number = number+"-"; break;
            case R.id.butMult: number = number+"×"; break;
            case R.id.butDiv: number = number+"/"; break;
        }



    }


}