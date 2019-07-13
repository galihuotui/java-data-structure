package unsynch;

public class TransferRunnable implements Runnable {


    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;


    public TransferRunnable(Bank b, int from, double maxAmount) {

        this.bank = b;
        this.fromAccount = from;
        this.maxAmount = maxAmount;
    }


    @Override
    public void run() {

        try{

            while (true) {

                int toAccount = (int) (bank.size() * Math.random());

                double amount = maxAmount * Math.random();

                bank.transfer(fromAccount, toAccount, amount);

                Thread.sleep(DELAY);


            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
