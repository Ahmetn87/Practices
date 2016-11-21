package hayen.com.practices;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import hayen.com.practices.Entity.Person;
import hayen.com.practices.di.components.DaggerUserComponent;
import hayen.com.practices.di.components.UserComponent;
import hayen.com.practices.di.modules.UserModule;

public class Dagger2Example extends AppCompatActivity {

    private static final String TAG = Dagger2Example.class.getName();

    /**
     * Either inject by name or directly
     * Normally we cant use Person class without instantiating new one
     * Person person  = new Person(); instead Dagger inject this itself
     * so we can use freely
     * But we have to provide Person class in module class
     * You can check providesPerson1() method in UserModule.class
     * for this method we specified by name
     * */
//    @Inject
//    @Named("Ahmet")
//    Person person;

    /**
     * Inject class and it s dependencies
     * */
//    @Inject
//    DiExtra extra;


    @BindView(R.id.btn_user)
    Button btnUser;
    @BindView(R.id.btn_product)
    Button btnProduct;

    private UserComponent userComponent;

    @Inject
    Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
        userComponent.inject(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // add to manifest android:name = .MyApp
//        ((MyApp)getApplication()).getUserComponent().inject(this);

//        if (person != null) Log.w(TAG, "User name: "+person.getName() );
//        else Log.w(TAG, "user is null tho " );
//
//        Log.w(TAG, "extra name: "+extra.getNameTho() );
        Log.w(TAG, "Person name"+ person.getName() );
    }

    @OnClick(R.id.btn_user)
    public void getUserName(Button button)
    {
        Log.w(TAG, "getUserName: "+ userComponent.getPerson().getName() );
    }


}
