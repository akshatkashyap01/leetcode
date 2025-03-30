class Solution {
    public int[] twoSum(int[] nums, int target) {
     if (nums == null) {
            return null;
        }
        
        int len = nums.length;
        
        if (len == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(nums[0], 0);
        
        for (int i = 1; i < len; i++) {
            int diff = target - nums[i];
            Integer idx = map.get(diff);
            
            if (idx != null) {
                return new int[] {idx, i};
            }
            
            map.put(nums[i], i);
        }
        
        return null;
      
    }
}