package DesignPattern.Structual.FilterPattern;

import java.util.List;

public class OrCriteria implements Criteria{

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(firstCriteriaItems);

        for (Person person : otherCriteriaItems){
            if (!firstCriteriaItems.contains(persons)){
                firstCriteriaItems.add(person);
            }
        }

        return firstCriteriaItems;
    }
}
