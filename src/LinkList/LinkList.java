package LinkList;

public class LinkList {

    public Link first;


    public boolean linkHasCircle() {


        Link fast = first;
        Link slow = first;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                return true;
            }

        }

        return false;
    }


    public Link theMiddleNode() {

        if (first == null) {

            return null;
        }

        Link fast = first;
        Link slow = first;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            if (fast != null) {

                slow = slow.next;

            }
        }

        return slow;

    }

    public Link theLastKthNode(int k) {


        if (k < 0) {

            return null;
        }

        Link fast = this.first;
        Link slow = this.first;

        int i=k;

        for (; i > 0 && fast != null; i--) {

            fast = fast.next;

        }

        if (i > 0) {

            return null;
        }

        while (fast != null) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;


    }

    //反转-遍历
    public LinkList reverseLinkedListWithLoop() {

        Link newHead = reverse2(this.first);

        return new LinkList(newHead);
    }



    //反转-递归
    public LinkList reverseLinkedListWithRecursion() {

        Link newHead = reverse1(this.first);

        return new LinkList(newHead);
    }


    public Link reverse2(Link node) {


        Link pre = null;
        Link next = null;

        while (node != null) {

            next = node.next;
            node.next = pre;

            pre = node;
            node = next;

        }


        return pre;


    }


    public Link reverse1(Link node) {

        if (node == null || node.next == null) {

            return node;

        } else {

            Link temp = node.next;

            Link newHead = reverse1(node.next);

            temp.next = node;

            node.next = null;

            return newHead;


        }


    }


    public LinkList(Link first) {

        this.first = first;

    }

    public LinkList() {

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
