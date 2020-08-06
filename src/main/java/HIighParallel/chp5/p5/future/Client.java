package HIighParallel.chp5.p5.future;

/**
 * 客户端程序，Client主要实现了获取FutureData，
 * 开启构造RealData的线程，并在接受请求后，很快返回FutureData。
 * 注意，它不会等待数据真的构造完毕再返回，而是立即返回FutureData，
 * 即使这个时候FutureData内并没有真实数据。
 */
public class Client {
    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            public void run(){
                // RealData的构建很慢，所以在单独的线程中进行；
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;    // FutureData会被立即饭hi
    }

    public static void main(String[] args) {
        Client client = new Client();
        // 这里会立即返回，因为得到的是FutureData，而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            // 这里用一个sleep代替对其他业务逻辑的处理
            // 在处理这些逻辑的过程中，RealData被创建，从而充分利用了等待时间
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        // 使用真实的数据
        System.out.println("数据 = " + data.getResult());
    }
}
