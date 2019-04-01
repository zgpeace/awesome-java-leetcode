package popular;

import java.util.Arrays;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        // result memory, 1 is true; -1 is false;
        int[] memo = new int[nums.length + 1];
        return helper(0, nums, memo);
    }

    public static boolean helper(int position, int[] nums, int[] memo) {
        if (memo[position] == 1 || position == nums.length - 1) {
            return true;
        } else if (memo[position] == -1) {
            return false;
        }
        int maxPosition = Math.min(position + nums[position], nums.length - 1) ;
        for(int i = maxPosition; i > position; i--) {
            memo[i] = helper(i, nums, memo) ? 1 : -1;
            if(memo[i] == 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpWithBottomUp(int[] nums) {
        // result memory, 1 is true; -1 is false;
        int[] memo = new int[nums.length];
        // check if the length == 1
        memo[nums.length - 1] = 1;

        for(int i = nums.length -2; i >= 0; i--) {
            int maxPosition = Math.min(i + nums[i], nums.length - 1);
            for(int k = i + 1; k <= maxPosition; k++) {
                if (k == nums.length - 1 || memo[k] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        return memo[0] == 1;
    }

    public static boolean canJumpWithGreedy(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = lastIndex - 1; i >=0 ; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        int[] input1 = {3,2,1,0,4};
        //System.out.println("intput: " + Arrays.toString(input) + '\n' + "output: " + canJump(input));
        //System.out.println("input1: " + Arrays.toString(input1) + '\n' + "output: " + canJump(input1));
        //System.out.println("intput: " + Arrays.toString(input) + '\n' + "output: " + canJumpWithBottomUp(input));
        //System.out.println("input1: " + Arrays.toString(input1) + '\n' + "output: " + canJumpWithBottomUp(input1));
        System.out.println("intput: " + Arrays.toString(input) + '\n' + "output: " + canJumpWithGreedy(input));
        System.out.println("input1: " + Arrays.toString(input1) + '\n' + "output: " + canJumpWithGreedy(input1));
    }
}
