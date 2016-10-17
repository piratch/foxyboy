package twinsynergy.foxgyboy.manager.bus;

import android.support.v4.app.Fragment;

/**
 * Created by Dev on 9/5/2016 AD.
 */
public class EventFragment {
    public Fragment fragment;

    public EventFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}