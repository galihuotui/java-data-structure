package classLoaderTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Caesar {

    public static void main(String[] args) {


        if (args.length != 3) {

            System.out.println("java classloader.Caesar in out key");

            return;
        }

        try {

            FileInputStream fileInputStream = new FileInputStream(args[0]);

            FileOutputStream fileOutputStream = new FileOutputStream(args[1]);


            int key = Integer.parseInt(args[2]);

            int ch;

            while ((ch = fileInputStream.read()) != -1) {

                byte c = (byte) (ch + key);

                fileOutputStream.write(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
