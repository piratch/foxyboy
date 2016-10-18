package twinsynergy.foxgyboy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import twinsynergy.foxgyboy.R;
import twinsynergy.foxgyboy.adapter.ViewListFriendAdapter;

public class MainFragment extends Fragment {

    @BindView(R.id.recycler_view_list_friend) RecyclerView recyclerViewListFriend;
    RecyclerView.Adapter viewListFriendAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        viewListFriendAdapter = new ViewListFriendAdapter();
        recyclerViewListFriend.setHasFixedSize(true);
        recyclerViewListFriend.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewListFriend.setAdapter(viewListFriendAdapter);
        viewListFriendAdapter.notifyDataSetChanged();
    }

}
