package ordArray;

/**
 * Created by cuikangyuan on 2017/6/12.
 */
public class OrderArrayApp {

    public static void main(String[] args) {

        int maxSize = 100;

        OrderArray orderArray = new OrderArray(maxSize);

        orderArray.insert(11);

        orderArray.insert(22);

        orderArray.insert(33);

        orderArray.insert(44);

        orderArray.insert(55);

        orderArray.insert(66);

        orderArray.insert(77);

        orderArray.insert(88);

        orderArray.display();

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
    }
}
