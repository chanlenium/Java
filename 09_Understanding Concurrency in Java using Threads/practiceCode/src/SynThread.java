public class SynThread implements Runnable{
    private String holdA = "This is ";
    private int[] holdB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Override
    //It's better to declare this method synchronized
    // 현재 Thread가 task를 끝내고 lock을 release해야 다음 thread의 task 실행가능
    public synchronized void run() {
        for(int w = 0; w < 10; w++) {
            System.out.println(holdA + holdB[w] + "." + Thread.currentThread().getName());
        }
    }
//    public void run() {
//        for(int i = 0; i < 10; i++){
//            System.out.println(holdA + holdB[i] + "." + Thread.currentThread().getName());
//        }
//    }

    public static void main(String[] args) {
        SynThread synThread = new SynThread();
        new Thread(synThread).start();
        new Thread(synThread).start();
    }
}
