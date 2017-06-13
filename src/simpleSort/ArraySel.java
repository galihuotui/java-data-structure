package simpleSort;

import array.HighArray;

/**
 * Created by cuikangyuan on 2017/6/13.
 */
public class ArraySel extends HighArray{

    public ArraySel(int max) {
        super(max);
    }

    public void selectSort() {
        int out, in, min;

        for (out = 0; out < nElems - 1; out++) {
            min = out;

            for (in = out; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }

            swap(out, min);

            this.display();
        }
    }
}
