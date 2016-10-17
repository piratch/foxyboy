package twinsynergy.foxgyboy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import twinsynergy.foxgyboy.R;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.imv_splash_screen) ImageView imvSplashScreen;
    Handler handler = new Handler();
    Runnable runnable;
    long delay_time;
    long time = 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        initInstance();
    }

    private void initInstance() {
        loadImage();
        startThread();
    }

    private void loadImage() {
        Glide.with(SplashScreenActivity.this)
                .load(R.drawable.logo_splash_screen)
                .crossFade()
                .centerCrop()
                .into(imvSplashScreen);
    }

    private void goToMainActivity(){
        startActivity(new Intent(SplashScreenActivity.this,LandingPageActivity.class));
        SplashScreenActivity.this.overridePendingTransition(0, 0);
        finish();
    }

    private void startThread(){
        runnable = new Runnable() {
            public void run() {
                goToMainActivity();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}
