class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            char chara = strs[0].charAt(i);
            for(String s : strs){
                if(i >= s.length() || s.charAt(i) != chara) return str.toString();
            }
            str.append(chara);
        }
        
        return str.toString();
    }
}