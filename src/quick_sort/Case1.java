package quick_sort;

public class Case1 {

    public static void main(String[] args) {

        //int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array = {9, 1, 7, 3, 8, 4, 7, 2, 1};

        Case1 case1 = new Case1();

        case1.printArray(array);

        case1.quickSort(array, 0, array.length - 1);

        case1.printArray(array);


    }


    public void quickSort(int[] array, int low, int high) {

        if (low < high) {

            if (high - low == 1) {

                if (array[low] > array[high]) {

                    swap(array, low, high);
                }

                return;

            }

            int index = partition(array, low, high);

            quickSort(array, low, index - 1);

            quickSort(array, index + 1, high);


        }

    }


    public int partition(int[] array, int low, int high) {


        System.out.println("before partition: low index: " + low + " high index: " + high + " ");
        printArray(array);

        int pivot = array[low];

        int left = low + 1;

        int right = high;

        System.out.println("pivot value: " + pivot + " left index: " + left + " right index: " + right);

        while (left < right) {
            while (array[left] < pivot) {

                if (left == high) {

                    break;
                }

                left ++;

            }

            while (array[right] > pivot) {

                if (right == low) {
                    break;
                }

                right --;

            }

            if (left < right) {

                swap(array, left, right);

            }
        }




        swap(array, low, right);

        System.out.println("after partition: ");
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
