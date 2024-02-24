package com.ali.kidslearing.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ali.kidslearing.R;
import com.ali.kidslearing.util.Const;
import com.ali.kidslearing.util.PrefHelper;
import com.ali.kidslearing.util.SharedPreferencesHelper;

public class ProfileActivity extends AppCompatActivity {


    SharedPreferencesHelper sp;
    TextView tvname,tvmath,tvvegi,tvanimal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        Window w = getWindow();
        sp = PrefHelper.getPrefHelper(ProfileActivity.this);
        String name =  sp.getString(Const.userName,"");

        int mathScore =  sp.getInt(Const.mathTest,0);

        initUi();
        tvname.setText("Name: "+ name);
        tvmath.setText(mathScore+"");
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


    }


    public  void initUi(){
        tvname = findViewById(R.id.name);
        tvmath = findViewById(R.id.math);
        tvvegi = findViewById(R.id.vegi);
        tvanimal = findViewById(R.id.animal);

    }
}
