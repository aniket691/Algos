package Collection.linkedList;

import java.util.ArrayList;

public class LinkedLists {


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

           ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * Use floyed cycledetection algo
     * fast and slow pointer
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {


        if (head == null) return false;

        if (head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next.next;


        while (true) {

            if (fast == null) break;

            if (fast.next == null) break;

            if (fast == slow) break;

            slow = slow.next;
            fast = fast.next.next;

        }

        if (fast == null || fast.next == null) return false;

        return true;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * null 1 2 3 4 -> null
     * p    c n
     * run following
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

// standard approach
//        if (head == null || head.next == null) return head;
//
//        ListNode newH = null;
//
//        while (head != null) {
//            ListNode temp = head;
//            head = head.next;
//            temp.next = newH;
//            newH = temp;
//        }
//
//        return newH;

        //my approach
        if (head == null) return head;
        if (head.next == null) return head;

        ListNode p = null;
        ListNode c = head;
        ListNode n = head.next;

        while (n != null) {
            c.next = p;
            p = c;
            c = n;
            n = n.next;
        }

        c.next = p;
        p = c;
        c = n;

        return p;
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/

    /**
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode res = new ListNode(0);

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }


        if (list1.val <= list2.val) {
            l1 = list1;
            l2 = list2;
            res = l1;
        } else {
            l1 = list2;
            l2 = list1;
            res = l1;
        }

        while (l1 != null) {

            ListNode temp = null;

            while (l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }

            temp.next = l2;

            ListNode t = l1;
            l1 = l2;
            l2 = t;

            l2 = l2.next;
        }

        return res;

    }

    //https://leetcode.com/problems/delete-node-in-a-linked-list/

    /**
     *
     */
    //copy next node value to curr node
    //link node's next to nodes->next->next
    //4519
    //4119
    //419
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
