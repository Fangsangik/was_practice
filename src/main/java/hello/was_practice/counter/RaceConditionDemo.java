package hello.was_practice.counter;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread - 1");
        Thread t2 = new Thread(counter, "Thread - 2");
        Thread t3 = new Thread(counter, "Thread - 3");

        t1.start();
        t2.start();
        t3.start();

        /*
        기대값 t1, t2, t3 -> 모두다 처음에는 1, 나중에는 0 값 기대

        결과 값 (Singleton 객체에서 상태를 유지 하기 위해 설계를 하게 되면 문제가 발생)
        Value for Thread after increment Thread - 1 1
        Value for Thread after increment Thread - 3 3
        Value for Thread at last Thread - 1 2
        Value for Thread after increment Thread - 2 2
        Value for Thread at last Thread - 2 0
        Value for Thread at last Thread - 3 1

        즉 싱글톤 환경에서 멀티 스레드를 공유하게 되면 -> 뜻하지 않은 결과가 나올 수 있다.
        RaceCondition -> 여러 쓰레드가 하나의 자원에 접근하기 위해 경쟁하는 쓰레드 상태
        즉 쓰레드 safty 하지 않다.

        동기화 처리하면 해결 가능
         */
    }
}
