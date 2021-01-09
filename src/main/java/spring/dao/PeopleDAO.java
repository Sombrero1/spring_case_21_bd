package spring.dao;

import spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Vasya"));
        people.add(new Person(++PEOPLE_COUNT,"Any"));
        people.add(new Person(++PEOPLE_COUNT,"Grob"));
        people.add(new Person(++PEOPLE_COUNT,"Vitaly"));
    }

    public List<Person> index() {
        return people;
    }
    public Person getPerson(int id){
        return  people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
