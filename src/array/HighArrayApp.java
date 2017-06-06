package array;

/**
 * Created by cuikangyuan on 2017/6/6.
 */
public class HighArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;

        HighArray array;

        array = new HighArray(maxSize);

        array.insert(1);
        array.insert(3);
        array.insert(2);
        array.insert(5);
        array.insert(11);
        array.insert(7);
        array.insert(4);

        array.display();

        if (array.find(121)) {
            System.out.println("find");
        } else {
            System.out.println("not find");
        }


        array.delete(11);
        array.delete(4);
        array.delete(1);
        array.delete(0);

        array.display();
    }
}
