package recursion.stackTriangle

var theNumber = 0
var theAnswer :Int = 0
lateinit var theStack: StackX
var codePart = 0
var theseParams: Params? = null

fun main(args: Array<String>) {

    System.out.print("Enter a number: ")

//
     theNumber = JavaUtil.getInt()
//
    System.out.println("theNumber: " + theNumber)

    recTriangle()

    System.out.println("Triangle answer: " + theAnswer)


}


fun recTriangle() {

    theStack = StackX(10000)
    codePart = 1


    //call step until it's true
    while (!step()) {

    }

}

fun step(): Boolean {


    var result: Boolean = false

    when(codePart) {

        //initial
        1 -> {
            theseParams = Params(theNumber, 6)
            theStack.push(theseParams)
            codePart = 2
        }
        //method entry
        2 -> {
            theseParams = theStack.peek()
            if (theseParams!!.n == 1) {

                theAnswer = 1
                codePart = 5 //exit

            } else {

                codePart = 3 //recursive call
            }

        }
        //method call
        3 -> {
            val newParams = Params(theseParams!!.n - 1, 4)
            theStack.push(newParams)
            codePart = 2
        }
        //calculation
        4 -> {

            theseParams = theStack.peek()
            theAnswer += theseParams!!.n
            codePart = 5

        }
        //method exit
        5 -> {
            theseParams = theStack.peek()
            codePart = theseParams!!.returnAddress //(4 or 6)
            theStack.pop()
        }
        6 -> {
            result = true
        }
        else -> {
            result = false
        }

    }



    return result
}


