class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        long sum = 0;
        int maxFreq = 1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            // Cost to make every element in the window equal to nums[right]
            long cost = (long) nums[right] * (right - left + 1) - sum;

            // If we don't have enough operations, shrink the window
            while (cost > k) {
                sum -= nums[left];
                left++;

                cost = (long) nums[right] * (right - left + 1) - sum;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}
