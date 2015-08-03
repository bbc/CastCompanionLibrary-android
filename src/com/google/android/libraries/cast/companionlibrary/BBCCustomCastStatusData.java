package com.google.android.libraries.cast.companionlibrary;

import org.json.JSONException;
import org.json.JSONObject;

public class BBCCustomCastStatusData {

    private boolean subtitlesEnabled = false;
    private boolean subtitlesAvailable = false;

    public BBCCustomCastStatusData(JSONObject customData) {
        try {
            subtitlesEnabled = customData.getBoolean("subtitlesEnabled");
        } catch (JSONException e) {
            subtitlesEnabled = false;
        }
        try {
            subtitlesAvailable = customData.getBoolean("subtitlesAvailable");
        } catch (JSONException e) {
            subtitlesAvailable = false;
        }
    }

    public BBCCustomCastStatusData() {

    }

    public boolean isSubtitlesEnabled() {
        return subtitlesEnabled;
    }

    public boolean isSubtitlesAvailable() {
        return subtitlesAvailable;
    }
}
