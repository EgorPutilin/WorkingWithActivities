package com.example.fragments_and_viewmodels.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fragments_and_viewmodels.ui.activities.MainViewmodel;
import com.example.fragments_and_viewmodels.R;
import com.example.fragments_and_viewmodels.ui.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private TextView txtText;
    private MainViewmodel mainViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize MainViewmodel
        mainViewmodel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewmodel.class);
        //для устаревших grade :  mainViewmodel = ViewModelProviders.of(this).get(MainViewmodel.class);
        txtText = findViewById(R.id.txtText);
        //txtText.setText("Some text: count" + mainViewmodel.getCount("Some text"));
        mainViewmodel.getCount("Some text");
        mainViewmodel.count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer count) {
                setText(count);
            }
        });

        Log.d("Lifecycle", "onCreate");
        addFragment();
    }

    private void setText(int count) {
        txtText.setText("Some text: count" + count);
    }

    private void addFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MainFragment mainFragment = new MainFragment();
        fragmentTransaction.add(R.id.mainContainer, mainFragment,  "MAIN_FRAGMENT");
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy");
    }


}
