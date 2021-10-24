package nextGreaterElement;

import java.util.Stack;

public class Client {

    public static void main(String[] args) {

        //new Client().nextGreaterElement();

        //new Client().dailyTemperatures();

        new Client().nextGreaterElementInLoopArray();
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

    public void dailyTemperatures() {

        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new int[t.length];

        Stack<Integer> stack = new Stack();
        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.empty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i; // get the distance
            stack.push(i);// add index, not the element
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    public void nextGreaterElementInLoopArray() {

        int[] a = {2, 1, 2, 4, 3};
        int n = a.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();

        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i % n]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
