package unsynch;

public class UnSynchBankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {

        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);

        int i;

        for (i = 0; i < NACCOUNTS; i++) {

            TransferRunnable transferRunnable = new TransferRunnable(b, i, INITIAL_BALANCE);

            Thread thread = new Thread(transferRunnable);

            thread.start();
        }

    }
}
