package com.google.android.libraries.cast.companionlibrary;

import android.content.Context;
import android.support.v7.app.MediaRouteDialogFactory;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.libraries.cast.companionlibrary.cast.VideoCastManager;
import com.google.android.libraries.cast.companionlibrary.cast.player.VideoCastController;

import static com.google.android.libraries.cast.companionlibrary.utils.LogUtils.LOGD;
import static com.google.android.libraries.cast.companionlibrary.utils.LogUtils.LOGE;


public class BBCStatsEnabledVideoCastManager extends VideoCastManager {
    private static final String TAG = "BBCCastManager";
    private final BBCCastStatsCallback bbcCastStatsCallback;

    public static synchronized BBCStatsEnabledVideoCastManager initialize(Context context,
                                                                          String applicationId, String dataNamespace, BBCCastStatsCallback bbcCastStatsCallback) {
        return BBCStatsEnabledVideoCastManager.initialize(context, applicationId, BBCStatsEnabledVideoCastControllerActivity.class, dataNamespace, bbcCastStatsCallback);
    }

    public static synchronized BBCStatsEnabledVideoCastManager initialize(Context context,
                                                                          String applicationId, Class<?> targetActivity, String dataNamespace, BBCCastStatsCallback bbcCastStatsCallback) {
        if (sInstance == null) {
            LOGD(TAG, "New instance of BBCStatsEnabledVideoCastManager is created");
            if (ConnectionResult.SUCCESS != GooglePlayServicesUtil
                    .isGooglePlayServicesAvailable(context)) {
                String msg = "Couldn't find the appropriate version of Google Play Services";
                LOGE(TAG, msg);
            }
            sInstance = new BBCStatsEnabledVideoCastManager(context, applicationId, targetActivity, dataNamespace, bbcCastStatsCallback);
            //VideoCastManager.sInstance = sInstance;
        }
        return (BBCStatsEnabledVideoCastManager) sInstance;
    }

    protected BBCStatsEnabledVideoCastManager(Context context, String applicationId, Class<?> targetActivity, String dataNamespace, BBCCastStatsCallback bbcCastStatsCallback) {
        super(context, applicationId, targetActivity, dataNamespace);
        this.bbcCastStatsCallback = bbcCastStatsCallback;
        setNextPreviousVisibilityPolicy(VideoCastController.NEXT_PREV_VISIBILITY_POLICY_HIDDEN);
    }

    @Override
    protected MediaRouteDialogFactory getMediaRouteDialogFactory() {
        return new BBCStatsEnabledVideoMediaRouteDialogFactory();
    }


    public BBCCastStatsCallback getBBCCastStatsCallback() {
        return bbcCastStatsCallback;
    }

    public static VideoCastManager getInstance() {
        if (sInstance == null) {
            String msg = "No VideoCastManager instance was found, did you forget to initialize it?";
            LOGE(TAG, msg);
            throw new IllegalStateException(msg);
        }
        return sInstance;
    }
}
