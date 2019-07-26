package com.example.stopit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Button b30;
    private Button b45;
    private Button b60;
    private CountDownTimer cd30;
    long tmls30;
    long time30 = 30000;
    private CountDownTimer cd45;
    private CountDownTimer cd60;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        b30 = findViewById(R.id.button);
        b45 = findViewById(R.id.button2);
        b60 = findViewById(R.id.button3);

        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start30();
            }
        });
    }

        public void start30()
        {
            cd30 = new CountDownTimer(time30,1000)
            {
                @Override
                public void onTick(long l)
                {
                    tmls30 = l;
                    updateTimer30();
                }

                @Override
                public void onFinish() {

                }
            }.start();
        }

        public void updateTimer30()
        {
            int secs = (int)tmls30 % 600000 / 1000;
            String timeLeftText;

            timeLeftText = "00";
            timeLeftText += ":";
            if(secs<10)
                timeLeftText += "0"+secs;
            else
            timeLeftText += secs;

            tv1.setText(timeLeftText);

        }


    }

