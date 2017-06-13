package simpleSort;

import array.HighArray;

/**
 * Created by cuikangyuan on 2017/6/12.
 */
public class SortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        //HighArray arrayBub = new ArrayBub(maxSize);
        ArrayIns array = new ArrayIns(maxSize);
        array.insert(77);
        array.insert(99);
        array.insert(44);
        array.insert(55);
        array.insert(22);
        /*
        arrayBub.insert(88);
        arrayBub.insert(11);
        arrayBub.insert(00);
        arrayBub.insert(66);
        arrayBub.insert(33);
        */
        //arrayBub.display();

        //arrayBub.bubbleSort();

        //arrayBub.display();

        array.insertSort();


    }
}
