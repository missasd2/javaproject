package DesignPattern.Structual.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        ArrayList<Person> singlePerson = new ArrayList<>();
        for (Person person : persons){
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")){
                singlePerson.add(person);
            }
        }
        return singlePerson;
    }
}
