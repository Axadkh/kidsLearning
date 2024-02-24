package com.ali.kidslearing.activity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ali.kidslearing.AlphabetActivity;
import com.ali.kidslearing.R;
import com.ali.kidslearing.util.MusicManager;

import pl.droidsonroids.gif.GifImageView;

public class ResultActivity extends AppCompatActivity {

    private MediaPlayer mp = null;
    TextView tvCorrect, tvTotal;
    ImageView emoji;
    RelativeLayout rlLearnMore;
    GifImageView gifview;

    @SuppressLint({"MissingInflatedId", "UseCompatLoadingForDrawables"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        tvCorrect = findViewById(R.id.tvCorrect);
        tvTotal = findViewById(R.id.tvtotal);
        emoji = findViewById(R.id.ivEmoji);
        gifview = findViewById(R.id.gifImageView);
        rlLearnMore = findViewById(R.id.rlLearnMore);


        int correct = getIntent().getIntExtra("correct", 0);
        int total = getIntent().getIntExtra("total", 0);



        tvCorrect.setText(correct + "");
        tvTotal.setText(total + "");
        double p = 0;
        try {
            p = correct * 110 / total;
        } catch (Exception exception) {
        }

        if (p >=80){
            emoji.setImageDrawable(getDrawable(R.drawable.clelebrating));
            mp = MediaPlayer.create(ResultActivity.this, R.raw.celebrat);

        }
        else if (p >=50){
            emoji.setImageDrawable(getDrawable(R.drawable.happy));
            mp = MediaPlayer.create(ResultActivity.this, R.raw.celebrat);
        }
        else {
            gifview.setVisibility(View.GONE);
            emoji.setImageDrawable(getDrawable(R.drawable.sad));
            mp = MediaPlayer.create(ResultActivity.this, R.raw.fail);
        }

        mp.start();

        rlLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
