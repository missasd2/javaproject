package JavaSE.grammar.polymorphism;

public class Dog extends Animal{

    @Override
    void eat() {
        System.out.println("dog 吃骨头");
    }

    @Override
    void work() {
        System.out.println("dog 看家");
    }
}
