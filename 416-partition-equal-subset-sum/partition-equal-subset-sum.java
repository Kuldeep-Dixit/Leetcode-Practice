class Solution {

//  ----------------------- Tabulation -------------------------------

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        int n = nums.length, target = sum / 2;
        boolean[][] result = new boolean[n + 1][target + 1];

        result[0][0] = true;

        for(int i = 1; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(nums[i - 1] <= j){
                    result[i][j] = result[i - 1][j - nums[i - 1]] || result[i - 1][j];
                }
                else result[i][j] = result[i - 1][j];
            }
        }
        return result[n][target];
    }


// ------------------------ Memoization -------------------------------

    // private static Boolean[][] result;

    // private static boolean recursive(int[] arr, int n, int target){
    //     if(target == 0) return true;

    //     else if(target < 0 || n == 0) return false;

    //     if(result[n][target] == null){
    //         if(arr[n - 1] <= target){
    //             result[n][target] = recursive(arr, n-1, target - arr[n - 1]) ||
    //                 recursive(arr, n-1, target);
    //         }
    //         else result[n][target] = recursive(arr, n-1, target);
    //     }
    //     return result[n][target];
    // }

    // public boolean canPartition(int[] nums) {

    //     int sum = 0;

    //     for(int i : nums) sum += i;

    //     if(sum % 2 != 0) return false;

    //     int n = nums.length, target = sum / 2;

    //     result = new Boolean[n + 1][target + 1];

        

    //     return recursive(nums, n, target);;
    // }
}