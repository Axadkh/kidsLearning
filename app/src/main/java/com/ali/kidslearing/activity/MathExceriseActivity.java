package com.ali.kidslearing.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ali.kidslearing.R;
import com.ali.kidslearing.adapter.Ans;
import com.ali.kidslearing.adapter.ExcriseAdapter;
import com.ali.kidslearing.adapter.ExcriseModel;
import com.ali.kidslearing.adapter.MathModel;
import com.ali.kidslearing.adapter.OnItemClickListener;
import com.ali.kidslearing.adapter.RvAdapter;
import com.ali.kidslearing.util.Const;
import com.ali.kidslearing.util.PrefHelper;

import java.util.ArrayList;

public class MathExceriseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MediaPlayer mp = null;
    private ExcriseAdapter adapter;
    private boolean isOnProgress = false;
    private int currentPosition = 0;
    private  int correctCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excerise);
        Window w = getWindow();

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mp = MediaPlayer.create(MathExceriseActivity.this, R.raw.click);
        recyclerView = findViewById(R.id.recyclerView);
        initAdapter();



    }

    private void initAdapter(){


        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        adapter = new ExcriseAdapter(this, getMath(), new OnItemClickListener() {
            @Override
            public void onItemClick(boolean isCorrect) {
                if(!isOnProgress) {
                    isOnProgress = true;
                    mp.start();
                    if (isCorrect) {
                        correctCount++;
                    }
                    if (currentPosition < adapter.getItemCount() - 1) {
                        currentPosition++;
                        recyclerView.scrollToPosition(currentPosition);
                    } else {
                        PrefHelper.getPrefHelper(MathExceriseActivity.this).saveInt(Const.mathTest, correctCount);

                        Intent i = new Intent(MathExceriseActivity.this, ResultActivity.class);
                        i.putExtra("correct", correctCount);
                        i.putExtra("total", getMath().size());
                        startActivity(i);
                        finish();
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            isOnProgress = false;
                        }
                    }, 500);
                }

                //mp.release();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private ArrayList<ExcriseModel> getMath(){
        ArrayList<ExcriseModel> items  = new  ArrayList<ExcriseModel>();
        items.add(
                new ExcriseModel(
                        R.drawable.one,
                        R.drawable.pluse,
                        R.drawable.three,
                        new Ans(R.drawable.six,
                                R.drawable.five,
                                R.drawable.four,
                                R.drawable.four
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.five, //5
                        R.drawable.pluse,
                        R.drawable.three, // 3
                        new Ans(R.drawable.seven,
                                R.drawable.nine,
                                R.drawable.eight,
                                R.drawable.eight
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.three,
                        R.drawable.pluse,
                        R.drawable.three,
                        new Ans(R.drawable.eight,
                                R.drawable.five,
                                R.drawable.six,
                                R.drawable.six
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.six,
                        R.drawable.pluse,
                        R.drawable.one,
                        new Ans(R.drawable.five,
                                R.drawable.six,
                                R.drawable.seven,
                                R.drawable.seven
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.six,
                        R.drawable.pluse,
                        R.drawable.three,
                        new Ans(R.drawable.seven,
                                R.drawable.eight,
                                R.drawable.nine,
                                R.drawable.nine
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.five,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        new Ans(R.drawable.six,
                                R.drawable.three,
                                R.drawable.four,
                                R.drawable.four
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.three,
                        R.drawable.minus_purpol,
                        R.drawable.three,
                        new Ans(R.drawable.one,
                                R.drawable.six,
                                R.drawable.zero,
                                R.drawable.zero
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.eight,
                        R.drawable.minus_purpol,
                        R.drawable.four,
                        new Ans(R.drawable.six,
                                R.drawable.three,
                                R.drawable.four,
                                R.drawable.four
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.four,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        new Ans(R.drawable.six,
                                R.drawable.five,
                                R.drawable.three,
                                R.drawable.three
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.five,
                        R.drawable.minus_blue,
                        R.drawable.four,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.nine,
                                R.drawable.one
                                )));


        return     items;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
