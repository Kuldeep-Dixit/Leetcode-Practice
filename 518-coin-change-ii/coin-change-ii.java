class Solution {

// ========================== Tabulation =======================================

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] result = new int[n + 1][amount + 1];
        result[0][0] = 1;

        for(int i = 1; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(coins[i - 1] <= j){
                    result[i][j] = result[i][j - coins[i - 1]] + result[i - 1][j];
                }
                else{
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        return result[n][amount];
    }

//  ========================= Memoization ========================================

    // private static int[][] result;
    // private static int recursive(int[] coins, int n, int amount){
    //     if(amount == 0) return 1;
    //     else if(n == 0) return 0;

    //     if(result[n][amount] == -1){
    //         if(coins[n - 1] <= amount){
    //             result[n][amount] = recursive(coins, n, amount - coins[n - 1]) + recursive(coins, n - 1, amount);
    //         } 
    //         else{
    //             result[n][amount] = recursive(coins, n - 1, amount);
    //         }
    //     }
        
    //     return result[n][amount];
    // }

    // public int change(int amount, int[] coins) {

    //     int n = coins.length;
    //     result = new int[n + 1][amount + 1];

    //     for(int[] i : result) Arrays.fill(i, -1);

    //     return recursive(coins, n, amount);
    // }
}