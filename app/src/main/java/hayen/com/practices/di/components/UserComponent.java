package hayen.com.practices.di.components;

import dagger.Component;
import hayen.com.practices.Dagger2Example;
import hayen.com.practices.DiExtra;
import hayen.com.practices.Entity.Person;
import hayen.com.practices.di.modules.UserModule;

/**
 * Created by ahmet.macit on 11/2/2016.
 */
/**
 * Interface that opens module class
 * method names do not really matter Dagger binds it based on returning type
 * */
@Component(modules = {UserModule.class})
public interface UserComponent {
    String getUserInfo();
    Person getPerson();
    DiExtra extra();

    /**
     * means that whatever supposed to be injected in Dagger2Example class will be injected
     * */
    void inject(Dagger2Example dagger2Example);
}
