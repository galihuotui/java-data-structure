package LinkList;

public class LinkedListReverseApp {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertIntoFirstPos(22, 2.99);
        linkList.insertIntoFirstPos(44, 4.99);
        linkList.insertIntoFirstPos(66, 6.99);
        linkList.insertIntoFirstPos(88, 8.99);


        linkList.displayList();


        //LinkList linkList1 = linkList.reverseLinkedListWithRecursion();
        LinkList linkList1 = linkList.reverseLinkedListWithLoop();


        linkList1.displayList();

    }
}
