package com.example.rondrae.httpreq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



        public class MainActivity extends AppCompatActivity {

            private TextView mText;
            private ImageView image, image2, image3, etc;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mText = findViewById(R.id.textViewID);


                OkHttpClient client = new OkHttpClient();
               //String site = "http://academyapptest.herokuapp.com/posts";
                String site = "https://www.pornhub.com/webmasters/search?id=44bc40f3bc04f65b7a35&search=hard&tags[]=Teen&thumbsize=medium";


                Request request = new Request.Builder()
                        .url(site)
                        .build();


                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {

                            final String myResponse = response.body().string();
                            //JSONObject object = null;
                            try {
                                //get everything from the API and store it in an object
                               JSONObject object = new JSONObject(myResponse);


                               //CREATE AN ARRAY FROM THE OBJECT HOLD ALL THE INFOR
                                JSONArray videos = object.getJSONArray("videos");


                                for (int i = 0; i < videos.length(); i++) {

                                    //CREATE AN OBJECT FROM THE MAIN OBJECT
                                    JSONObject videoObject = videos.getJSONObject(i);
                                    Log.d("good",videoObject.getString("default_thumb"));

                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            /*MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mText.setText(myResponse);
                                }
                            });*/

                        }
                    }
                });
            }
        }

