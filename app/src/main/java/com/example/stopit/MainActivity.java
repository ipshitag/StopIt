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
    boolean timerRunning = false;
    private CountDownTimer cd30;
    long tmls;
    long time30 = 30000;
    long time45 = 45000;
    long time60 = 60000;
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
        

       
            b45.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    start45();
                }
            });
        

        
            b60.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    start60();
                }
            });
    }

        public void start30()
        {
        if(!timerRunning) {
            cd45 = new CountDownTimer(time30,1000)
            {
                @Override
                public void onTick(long l)
                {
                    timerRunning = true;
                    tmls = l;
                    updateTimer();
                }

                @Override
                public void onFinish()
                {
                    timerRunning=false;
                }
            }.start();
        }
     }


    public void start60()
    {
    if(!timerRunning) {
        cd60 = new CountDownTimer(time60,1000)
        {
            @Override
            public void onTick(long l)
            {
                tmls = l;
                timerRunning = true;
                updateTimer();
            }

            @Override
            public void onFinish()
            {
                timerRunning=false;
            }
        }.start();
    }
}



    public void start45()
    {
    if(!timerRunning) {
        cd30 = new CountDownTimer(time45,1000)
        {
            @Override
            public void onTick(long l)
            {
                tmls = l;
                timerRunning=true;
                updateTimer();
            }

            @Override
            public void onFinish()
            {
                timerRunning=false;
            }
        }.start();
    }
   }


        public void updateTimer()
        {
            int secs = (int)tmls % 600000 / 1000;
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

