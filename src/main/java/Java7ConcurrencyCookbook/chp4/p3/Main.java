package Java7ConcurrencyCookbook.chp4.p3;

import Java7ConcurrencyCookbook.chp4.p2.Server;
import Java7ConcurrencyCookbook.chp4.p2.Task;

public class Main {

    public static void main(String[] args) {
        Java7ConcurrencyCookbook.chp4.p2.Server server = new Server();
        for (int i = 0; i < 100 ; i++) {
            Task task = new Task("Task: " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
