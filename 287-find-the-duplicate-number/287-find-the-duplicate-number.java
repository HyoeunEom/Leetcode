class Solution {
    public int findDuplicate(int[] nums) {
        int[] numsCopy = new int[nums.length];
        Arrays.fill(numsCopy, -1);
        for (int i = 0; i < nums.length ; i++ ) {
            if (numsCopy[nums[i]] != -1) {
                return nums[i];
            } else {
                numsCopy[nums[i]] = i;
            }
        }
        return -1;
    }
}