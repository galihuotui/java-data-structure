package recursion.binarySearch;

import ordArray.OrderArray;

public class TestApp {

    public static void main(String[] args) {

        int maxSize = 100;

        OrderArray array = new OrderArray(maxSize);

        array.insert(72);
        array.insert(90);
        array.insert(45);
        array.insert(126);
        array.insert(54);
        array.insert(99);
        array.insert(144);
        array.insert(27);
        array.insert(135);
        array.insert(81);
        array.insert(18);
        array.insert(108);
        array.insert(9);
        array.insert(117);
        array.insert(63);
        array.insert(36);

        array.display();

        int searchKey = 27;

        if (array.findWithRec(searchKey) != array.size()) {

            System.out.println(searchKey + " index is " + array.findWithRec(searchKey));


        } else {
            System.out.println("can not find " + searchKey);
        }


    }
}
