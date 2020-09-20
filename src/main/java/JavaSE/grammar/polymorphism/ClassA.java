package JavaSE.grammar.polymorphism;

public class ClassA {
    ClassC c = new ClassC();

    ClassA(){
        this("A");
        System.out.println("A");
    }

    ClassA(String s){
        System.out.println(s);
    }
}
