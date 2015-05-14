package com.google.android.libraries.cast.companionlibrary;

import android.os.Parcelable;


public interface BBCCastStatsCallback {
    void castIconClicked();
    void castDialogDisconnect();
    void castDialogControl();
    void castDialogCancel();
    void castActivityPageView();
}
