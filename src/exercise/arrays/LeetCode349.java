package exercise.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 336 👎 0
public class LeetCode349 {
    private static int[] intersection(int[] nums1, int[] nums2) {
        // 这一步是为了节省 map 的空间
        int[] mapArr = nums1.length > nums2.length ? nums2 : nums1;
        int[] forArr = nums1.length > nums2.length ? nums1 : nums2;

        // 将 nums1 的数据都放到 map; key 为 数据, value 初始化为 0
        Map<Integer,Integer> map = new HashMap<>();
        for (int value : mapArr) {
            map.put(value, 0);
        }
        // 为了节省空间, 将重复的数据放到 num2, 从头开始放, y表示放到哪个位置了; 最后截取 num2
        int y = 0;
        // 遍历num2; 当 'map中存在' 并且 'map中的值为0' 的时候,
        for (int i = 0; i < forArr.length; i++) {
            int v = forArr[i];
            Integer exist = map.get(v);
            if(exist != null && exist == 0){
                // 将map中的对应值设置为1, 将重复数据放到num2[y]中, y移动到下一位放数据的位置
                forArr[y] = v;
                map.put(v, 1);
                y++;
            }
        }
        // 截取
        return Arrays.copyOfRange(forArr, 0, y);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1,3,3};
        int[] nums2 = new int[]{2,2,3,3};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
