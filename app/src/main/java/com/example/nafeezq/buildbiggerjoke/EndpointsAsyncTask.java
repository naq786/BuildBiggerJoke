package com.example.nafeezq.buildbiggerjoke;

/**
 * Created by nafeezq on 1/9/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.example.androidjokelibrary.JokeDisplayActivity;
import com.example.nafeezq.buildbigger.backend.newJokeApi.NewJokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import java.io.IOException;


/**
 * Created by nafeezq on 1/4/2017.
 */

class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
    private static NewJokeApi myApiService = null;
    private Context context;



    private AsyncTaskListener<String> asyncTaskListener;

    protected EndpointsAsyncTask(AsyncTaskListener<String> asyncTaskListener){
        this.asyncTaskListener = asyncTaskListener;
    }


    EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        if (myApiService == null) {  // Only do this once
            NewJokeApi.Builder builder = new NewJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://buildbiggerjoke-155106.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();

        }

        Log.d("JOKE_PATH", myApiService.toString());


        try {

            return myApiService.getJoke().execute().getJokeString();
        } catch (IOException e) {

            return e.getMessage();
        }


    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra("JOKE_DISPLAY", result);
        context.startActivity(intent);
        ((Activity)context).finish();
        if(result!=null && asyncTaskListener!=null){
            asyncTaskListener.onAsyncTaskComplete(result);
        }


    }


}
