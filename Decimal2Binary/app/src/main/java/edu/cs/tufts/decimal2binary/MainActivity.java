package edu.cs.tufts.decimal2binary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText decimal;
    TextView result;
    Button convert, clear;
    String binary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decimal = (EditText)findViewById(R.id.EditText1);
        convert = (Button)findViewById(R.id.button1);
        clear = (Button) findViewById(R.id.button2);
        result = (TextView) findViewById(R.id.result);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal.getText().toString().isEmpty() ||
                        !decimal.getText().toString().matches("\\d+(?:\\.\\d+)?")) {
                    Toast.makeText(getApplicationContext(), "Please enter a number",
                            Toast.LENGTH_SHORT).show();
                    decimal.setText("");
                } else {
                    String s = decimal.getText().toString();
                    if (s.length() > 9) {
                        Toast.makeText(getApplicationContext(),
                                "The number is too big, please enter another number",
                                Toast.LENGTH_SHORT).show();
                        decimal.setText("");
                    } else {
                        int number = Integer.parseInt(s);
                        result.setText(String.valueOf(Integer.toBinaryString(number)));
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimal.setText("");
                result.setText("");
            }
        });
    }
}
