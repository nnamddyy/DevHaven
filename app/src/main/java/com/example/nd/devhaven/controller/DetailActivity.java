package com.example.nd.devhaven.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nd.devhaven.R;
import com.example.nd.devhaven.web;

/**
 * Created by nd on 8/25/17.
 */

public class DetailActivity extends AppCompatActivity {
    TextView Link, Username;
    ImageView imageView;
    Button pw;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //enables action bar support for java class

        imageView = (ImageView) findViewById(R.id.user_image_header);
        Username = (TextView) findViewById(R.id.username);
        Link = (TextView) findViewById(R.id.link);
        String username = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        pw = (Button) findViewById(R.id.devButton);
        pw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, web.class));

            }
        });


        Link.setText(link);
        Linkify.addLinks(Link, Linkify.WEB_URLS);

        //displays developer github profile details using Glide

        Username.setText(username);
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.loading)
                .into(imageView);

        //displays name on title bar
        getSupportActionBar().setTitle("Developer Homepage");
    }
    //creates an intent to display awesome developer details

    private Intent createShareForcastIntent(){
        String username = getIntent().getExtras().getString("login");
        String link = getIntent().getExtras().getString("link");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @" + username + ", " + link)
                .getIntent();
        return shareIntent;
    }


    //handles the menu item to share the details of an awesome developer
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }


}
