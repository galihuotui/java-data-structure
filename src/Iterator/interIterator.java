package Iterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class interIterator {

    static class Link {
        public long dData;
        public Link next;


        public Link(long dd) {
            dData = dd;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }

    static class ListIterator {

        private Link current;
        private Link previous;
        private LinkList ourList;

        public ListIterator(LinkList list) {
            ourList = list;
            reset();

        }

        public void reset() {
            current = ourList.getFirst();
            previous = null;
        }

        public boolean atEnd() {
            return current.next == null;
        }

        public void nextLink() {
            previous = current;
            current = current.next;
        }

        public Link getCurrent() {
            return current;
        }

        public void insertAfter(long dd) {
            Link newLink = new Link(dd);

            if (ourList.isEmpty()) {

                ourList.setFirst(newLink);
                current = newLink;

            } else {

                newLink.next = current.next;
                current.next = newLink;
                nextLink();

            }
        }

        public void insertBefore(long dd) {

            Link newLink = new Link(dd);

            if (previous == null) {

                newLink.next = ourList.getFirst();
                ourList.setFirst(newLink);
                reset();

            } else {
                newLink.next = previous.next;
                previous.next = newLink;
                current = newLink;
            }
        }

        public long deleteCurrent() {
            long value = current.dData;

            if (previous == null) {
                ourList.setFirst(current.next);
                reset();
            } else {
                previous.next = current.next;

                if (atEnd()) {
                    reset();
                } else {
                    current = current.next;
                }

            }

            return value;
        }
    }

    static class LinkList {

        private Link first;

        public LinkList() {
            first = null;
        }

        public Link getFirst() {
            return first;
        }

        public void setFirst(Link f) {
            first = f;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public ListIterator getIterator() {

            return new ListIterator(this);

        }

        public void displayList() {
            Link current = first;

            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println(" ");
        }
    }

    static class InterIterApp {

        public static void main(String[] args) throws IOException {

            LinkList linkList = new LinkList();
            ListIterator iterator = linkList.getIterator();

            long value;

            iterator.insertAfter(20);
            iterator.insertAfter(40);
            iterator.insertAfter(80);
            iterator.insertAfter(60);

            while (true) {

                System.out.print("Enter first letter of show, reset,");
                System.out.print("next, get, before, after, delete:");

                System.out.flush();

                int choice = getChar();

                switch (choice) {
                    //show list
                    case 's':
                        if (!linkList.isEmpty()) {
                            linkList.displayList();
                        } else {
                            System.out.println("List is empty");
                        }
                        break;
                    //reset (to first)
                    case 'r':
                        iterator.reset();
                        break;
                    //advance to next item
                    case 'n':
                        if (!linkList.isEmpty()
                                && !iterator.atEnd()) {

                            iterator.nextLink();

                        } else {
                            System.out.println("Can't go to next link");

                        }
                        break;
                    // get current item
                    case 'g':
                        if (!linkList.isEmpty()) {

                            value = iterator.getCurrent().dData;

                            System.out.println("Returned " + value);

                        } else {
                            System.out.println("List is empty");

                        }
                        break;

                    // insert before current
                    case 'b':
                        System.out.println("Enter value to insert: ");
                        System.out.flush();
                        value = getInt();
                        iterator.insertBefore(value);
                        break;

                    // insert after current
                    case 'a':
                        System.out.println("Enter value to insert: ");
                        System.out.flush();
                        value = getInt();
                        iterator.insertAfter(value);
                        break;

                    // delete current item
                    case 'd':
                        if (!linkList.isEmpty()) {
                            value = iterator.deleteCurrent();
                            System.out.println("Deleted " + value);
                        } else {
                            System.out.println("Can't delete");

                        }
                        break;
                    default:
                        System.out.println("Invalid entry");
                        break;
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
