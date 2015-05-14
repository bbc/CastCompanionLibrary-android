package com.google.android.libraries.cast.companionlibrary;

import android.support.annotation.NonNull;
import android.support.v7.app.MediaRouteControllerDialogFragment;
import android.support.v7.app.MediaRouteDialogFactory;


public class BBCStatsEnabledVideoMediaRouteDialogFactory extends MediaRouteDialogFactory {

    public BBCStatsEnabledVideoMediaRouteDialogFactory() {

    }

    @NonNull
    @Override
    public BBCStatsEnabledVideoMediaRouteControllerDialogFragment onCreateControllerDialogFragment() {
        return new BBCStatsEnabledVideoMediaRouteControllerDialogFragment();
    }
}
