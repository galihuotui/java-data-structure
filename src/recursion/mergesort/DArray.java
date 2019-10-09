package recursion.mergesort;

public class DArray {

    private long[] theArray;
    private int nElems;

    public DArray(int max) {

        theArray = new long[max];
        nElems = 0;

    }

    public void insert(long value) {

        theArray[nElems] = value;
        nElems++;

    }

    public void display() {

        for (int j = 0; j < nElems; j++) {

            System.out.print(theArray[j] + " ");

        }

        System.out.println("");
    }


    public void mergeSort() {


        long[] workSpace = new long[nElems];

        recMergeSort(workSpace, 0, nElems-1);

    }

    public void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {

        System.out.println("Entering " + lowerBound + "-" +upperBound);

        if (lowerBound == upperBound) { // if range is 1

            System.out.println("Base-Case Return " + lowerBound + "-" +upperBound);

            return;                     //no use sorting

        } else {

            // find midpoint
            int mid = (lowerBound + upperBound) / 2;

            //sort low half
            System.out.println("Will sort low half of " + lowerBound + "-" +upperBound);
            recMergeSort(workSpace, lowerBound, mid);

            //sort high half
            System.out.println("Will sort high half of " + lowerBound + "-" +upperBound);
            recMergeSort(workSpace, mid+1, upperBound);

            //merge them
            System.out.println("Will merge halves into " + lowerBound + "-" +upperBound);


            merge(workSpace, lowerBound, mid + 1, upperBound);


            System.out.print("Return " + lowerBound + "-" +upperBound + " ");
            display();

        }


    }

    //lowerPrt : the start index of the low half array
    //highPtr : the start index of the high half array
    //upperBound:
    public void merge(long[] workSpace, int lowerPrt, int highPtr, int upperBound) {

        int j = 0;
        int lowerBound = lowerPrt;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowerPrt <= mid && highPtr <= upperBound) {

            if (theArray[lowerPrt] < theArray[highPtr]) {

                workSpace[j++] = theArray[lowerPrt++];

            } else {

                workSpace[j++] = theArray[highPtr++];
            }

        }

        while (lowerPrt <= mid) {
            workSpace[j++] = theArray[lowerPrt++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }

        for (j = 0; j < n; j++) {

            theArray[lowerBound++] = workSpace[j];

        }

    }
}
