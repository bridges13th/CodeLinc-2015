package com.example.avery.ayyy;

/**
 * Created by ats on 11/7/2015.
 */
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

public class DB {

    public static final String KEY_ROWID = "id";
    public static final String KEY_ACCOUNT = "word";
    public static final String KEY_USERNAME= "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NUMBER="number";
    public static final String KEY_EMAIL="email";


    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "STUFF";
    private static final String DATABASE_TABLE = "Info";
    private static final int DATABASE_VERSION = 2;

    private static final  String DATABASE_CREATE =  "create table Info (id integer primary key autoincrement, "
            +KEY_ACCOUNT+" VARCHAR not null, username VARCHAR not null, "+KEY_EMAIL+" VARCHAR not null, number VARCHAR not null, password VARCHAR not null);";



    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DB(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {

        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {


                db.execSQL(DATABASE_CREATE);
                ContentValues cv=new ContentValues();



                cv.put(KEY_ACCOUNT, "John Doe");
                cv.put(KEY_USERNAME, "root");
                cv.put(KEY_PASSWORD, "funnn");
                cv.put(KEY_NUMBER,"919-699-1962");
                cv.put(KEY_EMAIL,"REDSAGE23@GMAIL.COM");

                db.insert("Info", null, cv);
                // db.insert("Info", KEY_ETYMOLOGY, cv);



            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }

    //---opens the database---
    public DB open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a record into the database---
    public long insertRecord(String account,  String username, String password, String number, String email)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ACCOUNT, account);
        initialValues.put(KEY_USERNAME, username);
        initialValues.put(KEY_PASSWORD, password);
        initialValues.put(KEY_NUMBER, number);
        initialValues.put(KEY_EMAIL, email);



        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID+"="+rowId, null) > 0;
    }

    //---retrieves all the records---
    public Cursor getAllRecords()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_ACCOUNT, KEY_USERNAME, KEY_PASSWORD,KEY_NUMBER,KEY_EMAIL}, null, null, null, null, null);
    }

    //---retrieves a particular record---
    public Cursor getRecord(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID, KEY_ACCOUNT, KEY_USERNAME, KEY_PASSWORD, KEY_EMAIL},
                        KEY_ROWID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String title,String username,String email,String number, String password )
    {
        ContentValues args = new ContentValues();
        args.put(KEY_ACCOUNT, title);
        args.put(KEY_USERNAME, username);
        args.put(KEY_EMAIL,email);
        args.put(KEY_NUMBER,number);
        args.put(KEY_PASSWORD,password);

        args.put(KEY_EMAIL,password);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
