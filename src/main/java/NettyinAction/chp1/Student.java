package NettyinAction.chp1;

import jdk.nashorn.internal.codegen.CompilerConstants;

public class Student {
    public void doHomeWork(CallBack c){
        System.out.println("学生做作业...");
        c.checkUpHomeWork();
    }
}
