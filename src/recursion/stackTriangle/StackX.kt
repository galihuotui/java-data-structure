package recursion.stackTriangle

class StackX(var maxSize: Int) {

    var stackArray: Array<Params?> = arrayOfNulls<Params>(maxSize)
    var top: Int = -1


    //push item on top of stack
    fun push(p: Params?) {

        stackArray[++top] = p
    }

    //take item from top of stack
    fun pop(): Params? {

        return stackArray[top--]
    }

    //peek at top of stack
    fun peek(): Params? {

        return stackArray[top]
    }

}