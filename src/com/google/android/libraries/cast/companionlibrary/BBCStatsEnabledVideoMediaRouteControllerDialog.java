package com.google.android.libraries.cast.companionlibrary;

import android.content.Context;

import com.google.android.libraries.cast.companionlibrary.cast.dialog.video.VideoMediaRouteControllerDialog;


public class BBCStatsEnabledVideoMediaRouteControllerDialog extends VideoMediaRouteControllerDialog {
    private final BBCCastStatsCallback bbcCastStatsCallback;

    public BBCStatsEnabledVideoMediaRouteControllerDialog(Context context, BBCCastStatsCallback bbcCastStatsCallback, boolean showVolumeControl) {
        super(context);
        setVolumeControlEnabled(showVolumeControl);
        this.bbcCastStatsCallback = bbcCastStatsCallback;
    }




}
