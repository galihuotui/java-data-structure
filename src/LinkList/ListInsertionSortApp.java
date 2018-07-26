package LinkList;

public class ListInsertionSortApp {


    public static void main(String[] args) {

        int size = 10;

        Link[] linkArray = new Link[10];

        for (int j=0; j<size; j++) {
            int n = (int) (java.lang.Math.random() * 99);

            Link newLink = new Link(n);

            linkArray[j] = newLink;

        }

        System.out.print("Unsorted array: ");
        for (int j=0; j<size; j++) {
            linkArray[j].displayLink();
        }
        System.out.println(" ");

        SortedList sortedList = new SortedList(linkArray);

        for (int j=0; j<size; j++) {
            linkArray[j] = sortedList.remove();
        }

        System.out.print("Sorted array: ");
        for (int j=0; j<size; j++) {
            linkArray[j].displayLink();
        }
    }

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

    static class SortedList {
        private Link first;

        public SortedList() {
            first = null;
        }

        public SortedList(Link[] linkArr) {
            first = null;

            for (int j=0; j<linkArr.length; j++) {
                insert(linkArr[j]);
            }
        }

        public void insert(Link k) {

            Link previous = null;
            Link current = first;

            while (current != null
                    && k.dData > current.dData) {

                previous = current;

                current = current.next;
            }

            if (previous == null) {
                first = k;
            } else {
                previous.next = k;
            }

            k.next = current;
        }

        public Link remove() {
            Link temp = first;

            first = first.next;

            return temp;
        }
    }

}
