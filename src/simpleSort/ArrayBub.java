package simpleSort;

import array.HighArray;

/**
 * Created by cuikangyuan on 2017/6/12.
 */
public class ArrayBub extends HighArray {

    public ArrayBub(int max) {
        super(max);
    }

    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
            this.display();
        }

    }

}
