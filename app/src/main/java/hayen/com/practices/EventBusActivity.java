package hayen.com.practices;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hayen.com.practices.Entity.EventBusMessage;

public class EventBusActivity extends AppCompatActivity {

    private static final String TAG = EventBusActivity.class.getName();
    @BindView(R.id.btn_send_to_mainactivity)
    Button btnSend;
    @BindView(R.id.txt_eventbus_content)
    EditText txtEventBusContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
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

    @OnClick(R.id.btn_send_to_mainactivity)
    public void submit(Button button)
    {
        Intent intent = new Intent(this, MainActivity.class);
        EventBusMessage eventBusMessage = new EventBusMessage();
        eventBusMessage.setMessage(txtEventBusContent.getText().toString());
        EventBus.getDefault().post(eventBusMessage);

        finish();
    }


}
