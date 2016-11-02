package hayen.com.practices.di.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import hayen.com.practices.DiExtra;
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

    @Provides
    @Named("Ahmet")
    Person providesPerson1()
    {
        Person p = new Person();
        p.setId(123);
        p.setName("Person 1 provided");
        p.setJob("Muhendis");
        return p;
    }

    @Provides
    DiExtra getExtra()
    {
        return new DiExtra(new Person());
    }

}
