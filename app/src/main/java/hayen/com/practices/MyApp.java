package hayen.com.practices;

import android.app.Application;

/**
 * Created by ahmet.macit on 11/2/2016.
 */

public class MyApp extends Application {

   // private UserComponent mUserComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        //mUserComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
    }

//    public UserComponent getUserComponent()
//    {
//        return mUserComponent;
//    }


}
