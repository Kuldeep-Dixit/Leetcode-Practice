class Solution {

    private static int[][] result;

    private int recursive(String txt1, String txt2, int n, int m){

        if(n == 0 || m == 0) return 0;

        if(result[n][m] == -1){
            if(txt1.charAt(n - 1) == txt2.charAt(m - 1)){
                result[n][m] = 1 + recursive(txt1, txt2, n - 1, m - 1);
            }
            else{
                result[n][m] = Math.max(recursive(txt1, txt2, n - 1, m), recursive(txt1, txt2, n, m - 1));
            }
        }
        

        return result[n][m];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        result = new int[n + 1][m + 1];
        for(int[] i : result) Arrays.fill(i, -1);
        result[0][0] = 0;
        return recursive(text1, text2, n, m);
        
    }
}