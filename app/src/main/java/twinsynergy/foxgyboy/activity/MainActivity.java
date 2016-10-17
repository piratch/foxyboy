package twinsynergy.foxgyboy.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.squareup.otto.Subscribe;

import butterknife.ButterKnife;
import twinsynergy.foxgyboy.R;
import twinsynergy.foxgyboy.fragment.LoginFragment;
import twinsynergy.foxgyboy.manager.MainBus;
import twinsynergy.foxgyboy.manager.bus.EventFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initInstance();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container,LoginFragment.newInstance())
                    .commit();
        }
    }

    private void initInstance(){
    }

    @Subscribe
    public void onEventFragment(EventFragment eventFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, eventFragment.getFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().unregister(this);
    }
}
