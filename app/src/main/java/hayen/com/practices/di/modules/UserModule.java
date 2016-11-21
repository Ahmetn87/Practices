package hayen.com.practices.di.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private static List<String> nameList = new ArrayList<>();

    static{
        nameList.add("Ahmet");
        nameList.add("Mehmet");
        nameList.add("Ali");
        nameList.add("Veli");
        nameList.add("Saban");
        nameList.add("Cakmak");
        nameList.add("Jack");
        nameList.add("Tom");
        nameList.add("Kim");
        nameList.add("Set");
        nameList.add("Xedfier");
        nameList.add("Bohemian");
        nameList.add("Paradox Interactive");
        nameList.add("Some game Developer");
    }


    @Provides
    Person providesPerson()
    {
        Person p = new Person();
        p.setId(123);
        p.setName(getRandomName());
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

    @Provides
    public String getRandomName()
    {
        return nameList.get(new Random().nextInt(nameList.size()));
    }


}
