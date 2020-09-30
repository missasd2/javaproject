package Java7ConcurrencyCookbook.chp2.p3;

public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;
    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema(){
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    /**
     * 当第一个电影院有票卖出的时候将调用这个方法
     * @param number
     * @return
     */
    public boolean sellTickets1(int number){
        synchronized (controlCinema1){
            if (number < vacanciesCinema1){
                vacanciesCinema1 -= number;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number){
        synchronized (controlCinema2){
            if (number < vacanciesCinema2){
                vacanciesCinema2 -= number;
                return true;
            }else {
                return false;
            }
        }
    }
}
