package twinsynergy.foxgyboy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import twinsynergy.foxgyboy.R;

/**
 * Created by peem-jirayu on 17/10/2559.
 */

public class ViewListFriendAdapter extends RecyclerView.Adapter {
    int type;
    private static class YourTurnViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTime;
        public YourTurnViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }
    private static class TheirTurnViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTime;
        public TheirTurnViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }

    private static class OtherFriendHeader extends RecyclerView.ViewHolder{
        TextView tvName;
        public OtherFriendHeader(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);

        }
    }
    private static class OtherFriend extends RecyclerView.ViewHolder{
        TextView tvName;
        public OtherFriend(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (type) {
            case 0:  {
                View view = inflater.inflate(R.layout.recycler_view_list_friend_your_turn_adpater,parent,false);
                YourTurnViewHolder yourTurnViewHolder = new YourTurnViewHolder(view);
                return yourTurnViewHolder;
            }
            case 1: {
                View view = inflater.inflate(R.layout.recycler_view_list_friend_your_their_adpater,parent,false);
                TheirTurnViewHolder theirTurnViewHolder = new TheirTurnViewHolder(view);
                return theirTurnViewHolder;
            }
            case 2 :{
                View view = inflater.inflate(R.layout.recycler_view_list_friend_other_adapter,parent,false);
                OtherFriendHeader otherFriendHeaderViewHolder = new OtherFriendHeader(view);
                return otherFriendHeaderViewHolder;
            }case 3 : default: {
                View view = inflater.inflate(R.layout.recycler_view_list_friend_other_position_adpter,parent,false);
                OtherFriend otherFriendViewHolder = new OtherFriend(view);
                return otherFriendViewHolder;
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case 0 :{
                ((YourTurnViewHolder)holder).tvName.setText("นางสาว สมหญิง หญิงจริงป่ะ");
                ((YourTurnViewHolder)holder).tvTime.setText("50 minute ago");
                break;
            }
            case 1 : {
                ((TheirTurnViewHolder) holder).tvName.setText("นางสาว สมหญิง หญิงจริงป่ะ");
                ((TheirTurnViewHolder) holder).tvTime.setText("50 minute ago");
                break;
            }case 2 :{
                ((OtherFriendHeader)holder).tvName.setText("นางสาว สมหญิง หญิงจริงป่ะ");
                break;
            }case 3 :{
                ((OtherFriend)holder).tvName.setText("นางสาว สมหญิง หญิงจริงป่ะ");
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        //dummy data
        if (position == 0 ){
            type = 0;
        }else if (position == 1) {
            type = 1;
        }else if (position == 2) {
            type = 2;
        }else {
            type = 3;
        }
        return type;
    }
}
