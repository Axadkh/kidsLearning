package com.ali.kidslearing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ali.kidslearing.activity.MathActivity;
import com.ali.kidslearing.activity.MathExceriseActivity;
import com.ali.kidslearing.activity.ProfileActivity;
import com.ali.kidslearing.activity.SettingsActivity;
import com.ali.kidslearing.util.BackgroundSoundService;
import com.ali.kidslearing.util.MusicManager;
import com.ali.kidslearing.util.PrefClass;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;



public class MainActivity extends AppCompatActivity  {

    ImageView numId = null;
    ImageView fruitId = null;
    ImageView animal = null;
    ImageView alphabetId = null;
    ImageButton monthBtn = null;
    ImageButton weekBtn = null;
    ImageView ivKids;
    CardView cvMath;
    CardView cvMathExc;
    ImageView comunityhelp;
    ImageView profileButton;
    ImageView veg;
    ImageView vihical;
    ImageView shape;
    ImageView color;
    ImageView day;
    ImageView month;
    ImageView body;
    MusicManager music_manager;
   // private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taw_activity_main);


            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        music_manager = new MusicManager(getApplicationContext());

        if (new PrefClass(getApplicationContext()).getSound() == true) {
            Intent svc = new Intent(this, BackgroundSoundService.class);
            svc.putExtra("isPlay", true);
            startService(svc);

        } else {
            Intent svc = new Intent(this, BackgroundSoundService.class);
            svc.putExtra("isPlay", false);
            startService(svc);
        }

        ivKids = findViewById(R.id.iv_kids);
        Glide.with(getApplicationContext())
                .load(R.drawable.kids_gif)
                .into(ivKids);

        numId = findViewById(R.id.numId);
        Glide.with(getApplicationContext())
                .load(R.drawable.num)
                .into(numId);

        fruitId = findViewById(R.id.fruitId);
        Glide.with(getApplicationContext())
                .load(R.drawable.fruit_gif)
                .into(fruitId);
        animal = findViewById(R.id.animal_id);
        Glide.with(getApplicationContext())
                .load(R.drawable.animal_gif)
                .into(animal);

        alphabetId = findViewById(R.id.alphabetId);
        Glide.with(getApplicationContext())
                .load(R.drawable.alpha_gif)
                .into(alphabetId);
        comunityhelp = findViewById(R.id.comunityhelp);
        veg = findViewById(R.id.veg);
        profileButton = findViewById(R.id.profileButton);
        vihical = findViewById(R.id.vihical);
        shape = findViewById(R.id.shape);
        color = findViewById(R.id.color);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        body = findViewById(R.id.body);
        cvMath = findViewById(R.id.cvMath);
        cvMathExc = findViewById(R.id.cvMathExc);
        monthBtn = (ImageButton)findViewById(R.id.monthId);
        weekBtn = (ImageButton)findViewById(R.id.weekId);

        final  ImageButton imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                final Animation myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                myRotation.setRepeatCount(0);
                imageButton.startAnimation(myRotation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presentActivity(v);

                    }
                }, 900);


            }
        });


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        onClick();
    }


    public void onClick() {

                fruitId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent fruitIntent = new Intent(MainActivity.this, FruitsActivity.class);
                        fruitIntent.putExtra("type", ResourcePool.fruit);
                        startActivity(fruitIntent);
                    }
                });

        animal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent animalIntent = new Intent(MainActivity.this, FruitsActivity.class);
                        animalIntent.putExtra("type", ResourcePool.animal);
                        startActivity(animalIntent);
                    }
                });

                comunityhelp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent comunity = new Intent(MainActivity.this, FruitsActivity.class);
                        comunity.putExtra("type", ResourcePool.comunity);
                        startActivity(comunity);
                    }
                });

                veg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent iveg = new Intent(MainActivity.this, FruitsActivity.class);
                        iveg.putExtra("type", ResourcePool.veg);
                        startActivity(iveg);
                    }
                });

        cvMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iveg = new Intent(MainActivity.this, MathActivity.class);
                startActivity(iveg);
            }
        });

        cvMathExc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iveg = new Intent(MainActivity.this, MathExceriseActivity.class);
                startActivity(iveg);
            }
        });







                vihical.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ivihical = new Intent(MainActivity.this, FruitsActivity.class);
                        ivihical.putExtra("type", ResourcePool.vehical);
                        startActivity(ivihical);
                    }
                });

                alphabetId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent alphabetIntent = new Intent(MainActivity.this, AlphabetActivity.class);
                        startActivity(alphabetIntent);
                    }
                });

                numId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent numberIntent = new Intent(MainActivity.this, NumberActivity.class);
                        startActivity(numberIntent);
                    }
                });

                monthBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent monthIntent = new Intent(MainActivity.this, KnowledgeActivity.class);
                        monthIntent.putExtra("type", ResourcePool.month);
                        startActivity(monthIntent);
                    }
                });


                weekBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent weekIntent = new Intent(MainActivity.this, KnowledgeActivity.class);
                        weekIntent.putExtra("type", ResourcePool.week);
                        startActivity(weekIntent);
                    }
                });

                shape.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent shape = new Intent(MainActivity.this, FruitsActivity.class);
                        shape.putExtra("type", ResourcePool.shape);
                        startActivity(shape);
                    }
                });

                color.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent color = new Intent(MainActivity.this, FruitsActivity.class);
                        color.putExtra("type", ResourcePool.color);
                        startActivity(color);
                    }
                });

                day.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent day = new Intent(MainActivity.this, FruitsActivity.class);
                        day.putExtra("type", ResourcePool.day);
                        startActivity(day);
                    }
                });


                month.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent month = new Intent(MainActivity.this, FruitsActivity.class);
                        month.putExtra("type", ResourcePool.months);
                        startActivity(month);
                    }
                });

                body.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent body = new Intent(MainActivity.this, FruitsActivity.class);
                        body.putExtra("type", ResourcePool.bodypart);
                        startActivity(body);
                    }
                });



    }

    public void presentActivity(View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.

                makeSceneTransitionAnimation(this, view, "transition");

        int revealX = (int) (view.getX() + view.getWidth() / 2);

        int revealY = (int) (view.getY() + view.getHeight() / 2);
        Intent intent =
                new Intent(this, SettingsActivity.class);
        intent.putExtra(SettingsActivity.
                EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(SettingsActivity.
                EXTRA_CIRCULAR_REVEAL_Y, revealY);
        ActivityCompat.
                startActivity(this, intent, options.toBundle());
    }

    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


    @Override
    public void onPause() {

        Log.e("0011", "onPause: 12");
        Intent svc = new Intent(this, BackgroundSoundService.class);
        svc.putExtra("isPlay", false);
        startService(svc);
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (new PrefClass(getApplicationContext()).getSound()) {
            Log.e("0011", "onResume: 11");
            Intent svc = new Intent(this, BackgroundSoundService.class);
            svc.putExtra("isPlay", true);
            startService(svc);

        } else {
            Log.e("0011", "onResume: 12");
            Intent svc = new Intent(this, BackgroundSoundService.class);
            svc.putExtra("isPlay", false);
            startService(svc);
        }

    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {

        Log.e("0011", "onDestroy: 12");
        Intent svc = new Intent(this, BackgroundSoundService.class);
        svc.putExtra("isPlay", false);
        startService(svc);
        super.onDestroy();
    }
}