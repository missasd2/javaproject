package JavaSE.util;

import java.util.HashMap;

/**
 * 重写equals的同时，也要同时覆盖hashcode方法；
 * 同时还要保证通过equals判断相等的两个对象，调用hashCode()方法方法要返回同样的整数值；
 * 而如果equals判断不相等的两个对象，其hashCode可以相同（只不过会发生哈希冲突，应尽量避免）
 */
public class MyTest {
    private static class Person{
        int idCard;
        String name;

        public Person(int idCard, String name){
            this.idCard = idCard;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj == null || getClass() != obj.getClass()){
                return false;
            }
            Person person = (Person) obj;
            //
            return this.idCard == person.idCard;

        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person person = new Person(1235, "hello");
        map.put(person, "sssss");
        System.out.println(map.get(new Person(1235, "hello")));;
    }
}
