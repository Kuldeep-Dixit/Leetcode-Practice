class Solution {
    private static int[][] result;
    private static int recursive(int[] coins, int n, int amount){

        if(n == 0 && amount != 0) return Integer.MAX_VALUE - 1; 
        else if(amount == 0){
            return 0;
        }

        if(result[n][amount] == -1){
            if(coins[n - 1] <= amount){
                result[n][amount] = Math.min(1 + recursive(coins, n, amount - coins[n - 1]),
                                recursive(coins, n - 1, amount));
            }
            else{
                result[n][amount] = recursive(coins, n - 1, amount);
            }
        }
        
        return result[n][amount];
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        result = new int[coins.length + 1][amount + 1];
        for(int[] i : result) Arrays.fill(i, -1);

        recursive(coins, coins.length, amount);
        return result[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : result[coins.length][amount];
    }
}