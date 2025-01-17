package Practice.Recursion;

import java.util.*;

public class Permutations2 {
    // Array contains duplicates
    // https://leetcode.com/problems/permutations-ii/
    // https://www.youtube.com/watch?v=qhBVWf0YafA

    /*
Time Complexity
    For instance, at the first stage, at most we would have N candidates to explore, i.e. the number of nodes at this level would be N.
    Moving on to the next stage, for each of the nodes in the first stage, we would have N−1 child nodes. Therefore, the number of nodes at this stage would be N⋅(N−1).
    So on and so forwards.
    It takes N steps to generate a single permutation. Since there are in total N! possible permutations, at most it would take us N⋅N! steps to generate all permutations, simply assuming that there is no overlapping effort (which is not true).

     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results
    ) {
        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }

}
