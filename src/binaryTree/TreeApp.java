package binaryTree;

public class TreeApp {

    public static void main(String[] args) {

        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);

        Node node = theTree.find(25);

        if (node != null) {
            System.out.println("find the node with key 25");
        } else {
            System.out.println("could not find node with key 25");
        }
    }
}
