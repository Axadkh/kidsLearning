package com.ali.kidslearing.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ali.kidslearing.AlphabetActivity;
import com.ali.kidslearing.MainActivity;
import com.ali.kidslearing.R;
import com.ali.kidslearing.util.Const;
import com.ali.kidslearing.util.PrefClass;
import com.ali.kidslearing.util.PrefHelper;
import com.ali.kidslearing.util.SharedPreferencesHelper;
import com.ali.kidslearing.util.SharedPreferencesSingleton;

public class NameActivity extends AppCompatActivity {

    boolean vibration;
    EditText etUserName;
    RelativeLayout btn;
    ImageView ivMale,ivFemale;
    SharedPreferences preferences;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
         preferences = getSharedPreferences("vibration", MODE_PRIVATE);
        vibration = preferences.getBoolean("TicVib", true);

        setContentView(R.layout.activity_name);

            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        etUserName = findViewById(R.id.editText);
        ivMale = findViewById(R.id.ivMale);
        ivFemale = findViewById(R.id.ivFemale);

        btn = findViewById(R.id.rvSubmitNam);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etUserName.getText().toString().isEmpty()) {


                    PrefHelper.getPrefHelper(NameActivity.this).saveString(Const.userName,etUserName.getText().toString());
                    String gender =PrefHelper.getPrefHelper(NameActivity.this).getString(Const.gender,"");
                    if(gender.isEmpty()){
                        PrefHelper.getPrefHelper(NameActivity.this).saveString(Const.gender,"male");
                    }



                    Intent intent = new Intent(NameActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        ivFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefHelper.getPrefHelper(NameActivity.this).saveString(Const.gender,"female");
                ivFemale.setAlpha(0.70f);
                ivMale.setAlpha(1.f);
            }
        });

        ivMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefHelper.getPrefHelper(NameActivity.this).saveString(Const.gender,"male");
                ivMale.setAlpha(0.70f);
                ivFemale.setAlpha(1.f);
            }
        });

    }
}
