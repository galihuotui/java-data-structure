package LinkList;

public class LinkList {

    private Link first;


    public void LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertIntoFirstPos(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }


    public Link deleteFirst() {
        Link temp = null;

        if (!isEmpty()) {
            temp = first;
            first = temp.next;
        }

        return temp;
    }

    public void displayList() {
        System.out.print("List first --> last");

        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

        System.out.println(" ");
    }

    public Link find(int key) {
        Link current = first;

        if (!isEmpty()) {
            while (current.iData != key) {
                if (current.next == null) {
                    //已经遍历到链接的最后一个元素
                    return null;
                } else {
                    current = current.next;
                }
            }
        }

        return current;
    }

    public Link delete(int key) {
        Link current = null;
        Link previous = null;

        if (!isEmpty()) {

            current = first;
            previous = first;

            while (current.iData != key) {
                if (current == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }

        if(current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }


        return current;
    }
}
