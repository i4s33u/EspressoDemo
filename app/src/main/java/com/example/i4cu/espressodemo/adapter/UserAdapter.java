package com.example.i4cu.espressodemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.i4cu.espressodemo.R;
import com.example.i4cu.espressodemo.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quan Bui on 07/09/2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;

    private Callback mCallback;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (null != mCallback) {

                ViewHolder viewHolder = (ViewHolder) v.getTag();
                User user = viewHolder.userModel;

                mCallback.onOpenUserDetails(user);
            }
        }
    };

    public UserAdapter(Callback callback) {
        userList = new ArrayList<>();
        mCallback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.card_view_item, parent, false);

        return new ViewHolder(itemView, onClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.userModel = user;

        holder.tvName.setText(user.getName());
        holder.tvAge.setText(String.valueOf(user.getAge()));
    }

    @Override
    public int getItemCount() {
        return null == userList ? 0 : userList.size();
    }

    public void addUser(User newUser) {
        userList.add(newUser);
        notifyItemInserted(userList.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.cv)
        CardView cv;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvAge)
        TextView tvAge;

        public User userModel;

        public ViewHolder(View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cv.setOnClickListener(onClickListener);
            cv.setTag(this);

            itemView.setTag(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnItemClickListener {
        void onItemClick(User item);
    }

    public interface Callback {
        void onOpenUserDetails(User user);
    }
}
