package LinkList;

public class FirstLastListApp {


    public static void main(String[] args) {

        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();


    }

    static class Link {
        public long dData;
        public Link next;

        public Link(long d) {
            dData = d;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }

    static class FirstLastList {
        private Link first;
        private Link last;

        public FirstLastList() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return first == null;
        }


        public void insertFirst(long dd) {
            Link newLink = new Link(dd);

            if (isEmpty()) {    //if empty list
                last = newLink; //newLink <-- last
            }

            newLink.next = first; //newLink --> old first
            first = newLink;      //first --> newLink
        }

        public void insertLast(long dd) {
            Link newLink = new Link(dd);
            if (isEmpty()) {        //is empty list
                first = newLink;    //first --> newLink
            } else {
                last.next = newLink; //old last --> newLink
            }

            last = newLink;          // newLink <-- last
        }

        public long deleteFirst() {
            long temp = first.dData;

            if (first.next == null) {
                last = null;
            }

            first = first.next;


            return temp;

        }

        public void displayList() {
            System.out.println("List (first --> last):" );

            Link current = first;

            while (current != null) {
                current.displayLink();
                current = current.next;
            }

            System.out.println("");
        }

    }
}
