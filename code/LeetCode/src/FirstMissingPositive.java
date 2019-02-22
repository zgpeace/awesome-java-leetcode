public class FirstMissingPositive {

    /**
     *
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     * Note:
     *
     * Your algorithm should run in O(n) time and uses constant extra space.
     */


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        boolean[] orderBools = new boolean[len + 2];
        for (int num: nums) {
            if (num < 0 || num > len + 1) {
                continue;
            }
            orderBools[num] = true;
        }

        for (int i = 1; i < len + 2 ; i++) {
            if (!orderBools[i]) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] nums = {1};
        System.out.println("expect 2, Output: " + obj.firstMissingPositive(nums));

        nums = new int[]{};
        System.out.println("expect 1, Output: " + obj.firstMissingPositive(nums));

        nums = new int[]{7,8,9,11,12};
        System.out.println("expect 1, Output: " + obj.firstMissingPositive(nums));
    }
}
