package quickSort3


fun main(args: Array<String>) {

    val maxSize = 11
    val arr = ArrayIns(maxSize)

    for (item in 0 until maxSize) {

        val v = (Math.random() * 199).toLong()
        arr.insert(v)
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


    fun swap(dex1: Int, dex2: Int) {
        val temp = theArray[dex1]
        theArray[dex1] = theArray[dex2]
        theArray[dex2] = temp
    }

    fun recQuickSort(left: Int, right: Int) {


        val size = right - left + 1

        if (size < 10) {

            insertionSort(left, right)

        } else {

            val median = medianOf3(left, right)
            val partition = partition(left, right, median)

            recQuickSort(left, partition - 1)
            recQuickSort(partition + 1, right)
        }
    }

    fun quickSort() {
        recQuickSort(0, nElems - 1)
    }

    fun partition(left: Int, right: Int, pivot: Long): Int {

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
        swap(center, right - 1) //put pivot on the right

        return theArray[right-1]

    }


    fun insertionSort(left: Int, right: Int) {

        println("insertionSort left: $left right: $right")
        print("before insertionSort : ")
        display()

        val leftValue = left + 1

        for (out in leftValue..right) {

            val temp = theArray[out]

            var insideIndex = out

            while (insideIndex > left && theArray[insideIndex-1] >= temp) {

                theArray[insideIndex] = theArray[insideIndex - 1]
                insideIndex --
            }

            theArray[insideIndex] = temp
        }

        print("after insertionSort: ")
        display()
    }
}