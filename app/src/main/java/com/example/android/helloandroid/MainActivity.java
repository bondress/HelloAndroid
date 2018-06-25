package com.example.android.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing the Phone TextView in XML
        TextView phoneText = findViewById(R.id.phone_text_view);

        //Changing the value to a String
        final String phone = phoneText.getText().toString();

        //Creating a method to react when the TextView is touched. The number in the TextView
        //Will be copied to the phone dialler once it is touched.
        phoneText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                        "tel", phone, null));
                startActivity(phoneIntent);
            }
        });

        //Referencing the Website TextView in XML
        TextView websiteText = findViewById(R.id.website_text_view);

        //Magically turning it into a hyperlink! The broswer will open the url once the TextView
        //is touched.
        Linkify.addLinks(websiteText, Linkify.WEB_URLS);

        //Referencing the Mail TextView in XML
        TextView mailText = findViewById(R.id.mail_text_view);

        //Creating a method to react when the TextView is touched. This will activate the default
        //mail app or give the option to choose the mail app with the email address in the
        //address bar.

        mailText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                mailIntent.setData(Uri.parse("mailto:ceo@udacity.com"));
                startActivity(Intent.createChooser(mailIntent, "Send your email in:"));
            }
        });

        //Referencing the Location TextViews in XML
        TextView locationText = findViewById(R.id.location_text_view);
        TextView locationText2 = findViewById(R.id.location2_text_view);

        //Converting the text to a String
        final String location = locationText.getText().toString();
        final String location2 = locationText2.getText().toString();

        //Creating a method to react when the TextView is touched. This will activate navigation in
        //Google map app
        locationText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + location + location2));
                startActivity(locationIntent);
            }
        });

        //Creating a method to react when the TextView is touched. This will activate navigation in
        //Google map app
        locationText2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("google.navigation:q=" + location + location2));
                startActivity(locationIntent);
            }
        });
    }
}
