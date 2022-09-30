package com.example.calculator2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String oldNumber;
    String operator = "";
    Boolean isNew = true;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.CalcField);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }


    public void clickNumber(View view) {
        if (isNew) editText.setText("");
        isNew = false;

        String number = editText.getText().toString();

        switch (view.getId()) {
            case R.id.but0:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = "0";
                } else {
                    number = number + 0;
                }
                break;


            case R.id.but1:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 1;
                break;
            case R.id.but2:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 2;
                break;
            case R.id.but3:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 3;
                break;
            case R.id.but4:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 4;
                break;
            case R.id.but5:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 5;
                break;
            case R.id.but6:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 6;
                break;
            case R.id.but7:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 7;
                break;
            case R.id.but8:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 8;
                break;
            case R.id.but9:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + 9;
                break;

            case R.id.butAC:
                number = "0";
                isNew = true;
                operator = "";
                break;

            case R.id.butPoint:
                if (zeroIsFirst(number)) {
                    number = "0.";
                }
                if (pointIsPresent(number)) {
                    number = number + ".";
                }
                break;

            case R.id.butPlusMinus:
                if (numberIsZero(number)) {
                    number = "0";
                } else {
                    if (plusMinusIsPresent(number)) {
                        number = "-" + number;
                    } else {
                        number = number.replace("-", "");
                    }
                }
                break;

        }
        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();

        switch (view.getId()) {

            case R.id.butSum:
                operator = "+";
                break;
            case R.id.butSub:
                operator = "-";
                break;
            case R.id.butMult:
                operator = "*";
                break;
            case R.id.butDiv:
                operator = "/";
                break;
        }
    }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        String resultString = "";
        switch (operator) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        resultString = Double.toString(result);
        editText.setText(resultString);

    }

    public void clickPercent(View view) {

        if (operator == "") {
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp + "";
            editText.setText(number);
        } else {
            Double result = 0.0;
            String newNumber = editText.getText().toString();
            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
                    break;
            }
            editText.setText(result + "");
            operator = "";
        }

    }



    private boolean zeroIsFirst(String number) {
        if (number.equals("")) {
            return true;
        }

        if (number.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }

    }

    private boolean numberIsZero(String number) {
        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean pointIsPresent(String number) {
        if (number.contains(".")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean plusMinusIsPresent(String number) {
        if (number.contains("-")) {
            return false;
        } else {
            return true;
        }
    }


}