package com.google.android.libraries.cast.companionlibrary;

import android.os.Parcelable;


public interface BBCCastStatsCallback {
    void castIconClicked();
    void castDialogDisconnect();
    void castDialogControl();
    void castDialogCancel();
    void castActivityPageView();

    static BBCCastStatsCallback NULL = new BBCCastStatsCallback() {
        @Override
        public void castIconClicked() {

        }

        @Override
        public void castDialogDisconnect() {

        }

        @Override
        public void castDialogControl() {

        }

        @Override
        public void castDialogCancel() {

        }

        @Override
        public void castActivityPageView() {

        }
    };

}
