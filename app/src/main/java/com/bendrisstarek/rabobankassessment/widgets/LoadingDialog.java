package com.bendrisstarek.rabobankassessment.widgets;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.bendrisstarek.rabobankassessment.R;
import com.bendrisstarek.rabobankassessment.databinding.DialogLoadingBinding;
import com.bendrisstarek.rabobankassessment.util.ActivityUtils;
import com.bendrisstarek.rabobankassessment.util.FragmentUtils;



/**
 * this class represents a custom dialog fragment
 */
public class LoadingDialog extends DialogFragment {

    /**
     * used to show a loading dialog
     * @param context
     * @param dialog
     */
    public static void show(@NonNull Context context, @NonNull LoadingDialog dialog) {
        final FragmentManager manager = ActivityUtils.getManager(context);

        if (manager != null && !dialog.isAdded() && !dialog.isVisible()) {
            if (manager.findFragmentByTag(LoadingDialog.class.getName()) != null) return;
            dialog.show(manager, LoadingDialog.class.getName());
        }

    }

    /**
     * get a new instance of the loading dialog
     * @return
     */
    public static LoadingDialog newInstance() {
        LoadingDialog dialog = new LoadingDialog();
        dialog.setCancelable(false);
        return dialog;
    }

    public static void dismiss(@NonNull LoadingDialog dialog) {
        if (dialog.getActivity() != null && !dialog.getActivity().isFinishing() && dialog.isAdded()) {
            dialog.dismiss();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if(dialog.getWindow() != null)
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        dialog.getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        return dialog;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DialogLoadingBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_loading, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        FragmentUtils.setWindowFullSize(this);
    }

}


