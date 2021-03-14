package exercise.arrays;

import java.util.Arrays;

/*
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"


 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。


 说明:

 所有输入只包含小写字母 a-z 。
 Related Topics 字符串
 👍 1363 👎 0
 */
public class LeetCode14 {
    // 公开前缀: 有一个前缀, 数组里任何一个元素都是以这个前缀开始的;
    public static String longestCommonPrefix(String[] strs) {
        String r = "";
        // 特殊情况处理
        if(strs.length == 0){
            return r;
        }
        if(strs.length == 1){
            return strs[0];
        }
        // 取数组第一个作为公共前缀, 将strs从索引1开始遍历
        r = strs[0];
        for(int i = 1; i < strs.length; i++){
            while (true){
                if(strs[i].startsWith(r)){
                    break;
                }else {
                    r = r.substring(0, r.length() - 1);
                }
                if(r.equals("")){
                    return r;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        // String[] a = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(a));
    }
}
