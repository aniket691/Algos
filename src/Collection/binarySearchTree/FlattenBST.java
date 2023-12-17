package Collection.binarySearchTree;

import java.util.Scanner;

public class FlattenBST  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node ans = bt(arr);
        flatten(ans);
    }

    public static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    private static Node bt(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //track prev
    public static void inOrder2(Node curr, Node prev) {
        if (curr == null) return;
        inOrder2(curr.left, prev);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        inOrder2(curr.right, prev);
    }

    public static Node flatten(Node parent) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        inOrder2(parent, prev);
        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;
        return ret;
    }
}
