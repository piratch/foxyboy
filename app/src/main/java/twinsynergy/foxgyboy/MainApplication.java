package twinsynergy.foxgyboy;

import android.app.Application;

/**
 * Created by peem-jirayu on 17/10/2559.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
