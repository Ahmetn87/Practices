package hayen.com.practices.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import hayen.com.practices.data.SqliteExampleColumns.PersonEntry;

/**
 * Created by AhmetNM on 10/10/16.
 */
public class SqliteExampleDbHelpler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "example.db";
    private static final String TAG = SqliteExampleDbHelpler.class.getName();

    public SqliteExampleDbHelpler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SqliteExampleDbHelpler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold person info
        final String SQL_CREATE_PERSONS_TABLE = "CREATE TABLE " + PersonEntry.TABLE_NAME + " (" +
                PersonEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PersonEntry.COLUMN_PERSON_NAME + " TEXT UNIQUE NOT NULL, " +
                PersonEntry.COLUMN_PERSON_JOB + " TEXT UNIQUE NOT NULL" +
                " );";
        Log.w(TAG, "onCreate: " + SQL_CREATE_PERSONS_TABLE);

        sqLiteDatabase.execSQL(SQL_CREATE_PERSONS_TABLE);
        // u may create more table
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        // Note that this only fires if you change the version number for your database.
        // It does NOT depend on the version number for your application.
        // If you want to update the schema without wiping data, commenting out the next 2 lines
        // should be your top priority before modifying this method.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PersonEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
        Log.w(TAG, "onUpgrade Current Table is dropped ");
    }
}
