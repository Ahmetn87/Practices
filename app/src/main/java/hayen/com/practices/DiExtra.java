package hayen.com.practices;

import javax.inject.Inject;

import hayen.com.practices.Entity.Person;

/**
 * Created by AhmetNM on 11/2/16.
 */

public class DiExtra {

    private Person person;

    /**
     * Will be injected by dagger
     * */
    @Inject
    public DiExtra(Person person)
    {
        this.person = person;
    }


    public String getNameTho()
    {
        person.setName("extra name added");
        return person.getName();
    }

}
