package hayen.com.practices.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmet.macit on 11/2/2016.
 */
@Module
public class AppModule {
    Application mApplication;
    public AppModule(Application application)
    {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication()
    {
        return mApplication;
    }
}
