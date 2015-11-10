package com.example.avery.ayyy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Main2Activity extends ActionBarActivity {
public WebView mywebview;


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.profile) {
            Intent f =new Intent(this, Main24Activity.class);
            startActivity(f);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mywebview=(WebView)findViewById(R.id.webView);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("file:///android_asset/donate.html");


        final Intent line = new Intent(this,MainActivity.class);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(line);
            }
        });
    }
}
