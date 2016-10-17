package hayen.com.practices;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class VolleyExample extends AppCompatActivity {

    private static final String URL= "http://10.1.1.30/OSOS/DataServices/AmrDataService.svc/FindMeterByFlagCodeSerialNumber?flagCode=VIK&serialNumber=13";
    private static final String TAG = VolleyExample.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        volleyRequest();
    }

    private Context getContext()
    {
        return VolleyExample.this;
    }

    private void volleyRequest()
    {
        RequestQueue queue = Volley.newRequestQueue(getContext());


        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.w(TAG, "onResponse: "+ jsonObject.getJSONArray("result"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.w(TAG, "onResponse: "+ response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(request);
    }

}
