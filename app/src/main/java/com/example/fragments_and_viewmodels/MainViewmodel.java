package com.example.fragments_and_viewmodels;

import androidx.lifecycle.ViewModel;

public class MainViewmodel extends ViewModel {
    int getCount(String s) {
        return s.length();
    }
}
