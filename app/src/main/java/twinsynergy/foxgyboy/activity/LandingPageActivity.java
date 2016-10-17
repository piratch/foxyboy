package twinsynergy.foxgyboy.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import twinsynergy.foxgyboy.R;

public class LandingPageActivity extends AppCompatActivity {

    @BindView(R.id.imv_character_boy_landing_page) ImageView imvCharacterBoyLandingPage;
    @BindView(R.id.imv_cloud1_landing_page) ImageView imvCould1LandingPage;
    @BindView(R.id.imv_cloud2_landing_page) ImageView imvCould2LandingPage;
    @BindView(R.id.imv_cloud3_landing_page) ImageView imvCould3LandingPage;
    @BindView(R.id.imv_bg_landing_page) ImageView imvBgLandingPage;
    @BindView(R.id.imv_logo_landing_page) ImageView imvLogoLandingPage;
    @BindView(R.id.imv_character_cat_landing_page) ImageView imvCharacterCatLandingPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        ButterKnife.bind(this);
        initInstance();
    }

    private void initInstance() {
        loadImage(R.drawable.bg_landing_page,imvBgLandingPage);
        loadImage(R.drawable.character_boy_landing_page,imvCharacterBoyLandingPage);
        loadImage(R.drawable.cloud1_landing_page,imvCould1LandingPage);
        loadImage(R.drawable.cloud2_landing_page,imvCould2LandingPage);
        loadImage(R.drawable.cloud3_landing_page,imvCould3LandingPage);
        loadImage(R.drawable.logo_foxgyboy_landing_page,imvLogoLandingPage);
        loadImageRotation(R.drawable.character_cat_landing_page,imvCharacterCatLandingPage);
        setViewAnimationFadeIn(imvCharacterBoyLandingPage);
        setViewAnimationFadeIn(imvCould1LandingPage);
        setViewAnimationFadeIn(imvCould2LandingPage);
        setViewAnimationFadeIn(imvCould3LandingPage);
        setViewAnimationFadeIn(imvLogoLandingPage);
        setViewAnimationTransition(imvCharacterCatLandingPage);
    }

    private void loadImage(int drawablePicture , ImageView imageView) {
        Glide.with(LandingPageActivity.this)
                .load(drawablePicture)
                .fitCenter()
                .into(imageView);
    }

    private void loadImageRotation(int drawablePicture , ImageView imageView) {
        imvCharacterCatLandingPage.setRotation(45);
        Glide.with(LandingPageActivity.this)
                .load(drawablePicture)
                .fitCenter()
                .into(imageView);
    }



    private void setViewAnimationFadeIn(ImageView imageView){
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", .1f, 1f);
        fadeIn.setDuration(2000);
        fadeIn.start();
    }

    private void setViewAnimationTransition(ImageView imageView){
        ObjectAnimator animX = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_X, -40f);
        ObjectAnimator animY = ObjectAnimator.ofFloat(imageView, View.TRANSLATION_Y, 140f);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animX, animY);
        animSet.setDuration(1000);
        animSet.start();
    }
}
