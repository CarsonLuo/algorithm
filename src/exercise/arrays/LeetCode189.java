package exercise.arrays;

import java.util.Arrays;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//
//
// 进阶：
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//
//
//
//
// 示例 1:
//
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
//
//
//
//
// Related Topics 数组
// 👍 917 👎 0
public class LeetCode189 {

    /**
     * 移动一次: 将数组往右移一位, 再将最后的数据放在最前面
     * k次 * 移动一次
     */
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        while (i < k){
            int last = nums[nums.length-1];
            for(int y = nums.length - 1; y > 0; y--){
                nums[y] = nums[y-1];
            }
            nums[0] = last;
            i++;
        }
    }

    private static void rotate2(int[] nums, int k){
        // 当 nums.length = 10, k = 13 与 k = 3 是一样的;
        k = k % nums.length;
        // 转置整个数组
        reverse(nums, 0, nums.length - 1);
        // 转置前部分
        reverse(nums, 0, k - 1);
        // 转置后部分
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] arr, int start, int end){
        while (start < end){
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] numArr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        rotate2(numArr, 15);
        System.out.println(Arrays.toString(numArr));
    }
}
