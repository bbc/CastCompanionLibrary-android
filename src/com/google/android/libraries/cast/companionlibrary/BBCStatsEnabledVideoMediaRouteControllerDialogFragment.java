package com.google.android.libraries.cast.companionlibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.media.MediaRouter;
import android.view.View;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.libraries.cast.companionlibrary.cast.callbacks.VideoCastConsumer;
import com.google.android.libraries.cast.companionlibrary.cast.dialog.video.VideoMediaRouteControllerDialog;
import com.google.android.libraries.cast.companionlibrary.cast.dialog.video.VideoMediaRouteControllerDialogFragment;

import java.util.List;
import java.util.Locale;


public class BBCStatsEnabledVideoMediaRouteControllerDialogFragment extends VideoMediaRouteControllerDialogFragment implements VideoCastConsumer {
    public BBCStatsEnabledVideoMediaRouteControllerDialogFragment() {

    }

    @Override
    public VideoMediaRouteControllerDialog onCreateControllerDialog(Context context, Bundle savedInstanceState) {
        return new BBCStatsEnabledVideoMediaRouteControllerDialog(context, getStatsCallback());
    }

    @Override
    public void onPause() {
        super.onPause();
        getStatsCallback().castDialogCancel();
        BBCStatsEnabledVideoCastManager.getInstance().removeVideoCastConsumer(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        BBCStatsEnabledVideoCastManager.getInstance().addVideoCastConsumer(this);
    }



    private static BBCCastStatsCallback getStatsCallback() {
        return ((BBCStatsEnabledVideoCastManager)BBCStatsEnabledVideoCastManager.getInstance()).getBBCCastStatsCallback();
    }

    @Override
    public void onApplicationConnected(ApplicationMetadata appMetadata, String sessionId, boolean wasLaunched) {

    }

    @Override
    public void onApplicationConnectionFailed(int errorCode) {

    }

    @Override
    public void onApplicationStopFailed(int errorCode) {

    }

    @Override
    public void onApplicationStatusChanged(String appStatus) {

    }

    @Override
    public void onVolumeChanged(double value, boolean isMute) {

    }

    @Override
    public void onApplicationDisconnected(int errorCode) {
        getStatsCallback().castDialogDisconnect();
    }

    @Override
    public void onRemoteMediaPlayerMetadataUpdated() {

    }

    @Override
    public void onRemoteMediaPlayerStatusUpdated() {

    }

    @Override
    public void onNamespaceRemoved() {

    }

    @Override
    public void onDataMessageSendFailed(int errorCode) {

    }

    @Override
    public void onDataMessageReceived(String message) {

    }

    @Override
    public void onTextTrackStyleChanged(TextTrackStyle style) {

    }

    @Override
    public void onTextTrackEnabledChanged(boolean isEnabled) {

    }

    @Override
    public void onTextTrackLocaleChanged(Locale locale) {

    }

    @Override
    public void onMediaLoadResult(int statusCode) {

    }

    @Override
    public void onMediaQueueUpdated(List<MediaQueueItem> queueItems, MediaQueueItem item, int repeatMode, boolean shuffle) {

    }

    @Override
    public void onRemoteMediaPreloadStatusUpdated(MediaQueueItem item) {

    }

    @Override
    public void onUpcomingPlayClicked(View v, MediaQueueItem item) {

    }

    @Override
    public void onUpcomingStopClicked(View view, MediaQueueItem upcomingItem) {

    }

    @Override
    public void onMediaQueueOperationResult(int operationId, int statusCode) {

    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectionSuspended(int cause) {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

    }

    @Override
    public void onCastDeviceDetected(MediaRouter.RouteInfo info) {

    }

    @Override
    public void onCastAvailabilityChanged(boolean castPresent) {

    }

    @Override
    public void onConnectivityRecovered() {

    }

    @Override
    public void onUiVisibilityChanged(boolean visible) {

    }

    @Override
    public void onReconnectionStatusChanged(int status) {

    }

    @Override
    public void onDeviceSelected(CastDevice device) {

    }

    @Override
    public void onFailed(int resourceId, int statusCode) {

    }
}
