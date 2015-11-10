package com.example.avery.ayyy;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    //ListAdapter listAdapter;
   // ListView expListView;
    //List<String> listDataHeader;
    //HashMap<String, List<String>> listDataChild;
    ListView list;
    String[] web = {
            "GardenKeepers",
            "A-Walk-4lunch",
            "campaign3",
            "campaign4"


    };
    Integer[] imageId = {

R.drawable.camp1,R.drawable.uuuu,R.drawable.oooooo,R.drawable.oooooo



    };
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
        setContentView(R.layout.activity_main);

       /*
        // get the listview
        expListView = (ListView) findViewById(R.id.listView);

        // preparing list data
        //prepareListData();

        String[] stringArray = new String[10];
        for(int i=0; i < stringArray.length; i++){
            stringArray[i] = "String " + i;
        }
        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray);
        // setting list adapter
        expListView.setAdapter(listAdapter);
        */
        final Intent line = new Intent(this,Pledge.class);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(line);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.moonclerk.com/pay/9m5u3m03c6"));
                startActivity(browserIntent);
            }
        });
        final Intent i=new Intent(this, camp1.class);
        final Intent b=new Intent(this, Main22Activity.class);
        CustomList adapter;
        adapter = new CustomList(MainActivity.this, web, imageId);

        list = (ListView) findViewById(R.id.listView2);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch ((int)id) {
                    case 0:
                       startActivity(i);
                        break;
                    case 1: startActivity(b);
                        break;
                    case 2:
                        break;
                }

            }

        });
    }

}