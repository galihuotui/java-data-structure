package nextGreaterElement;

import java.util.Stack;

public class Client {

    public static void main(String[] args) {

        new Client().nextGreaterElement();
    }

    public void nextGreaterElement() {

        int[] a = {2, 1, 3, 4, 2, 3};

        int[] s = new int[a.length];
        Stack<Integer> stack = new Stack();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            s[i] = stack.empty() ? -1 : stack.peek();
            stack.push(a[i]);
        }


        for (int i : s) {
            System.out.print(i + " ");
        }

    }
}
