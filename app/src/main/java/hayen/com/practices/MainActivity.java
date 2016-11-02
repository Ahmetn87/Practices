package hayen.com.practices;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hayen.com.practices.data.SmartMeterConnectionManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    @BindView(R.id.btn_recycle_example)
    Button btnRecycle;
    @BindView(R.id.btn_sqlite_example)
    Button btnSqliteExample;
    @BindView(R.id.btn_content_provider_example)
    Button btnContentProviderExample;
    @BindView(R.id.btn_card_view_example)
    Button btnCardViewAndMaterial;
    @BindView(R.id.btn_volley_example)
    Button btnVolleyRequest;
    @BindView(R.id.btn_auto_complete_textview_example)
    Button btnAutoCompleteTextView;
    @BindView(R.id.btn_dagger_example)
    Button btnDaggerExample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SmartMeterConnectionManager.checkSmartMeterExistance(this, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(response);
                Log.w(TAG, "response: "+ response );
                Log.w(TAG, "jsonString: "+ jsonString );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    }

    @OnClick(R.id.btn_recycle_example)
    public void submit(Button button) {
        Intent intent = new Intent(MainActivity.this, RecycleViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_sqlite_example)
    public void sqliteActivity(Button button)
    {
        Intent intent = new Intent(MainActivity.this, SqliteExample.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_content_provider_example)
    public void contentProviderActivity(Button button)
    {
        Intent intent = new Intent(this,ContentProviderActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_card_view_example)
    public void cardViewAndMaterialActivity(Button button)
    {
        Intent intent = new Intent(this,CardViewExampleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_volley_example)
    public void volleyExampleActivity(Button button)
    {
        Intent intent = new Intent(this,VolleyExample.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_auto_complete_textview_example)
    public void autoCompleteTextviewActivity(Button button)
    {
        Log.w(TAG, "autoCompleteTextviewActivity: " );
        Intent intent = new Intent(this,AutoCompleteText.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_dagger_example)
    public void dagger(Button button)
    {
        Log.w(TAG, "autoCompleteTextviewActivity: " );
        Intent intent = new Intent(this,Dagger2Example.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
