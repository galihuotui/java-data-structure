package Stack;

/**
 * Created by cuikangyuan on 2017/9/1.
 */
public class CharStackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public CharStackX(int s) {
        this.maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        //top先加1，再插入元素
        if (!isFull()) {
            stackArray[++top] = j;
        }
    }

    public char pop() {
        //选去除top指向的数据，然后top减1
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
