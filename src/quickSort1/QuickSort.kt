package quickSort1


fun main(args: Array<String>) {

    val maxSize = 5
    val arr = ArrayIns(maxSize)

    for (i in 0 until maxSize) {

        val value = (Math.random()*199).toLong()
        arr.insert(value)
    }

    arr.display()
    arr.quickSort()
    arr.display()

}

class ArrayIns(val maxSize: Int) {

    val theArray = LongArray(maxSize)
    var nElems = 0


    fun insert(value: Long) {


        theArray[nElems] = value
        nElems++
    }


    fun display() {

        for (i in theArray) {
            print("$i ")
        }

        println()

    }


    fun swap(dex1: Int, dex2: Int) {
        //println("swap >>> $dex1 and $dex2")
        val temp = theArray[dex1]
        theArray[dex1] = theArray[dex2]
        theArray[dex2] = temp
    }


    fun quickSort() {

        recQuickSort(0, nElems - 1)

    }


    fun recQuickSort(left: Int, right: Int) {

        println("quickSort left $left and right $right")


        if (right - left <= 0) {

            return

        } else {

            val pivot = theArray[right]

            val partition = partitionInt(left, right, pivot)

            recQuickSort(left, partition - 1)

            recQuickSort(partition + 1, right)

        }

    }

    fun partitionInt(left: Int, right: Int, pivot: Long): Int {

        var leftPtr = left - 1
        //choose the right edge item as pivot
        //so the rightPtr doesn't need to minus one when initial it
        var rightPtr = right


        while (true) {

            while (theArray[++leftPtr] < pivot) {

            }

            while (rightPtr > 0 && theArray[--rightPtr] > pivot) {

            }


            if (leftPtr >= rightPtr) {

                break

            } else {
                println("swap leftPrt $leftPtr and rightPtr $rightPtr ")
                swap(leftPtr, rightPtr)

            }

        }

        println("swap leftPrt $leftPtr and right $right ")
        swap(leftPtr, right)

        print("partition >>> ")
        display()

        return leftPtr
    }

}