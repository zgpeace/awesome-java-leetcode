public class ContainerWithMostWater {
    /*
    Container With Most Water
    Description
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.

    Tags: Array, Two Pointers
     */

    /*
    思路
    题意是给你 a1, a2, ..., an 这 n 个数，代表 (i, ai) 坐标，让你从中找两个点与 x 轴围成的容器可以容纳最多的水。

    不明白的话可以看数据为 1 8 6 2 5 4 8 3 7 所示的图。

    如果用暴力法求每种情况的结果，其时间复杂度为 O(n^2)，相信肯定会超时，我们可以探索下是否有更巧妙的办法呢，
    题目的标签有双指针，是否就可以想到首尾各放一指针，然后根据条件来收缩。首先计算一次首尾构成的最大面积，
    然后分析下该移动哪个指针，如果移动大的那个指针的话，那样只会减小面积，所以我们要移动小的那个指针，小的那个指针移动到哪呢？
    当然是移动到大于之前的值的地方，否则面积不都比之前小么，然后继续更新最大值即可，借助如上分析写出如下代码应该不是什么难事了吧。
     */

    public int maxArea(int[] height) {
        int max = 0;
        int h = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            h = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * h);
            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
        }

        return max;
    }


























}
