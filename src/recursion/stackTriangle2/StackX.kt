package recursion.stackTriangle2

class StackX(var maxSize: Int) {

    var stackArray: IntArray = IntArray(maxSize)
    var top: Int = -1


    //push item on top of stack
    fun push(p: Int) {

        stackArray[++top] = p
    }

    //take item from top of stack
    fun pop(): Int {

        return stackArray[top--]
    }

    //peek at top of stack
    fun peek(): Int {

        return stackArray[top]
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

}