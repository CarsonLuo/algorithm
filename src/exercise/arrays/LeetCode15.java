package exercise.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3086 👎 0
public class LeetCode15 {

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3){
            return result;
        }
        // 排序
        Arrays.sort(nums);
        // 将一个数固定, 然后用双指针遍历[一个指针从'固定的数后一位开始', 一个指针从'最后开始']
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果 '固定的数' 都大于0了, 后面怎么加都不可能等于0
            if(nums[i] > 0){
                break;
            }
            // 固定的数 与 其前一位相等, 因为前一位处理过了, 所以跳过这位
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int k = nums[i] + nums[x] + nums[y];
                if (k > 0) {
                    // 说明y对应的数太大了, y要向前移动, 还要处理重复的值
                    do{y--;}while (x < y && nums[y] == nums[y+1]);
                    continue;
                } else if (k == 0) {
                    result.add(Arrays.asList(nums[i], nums[x], nums[y]));
                }
                // 对应 k == 0, k < 0 两种情况
                do{x++;}while (x < y && nums[x] == nums[x-1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-4,-4,-1,-1,0,1,1,2,2,2};
        List<List<Integer>> result = threeSum(input);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
