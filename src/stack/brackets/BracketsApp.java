package stack.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cuikangyuan on 2017/9/4.
 * a{b(c[d]e)f}
 */
public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.print("Enter string containing delimiters: \n");
            System.out.flush();

            input = getString();

            if (("").equals(input)) {
                break;
            }

            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = bufferedReader.readLine();
        return s;
    }
}
