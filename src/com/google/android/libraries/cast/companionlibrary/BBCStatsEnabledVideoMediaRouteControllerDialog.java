package com.google.android.libraries.cast.companionlibrary;

import android.content.Context;

import com.google.android.libraries.cast.companionlibrary.cast.dialog.video.VideoMediaRouteControllerDialog;

/**
 * Created by lamons01 on 14/05/15.
 */
public class BBCStatsEnabledVideoMediaRouteControllerDialog extends VideoMediaRouteControllerDialog {
    private final BBCCastStatsCallback bbcCastStatsCallback;

    public BBCStatsEnabledVideoMediaRouteControllerDialog(Context context, BBCCastStatsCallback bbcCastStatsCallback) {
        super(context);
        this.bbcCastStatsCallback = bbcCastStatsCallback;
    }




}
