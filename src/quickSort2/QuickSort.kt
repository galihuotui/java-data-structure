package quickSort2


fun main(args: Array<String>) {

    val maxSize = 16
    val arr = ArrayIns(maxSize)

    for (i in 0 until maxSize) {

        val value = (Math.random() * 199).toLong()

        arr.insert(value)
    }

    arr.display()
    arr.quickSort()
    arr.display()

}


class ArrayIns(maxSize: Int) {

    val theArray = LongArray(maxSize)
    var nElems = 0



    fun insert(value: Long) {
        theArray[nElems] = value
        nElems++
    }

    fun display() {
        for (item in theArray) {
            print("$item ")
        }
        println()
    }

    fun quickSort() {

        recQuickSort(0, nElems - 1)

    }

    fun recQuickSort(left: Int, right: Int) {

        val size = right - left + 1

        if (size <= 3) {
            //manual sort of small
            manualSort(left, right)

        } else {
            //quicksort of large
            val median = medianOf3(left, right)
            val partition = partitionIt(left, right, median)

            recQuickSort(left, partition - 1)
            recQuickSort(partition + 1, right)

        }


    }

    fun manualSort(left:Int, right: Int) {

        val size = right - left + 1

        if (size <= 1) {
            return
        } else if (size == 2) {
            if (theArray[left] > theArray[right]) {
                swap(left, right)
                return
            }
        } else {
            if (theArray[left] > theArray[right-1]) {
                swap(left, right-1)
            }
            if (theArray[left] > theArray[right]) {
                swap(left, right)
            }
            if (theArray[right-1] > theArray[right]) {
                swap(right-1, right)
            }

        }

    }


    fun swap(index1: Int, index2: Int) {

        val temp = theArray[index1]
        theArray[index1] = theArray[index2]
        theArray[index2] = temp
    }

    fun medianOf3(left: Int, right: Int): Long {

        val center = (left + right) / 2

        if (theArray[left] > theArray[center]) {
            swap(left, center)
        }

        if (theArray[left] > theArray[right]) {
            swap(left, right)
        }

        if (theArray[center] > theArray[right]) {
            swap(center, right)
        }

        swap(center, right-1)

        return theArray[right-1]
    }

    fun partitionIt(left: Int, right: Int, pivot: Long): Int {

        var leftPtr = left
        var rightPtr = right - 1


        while (true) {

            while (theArray[++leftPtr] < pivot) {

            }

            while (theArray[--rightPtr] > pivot) {

            }

            if (leftPtr >= rightPtr) {

                break

            } else {

                swap(leftPtr, rightPtr)
            }

        }

        swap(leftPtr, right - 1)
        return leftPtr

    }




}
