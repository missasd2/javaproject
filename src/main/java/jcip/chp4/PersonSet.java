package jcip.chp4;

import JavaSE.Serializable.Person;
import jcip.annotate.GuardeBy;
import jcip.annotate.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * 代码清单4-2 通过封闭机制与加锁 来确保线程安全
 * 线程状态被封闭在对象的一个实例中
 */
@ThreadSafe
public class PersonSet {
    @GuardeBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }
}
