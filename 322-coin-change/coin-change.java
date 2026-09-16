class Solution {

    // ======================= Tabulation ========================
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[][] result = new int[coins.length + 1][amount + 1];

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(j == 0) result[i][j] = 0;
                else if(i == 0) result[i][j] = Integer.MAX_VALUE - 1;
            }
        } 

        for(int i = 1; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(coins[i - 1] <= j){
                    result[i][j] = Math.min(
                        1 + result[i][j - coins[i - 1]],
                        result[i - 1][j]
                    );
                }
                else{
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        
        return result[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : result[coins.length][amount];
    }

    // ======================= Memoization =======================
    // private static int[][] result;
    // private static int recursive(int[] coins, int n, int amount){

    //     if(n == 0 && amount != 0) return Integer.MAX_VALUE - 1; 
    //     else if(amount == 0){
    //         return 0;
    //     }

    //     if(result[n][amount] == -1){
    //         if(coins[n - 1] <= amount){
    //             result[n][amount] = Math.min(1 + recursive(coins, n, amount - coins[n - 1]),
    //                             recursive(coins, n - 1, amount));
    //         }
    //         else{
    //             result[n][amount] = recursive(coins, n - 1, amount);
    //         }
    //     }
        
    //     return result[n][amount];
    // }
    // public int coinChange(int[] coins, int amount) {
    //     if(amount == 0) return 0;

    //     result = new int[coins.length + 1][amount + 1];
    //     for(int[] i : result) Arrays.fill(i, -1);

    //     recursive(coins, coins.length, amount);
    //     return result[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : result[coins.length][amount];
    // }
}