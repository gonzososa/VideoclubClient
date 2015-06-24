package com.outlook.gonzasosa.demos.videoclubclient.REST;

import com.outlook.gonzasosa.demos.videoclubclient.Interfaces.VideoClubService;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class VideoclubClient {
    private static VideoClubService vc;
    private static String ROOT = "http://XAMANEK:52444/api";

    static {
        setupRestClient ();
    }

    private VideoclubClient () {}

    public static VideoClubService get () {
        return vc;
    }

    private static void setupRestClient () {
        RestAdapter.Builder builder = new RestAdapter.Builder ()
                .setEndpoint    (ROOT)
                .setClient      (new OkClient (new OkHttpClient ()))
                .setLogLevel    (RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build ();
        vc = restAdapter.create (VideoClubService.class);
    }
}
