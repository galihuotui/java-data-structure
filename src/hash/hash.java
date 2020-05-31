package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hash {

    public static class DataItem {
        private int iData;

        public DataItem(int ii) {
            iData = ii;
        }

        public int getKey() {
            return iData;
        }
    }

    public static class HashTable {
        private DataItem[] hashArray;
        private int arraySize;
        private DataItem nonItem;


        public HashTable(int size) {
            arraySize = size;
            hashArray = new DataItem[arraySize];
            nonItem = new DataItem(-1);
        }

        public void displayTable() {
            System.out.print("Table: ");
            for (int j = 0; j < arraySize; j++) {
                if (hashArray[j] != null) {
                    System.out.print(hashArray[j].getKey() + " ");
                } else {
                    System.out.print("** ");
                }
            }
            System.out.println("");
        }

        public int hashFunc(int key) {
            return key % arraySize;
        }

        public void insert(DataItem item) {
            //assume table not full
            int key = item.getKey();
            int hashVal = hashFunc(key);

            while (hashArray[hashVal] != null
                    && hashArray[hashVal].getKey() != -1) {
                hashVal ++;
                hashVal %= arraySize;
            }

            hashArray[hashVal] = item;
        }

        public DataItem delete(int key) {
            int hashVal = hashFunc(key);

            while (hashArray[hashVal] != null) {
                if (hashArray[hashVal].getKey() == key) {
                    DataItem temp = hashArray[hashVal];
                    hashArray[hashVal] = nonItem;
                    return temp;
                }

                ++hashVal;
                hashVal %= arraySize;
            }

            return null;
        }

        public DataItem find(int key) {
            int hashVal = hashFunc(key);
            while (hashArray[hashVal] != null) {
                if (hashArray[hashVal].getKey() == key) {
                    return hashArray[hashVal];
                }

                ++hashVal;
                hashVal %= arraySize;
            }

            return null;

        }

    }

    public static class HashTableApp {

        public static void main(String[] args) throws IOException {
            DataItem dataItem;
            int aKey, size, n, keysPerCell;

            System.out.println("Enter size of hash table: ");
            size = getInt();

            System.out.println("Enter initial number of items: ");
            n = getInt();
            keysPerCell = 10;

            HashTable hashTable = new HashTable(size);

            for (int j = 0; j < n; j++) {

                aKey = (int) (Math.random() * keysPerCell * size);

                dataItem = new DataItem(aKey);
                hashTable.insert(dataItem);
            }

            while (true) {
                System.out.println("Enter first letter of ");
                System.out.println("show, insert, delete, or find: ");
                char choice = getChar();
                switch (choice) {
                    case 's':
                        hashTable.displayTable();
                        break;
                    case 'i':
                        System.out.println("Enter key value to insert:");
                        aKey = getInt();
                        dataItem = new DataItem(aKey);
                        hashTable.insert(dataItem);
                        break;
                    case 'd':
                        System.out.println("Enter key value to delete: ");
                        aKey = getInt();
                        hashTable.delete(aKey);
                        break;
                    case 'f':
                        System.out.println("Enter key value to find: ");
                        aKey = getInt();
                        dataItem = hashTable.find(aKey);
                        if (dataItem != null) {
                            System.out.println("Found " + aKey);
                        } else {
                            System.out.println("Could not find " + aKey);
                        }
                        break;
                    default:
                        System.out.println("Invalid entry\n");

                }
            }

        }


        public static String getString() throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            return s;
        }

        public static char getChar() throws IOException {
            String s = getString();
            return s.charAt(0);
        }

        public static int getInt() throws IOException {
            String s = getString();
            return Integer.parseInt(s);
        }
    }
}
