package Practice.DP;

public class CoinChange {
    // https://leetcode.com/problems/coin-change/
    public int coinChange(int[] coins, int amount) {
        int ans = solve(coins, 0, amount, new Integer[amount+1]);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int solve(int[] coins, int currAmount, int maxAmount, Integer[] memo){
        if(currAmount == maxAmount){
            return 0;
        }
        if(memo[currAmount] != null) return memo[currAmount];
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            if(currAmount + coins[i] >= 0 && currAmount + coins[i] <= maxAmount){
                int sub = solve(coins, currAmount+coins[i], maxAmount, memo);
                if(sub == Integer.MAX_VALUE){
                    continue;
                }else{
                    minCoins = Math.min(minCoins, 1+sub);
                }
            }
        }
        memo[currAmount] = minCoins;
        return minCoins;
    }
}
