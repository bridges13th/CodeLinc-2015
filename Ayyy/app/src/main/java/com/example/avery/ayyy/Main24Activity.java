package com.example.avery.ayyy;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main24Activity extends Activity {
DB db=new DB(this);
    public EditText E;
    public EditText C;
    public EditText a;
    public EditText b;
    public EditText g;
    public EditText six;
    public Button H;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main24);
        E=(EditText)findViewById(R.id.editText);
        six=(EditText)findViewById(R.id.editText2);
        C=(EditText)findViewById(R.id.editText3);
        a=(EditText)findViewById(R.id.editText4);
        b=(EditText)findViewById(R.id.editText5);
        g=(EditText)findViewById(R.id.editText5);
        H=(Button)findViewById(R.id.button3);
        final Intent i = new Intent(this,Main2Activity.class);
        H.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                db.open();
                db.updateRecord(1,E.getText().toString(),six.getText().toString(),C.getText().toString(),a.getText().toString(),b.getText().toString());
                db.close();



                startActivity(i);
            }
        });
        db.open();
        Cursor c = db.getAllRecords();
        if (c.moveToFirst())
        {
            do {


                DisplayRecord(c);

            } while (c.moveToNext());
        }
        startManagingCursor(c);
        db.close();

    }



    public void DisplayRecord(Cursor c)
    {



                        E.setText(c.getString(2));
                       six.setText(c.getString(2));


                        C.setText(c.getString(3));
                        b.setText(c.getString(3));
                        g.setText(c.getString(3));



    }
}
