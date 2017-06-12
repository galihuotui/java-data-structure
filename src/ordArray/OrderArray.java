package ordArray;

/**
 * Created by cuikangyuan on 2017/6/12.
 *
 */
public class OrderArray {

    private long[] a;
    private int nElmes;

    public OrderArray(int max) {
        a = new long[max];
        nElmes = 0;
    }

    public int size () {
        return nElmes;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElmes - 1;

        int curIndex;

        while (true) {
            curIndex = ( lowerBound + upperBound ) / 2;
            if (a[curIndex] == searchKey) {
                return curIndex;
            } else if (lowerBound > upperBound) {
                return nElmes;
            } else if (a[curIndex] < searchKey) {
                lowerBound = curIndex + 1;
            } else {
                upperBound = curIndex - 1;
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElmes; j++) {
            if (a[j] > value) {
                break;
            }
        }


        for (int k = nElmes; k > j; k++) {
            a[k] = a[k - 1];
        }

        a[j] = value;
        nElmes ++;
    }

    public boolean delete(long value) {

        int j = find(value);

        if (j == nElmes) {
            return false;
        } else {

            for (int k = j; k < nElmes; k++) {
                a[k] = a[k+1];
            }

            nElmes --;

            return true;
        }
    }

    public void display() {
        for (int j = 0; j< nElmes; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");

    }

}
