package recursion.stackTriangle2

import recursion.stackTriangle.JavaUtil

var theNumber = 0
var theAnswer :Int = 0
lateinit var theStack: StackX

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

    theAnswer = 0

    while(theNumber > 0) {

        theStack.push(theNumber)
        --theNumber
    }

    while (!theStack.isEmpty()) {
        val newN = theStack.pop()
        theAnswer += newN

    }

}




