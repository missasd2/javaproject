package MultiThread;

public class TestMain2 {

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask("Task " + i);
            myServer.executeTask(task);
        }

        myServer.endExecutor();
    }
}
