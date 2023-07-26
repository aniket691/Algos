package Collection.linkedList;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LinkedLists {


    /**
     * ListNode
     **/
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * Node
     **/
    //Dummy node for algo
    static class Node {
        int data;
        Node next;

        Node bottom;

        Node prev;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
            prev = null;
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

    public Node reverseListGfg(Node head) {

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

        Node p = null;
        Node c = head;
        Node n = head.next;

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

    //https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * The given code is an implementation of a method to remove duplicates from a linked list,
     * where the method takes the head of the linked list as input and returns the head of the linked list after removing duplicates.
     * <p>
     * Intuition:
     * The given code uses a set to keep track of unique elements in the linked list.
     * It iterates over the linked list, adding each element to the set. If it encounters a duplicate element while iterating,
     * it removes it by changing the pointers of the previous node to skip the duplicate node.
     * The code continues iterating until it reaches the end of the linked list.
     * <p>
     * Algorithm:
     * <p>
     * Set a temporary variable temp to the head of the linked list.
     * If the linked list is empty or has only one element, return the head.
     * Create a set to keep track of unique elements.
     * While temp is not null, do the following:
     * a. Add the value of temp to the set.
     * b. If temp has a next node and the value of the next node is already in the set,
     * remove the next node by changing the pointers of the previous node to skip the next node.
     * c. Move temp to the next node.
     * Return the head of the linked list after removing duplicates.
     *
     * @param head
     * @return
     */
    public Node removeDuplicates(Node head) {
        // Your code here
        Node temp = head;

        if (head == null) return head;

        if (head.next == null) return head;

        Set<Integer> set = new HashSet<>();

        while (temp != null) {
            set.add(temp.data);
            //keep deleting the nodes till there are duplicates
            while (temp.next != null && set.contains(temp.next.data)) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    //https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/

    /**
     * The code you provided is implementing an algorithm to segregate a linked list containing 0's, 1's, and 2's. The intuition behind this algorithm is to count the number of occurrences of each element in the linked list, and then create a new linked list with the same elements, but in the desired order of 0's, 1's, and 2's.
     * <p>
     * Here's the step-by-step algorithm for the code:
     * <p>
     * 1. Initialize three integer variables to zero to count the number of occurrences of each element.
     * 2. Check if the head of the linked list is null or if there is only one element in the list. If either of these conditions is true, return the head.
     * 3. Initialize a temporary node variable to the head of the linked list.
     * 4. Traverse the linked list and increment the respective count variable based on the value of the current node.
     * 5. Create a new node to represent the head of the new linked list with a value of 0, and set a temporary node variable to point to this new node.
     * 6. Create a new node for each zero in the linked list and append it to the end of the new linked list.
     * 7. Create a new node for each one in the linked list and append it to the end of the new linked list.
     * 8. Create a new node for each two in the linked list and append it to the end of the new linked list.
     * 9. Return the next node of the head of the new linked list since the first node has a value of 0.
     * <p>
     * Overall, the algorithm takes O(n) time complexity, where n is the number of nodes in the linked list.
     *
     * @param head
     * @return
     */
    static Node segregate(Node head) {
        // add your code here
        int zero = 0;
        int one = 0;
        int two = 0;

        if (head == null) return head;

        if (head.next == null) return head;

        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) zero++;
            else if (temp.data == 1) one++;
            else if (temp.data == 2) two++;
            temp = temp.next;
        }

        //System.out.println(zero+" "+one+" "+two+ " ");

        Node nh = new Node(0);
        Node res = nh;

        while (zero > 0) {
            Node nn = new Node(0);
            nh.next = nn;
            nh = nn;
            zero--;
        }

        while (one > 0) {
            Node nn = new Node(1);
            nh.next = nn;
            nh = nn;
            one--;
        }

        while (two > 0) {
            Node nn = new Node(2);
            nh.next = nn;
            nh = nn;
            two--;
        }

        return res.next;

    }

    //https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    /**
     * The code you provided is implementing an algorithm to multiply two linked lists as if they are numbers. The intuition behind this algorithm is to traverse both linked lists, convert the nodes into integer digits and then compute the product of these integers. Finally, return the product modulo a prime number to avoid overflow.
     * <p>
     * Here's the step-by-step algorithm for the code:
     * <p>
     * 1. Initialize the answer variable to 0 and two long variables to hold the two numbers.
     * 2. Initialize a temporary node variable to point to the head of the first linked list.
     * 3. Traverse the first linked list and convert each node's data into an integer digit, and add it to the first number.
     * 4. Move the temporary node variable to the next node.
     * 5. Repeat steps 3 and 4 until there are no more nodes left in the first linked list.
     * 6. Initialize another temporary node variable to point to the head of the second linked list.
     * 7. Traverse the second linked list and convert each node's data into an integer digit, and add it to the second number.
     * 8. Move the temporary node variable to the next node.
     * 9. Repeat steps 7 and 8 until there are no more nodes left in the second linked list.
     * 10. Compute the product of the two numbers and take the modulo of a prime number.
     * 11. Return the result.
     * <p>
     * Overall, the algorithm takes O(n) time complexity, where n is the number of nodes in the linked lists. The space complexity is O(1) since the algorithm uses only a few variables to store intermediate results.
     *
     * @param l1
     * @param l2
     * @return
     */
    public long multiplyTwoLists(Node l1, Node l2) {
        //add code here.

        long ans = 0;
        long num1 = 0L;
        long num2 = 0L;
        long N = 1000000007;

        Node temp1 = l1;
        Node temp2 = l2;


        while (temp1 != null) {
            num1 = (num1 * 10) % N + temp1.data;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            num2 = (num2 * 10) % N + temp2.data;
            temp2 = temp2.next;
        }


        // System.out.println(num1+" "+num2);

        return ((num1 % N) * (num2 % N)) % N;
    }

    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    public static void removeLoop(Node head) {
        //corner cases
        if (head == null || head.next == null) return;
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            Node prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if (slow == head && fast == head) prev.next = null;
                else slow.next = null;
                return;
            }
        }
        return;
    }

    ListNode intersectPoint(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }//while
        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return res.bottom;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        //here we will get res.bottom
        //So it will look like this and will keep merging
        //5->   10->   19-> null
        //      |      |
        //      20     22
        //             |
        //             28
        //             |
        //             35
        //             |
        //             40
        //             |
        //             .
        //             .
        root = mergeTwoLists(root, root.next);
        return root;
    }

    public static Node reverseDLL(Node head) {
        //Your code here
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    Node compute(Node head) {
        head = reverseListGfg(head);
        Node n = head.next, c = head;
        while (n != null) {
            while (n != null && c.data > n.data) {
                n = n.next;
            }
            c.next = n;
            if (n == null) break;
            c = n;
            n = n.next;
        }
        return reverseListGfg(head);
    }


    ListNode divide(int N, ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyEven = new ListNode(-1);
        ListNode dummyOdd = new ListNode(-1);

        ListNode evenTail = dummyEven,
                oddTail = dummyOdd,
                curr = head;


        while (curr != null) {
            if (curr.val % 2 != 0) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            curr = curr.next;
        }

        evenTail.next = dummyOdd.next;
        oddTail.next = null;

        return dummyEven.next;
    }

}
