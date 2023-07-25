package Collection.backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingTest {

    @Test
    public void ratTest() {
        BackTrackingKot obj = new BackTrackingKot();
        int a[][] = {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}};
        int n = a.length;
//        ArrayList<String> res = obj.findPath(a, n);
//        if (res.size() > 0) {
//            for (int i = 0; i < res.size(); i++)
//                System.out.print(res.get(i) + " ");
//            System.out.println();
//        } else {
//            System.out.println(-1);
//        }
    }

    @Test
    public void combinationSum() {
        BackTrackingKot obj = new BackTrackingKot();
        int[] a = {1, 2, 3, 4};
        int tar = 4;
//        //List<List<Integer>> ans = obj.combinationSum(a, tar);
//        for (List<Integer> i : ans) {
//            for (int ele : i) System.out.print(ele + " ");
//            System.out.println();
//        }
    }
}
