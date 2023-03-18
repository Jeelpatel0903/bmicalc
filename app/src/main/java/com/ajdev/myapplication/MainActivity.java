package com.ajdev.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edweight,heightinft,heightinin;
        Button calcbmi;
        TextView txtResult;
        LinearLayout lmain;

        lmain = findViewById(R.id.lmain);
        edweight = findViewById(R.id.EditWeight);
        heightinft = findViewById(R.id.EditHeightft);
        heightinin = findViewById(R.id.EditHeightIn);
        calcbmi = findViewById(R.id.clikbtn);
        txtResult = findViewById(R.id.result);

        calcbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edweight.getText().toString());
                int ft = Integer.parseInt(heightinft.getText().toString());
                int in = Integer.parseInt(heightinin.getText().toString());

                int totalinc = ft*12 + in;
                double totalcm = totalinc*2.53;
                double totalmet = totalcm/100;

                double bmi = wt/(totalmet*totalmet);

                if(bmi>25){
                    txtResult.setText("You are over weight");
                    lmain.setBackgroundColor(getResources().getColor(R.color.ow));

                } else if (bmi<18) {
                    txtResult.setText("you are under weight");
                    lmain.setBackgroundColor(getResources().getColor(R.color.uw));

                }
                else
                {
                    txtResult.setText("you are healthy");
                    lmain.setBackgroundColor(getResources().getColor(R.color.health));
                }

            }
        });


    }
}