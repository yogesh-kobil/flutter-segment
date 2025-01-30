package com.example.flutter_segment;

import android.os.Bundle;

import java.util.HashMap;

public class FlutterSegmentOptions {
    private final String writeKey;
    private final String apiHost;
    private final Boolean trackApplicationLifecycleEvents;
    private final Boolean debug;

    public FlutterSegmentOptions(
            String writeKey,
            String apiHost,
            Boolean trackApplicationLifecycleEvents,
            Boolean debug) {
        this.writeKey = writeKey;
        this.apiHost = apiHost;
        this.trackApplicationLifecycleEvents = trackApplicationLifecycleEvents;
        this.debug = debug;
    }

    public String getWriteKey() {
        return writeKey;
    }

    public String getApiHost() {
        return apiHost;
    }

    public Boolean getTrackApplicationLifecycleEvents() {
        return trackApplicationLifecycleEvents;
    }

    public Boolean getDebug() {
        return debug;
    }

    static FlutterSegmentOptions create(Bundle bundle) {
        String writeKey = bundle.getString("com.claimsforce.segment.WRITE_KEY");
        Boolean trackApplicationLifecycleEvents = bundle
                .getBoolean("com.claimsforce.segment.TRACK_APPLICATION_LIFECYCLE_EVENTS");
        String apiHost = bundle
                .getString("com.claimsforce.segment.API_HOST");
        Boolean debug = bundle.getBoolean("com.claimsforce.segment.DEBUG", false);
        return new FlutterSegmentOptions(writeKey, apiHost, trackApplicationLifecycleEvents, debug);
    }

    static FlutterSegmentOptions create(HashMap<String, Object> options) {
        String writeKey = (String) options.get("writeKey");
        String apiHost = (String) options.get("apiHost");
        Boolean trackApplicationLifecycleEvents = (Boolean) options.get("trackApplicationLifecycleEvents");
        Boolean debug = orFalse((Boolean) options.get("debug"));
        return new FlutterSegmentOptions(writeKey, apiHost, trackApplicationLifecycleEvents, debug);
    }

    private static Boolean orFalse(Boolean value) {
        return value == null ? false : value;
    }
}
