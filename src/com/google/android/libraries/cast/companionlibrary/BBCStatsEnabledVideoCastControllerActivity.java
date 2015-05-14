package com.google.android.libraries.cast.companionlibrary;

import com.google.android.libraries.cast.companionlibrary.cast.player.VideoCastControllerActivity;

public class BBCStatsEnabledVideoCastControllerActivity extends VideoCastControllerActivity {

    @Override
    protected void onResume() {
        super.onResume();
        ((BBCStatsEnabledVideoCastManager)BBCStatsEnabledVideoCastManager.getInstance()).getBBCCastStatsCallback().castActivityPageView();
    }
}
