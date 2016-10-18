package twinsynergy.foxgyboy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import twinsynergy.foxgyboy.R;
import twinsynergy.foxgyboy.manager.MainBus;
import twinsynergy.foxgyboy.manager.bus.EventFragment;

public class LoginFragment extends Fragment {

    @BindView(R.id.btn_facebook_login) Button btnFacebookLogin;
    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, rootView);
        initInstances();
        return rootView;
    }

    private void initInstances() {

    }

    @OnClick(R.id.btn_facebook_login)
    public void onClickBtnLogin(){
        MainBus.getInstance().getBus()
                .post(new EventFragment(MainFragment.newInstance()));
    }
}
