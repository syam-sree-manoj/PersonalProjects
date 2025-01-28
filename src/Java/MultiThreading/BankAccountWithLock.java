package Java.MultiThreading;

// github token : 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
// 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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountWithLock {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        String format = String.format(" %s attempting to withdraw amount %d", Thread.currentThread().getName(), amount);
        System.out.println(format);

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try {
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + "proceeding to withdraw");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + "completed withdrawl. Balance: " + balance);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println(Thread.currentThread().getName() + "could not acquire the lock");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }


}

