package hayen.com.practices.di.modules;

import dagger.Module;
import dagger.Provides;
import hayen.com.practices.Entity.Person;

/**
 * Created by ahmet.macit on 11/2/2016.
 */
@Module
public class UserModule {

    @Provides
    String providesUserInfo()
    {
        return "Ahmet Nazim Macit";
    }

    @Provides
    Person providesPerson()
    {
        Person p = new Person();
        p.setId(123);
        p.setName("Aho Naho Maho");
        p.setJob("Muhendis");
        return p;
    }

}
