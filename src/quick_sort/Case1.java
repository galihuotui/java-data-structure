package quick_sort;

public class Case1 {

    public static void main(String[] args) {

        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] array = {9, 1, 7, 3, 8, 4, 7, 2, 1};

        Case1 case1 = new Case1();

        //case1.printArray(array);

        case1.quickSort(array, 0, array.length - 1);

        //case1.printArray(array);


    }


    public void quickSort(int[] array, int low, int high) {

        System.out.println("quickSort start low index ->  " + low + " high index ->   " + high);

        if (low < high) {

            if (high - low == 1) {

                if (array[low] > array[high]) {

                    swap(array, low, high);
                }

                return;

            }

            int index = partition(array, low, high);

            System.out.println("partition then get index " + index);

            System.out.println("call quickSort low index ->  " + low + " high index ->  " + (index - 1));

            quickSort(array, low, index - 1);

            System.out.println("call quickSort low index ->  " + (index + 1) + " high index ->  " + high);

            quickSort(array, index + 1, high);


        }

    }


    public int partition(int[] array, int low, int high) {

        System.out.println("array before partition : ");

        printArray(array);

        System.out.println("partition: low index: " + low + " high index: " + high + " ");

        int pivot = array[low];

        int left = low + 1;

        int right = high;

        System.out.println("partition pivot value: " + pivot + " left index: " + left + " right index: " + right);

        System.out.println("start partition ");


        while (left < right) {

            System.out.println("out loop running : " + " left index -> " + left + " right index -> " + right);


            while (array[left] < pivot) {

                if (left == high) {

                    break;
                }

                left ++;

            }

            System.out.println("left loop finish : " + " left index -> " + left + " right index -> " + right);


            while (array[right] > pivot) {

                if (right == low) {
                    break;
                }

                right --;

            }

            System.out.println("right loop finish : " + " left index -> " + left + " right index -> " + right);


            if (left < right) {

                System.out.println("swap left and right : " + " left value -> " + array[left] + " right value -> " + array[right]);

                swap(array, left, right);

                System.out.println("current array : ");

                printArray(array);

            }
        }


        System.out.println("stop out loop : " + " left index -> " + left + " right index -> " + right);


        System.out.println("swap low and right : " + " low value -> " + array[low] + " right value -> " + array[right]);

        swap(array, low, right);

        System.out.println("array after partition : ");

        printArray(array);

        return right;


    }


    public void swap(int[] array, int i, int j) {

        int temp = array[i];

        array[i] = array[j];

        array[j] = temp;


    }

    public void printArray(int[] array) {

        if (array != null && array.length > 0) {

            for (int i = 0; i < array.length; i++) {

                System.out.print(array[i] + " ");

            }

            System.out.println("");

        }

    }
}
