package com.bendrisstarek.rabobankassessment.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bendrisstarek.rabobankassessment.util.ActivityUtils;


/**
 * this class represents the custom activity
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Resources mResources;
    protected BaseActivity mActivity;
    protected Context mContext;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = mActivity = this;
        mResources = getResources();
        retrieveExtras(getIntent() != null && getIntent().getExtras() != null ? getIntent().getExtras() : new Bundle());
        ActivityUtils.setFullScreenMode(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




    protected void retrieveExtras(Bundle bundle) {
    }

    protected void removeExtras(Bundle bundle) {
    }
}