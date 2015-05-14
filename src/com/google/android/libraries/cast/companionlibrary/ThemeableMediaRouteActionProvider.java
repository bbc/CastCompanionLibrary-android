package com.google.android.libraries.cast.companionlibrary;
import android.content.Context;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.app.MediaRouteButton;

/**
 * A MediaRouteActionProvider that allows the use of a ThemeableMediaRouteButton.
 */
public class ThemeableMediaRouteActionProvider extends MediaRouteActionProvider {

    public ThemeableMediaRouteActionProvider(Context context) {
        super(context);
    }

    @Override public MediaRouteButton onCreateMediaRouteButton() {
        return new ThemeableMediaRouteButton(getContext());
    }
}
