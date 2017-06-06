package array;

/**
 * Created by cuikangyuan on 2017/6/6.
 */
public class LowArrayApp {

    public static void main(String[] args) {
        LowArray array;
        array = new LowArray(5);

        int nElems = 0;

        array.setElem(0, 1);
        array.setElem(1, 2);
        array.setElem(2, 3);
        array.setElem(3, 4);
        array.setElem(4, 5);

        nElems = 5;

        int i = 0;

        for (i = 0; i < nElems; i++) {
            System.out.print(array.getElem(i) + " ");
        }

        System.out.println("");
        //search
        //int searchKey = 6;
        int searchKey = 5;

        for (i = 0; i < nElems; i++) {
            if (array.getElem(i) == searchKey) {
                break;
            }
        }

        if (i == nElems) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Find " + searchKey);
        }

        //delete
        int deleteKey = 1;
        for (i = 0; i < nElems; i++) {
            if (array.getElem(i) == deleteKey) {
                nElems --;
                break;
            }
        }

        for (int j = i; j < nElems; j++) {

            array.setElem(j, array.getElem(j + 1));
        }


        for (i = 0; i < nElems; i++) {
            System.out.print(array.getElem(i) + " ");
        }
    }
}
