class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int maxVal = nums[0];
        int minVal = nums[0];
        
        
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
            if (num < minVal) {
                minVal = num;
            }
        }
        
        
        long maxDiff = (long) maxVal - minVal;
        
        
        return maxDiff * k;
    }
}
