package classLoaderTest;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CryptoClassLoader extends ClassLoader {


    private int key;

    public CryptoClassLoader(int key) {

        this.key = key;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classBytes = null;

        try {
            classBytes = loadClassBytes(name);

            Class<?> cl = defineClass(
                    name,
                    classBytes,
                    0,
                    classBytes.length);

            if (cl == null) {
                throw new ClassNotFoundException(name);
            }

            return cl;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    private byte[] loadClassBytes(String name) throws IOException {

        String cname = name.replace(".", "/") + ".caesar";

        byte[] bytes = Files.readAllBytes(Paths.get(cname));

        for (int i = 0; i < bytes.length; i++) {

            bytes[i] = (byte) (bytes[i] - key);

        }

        return bytes;

    }
}
