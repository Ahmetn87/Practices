package hayen.com.practices.di.components;

import dagger.Component;
import hayen.com.practices.Dagger2Example;
import hayen.com.practices.Entity.Person;
import hayen.com.practices.di.modules.UserModule;

/**
 * Created by ahmet.macit on 11/2/2016.
 */

@Component(modules = {UserModule.class})
public interface UserComponent {
    String getUserInfo();
    Person getPerson();

    void inject(Dagger2Example dagger2Example);
}
