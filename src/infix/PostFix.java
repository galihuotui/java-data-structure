package infix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostFix {

    static class StackX {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new int[maxSize];
            top = -1;
        }

        public void push(int j) {
            stackArray[++top] = j;
        }

        public int pop() {
            return stackArray[top--];
        }

        public int peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }

        public int peekN(int n) {
            return stackArray[n];
        }

        public void displayStack(String s) {
            System.out.print(s);
            System.out.print("Stack (bottom-->top): ");

            for (int j=0; j<size(); j++) {
                System.out.print(peekN(j));
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    static class ParsePost {
        private StackX theStack;
        private String input;

        public ParsePost(String s) {
            input = s;
        }

        public int doParse() {
            theStack = new StackX(20);
            char ch;
            int j;
            int num1, num2, interAns;

            for (j = 0; j < input.length(); j++) {
                ch = input.charAt(j);
                theStack.displayStack("" + ch + "  ");

                if (ch >= '0' && ch <= '9') {
                    theStack.push((int)(ch-'0'));
                } else {
                    num2 = theStack.pop();
                    num1 = theStack.pop();

                    switch (ch) {
                        case '+':
                            interAns = num1 + num2;
                            break;
                        case '-':
                            interAns = num1 - num2;
                            break;
                        case '*':
                            interAns = num1 * num2;
                            break;
                        case '/':
                            interAns = num1 / num2;
                            break;
                        default:
                            interAns = 0;
                            break;
                    }

                    theStack.push(interAns);
                }
            }

            interAns = theStack.pop();
            return interAns;
        }

    }

    static class InfixApp {
        public static void main(String[] args) throws IOException {
            String input;
            int ouput;

            while (true) {
                System.out.print("Enter postfix: ");
                System.out.flush();

                input = getString();

                if ("".equals(input)) {
                    break;
                }

                ParsePost postFix = new ParsePost(input);
                ouput = postFix.doParse();

                System.out.println("Values is " + ouput);

            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String s = bufferedReader.readLine();
        return s;
    }

}
