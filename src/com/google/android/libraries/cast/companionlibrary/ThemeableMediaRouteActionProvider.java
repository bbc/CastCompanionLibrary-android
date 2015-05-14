package com.google.android.libraries.cast.companionlibrary;
import android.content.Context;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.app.MediaRouteButton;

/**
 * A MediaRouteActionProvider that allows the use of a ThemeableMediaRouteButton.
 * See https://gist.github.com/rharter/c2787f9ddd32651e8885
 * @author Ryan Harter http://ryanharter.com/blog/2015/03/06/styling-chromecast-icons/
 */
public class ThemeableMediaRouteActionProvider extends MediaRouteActionProvider {

    public ThemeableMediaRouteActionProvider(Context context) {
        super(context);
    }

    @Override public MediaRouteButton onCreateMediaRouteButton() {
        return new ThemeableMediaRouteButton(getContext());
    }
}
