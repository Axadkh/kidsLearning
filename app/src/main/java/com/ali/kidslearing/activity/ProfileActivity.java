package com.ali.kidslearing.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ali.kidslearing.R;
import com.ali.kidslearing.adapter.QuizAdapter;
import com.ali.kidslearing.util.Const;
import com.ali.kidslearing.util.PrefHelper;
import com.ali.kidslearing.util.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ProfileActivity extends AppCompatActivity {


    SharedPreferencesHelper sp;
    RecyclerView quizRv;
    TextView tvname;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        Window w = getWindow();
        sp = PrefHelper.getPrefHelper(ProfileActivity.this);
        String name =  sp.getString(Const.userName,"");

        initUi();
        tvname.setText("Name: "+ name);

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setAdapter();

    }


    public  void setAdapter(){

        QuizAdapter adapter = new QuizAdapter(ProfileActivity.this,getQuiz());
        quizRv.setAdapter(adapter);
        quizRv.setNestedScrollingEnabled(false);
        quizRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }


    public ArrayList<String> getQuiz(){
       String quiz = sp.getString(Const.mathTest,"");

       String[] quizAr= quiz.split(",");
       ArrayList<String> list = new ArrayList<>();

       for (String s : quizAr){
           list.add(s);
       }
        Collections.reverse(list);

       return  list;
    }
    public  void initUi(){
        tvname = findViewById(R.id.name);
        quizRv = findViewById(R.id.quizRv);


    }
}
