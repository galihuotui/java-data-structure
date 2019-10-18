package partition


fun main(args: Array<String>) {

    val maxSize = 5
    val arr = ArrayPar(maxSize)

    for (i in 0 until maxSize) {

        val n = (Math.random() * 199).toLong()

        arr.insert(n)

    }


    arr.display()

    val pivot = 99L

    val partDex = arr.partition(0, maxSize - 1, pivot)

    println("partDex: $partDex")

    arr.display()

}

class ArrayPar(val max: Int) {

    var theArray: LongArray = LongArray(max)
    var nElems: Int = 0


    fun insert(value: Long) {

        theArray[nElems] = value
        nElems++

    }

    fun size(): Int {

        return nElems

    }

    fun display() {

        for (item in theArray) {

            print("$item ")
        }

        println()

    }


    //方法返回分割边界的下标数值 它指向右边(较大关键字)子数组最左端的数据项，划分标记给出了两个子数组的分界
    fun partition(left: Int, right: Int, pivot: Long): Int {

        var leftPtr = left - 1
        var rightPtr = right + 1

        while(true) {

            //find bigger item
            while(leftPtr < right
                    && theArray[++leftPtr] < pivot) {
            }

            //find smaller item
            while (rightPtr > left
                    && theArray[--rightPtr] > pivot) {

            }

            if (leftPtr >= rightPtr) { //if pointers cross
                break                // partition done
            } else {
                swap(leftPtr, rightPtr)
            }
        }

        return leftPtr

    }

    fun swap(index1: Int, index2: Int) {

        val temp = theArray[index1]

        theArray[index1] = theArray[index2]

        theArray[index2] = temp

    }

}