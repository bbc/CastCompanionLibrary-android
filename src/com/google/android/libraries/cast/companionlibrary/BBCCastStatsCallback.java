package com.google.android.libraries.cast.companionlibrary;

import android.os.Parcelable;


public interface BBCCastStatsCallback extends Parcelable {
    void castIconClicked();
    void castDialogDisconnect();
    void castDialogControl();
    void castDialogCancel();
    void castActivityPageView();
}
