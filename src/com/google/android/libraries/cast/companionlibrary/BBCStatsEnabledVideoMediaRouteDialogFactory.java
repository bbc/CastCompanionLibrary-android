package com.google.android.libraries.cast.companionlibrary;

import android.support.annotation.NonNull;
import android.support.v7.app.MediaRouteControllerDialogFragment;
import android.support.v7.app.MediaRouteDialogFactory;


public class BBCStatsEnabledVideoMediaRouteDialogFactory extends MediaRouteDialogFactory {

    private boolean showControlDialogVolumeControl;

    public BBCStatsEnabledVideoMediaRouteDialogFactory(boolean showControlDialogVolumeControl) {
        this.showControlDialogVolumeControl = showControlDialogVolumeControl;
    }

    @NonNull
    @Override
    public BBCStatsEnabledVideoMediaRouteControllerDialogFragment onCreateControllerDialogFragment() {
        return BBCStatsEnabledVideoMediaRouteControllerDialogFragment.newInstance(showControlDialogVolumeControl);
    }
}
