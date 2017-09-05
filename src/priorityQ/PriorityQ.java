package priorityQ;

/**
 * Created by cuikangyuan on 2017/9/5.
 */
public class PriorityQ {

    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;

        if (isFull()) {
            return;
        }

        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems-1; j >=0; j--) {
                if (item > queArray[j]) {
                    queArray[j+1] = queArray[j];
                } else {
                    break;
                }
            }

            queArray[j+1] = item;
            nItems++;
        }
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }
}
