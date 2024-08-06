package com.example.happy.newsreader;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<newsItem> availNews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        callNewsAPI();
    }

    private class customeAdapter extends ArrayAdapter<newsItem>{
       public customeAdapter() {
           super(MainActivity.this, R.layout.my_layout, availNews);
       }

       @NonNull
       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           if(convertView==null){
               convertView=getLayoutInflater().inflate(R.layout.my_layout,parent,false);
           }
           newsItem mycurrentItem= availNews.get(position);
          // Log.i("position",Integer.toString(position));
           ImageView myImage= (ImageView) convertView.findViewById(R.id.left_icon);
           TextView myHeading=(TextView) convertView.findViewById(R.id.heading);
           TextView myDescription=(TextView) convertView.findViewById(R.id.description);
           //Log.d("myTag:", mycurrentItem.getImageId());
          // Log.d("myTag",mycurrentItem.getTittle() );
          //myImage.setImageResource(mycurrentItem.getImageId());

           myHeading.setText(mycurrentItem.getTittle());
           myDescription.setText(mycurrentItem.getNewsDesc());
          // myImage.setImageResource(R.mipmap.ic_launcher);
           Log.d("myTag:", mycurrentItem.getImageId());

           Picasso.with(getBaseContext()).load(mycurrentItem.getImageId()).resize(50, 50).into(myImage);
           return convertView;
       }
   }

    public void callNewsAPI(){
        RequestQueue queue =Volley.newRequestQueue(this);

        JsonObjectRequest myRequest= new JsonObjectRequest(Request.Method.GET,
                " https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=bae90d1de3214384a02840158d277714",
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            JSONArray newsItems = response.getJSONArray("articles");
                            try {

                                for (int i = 0; i < newsItems.length(); i++) {
                                    JSONObject temp = newsItems.getJSONObject(i);
                                    String tittle= temp.getString("title");
                                    String description= temp.getString("description");
                                    String url= temp.getString("url");
                                    String author=temp.getString("author");
                                    String imageURL=temp.getString("urlToImage");
                                    availNews.add(new newsItem(tittle, description, imageURL, author));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } catch(JSONException e){
                            e.printStackTrace();
                        }//try end
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        /*
        myRequest.setRetryPolicy(new DefaultRetryPolicy(
            10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT //extend the timeout period
        ));
        */
        queue.add(myRequest);

        //wait for 2 secs
        SystemClock.sleep(3000);

        ArrayAdapter<newsItem> adapter = new customeAdapter();

        ListView newsItem= (ListView) (findViewById(R.id.newsItem));
        newsItem.setAdapter(adapter);

        newsItem.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id)
            {

                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



