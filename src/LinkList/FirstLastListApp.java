package LinkList;

public class FirstLastListApp {


    class Link {
        public long dData;
        public Link next;

        public Link(long d) {
            dData = d;
        }

        public void displayLink() {
            System.out.print(dData + " ");
        }
    }

    class FirstLastList {
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

        public void insertLast(Long dd) {
            Link newLink = new Link(dd);
            if (isEmpty()) {        //is empty list
                first = newLink;    //first --> newLink
            } else {
                last.next = newLink; //old last --> newLink
            }

            last = newLink;          // newLink <-- last
        }

    }
}
