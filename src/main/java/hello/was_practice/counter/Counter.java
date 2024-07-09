package hello.was_practice.counter;

public class Counter implements Runnable{

    //싱글톤은 상태 값 소유 X => 싱글톤 상태 값 갖도록 설정
    private int cnt = 0;

    public void increment() {
        cnt++;
    }

    public void decrement() {
        cnt--;
    }

    public int getVal() {
        return cnt;
    }


    @Override
    public void run() {
        synchronized (this) { //동기화 처리 방식을 사용하면 해결 가능
            this.increment();
            System.out.println("Value for Thread after increment " + Thread.currentThread().getName() + " " + this.getVal());
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getVal());
        }
    }
}
