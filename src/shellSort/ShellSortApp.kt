package shellSort


fun main(strings: Array<String>) {

    val maxSize = 10

    var arr = ArraySh(maxSize)

    for(i in 0 until 10) {

        val v = (Math.random() * 99).toLong()
        arr.insert(v)

    }

    arr.display()
    arr.shellSort()
    arr.display()

}