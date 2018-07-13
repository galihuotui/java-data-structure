package LinkList;

public class LinkListApp {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertIntoFirstPos(22, 2.99);
        linkList.insertIntoFirstPos(44, 4.99);
        linkList.insertIntoFirstPos(66, 6.99);
        linkList.insertIntoFirstPos(88, 8.99);

        linkList.displayList();

        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            System.out.print("Delete: ");
            link.displayLink();
            System.out.println(" ");
        }

        linkList.displayList();
    }
}
