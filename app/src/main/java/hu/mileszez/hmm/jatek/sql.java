package hu.mileszez.hmm.jatek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class sql extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "data.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE rows (" +
                    "id" + " INTEGER PRIMARY KEY," +
                    "nev" + " TEXT," +
                    "startDate" + " DATE," +
                    "endDate" + " DATE," +
                    "timeSpent" + " TIME," +
                    "description" + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS rows";
    public sql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void setValues(String nev, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nev", nev);
        values.put("description", description);
        long stat = db.insert("rows", null, values);
    }
    public Object readValues(boolean print) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("rows", null, null, null, null,null,null);
        List itemIds = new ArrayList<>();
        while(cur.moveToNext()) {
            long itemId = cur.getLong(
                    cur.getColumnIndexOrThrow("id"));
            itemIds.add(itemId);
        }
        cur.close();
        if (print = true) {
            Log.d("INFO", String.valueOf(itemIds));
        }
        return itemIds;
    }
    public List getRow() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM rows", null);
        List itemIds = new ArrayList<>();
        while(cur.moveToNext()) {
            String itemId = cur.getString(cur.getColumnIndexOrThrow("nev"));
            Log.d("ITEM", itemId);
        }
        cur.close();
        return itemIds;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
