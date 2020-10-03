package DesignPattern.Structual.FilterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建实现了Criteria接口的实体类；
 */
public class CriteriaMale implements Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persons){
        ArrayList<Person> malePersons = new ArrayList<>();
        for (Person person : persons){
            if (person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
