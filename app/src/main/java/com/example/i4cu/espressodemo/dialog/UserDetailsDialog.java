package com.example.i4cu.espressodemo.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.i4cu.espressodemo.R;

/**
 * Created by Quan Bui on 9/8/16.
 */
public class UserDetailsDialog extends DialogFragment {

    @BindView(R.id.imvClose)
    ImageView imvClose;

    @BindView(R.id.tvUserName)
    TextView tvUserName;

    @BindView(R.id.tvUserAge)
    TextView tvUserAge;

    private String name;

    private int age;

    public static UserDetailsDialog newInstance(String name, int age) {
        UserDetailsDialog dialog = new UserDetailsDialog();

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("age", age);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        name = getArguments().getString("name");
        age = getArguments().getInt("age");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.dialog_user_details, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        tvUserName.setText(name);
        tvUserAge.setText(String.valueOf(age));
    }

    @OnClick(R.id.imvClose)
    public void onCloseButtonClicked() {
        dismiss();
    }
}
