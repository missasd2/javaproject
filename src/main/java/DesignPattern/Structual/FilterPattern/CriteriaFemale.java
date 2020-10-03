package DesignPattern.Structual.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        ArrayList<Person> femalePersons = new ArrayList<>();
        for (Person person : persons){
            if (person.getGender().equalsIgnoreCase("female")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
