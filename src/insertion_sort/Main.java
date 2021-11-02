package insertion_sort;

public class Main {

    public static void main(String[] args) {


        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};


        Main main = new Main();


        main.printArray(array);

        //main.insertionSort(array);

        main.insertionSort3(array);
        main.printArray(array);


    }

    public void insertionSort3(int[] array) {

        if (array != null && array.length > 0) {

            for (int i = 1; i < array.length; i++) {
                int insertValue = array[i];
                int insertIndex = i;

                while (insertIndex > 0 && insertValue < array[insertIndex-1]) {

                    array[insertIndex] = array[insertIndex-1];

                    insertIndex --;
                }

                if (insertIndex != i) {
                    array[insertIndex] = insertValue;
                }

            }


        }

    }

    public void insertionSort2(int[] array) {

        if (array != null && array.length > 0) {

            for (int i = 1; i < array.length; i++) {
                int insertValue = array[i];
                int insertIndex = i - 1;

                while (insertIndex >= 0 && insertValue < array[insertIndex]) {

                    array[insertIndex + 1] = array[insertIndex];

                    insertIndex --;
                }

                if (insertIndex + 1 != i) {
                    array[insertIndex+1] = insertValue;
                }

            }


        }

    }

    public void insertionSort(int[] array) {

        if (array != null && array.length > 0) {

            for (int i = 1; i < array.length; i++) {

                int current = array[i];

                int j;

                for (j = i; j > 0; j--) {

                    if (array[j - 1] > current) {

                        array[j] = array[j - 1];

                    } else {

                        break;

                    }

                }

                array[j] = current;

                System.out.print(current + " -> ");
                printArray(array);


            }


        }

    }

    public void printArray(int[] array) {

        if (array != null && array.length > 0) {

            for (int i = 0; i < array.length; i++) {

                System.out.print(array[i] + " ");

            }

            System.out.println("");

        }

    }


    public void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
