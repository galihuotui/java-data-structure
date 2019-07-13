package unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private Lock bankLock = new ReentrantLock(); //构建一个用来保护临界区的可重入锁

    private Condition sufficientFunds; //条件对象 余额充足

    private final double[] accounts;

    public Bank(int n, double initialBalance) {

        accounts = new double[n];

        for (int i = 0; i < accounts.length; i++) {

            accounts[i] = initialBalance;
        }

        sufficientFunds = bankLock.newCondition();
    }

//    public void transfer(int from, int to, double amount) {
//
//
//        bankLock.lock(); //获取这个锁
//
//        try {
//
//            if (accounts[from] < amount) {
//                sufficientFunds.await(); //释放锁 并且当前线程阻塞
//            }
//
//            System.out.print(Thread.currentThread());
//
//            accounts[from] -= amount;
//
//            System.out.printf(" %10.2f from %d to %d", amount, from, to);
//
//            accounts[to] += amount;
//
//            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
//
//
//            //解除等待线程的阻塞
//            sufficientFunds.signalAll();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//
//            bankLock.unlock(); //释放这个锁
//        }
//
//
//
//
//    }

    public synchronized void transfer(int from, int to, double amount) {



        try {

            if (accounts[from] < amount) {
                wait();
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= amount;

            System.out.printf(" %10.2f from %d to %d", amount, from, to);

            accounts[to] += amount;

            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());


            //解除等待线程的阻塞
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }




    }

    public double[] getAccounts() {
        return accounts;
    }

//    public double getTotalBalance() {
//
//        bankLock.lock();
//
//        try {
//            double sum = 0;
//
//            for (double a : accounts) {
//
//                sum += a;
//
//            }
//
//            return sum;
//
//        } finally {
//
//            bankLock.unlock();
//        }
//
//
//    }

    public synchronized double getTotalBalance() {


        try {
            double sum = 0;

            for (double a : accounts) {

                sum += a;

            }

            return sum;

        } finally {

        }


    }

    public int size() {
        return accounts.length;
    }
}
