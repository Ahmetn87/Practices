package hayen.com.practices;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import butterknife.OnItemSelected;
import hayen.com.practices.data.SqliteExampleColumns;
import hayen.com.practices.data.SqliteExampleDbHelpler;

public class SqliteExample extends AppCompatActivity {

    private static final String TAG = SqliteExample.class.getName();
    @BindView(R.id.txt_name)
    EditText txtName;
    @BindView(R.id.txt_job)
    EditText txtJob;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_add_bulk)
    Button btnAddBulk;
    @BindView(R.id.listview_sqlite)
    ListView listView;

    private SqliteExampleDbHelpler helper;
    private SQLiteDatabase db;
    private ArrayAdapter<String> adapter;
    private List<String> personInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);
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
        personInfoList = new ArrayList<>();
        helper = new SqliteExampleDbHelpler(this);
        db = helper.getWritableDatabase();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getAllRecord());

        listView.setAdapter(adapter);

    }

    @OnClick(R.id.btn_add)
    public void submit(Button button) {
        // Second Step: Create ContentValues of what you want to insert
        ContentValues testValues = new ContentValues();
        testValues.put(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME, txtName.getText().toString());
        testValues.put(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_JOB,txtJob.getText().toString());

        long rowId;
        rowId = db.insert(SqliteExampleColumns.PersonEntry.TABLE_NAME, null, testValues);
        if (rowId == -1)
        {
            btnAdd.setText("Ekleme Basarisiz ...");
        }else
        {
            btnAdd.setText("Ekleme Basarili ...");
            adapter.add(String.format("%s - %s", txtName.getText().toString(),txtJob.getText().toString()));
            adapter.notifyDataSetChanged();
        }

        //db.close();

    }

    @OnClick(R.id.btn_add_bulk)
    public void addBulk(Button button)
    {
        adapter.addAll(getBulkList());
        adapter.notifyDataSetChanged();
    }

    @OnItemSelected(R.id.listview_sqlite)
    void onItemSelected(int position) {
        adapter.remove(adapter.getItem(position));
        adapter.notifyDataSetChanged();
        Log.w(TAG, "onItemSelected: "+String .valueOf(position) );
    }

    private List<String> getBulkList()
    {
        List<String> bulkList = new ArrayList<>();
        bulkList.add("Item 1");
        bulkList.add("Item 2");
        bulkList.add("Item 3");
        bulkList.add("Item 4");
        bulkList.add("Item 5");
        bulkList.add("Item 6");
        return bulkList;
    }


   private List<String> getAllRecord()
   {
       // A cursor is your primary interface to the query results.
       Cursor cursor = db.query(
               SqliteExampleColumns.PersonEntry.TABLE_NAME,  // Table to Query
               null, // all columns
               null, // Columns for the "where" clause
               null, // Values for the "where" clause
               null, // columns to group by
               null, // columns to filter by row groups
               null // sort order
       );

       while (cursor.moveToNext())
       {
           String name = cursor.getString(cursor.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_NAME));
           String job = cursor.getString(cursor.getColumnIndex(SqliteExampleColumns.PersonEntry.COLUMN_PERSON_JOB));
           personInfoList.add(String.format("%s - %s", name, job));
       }

       cursor.close();
       //db.close();
       return personInfoList;
   }
}
