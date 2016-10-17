package hayen.com.practices;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hayen.com.practices.Adapters.RecycleViewAdapt;
import hayen.com.practices.Entity.Information;

public class RecycleViewActivity extends AppCompatActivity {

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

    private List<Information> getData()
    {
        List<Information> dataList = new ArrayList<>();
        for (int i=0;i<100;i++)
        {
            Information info = new Information(String.format("%s",String.valueOf(i)),String.format("%s%s",String.valueOf(i),String.valueOf(i)));
            dataList.add(info);
        }
        return dataList;
    }

}
