package palindromeList;

public class Client {

    static class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {

        //1
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        listNode1.val = 1;
        listNode2.val = 2;
        listNode3.val = 3;
        listNode4.val = 2;
        listNode5.val = 1;

        //2
        ListNode listNode6 = new ListNode();
        ListNode listNode7 = new ListNode();
        ListNode listNode8 = new ListNode();
        ListNode listNode9 = new ListNode();

        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = null;

        listNode6.val = 1;
        listNode7.val = 2;
        listNode8.val = 2;
        listNode9.val = 1;

        System.out.println(new Client().isPalindrome(listNode1));
        System.out.println(new Client().isPalindrome(listNode6));
    }


    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = (right.val == left.val) && res;
        left = left.next;
        return res;
    }


//    public void traverse(ListNode head) {
//        if (head == null) {
//            return;
//        }
//        //preorder
//        traverse(head.next);
//        //postorder
//    }
}
