package com.example.calculator2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String oldNumber;
    String operator;
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

            case R.id.butPoint:
                if (pointIsPresent(number)) {
                    number = number + ".";
                }  break;

            case R.id.butPlusMinus:
                if (plusMinusIsPresent(number)) {
                    number = "-" + number;
                } else {
                    number = number.replace("-","");
                }  break;


        }
        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();

        switch (view.getId()) {
            case R.id.butSum: operator="+"; break;
            case R.id.butSub: operator="-"; break;
            case R.id.butMult: operator="*"; break;
            case R.id.butDiv: operator="/"; break;
        }
    }


    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        String resultString = "";
        switch (operator) {
            case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber); break;
            case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber); break;
            case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber); break;
            case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber); break;
        }
        resultString = Double.toString(result);
        editText.setText(resultString);

    }

    public boolean pointIsPresent(String number) {
        if (number.contains(".")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean plusMinusIsPresent(String number) {
        if (number.contains("-")) {
            return false;
        } else {
            return true;
        }
    }

    public void clickPercent(View view) {









    }


//    public boolean resultIsPointZero(String word) {
//
//    }

//        public static String resultWithoutNull(String number) {
//                String newWord = number.substring(number.lastIndexOf(".") + 0);
//                if (newWord == ".0") {
//                    return number;
//               } else {
//                    return number.substring(0, number.lastIndexOf("."));
//                }
//        }

    }   