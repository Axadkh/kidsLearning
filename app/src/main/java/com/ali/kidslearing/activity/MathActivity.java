package com.ali.kidslearing.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ali.kidslearing.R;
import com.ali.kidslearing.adapter.MathModel;
import com.ali.kidslearing.adapter.RvAdapter;

import java.util.ArrayList;

public class MathActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RvAdapter adapter;
    private ImageView btnPrevious, btnNext;
    private int currentPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        recyclerView = findViewById(R.id.recyclerView);
        btnPrevious = findViewById(R.id.prevId);
        btnNext = findViewById(R.id.nextId);

        initAdapter();

        clickLis();


    }

    private void initAdapter(){


        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        adapter = new RvAdapter(this, getMath());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private ArrayList<MathModel> getMath(){
        ArrayList<MathModel> items  = new  ArrayList<MathModel>();
        items.add(
                new MathModel(
                        R.drawable.one,
                        R.drawable.onef,
                        R.drawable.pluse,
                        R.drawable.three,
                        R.drawable.threef,
                        R.drawable.four,
                        R.drawable.fourf
                ));

        items.add(
                new MathModel(
                        R.drawable.four,
                        R.drawable.fourf,
                        R.drawable.pluse,
                        R.drawable.five,
                        R.drawable.fivef,
                        R.drawable.nine,
                        R.drawable.ninef
                ));


        items.add(
                new MathModel(
                        R.drawable.three,
                        R.drawable.threef,
                        R.drawable.pluse,
                        R.drawable.three,
                        R.drawable.threef,
                        R.drawable.six,
                        R.drawable.sixef
                ));

        items.add(
                new MathModel(
                        R.drawable.six,
                        R.drawable.sixef,
                        R.drawable.pluse,
                        R.drawable.one,
                        R.drawable.onef,
                        R.drawable.seven,
                        R.drawable.sevenf
                ));

        items.add(
                new MathModel(
                        R.drawable.eight,
                        R.drawable.eightf,
                        R.drawable.pluse,
                        R.drawable.one,
                        R.drawable.onef,
                        R.drawable.nine,
                        R.drawable.ninef
                ));


        items.add(
                new MathModel(
                        R.drawable.five,
                        R.drawable.fivef,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        R.drawable.onef,
                        R.drawable.four,
                        R.drawable.fourf
                ));


        items.add(
                new MathModel(
                        R.drawable.seven,
                        R.drawable.sevenf,
                        R.drawable.minus_purpol,
                        R.drawable.three,
                        R.drawable.threef,
                        R.drawable.four,
                        R.drawable.fourf
                ));

        items.add(
                new MathModel(
                        R.drawable.eight,
                        R.drawable.eightf,
                        R.drawable.minus_purpol,
                        R.drawable.four,
                        R.drawable.fourf,
                        R.drawable.four,
                        R.drawable.fourf
                ));


        items.add(
                new MathModel(
                        R.drawable.four,
                        R.drawable.fourf,
                        R.drawable.minus_blue,
                        R.drawable.one,
                        R.drawable.onef,
                        R.drawable.three,
                        R.drawable.threef
                ));


        items.add(
                new MathModel(
                        R.drawable.five,
                        R.drawable.fivef,
                        R.drawable.minus_blue,
                        R.drawable.four,
                        R.drawable.fourf,
                        R.drawable.one,
                        R.drawable.onef
                ));


        return     items;
    }
    public void clickLis(){
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition > 0) {
                    currentPosition--;
                    recyclerView.smoothScrollToPosition(currentPosition);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition < adapter.getItemCount() - 1) {
                    currentPosition++;
                    recyclerView.smoothScrollToPosition(currentPosition);
                }else{
                    finish();
                }
            }
        });
    }


}
