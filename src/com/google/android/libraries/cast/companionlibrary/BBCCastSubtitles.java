package com.google.android.libraries.cast.companionlibrary;

import android.support.v7.media.MediaRouter;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.libraries.cast.companionlibrary.cast.VideoCastManager;
import com.google.android.libraries.cast.companionlibrary.cast.callbacks.VideoCastConsumer;
import com.google.android.libraries.cast.companionlibrary.cast.exceptions.NoConnectionException;
import com.google.android.libraries.cast.companionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import java.util.List;
import java.util.Locale;

public class BBCCastSubtitles {

    private boolean mSubtitlesOn = false;
    public static final String MESSAGE_SUBTITLES_ON = "subtitlesOn";
    public static final String MESSAGE_SUBTITLES_OFF = "subtitlesOff";

    private VideoCastManager videoCastManager;
    private ImageButton mClosedCaptionIcon;

    public BBCCastSubtitles(final ImageButton mClosedCaptionIcon) {

        this.mClosedCaptionIcon = mClosedCaptionIcon;

        videoCastManager = VideoCastManager.getInstance();

        videoCastManager.addVideoCastConsumer(new VideoCastConsumer() {

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

            }

            @Override
            public void onRemoteMediaPlayerMetadataUpdated() {
            }

            @Override
            public void onRemoteMediaPlayerStatusUpdated() {

                BBCCustomCastStatusData castStatusData;
                MediaStatus mediaStatus = videoCastManager.getMediaStatus();

                if (mediaStatus == null || mediaStatus.getCustomData() == null) {
                    castStatusData = new BBCCustomCastStatusData();
                } else {
                    castStatusData = new BBCCustomCastStatusData(mediaStatus.getCustomData());
                }

                setSubtitlesEnabled(castStatusData.isSubtitlesEnabled());
                setSubtitlesAvailable(castStatusData.isSubtitlesAvailable());
            }

            @Override
            public void onNamespaceRemoved() {

            }

            @Override
            public void onDataMessageSendFailed(int errorCode) {

            }

            @Override
            public void onDataMessageReceived(String message) {
                handleCastMessage(message);
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
        });
    }

    public void handleCastMessage(String message) {
        setSubtitlesEnabled(MESSAGE_SUBTITLES_ON.equals(message));
    }

    private void setSubtitlesAvailable(boolean subtitlesAvailable) {
        if(subtitlesAvailable) {
            mClosedCaptionIcon.setVisibility(View.VISIBLE);
        } else {
            mClosedCaptionIcon.setVisibility(View.GONE);
        }
    }

    private void setSubtitlesEnabled(boolean subtitlesEnabled) {
        mSubtitlesOn = subtitlesEnabled;
    }

    public void toggleSubtitles() throws TransientNetworkDisconnectionException, NoConnectionException {

        String subtitleState;

        if(mSubtitlesOn) {
            subtitleState = MESSAGE_SUBTITLES_OFF;
        } else {
            subtitleState = MESSAGE_SUBTITLES_ON;
        }

        videoCastManager.sendDataMessage(subtitleState);
    }
}
