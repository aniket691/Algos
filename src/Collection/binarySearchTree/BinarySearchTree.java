package Collection.binarySearchTree;

import java.util.Collections;
import java.util.Vector;

public class BinarySearchTree {


    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1

    /**
     * Intuition:
     * The given code implements a recursive algorithm to solve a binary tree problem that checks whether the values of nodes in the tree form a continuous sequence of integers within a given range.
     * <p>
     * Algorithm:
     * The algorithm takes three arguments:
     * 1. A binary tree node.
     * 2. A minimum integer value for the range.
     * 3. A maximum integer value for the range.
     * <p>
     * The function first checks whether the input node is null, and returns false if that's the case.
     * It then checks whether the given range only has a single value (i.e., `min == max`). If that's the case, the function returns true, indicating that the tree nodes form a continuous sequence of integers.
     * <p>
     * Otherwise, the function makes two recursive calls:
     * 1. The first call is made with the left child node of the current node and updates the range by setting the new maximum value to `node.data - 1`. This is because any value in the left subtree of the current node must be less than the current node's value to form a continuous sequence.
     * 2. The second call is made with the right child node of the current node and updates the range by setting the new minimum value to `node.data + 1`. This is because any value in the right subtree of the current node must be greater than the current node's value to form a continuous sequence.
     * <p>
     * Finally, the function returns the logical OR of the two recursive calls, indicating whether either of the subtrees has a continuous sequence of integers within the updated range.
     * <p>
     * Overall, this algorithm recursively traverses the binary tree in a depth-first manner, updating the range of allowed integer values as it goes. The algorithm returns true if it finds a continuous sequence of integers in any of the subtrees or false otherwise.
     *
     * @param node
     * @param min
     * @param max
     * @return
     */
    public static boolean solve(Node node, int min, int max) {

        if (node == null) return false;

        if (min == max) return true;

        return solve(node.left, min, node.data - 1) || solve(node.right, node.data + 1, max);

    }

    public static boolean isDeadEnd(Node root) {
        //Add your code here.
        return solve(root, 1, Integer.MAX_VALUE);
    }


    //https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1

    /**
     * The given code is used to convert a binary tree to a binary search tree (BST). The algorithm used is as follows:
     * <p>
     * 1. Traverse the binary tree in an inorder manner and store the values of the nodes in a vector.
     * 2. Sort the vector to obtain a sorted list of node values.
     * 3. Traverse the binary tree again in an inorder manner and replace the value of each node with the next smallest value from the sorted vector.
     * 4. Continue until all nodes have been updated.
     * <p>
     * The intuition behind the algorithm is that the inorder traversal of a BST produces a sorted list of values.
     * Thus, by performing an inorder traversal of the binary tree, we obtain a list of the node values in their original order.
     * We can then sort this list to obtain a sorted order of the node values. Finally, we traverse the binary tree again in an inorder manner,
     * and replace each node value with the next smallest value from the sorted list. By doing so, we are essentially maintaining the binary search tree property, since the next smallest value in a sorted list is the value that should be on the left side of the node in a BST.
     * <p>
     * The algorithm has a time complexity of O(nlogn) due to the sorting operation, where n is the number of nodes in the binary tree.
     * The space complexity is O(n) due to the use of the vector to store the node values.
     *
     * @param v
     * @param root
     */
    public static void inorder(Vector<Integer> v, Node root) {
        if (root == null) {
            return;
        }
        inorder(v, root.left);
        v.add(root.data);
        inorder(v, root.right);
    }

    public static void bst(Vector<Integer> v, Node root, int i) {
        if (root == null) {
            return;
        }
        bst(v, root.left, i);
        root.data = v.remove(i);
        bst(v, root.right, i);
    }

    Node binaryTreeToBST(Node root) {
        int idx = 0;
        Vector<Integer> v = new Vector<>();
        inorder(v, root);
        Collections.sort(v);
        bst(v, root, idx);
        return root;
    }

}
