package com.snail.activityforresult;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: snail
 * Data: 3/29/21.
 * Des:
 * version:
 */

public class ActivityForResultUtil {

    private static List<FragmentActivity> sFragmentActivities = new ArrayList();
    private static int sCode = 10000;

    public static  synchronized void startActivityForResult(
            FragmentActivity activity,
            Intent intent,
             OnActivityResultListener listener) {
        if (sFragmentActivities.contains(activity)) {
            return;
        }
        try {
            new HelpDialogFragment(intent, listener, sCode++).show(activity.getSupportFragmentManager(), "");
        } catch (Exception ignore) {
        }
    }


    public static class HelpDialogFragment extends DialogFragment {

        private Intent intent;
        private final  OnActivityResultListener listener;
        private int requestCode;

        public HelpDialogFragment(Intent intent,
                                 OnActivityResultListener listener, int code) {
            this.intent = intent;
            this.listener = listener;
            this.requestCode = code;

        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            sFragmentActivities.add(getActivity());
            if (intent != null) {
                startActivityForResult(intent, requestCode);
            }
        }

        public void onStart() {
            super.onStart();
            if (this.getDialog().getWindow() != null) {
                setCancelable(false);
                this.getDialog().getWindow().setDimAmount(0.0F);
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (listener != null && this.requestCode == requestCode) {
                listener.onActivityResult(requestCode, resultCode, data);
                sFragmentActivities.remove(getActivity());
                dismissAllowingStateLoss();
            }
        }
    }

}
