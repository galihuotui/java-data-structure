package infix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//中缀表达式 转化 后缀表达式
public class InFix {

    static class InfixApp {
        public static void main(String[] args) throws IOException {
            String input, ouput;

            while (true) {
                System.out.print("Enter infix: ");
                System.out.flush();

                input = getString();

                if ("".equals(input)) {
                    break;
                }

                InToPost inToPost = new InToPost(input);
                ouput = inToPost.doTrans();

                System.out.println("Postfix is " + ouput);

            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String s = bufferedReader.readLine();
        return s;
    }

    static class StackX {
        private int maxSize;
        private char[] stackArray;
        private int top;

        public StackX(int s) {
            maxSize = s;
            stackArray = new char[maxSize];
            top = -1;
        }

        public void push(char j) {
            stackArray[++top] = j;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }

        public char peekN(int n) {
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

    static class InToPost {
        private StackX theStack;
        private String input;
        private String output = "";

        public InToPost(String in) {
            input = in;
            int stackSize = in.length();
            theStack = new StackX(stackSize);
        }

        public String doTrans() {
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);

                theStack.displayStack("For " + ch + " ");

                switch (ch) {
                    case '+':
                    case '-':
                        gotOper(ch, 1);
                        break;
                    case '*':
                    case '/':
                        gotOper(ch, 2);
                        break;
                    case '(':
                        theStack.push(ch);
                        break;
                    case ')':
                        //it's a right paren
                        gotParen(ch);
                        break;
                    default:
                        output = output + ch;
                        break;
                }

            }

            while (!theStack.isEmpty()) {
                theStack.displayStack("While ");
                output = output + theStack.pop();
            }

            theStack.displayStack("End  ");

            return output;
        }

        //get operator from input
        public void gotOper(char opThis, int prec1) {
            while (!theStack.isEmpty()) {
                char opTop = theStack.pop();

                if (opTop == '(') {
                    theStack.push(opTop);
                    break;
                } else {
                    int prec2;
                    if (opTop == '+' || opTop == '-') {
                        prec2 = 1;
                    } else {
                        prec2 = 2;
                    }

                    if (prec2 < prec1) {
                        theStack.push(opTop);
                        break;
                    } else {
                        output = output + opTop;
                    }
                }
            }
            theStack.push(opThis);
        }

        //get right paren from input
        public void gotParen(char ch) {
            while (!theStack.isEmpty()) {
                char chx = theStack.pop();
                if (chx == '(') {
                    break;
                } else {
                    output = output + chx;
                }

            }
        }
    }
}
