class Solution {
    List<List<Integer>> result;
    public void Recursive(List<Integer> arr, int idx, int[] nums){
        if(idx == nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }
        Recursive(arr,idx+1,nums);
        arr.add(nums[idx]);
        Recursive(arr,idx+1,nums);
        arr.remove(arr.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        Recursive(new ArrayList<>(),0,nums);
        return result;
        
    }
}