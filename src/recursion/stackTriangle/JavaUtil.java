package recursion.stackTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaUtil {


    public static String getString() throws IOException {


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);


        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = bufferedReader.readLine();

        return s;

    }

    public static int getInt() throws IOException {

        String s = getString();

        return Integer.parseInt(s);


    }
}
