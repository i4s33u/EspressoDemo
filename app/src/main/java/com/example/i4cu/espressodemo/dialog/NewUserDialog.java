package com.example.i4cu.espressodemo.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.i4cu.espressodemo.R;
import com.example.i4cu.espressodemo.User;

/**
 * Created by Quan Bui on 07/09/2016.
 */
public class NewUserDialog
    extends DialogFragment {

    @BindView(R.id.edtName)
    EditText edtName;

    @BindView(R.id.edtAge)
    EditText edtAge;

    private Callback mCallback;

    public NewUserDialog() {

    }

    public static NewUserDialog newInstance() {
        return new NewUserDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.dialog_create_user, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        edtName.requestFocus();
        getDialog().getWindow()
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @OnClick(R.id.btnSubmit)
    public void onButtonClicked() {
        submitData();
    }

    public void submitData() {
        String name = edtName.getText().toString();
        String age = edtAge.getText().toString();
        if (!name.isEmpty() && !age.isEmpty()) {
            User newUser = new User(name, Integer.parseInt(age));
            mCallback.submit(newUser);
        } else {
            mCallback.cancel();
        }
        dismiss();
    }

    public interface Callback {
        void submit(User user);
        void cancel();
    }

    public void setCallback(Callback mCallback) {
        this.mCallback = mCallback;
    }
}
