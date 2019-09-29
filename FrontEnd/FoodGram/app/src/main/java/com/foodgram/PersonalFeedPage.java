package com.foodgram;

import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PersonalFeedPage extends AppCompatActivity {
//    String JSON_String;

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    private Button signOut;
    private Button post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feed_page);

        signOut = (Button) findViewById(R.id.btn_signOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_page();
            }
        });

        post = (Button) findViewById(R.id.make_post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePost_page();
            }
        });


        mTextViewResult = findViewById(R.id.tv_ViewComments);
        Button btn_getFeed = findViewById(R.id.btn_getFeed);

        mQueue = Volley.newRequestQueue(this);

        btn_getFeed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getFeed();
            }
        });

    }


    public void welcome_page(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void makePost_page(){
        Intent intent = new Intent(this, MakePostPage.class);
        startActivity(intent);
    }


    public void getFeed() {

       // String url = "http://coms-309-mg-1.misc.iastate.edu:3306/comment/get/all";
String url = "https://api.myjson.com/bins/143pkp";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                       try {
                            JSONArray jsonArray = response.getJSONArray("comments");
                           mTextViewResult.setText("");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject comment = jsonArray.getJSONObject(i);

                                int id = comment.getInt("id");
                                String commentC = comment.getString("comment");

                                mTextViewResult.append(String.valueOf(id) + "\t" + commentC + "\n\n");

                            }

                        } catch (JSONException e) {
                            mTextViewResult.setText("JSON EXCEPTION");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                mTextViewResult.setText("Error");
                error.printStackTrace();
            }
        });

        mQueue.add(request);

    }


}

