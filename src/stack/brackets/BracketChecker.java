package stack.brackets;

import stack.CharStackX;

import java.io.IOException;

/**
 * Created by cuikangyuan on 2017/9/4.
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        CharStackX stackX = new CharStackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);

            switch (c) {
                case '{':
                case '[':
                case '(':
                    stackX.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackX.isEmpty()) {
                        char c1 = stackX.pop();
                        if ((c == '}' && c1 != '{') ||
                            (c == ']' && c1 != '[')||
                            (c == ')' && c1 != '(')) {
                            System.out.println("Error: " + c + " at " + j);
                        }
                    } else {
                        System.out.println("Error: " + c + " at " + j);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stackX.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }



}
