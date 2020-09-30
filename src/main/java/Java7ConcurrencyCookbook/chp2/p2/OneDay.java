package Java7ConcurrencyCookbook.chp2.p2;

public class OneDay {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setSalary(1000);
        Mother mother = new Mother(tom);
        Father father = new Father(tom);
        Thread threadFather = new Thread(father);
        Thread threadMother = new Thread(mother);
        System.out.printf("Tom initial has %f\n", tom.getSalary());
        threadMother.start();
        threadFather.start();
        try {
            threadMother.join();
            threadFather.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Tom finally has %f\n", tom.getSalary());

    }
}
