package Java7ConcurrencyCookbook.chp3.p4;

public class Main {
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        // 将视频会议对象作为传入参数创建线程，并且启动
        Thread threadConference = new Thread(conference);
        threadConference.start();
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
