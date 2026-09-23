class Solution {
    private static int[][] ans;

    private static int recursive(String x, String y, int n, int m){

        if(n == 0 || m == 0) return 0;

        if(ans[n][m] == -1){
            if(x.charAt(n - 1) == y.charAt(m - 1))
                ans[n][m] = 1 + recursive(x, y, n - 1, m - 1);
            else{
                ans[n][m] = Math.max(recursive(x, y, n, m - 1),
                            recursive(x, y, n - 1, m));
            }
        }
        

        return ans[n][m];

    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length(), m = n;

        StringBuilder rev = new StringBuilder("");
        for(int i = n - 1; i >= 0; i--){
            rev.append(s.charAt(i));
        }
        ans = new int[n + 1][m + 1];
        for(int[] i : ans) Arrays.fill(i, -1);
        return recursive(s, rev.toString(), n, m);
    }
}