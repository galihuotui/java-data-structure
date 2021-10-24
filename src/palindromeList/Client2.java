package palindromeList;

import java.util.List;

public class Client2 {

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

        System.out.println(new Client2().isPalindrome2(listNode1));
        System.out.println(new Client2().isPalindrome2(listNode6));
    }


    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && slow != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (right.val != left.val) {
                return false;
            }

            right = right.next;
            left = left.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


}
