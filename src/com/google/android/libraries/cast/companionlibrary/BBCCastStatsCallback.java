package com.google.android.libraries.cast.companionlibrary;

import android.os.Parcelable;

/**
 * Created by lamons01 on 14/05/15.
 */
public interface BBCCastStatsCallback extends Parcelable {
    void castIconClicked();
    void castDialogDisconnect();
    void castDialogControl();
    void castDialogCancel();
    void castActivityPageView();
}
