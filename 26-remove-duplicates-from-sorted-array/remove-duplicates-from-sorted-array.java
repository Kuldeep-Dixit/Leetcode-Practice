class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        int i = 0, j = 1, count = 1;

        while(j < nums.length){
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            if (j < nums.length) {
                nums[i + 1] = nums[j];
                i++;
                count++;
                j++;
            }
        }
        return count;
    }
}