package ordArray;

/**
 * Created by cuikangyuan on 2017/6/12.
 */
public class OrderArrayApp {

    public static void main(String[] args) {

        int maxSize = 100;

        OrderArray orderArray = new OrderArray(maxSize);

        orderArray.insert(3);
        orderArray.insert(1);
        orderArray.insert(4);

        orderArray.insert(2);

        orderArray.insert(6);

        orderArray.insert(5);


        orderArray.insert(8);
        orderArray.insert(7);




        orderArray.display();
/*
        int searchKey = 55;

        int i = orderArray.find(searchKey);

        if (i != orderArray.size()) {
            //find out
            System.out.println("find out " + i);
        } else {
            //not find
            System.out.println("not find");
        }

        orderArray.delete(55);

        orderArray.display();
        */
    }
}
