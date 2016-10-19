package hayen.com.practices.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by AhmetNM on 10/11/16.
 */
public class PersonProvider extends ContentProvider {

    private static final int ALL_PERSON_RECORD = 99;
    private static final int PERSON_WITH_NAME = 100;
//    private static final int PERSON_WITH_JOB = 101;
    private static final UriMatcher mUriMatcher = buildUriMatcher();
    private SqliteExampleDbHelpler dbHelpler;

    private SQLiteQueryBuilder personQueryBuilder;

    private static final String mNameClause = SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME +" = ?";

    static UriMatcher buildUriMatcher()
    {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        String authority = SqliteExampleColumns.CONTENT_AUTHORITY;
        matcher.addURI(authority, SqliteExampleColumns.PersonEntry.TABLE_NAME,ALL_PERSON_RECORD);
        matcher.addURI(authority, SqliteExampleColumns.PersonEntry.TABLE_NAME+"/*",PERSON_WITH_NAME);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        dbHelpler = new SqliteExampleDbHelpler(getContext());
        return true;
    }

    @Nullable
    @Override                   // Projection      Selection  Selection Args    SortOrder
    public Cursor query(@Nullable Uri uri, @Nullable String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor ;
        switch (mUriMatcher.match(uri))
        {
            case ALL_PERSON_RECORD:
                retCursor = getAllPersonRecords(projection, sortOrder);
                break;
            case PERSON_WITH_NAME:
            {
                retCursor = getPersonWithName(uri, projection, sortOrder);
                break;
            }default:
            throw new UnsupportedOperationException("Uknown Uri "+ uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }



    @Nullable
    @Override
    public String getType(Uri uri) {
        int match = mUriMatcher.match(uri);

        switch (match)
        {
            case PERSON_WITH_NAME:
                return SqliteExampleColumns.PersonEntry.CONTENT_ITEM_TYPE;
            case ALL_PERSON_RECORD:
                return SqliteExampleColumns.PersonEntry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Uknown Uri "+ uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase db = dbHelpler.getWritableDatabase();
        int match = mUriMatcher.match(uri);
        Uri returnUri;
        switch (match)
        {
            case PERSON_WITH_NAME:
                long _id = db.insert(SqliteExampleColumns.PersonEntry.TABLE_NAME,null,contentValues);
                if (_id>0) returnUri = SqliteExampleColumns.PersonEntry.buildPersonUri(_id);
                else throw new UnsupportedOperationException("Uknown uri " + uri);
                break;
            default:
                throw new UnsupportedOperationException("Uknown uri "+uri);
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    private Cursor getPersonWithName(Uri uri, String[] projection, String sortOrder)
    {
        String name = SqliteExampleColumns.PersonEntry.getNameFromUri(uri);
        personQueryBuilder = new SQLiteQueryBuilder();
        personQueryBuilder.setTables(SqliteExampleColumns.PersonEntry.TABLE_NAME);
        return personQueryBuilder.query(dbHelpler.getReadableDatabase(),
                projection,
                mNameClause,
                new String[]{name},
                null,
                null,
                sortOrder);
    }

    private Cursor getAllPersonRecords(String[] projection, String sortOrder) {
        personQueryBuilder = new SQLiteQueryBuilder();
        personQueryBuilder.setTables(SqliteExampleColumns.PersonEntry.TABLE_NAME);

        return personQueryBuilder.query(dbHelpler.getReadableDatabase(),
                projection,
                null,
                null,
                null,
                null,
                sortOrder);
    }






}
