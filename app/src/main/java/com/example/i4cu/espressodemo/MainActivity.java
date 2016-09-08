package com.example.i4cu.espressodemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.i4cu.espressodemo.adapter.UserAdapter;
import com.example.i4cu.espressodemo.dialog.NewUserDialog;
import com.example.i4cu.espressodemo.dialog.UserDetailsDialog;

public class MainActivity
    extends AppCompatActivity implements UserAdapter.Callback {

    @BindView(R.id.rvList)
    RecyclerView rvList;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mAdapter = new UserAdapter(this);
        RecyclerView.LayoutManager mLayoutManager =
            new LinearLayoutManager(getApplicationContext());
        rvList.setHasFixedSize(false);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOpenUserDetails(User user) {
        FragmentManager fm = getSupportFragmentManager();
        UserDetailsDialog dialog = UserDetailsDialog.newInstance(user.getName(), user.getAge());
        dialog.show(fm, "show user details");
    }

    public void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        NewUserDialog newUserDialog = NewUserDialog.newInstance();
        newUserDialog.setCallback(new NewUserDialog.Callback() {
            @Override
            public void submit(User user) {
                mAdapter.addUser(user);
            }

            @Override
            public void cancel() {
                Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_LONG).show();
            }
        });
        newUserDialog.show(fm, "add new user");
    }
}
