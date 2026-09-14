class Solution {
    List<List<Integer>> result;
    
    public void recursive(int[] candi, int target, List<Integer> list, int sum, int idx){
        if(sum > target || idx >= candi.length) return;
        
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
            recursive(candi, target, list, sum, idx + 1);
            list.add(candi[idx]);
            recursive(candi, target, list, sum + candi[idx], idx);
            list.remove(list.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        recursive(candidates, target, new ArrayList<>(), 0, 0);
        
        return result;
    }
}