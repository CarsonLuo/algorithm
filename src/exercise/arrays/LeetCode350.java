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
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 460 👎 0
public class LeetCode350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 这一步是为了节省 map 的空间
        int[] mapArr = nums1.length > nums2.length ? nums2 : nums1;
        int[] forArr = nums1.length > nums2.length ? nums1 : nums2;

        // 将 nums1 放到 map中, 初始化的value 为 1; 当 nums1中的有重复的, 则value++
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : mapArr) {
            Integer v = map.get(value);
            if(v == null){
                map.put(value, 1);
            }else {
                map.put(value, ++v);
            }
        }
        // 为了节省空间, 将重复的数据放到 num2, 从头开始放, y表示放到哪个位置了; 最后截取 num2
        int y = 0;
        for (int value : forArr) {
            Integer v = map.get(value);
            // 如果从map中, 获取得到数据, 并且数据大于0; 则把'交集数据放到 y位置', y++; 再讲map中的value--
            if(v != null && v > 0){
                nums2[y++] = value;
                map.put(value, --v);
            }
        }
        // 截取
        return Arrays.copyOfRange(forArr, 0, y);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        // 排序两个数组
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // i : nums1 的指针; y : nums2的指针; k : nums2放置重复数据的位置
        int i = 0, y = 0, k = 0;
        while (i < nums1.length && y < nums2.length){
            if(nums1[i] == nums2[y]){
                y++;
                nums2[k++] = nums1[i++];
            }else if(nums1[i] > nums2[y]){
                y++;
            }else {
                i++;
            }
        }
        // 截取
        return Arrays.copyOfRange(nums2, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,2};
        int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }
}
