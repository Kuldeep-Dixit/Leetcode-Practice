class Solution {

    // ============================ Tabulation ==========================================

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];

                else{

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder ans = new StringBuilder("");
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                ans.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i][j - 1] > dp[i - 1][j]){
                ans.insert(0, str2.charAt(j - 1));
                j--;
            }
            else{
                ans.insert(0, str1.charAt(i - 1));
                i--;
            }
        }
        if(i != 0){
            while(i != 0){
               ans.insert(0, str1.charAt(i - 1));
                i--; 
            }
        }
        if(j != 0){
            while(j != 0){
                ans.insert(0, str2.charAt(j - 1));
                j--;
            }
            
        }
        return ans.toString();

    }

// ================================ Memoization ==========================================

    // private static String[][] dp;

    // private static String recursive(String x, String y, int n, int m){
    //     if (n == 0) {
    //         return y.substring(0, m);
    //     }

    //     if (m == 0) {
    //         return x.substring(0, n);
    //     }
    //     if(dp[n][m] == null){
    //         if(x.charAt(n - 1) == y.charAt(m - 1)){
    //             dp[n][m] = recursive(x, y, n - 1, m - 1) + x.charAt(n - 1);
    //         }
    //         else{
    //             String ans1 = recursive(x, y, n, m - 1) + y.charAt(m - 1);

    //             String ans2 = recursive(x, y, n - 1, m) + x.charAt(n - 1);

    //             dp[n][m] = ans1.length() <= ans2.length() ? ans1 : ans2;
    //         }
    //     }
    //     return dp[n][m];
        
    // }

    // public String shortestCommonSupersequence(String str1, String str2) {
    //     int n = str1.length(), m = str2.length();

    //     dp = new String[n + 1][m + 1];

    //     return recursive(str1, str2, n, m);


    // }
}