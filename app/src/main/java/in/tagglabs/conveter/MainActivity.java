package in.tagglabs.conveter;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.parseFloat;
//import android.java2novice.math;

public class MainActivity extends AppCompatActivity {
    TextView northText, southText, eastText, westText, acreeText, guntaText, conveter;
    EditText northEdit, southEdit, eastEdit, westEdit;
    Button button;
    float east, west, south, north, acree, gunta, northSouth, eastWest, mul;
    long i = 43560;
    double guntaPI = 0.4;
    long PI = 40;
    String doubleAsString, doubleAsString1, one, two, removeFirstDout, newValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        northText = findViewById(R.id.northTextView);
        southText = findViewById(R.id.southTextView);
        eastText = findViewById(R.id.easttextView);
        westText = findViewById(R.id.westTextView);
        acreeText = findViewById(R.id.acreeTextView);
        conveter = findViewById(R.id.conveter);
        northEdit = findViewById(R.id.northEditText);
        southEdit = findViewById(R.id.southEditText);
        eastEdit = findViewById(R.id.eastEditText);
        westEdit = findViewById(R.id.westEditText);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                north = Integer.parseInt(northEdit.getText().toString());
                south = Integer.parseInt(southEdit.getText().toString());
                east = Integer.parseInt(eastEdit.getText().toString());
                west = Integer.parseInt(westEdit.getText().toString());
//                answer.setText("Answer:");
//                Toast.makeText(MainActivity.this, "North ->"+north+" South->"+south+" East->"+east+" West->"+west, Toast.LENGTH_SHORT).show();
                getacree();
            }
        });
    }

    @SuppressLint("NewApi")
    private void getacree() {
        northSouth = (north + south) / 2;
        eastWest = (east + west) / 2;
        mul = (northSouth * eastWest) / i;
        acreeText.setText("Acree:" + String.valueOf(mul));
        Toast.makeText(this, "Acree: " + mul, Toast.LENGTH_SHORT).show();
        doubleAsString = String.valueOf(mul);
        int indexOfDecimal = doubleAsString.indexOf(".");
        System.out.println("Integer Part: " + doubleAsString.substring(0, indexOfDecimal));
        System.out.println("Decimal Part: " + doubleAsString.substring(indexOfDecimal));
        one = doubleAsString.substring(0, indexOfDecimal);
        two = doubleAsString.substring(indexOfDecimal);
//        float gunte=Integer.parseInt(doubleAsString.substring(indexOfDecimal))*PI;
        float add = (float) (parseFloat(two) + 0.01);
        double roundOff = (double) Math.round(add * 100) / 100;

        doubleAsString1 = String.valueOf(add);
        newValue = doubleAsString1.substring(indexOfDecimal);
        removeFirstDout = String.valueOf(roundOff);
        double aa=parseFloat(removeFirstDout.substring(2))*guntaPI;
        Log.e("---One--", one);
//        Log.e("---two--",two);
        Log.e("--Round--", removeFirstDout.substring(2));
        Log.e("--Gunta--",String.valueOf(aa));
//        Log.e("--Value Round Off--",String.valueOf(add)+"--new--"+(newValue.substring(1)));
    }

    private void getGunta() {


    }
}
