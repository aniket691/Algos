package Collection.tree;

import java.util.*;


class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}

public class Tree {
    public static void printLevelWise(TreeNode<Integer> root) {

        //create a queue
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        //add to root to q
        q.add(root);

        //while q is not empty
        while (!q.isEmpty()) {
            //get the node
            TreeNode<Integer> level = q.peek();
            //remove current element
            q.remove();
            //print current data
            System.out.println(level.data);
            //add children of current node
            q.addAll(level.children);
        }
    }


    //find the count of nodes whose value is greater than x
    public static int numNodeGreater(TreeNode<Integer> root, int x) {

        //if root is null then the count will be 0 as per test case
        if (root == null) return 0;

        //initialize the count to 0 because default count is 0
        int count = 0;

        //if current node's data is greater than x increase the count
        if (root.data > x) {
            count += 1;
        }

        //recursively check which nodes have the value greater than x
        for (int i = 0; i < root.children.size(); i++) {
            count += numNodeGreater(root.children.get(i), x);
        }

        //return the count
        return count;
    }


}
