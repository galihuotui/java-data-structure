package Stack.ReverseApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cuikangyuan on 2017/9/1.
 */
public class ReverseApp {

    public static void main(String[] args) throws IOException {
        String input, output;

        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();

            input = getString();

            if (input.equals("")) {
                break;
            }

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();

            System.out.println("Reversed: " + output);
        }
    }


    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = bufferedReader.readLine();

        return s;
    }
}
