package com.example.fragments_and_viewmodels.ui.activities;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewmodel extends ViewModel {

    public MutableLiveData<Integer> count = new MutableLiveData<>();

    public void getCount(String s) {
        count.postValue(s.length());
    }
}
