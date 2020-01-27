package com.example.fragments_and_viewmodels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtText;
    private MainViewmodel mainViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize MainViewmodel
        mainViewmodel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewmodel.class);
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
    }

    private void setText(int count) {
        txtText.setText("Some text: count" + count);
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
