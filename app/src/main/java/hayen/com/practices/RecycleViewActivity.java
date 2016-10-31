package hayen.com.practices;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hayen.com.practices.Adapters.RecycleViewAdapt;
import hayen.com.practices.Entity.Information;

public class RecycleViewActivity extends AppCompatActivity implements RecycleViewAdapt.ClickListener{

    private static final String TAG = RecycleViewActivity.class.getName();
    @BindView(R.id.btn_add_recycle)
    Button btnAdd;
    @BindView(R.id.btn_add_bulk_recycle)
    Button btnAddBulk;
    @BindView(R.id.listview_recycle)
    RecyclerView listView;

    RecycleViewAdapt adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        adapter = new RecycleViewAdapt(RecycleViewActivity.this,getData());
        RecycleViewAdapt.setClickListener(this);
        listView.setAdapter(adapter);

        listView.setLayoutManager(new LinearLayoutManager(this));

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

    @OnClick(R.id.btn_add_recycle)
    public void add(Button button)
    {
        Information information = new Information("This is new Line nigga","Some position ibine");
        adapter.addData(information);
        listView.scrollToPosition(0);
    }

    @OnClick(R.id.btn_add_bulk_recycle)
    public void addBulk(Button button)
    {
        List<Information> informations = new ArrayList<>();
        for (int i=0; i<5; i++)
        {
            informations.add(new Information("This is bulk added",String .valueOf(i)));
        }
        adapter.addDataBulk(informations);
        listView.scrollToPosition(0);
    }

    private List<Information> getData()
    {
        List<Information> dataList = new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            Information info = new Information(String.format("%s",String.valueOf(i)),String.format("%s%s",String.valueOf(i),String.valueOf(i)));
            dataList.add(info);
        }
        return dataList;
    }

    @Override
    public void onItemClick(View v, int position) {
        Log.w(TAG, "onItemClick: "+String .valueOf(position) );
    }

    @Override
    public void onItemLongClick(View v, int position) {
        Log.w(TAG, "onItemLongClick: "+String .valueOf(position) );
    }
}
