package cl.caraya.action.beans;

import cl.caraya.action.annotations.CustomQualified;
import cl.caraya.action.domain.Person;

@CustomQualified
public class DuplicateBeanImpl implements BeanServices{
    @Override
    public Person print(Person msg) {
        return null;
    }
}
