package com.zgz.zplayandroid.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/17
 * @time 15:46
 * @description
 **/
public abstract class BaseActivity extends AppCompatActivity implements BaseView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
