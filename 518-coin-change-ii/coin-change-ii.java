class Solution {

//  ========================= Memoization ========================================

    private static int[][] result;
    private static int recursive(int[] coins, int n, int amount){
        if(amount == 0) return 1;
        else if(n == 0) return 0;

        if(result[n][amount] == -1){
            if(coins[n - 1] <= amount){
                result[n][amount] = recursive(coins, n, amount - coins[n - 1]) + recursive(coins, n - 1, amount);
            } 
            else{
                result[n][amount] = recursive(coins, n - 1, amount);
            }
        }
        
        return result[n][amount];
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;
        result = new int[n + 1][amount + 1];

        for(int[] i : result) Arrays.fill(i, -1);

        return recursive(coins, n, amount);
    }
}