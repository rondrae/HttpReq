package com.example.rondrae.httpreq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText =findViewById(R.id.textViewID);


        OkHttpClient client = new OkHttpClient();
        String site ="https://www.pornhub.com/webmasters/search?id=44bc40f3bc04f65b7a35&search=hard&tags[]=Teen&thumbsize=medium" ;


        Request  request = new Request.Builder()
                .url(site)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){

                    //final String [] myResponse = response.body().string();
                    try {
                         JSONArray myResponse = new JSONArray(response.body());
                         if (myResponse !=null && myResponse.length() > 0){

                             for (int i =0; i < myResponse.length(); i++)
                             {
                                 JSONObject object = myResponse.getJSONObject(i);
                                 mText.setText(object.getString(String.valueOf(0)));

                             }

                         }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            //mText.setText(myResponse);
                        }
                    });

                }
            }
        });
    }
}
