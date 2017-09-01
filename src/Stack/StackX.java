package Stack;

/**
 * Created by cuikangyuan on 2017/9/1.
 */
class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int s) {
        this.maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j) {
        //top先加1，再插入元素
        if (!isFull()) {
            stackArray[++top] = j;
        }
    }

    public long pop() {
        //选去除top指向的数据，然后top减1
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
