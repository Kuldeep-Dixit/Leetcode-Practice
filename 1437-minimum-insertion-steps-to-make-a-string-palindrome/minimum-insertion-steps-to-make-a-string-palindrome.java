class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder rev = new StringBuilder("");
        
        for(int i = n - 1; i >= 0; i--){
            rev.append(s.charAt(i));
        }
        String t = rev.toString();
        
        int[][] ans = new int[n + 1][n + 1];
        
        for(int i = 1; i < ans.length; i++){
            for(int j = 1; j < ans[i].length; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    ans[i][j] = 1 + ans[i - 1][j - 1];
                else
                    ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]);
            }
        }
        
        return n - ans[n][n];
        
    }
}