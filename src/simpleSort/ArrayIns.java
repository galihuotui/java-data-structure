package simpleSort;

import array.HighArray;

/**
 * Created by cuikangyuan on 2017/6/13.
 */
public class ArrayIns extends HighArray {
    public ArrayIns(int max) {
        super(max);
    }

    public void insertSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];

            in = out;

            while (in > 0 && a[in - 1] >= temp) {
                //比temp中大的数据向右移动一个位置
                a[in] = a[in - 1];
                --in;
            }

            a[in] = temp;

            this.display();
        }

    }
}
