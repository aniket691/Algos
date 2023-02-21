package Collection.recursion;

import Collection.array.Array;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecursionTest {

    @Test
    public void recursionTest() {
        Recursion.towerOfHanoi(3, '1', '2', '3');
        int[] arr = {1,2};
        //Recursion.subsetsSumK(arr,8);
        List<List<Integer>> ans = Recursion.subsets(arr);
        System.out.println(ans);
    }
}
