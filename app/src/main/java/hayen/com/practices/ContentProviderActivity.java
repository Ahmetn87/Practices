package hayen.com.practices;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.btn_get_all_records_content_provider)
    Button btnGetAllRecords;


    private ArrayAdapter<String> listAdapter;


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
        List<String> nameList = new ArrayList<>();
        PersonProvider contentProvider = new PersonProvider();
        String[] selection = new String[]{txtName.getText().toString()};
        String[] projection = new String[]{SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME};
        Cursor names = contentProvider.query(SqliteExampleColumns.PersonEntry.CONTENT_URI, projection, null, selection, null);

        while (names.moveToNext()) {
            int nameIndex = names.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME);
            String retrievedName = names.getString(nameIndex);
            nameList.add(retrievedName);
            Log.w(TAG, "getByName: " + retrievedName);
        }
        names.close();

        listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);
        contentList.setAdapter(listAdapter);
    }

    private void getName(String name) {
        List<String> nameList = new ArrayList<>();
        Uri withName = SqliteExampleColumns.PersonEntry.buildPersonInfoWithName(name);
        String[] projection = new String[]{SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME};
        Cursor names = getContentResolver().query(withName, projection, null, null, null);
        while (names.moveToNext()) {
            int nameIndex = names.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME);
            String retrievedName = names.getString(nameIndex);
            nameList.add(retrievedName);
            Log.w(TAG, "getByName: " + retrievedName);
        }
        names.close();
        listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nameList);
        contentList.setAdapter(listAdapter);
    }

    private void getAllPersonRecords() {
        List<String> recordList = new ArrayList<>();
        String[] projection = new String[]{SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME, SqliteExampleColumns.PersonEntry.COLUMN_PERSON_JOB};
        Cursor records = getContentResolver().query(SqliteExampleColumns.PersonEntry.CONTENT_URI,projection,null,null,null);
        while (records.moveToNext())
        {
            int nameIndex = records.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME);
            int jobIndex = records.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_JOB);

            String retrievedName = records.getString(nameIndex);
            String retrievedJob = records.getString(jobIndex);
            recordList.add(String .format("%s - %s",retrievedName,retrievedJob));

        }
        records.close();
        listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,recordList);
        contentList.setAdapter(listAdapter);
    }

    @OnClick(R.id.btn_find_content_provider)
    public void findPersonByName(Button button) {
        if (txtName.getText().toString().trim().length() == 0)
        {
            txtName.setError("Bos gecme");
            return;
        }
        txtName.setError(null);
        getName(txtName.getText().toString());

    }

    @OnClick(R.id.btn_get_all_records_content_provider)
    public void getAllRecords(Button button)
    {
        getAllPersonRecords();
        // oho
    }

}
