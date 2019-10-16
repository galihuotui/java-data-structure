package shellSort

class ArraySh(val max: Int) {

    lateinit var theArray: LongArray
    var nElems: Int = 0

    init {

        theArray = LongArray(max)

    }


    fun insert(value: Long) {
        theArray[nElems] = value
        nElems++
    }

    fun display() {

        for (e in theArray) {
            print("${e} ")
        }
        println()
    }

    fun shellSort() {

        var temp = 0L
        //find initial value of h
        var h = 1

        while (h <= nElems/3) {
            h = h*3 + 1 //(1, 4, 13, 40, 121 ....)
        }

        println("max h: ${h}")

        while (h > 0) {


            for (outer in h until nElems) {

                temp = theArray[outer]

                var inner = outer

                while (inner > h-1 && theArray[inner-h] >= temp) {

                    theArray[inner] = theArray[inner - h]
                    inner -= h

                }

                theArray[inner] = temp

                print("loop h: ${h} outer: ${outer} result: ")
                display()

            }


            h = (h-1) / 3 //decrease h

        }


    }

}