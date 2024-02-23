package com.ali.kidslearing.activity;

import android.os.Bundle;
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

import java.util.ArrayList;

public class MathExceriseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExcriseAdapter adapter;
    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excerise);
        Window w = getWindow();

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

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
                if (currentPosition < adapter.getItemCount() - 1) {
                    currentPosition++;
                    recyclerView.smoothScrollToPosition(currentPosition);
                }else{
                    finish();
                }
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
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.four,
                        R.drawable.pluse,
                        R.drawable.five,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.three,
                        R.drawable.pluse,
                        R.drawable.three,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.six,
                        R.drawable.pluse,
                        R.drawable.one,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.eight,
                        R.drawable.pluse,
                        R.drawable.one,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.five,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.seven,
                        R.drawable.minus_purpol,
                        R.drawable.three,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));

        items.add(
                new ExcriseModel(
                        R.drawable.eight,
                        R.drawable.minus_purpol,
                        R.drawable.four,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.four,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                        )));


        items.add(
                new ExcriseModel(
                        R.drawable.five,
                        R.drawable.minus_blue,
                        R.drawable.four,
                        new Ans(R.drawable.one,
                                R.drawable.three,
                                R.drawable.six,
                                R.drawable.one
                                )));


        return     items;
    }



}
