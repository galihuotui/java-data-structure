package LinkList;

public class LinkListApp {

    public static void main(String[] args) {

        LinkList linkList = new LinkList();

        linkList.insertIntoFirstPos(11, 2.99);
        linkList.insertIntoFirstPos(22, 2.99);
        linkList.insertIntoFirstPos(33, 2.99);
        linkList.insertIntoFirstPos(44, 4.99);

        linkList.insertIntoFirstPos(55, 4.99);

        linkList.insertIntoFirstPos(66, 6.99);
        linkList.insertIntoFirstPos(77, 6.99);
        linkList.insertIntoFirstPos(88, 8.99);
        linkList.insertIntoFirstPos(99, 8.99);

//        linkList.displayList();
//
//        while (!linkList.isEmpty()) {
//            Link link = linkList.deleteFirst();
//            System.out.print("Delete: ");
//            link.displayLink();
//            System.out.println(" ");
//        }
//
//        linkList.displayList();


        linkList.displayList();

//        int k = 3;
//
//        Link link = linkList.theLastKthNode(k);
//
//        if (link != null) {
//
//            System.out.println("The Last " + k + " Node -> " + link.iData);
//
//        }


        //Link link = linkList.theMiddleNode();
        //System.out.println("The Middle Node -> " + link.iData);


        System.out.println("The LinkList Has Circle ? " + linkList.linkHasCircle());

    }
}
