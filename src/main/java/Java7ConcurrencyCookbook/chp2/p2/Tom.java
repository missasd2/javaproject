package Java7ConcurrencyCookbook.chp2.p2;

public class Tom {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public synchronized void addAccount(double num){
        double tmp = salary;
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        tmp += num;
        salary = tmp;
    }

    public synchronized void subAccount(double num){
        double tmp = salary;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= num;
        salary = tmp;
    }

}
