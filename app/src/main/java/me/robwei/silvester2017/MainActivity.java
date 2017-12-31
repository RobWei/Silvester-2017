package me.robwei.silvester2017;

import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity 
{
    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text1 = (TextView)findViewById(R.id.timeLeft);
        final TextView text2 = (TextView)findViewById(R.id.textrz);
        final GifImageView giv = (GifImageView) findViewById(R.id.gif);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        giv.setVisibility(View.INVISIBLE);

        long between = (Long.valueOf("1514761200000")-System.currentTimeMillis());
        new CountDownTimer(between, 1000) 
        {

            public void onTick(long millisUntilFinished)
            {
                    text1.setText(""+String.format(FORMAT,
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }
            
            public void onFinish() 
            {
                text1.setText("");
                text2.setText("");
                giv.setVisibility(View.VISIBLE);
            }
        }.start();
    }

}

