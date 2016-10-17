package hayen.com.practices;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hayen.com.practices.data.PersonProvider;
import hayen.com.practices.data.SqliteExampleColumns;

public class ContentProviderActivity extends AppCompatActivity {

    private static final String TAG = ContentProviderActivity.class.getName();
    @BindView(R.id.txt_name_content_provider)
    EditText txtName;
    @BindView(R.id.txt_job_content_provider)
    EditText txtJob;
    @BindView(R.id.listview_content_provider)
    ListView contentList;
    @BindView(R.id.btn_find_content_provider)
    Button btnFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    private void getByName(String name) {
        PersonProvider contentProvider = new PersonProvider();
        String[] selection = new String[]{txtName.getText().toString()};
        String[] projection = new String[]{SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME};
        Cursor names = contentProvider.query(SqliteExampleColumns.PersonEntry.CONTENT_URI, projection,null,selection,null);

        while (names.moveToNext())
        {
            int nameIndex = names.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME);
            String retrievedName = names.getString(nameIndex);
            Log.w(TAG, "getByName: "+ retrievedName );
        }

    }

    private void getName(String name)
    {
        String[] selection = new String[]{name};
        String[] projection = new String[]{SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME};
        Cursor names = getContentResolver().query(SqliteExampleColumns.PersonEntry.CONTENT_URI,projection,null,selection,null);
        while (names.moveToNext())
        {
            int nameIndex = names.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME);
            String retrievedName = names.getString(nameIndex);
            Log.w(TAG, "getByName: "+ retrievedName );
        }
    }

    @OnClick(R.id.btn_find_content_provider)
    public void findPersonByName(Button button)
    {
        getName(txtName.getText().toString());
    }


}
