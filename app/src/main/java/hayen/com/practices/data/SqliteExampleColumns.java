package hayen.com.practices.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by AhmetNM on 10/10/16.
 */
public class SqliteExampleColumns {

    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.
    public static final String CONTENT_AUTHORITY = "hayen.com.practices";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.
    public static final String PATH_PERSON = "person";
//    public static final String PATH_JOB = "job";


    /* Inner class that defines the table contents of the location table */
    public static final class PersonEntry implements BaseColumns
    {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERSON).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PERSON;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PERSON;

        //Table Name
        public static final String TABLE_NAME = "person";

        // to make it more human readable
        public static final String COLUMN_PERSON_NAME = "name";
        public static final String COLUMN_PERSON_JOB = "job";

        /**
         * Gonna append the row id and return it back
         * */
        public static Uri buildPersonUri(long id)
        {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Append the name parameter to the URI
         * */
        public static Uri buildPersonInfoWithName(String name)
        {
            return CONTENT_URI.buildUpon().appendPath(name).build();
        }

        /**
         * It will take out name parameter from the given URI
         * */
        public static String getNameFromUri(Uri uri)
        {
            return uri.getPathSegments().get(1);
        }

    }

}
