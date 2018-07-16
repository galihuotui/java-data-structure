package LinkList;

public class LinkListApp2 {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertIntoFirstPos(22, 2.99);
        linkList.insertIntoFirstPos(44, 4.99);
        linkList.insertIntoFirstPos(66, 6.99);
        linkList.insertIntoFirstPos(88, 8.99);

        linkList.displayList();


        Link f = linkList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can not find link");
        }

        Link d = linkList.delete(66);
        if (d != null) {
            System.out.println("Delete link with key " + d.iData);
        } else {
            System.out.println("Can not delete link");
        }


        linkList.displayList();
    }
}
