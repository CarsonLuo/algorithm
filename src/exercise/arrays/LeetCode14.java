package exercise.arrays;

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
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs.length < 2){
            return prefix;
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(i == 0){
                prefix = str;
            }
            prefix = compare(str, prefix);
            if(prefix.length() == 0){
                return prefix;
            }
        }
        return prefix;
    }

    private String compare(String str, String prefix){
        int length = Math.min(str.length(), prefix.length());
        for(int i = 0; i < length; i++){
            if(str.charAt(i) != prefix.charAt(i)){
                return prefix.substring(0, i);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LeetCode14 l = new LeetCode14();

        String[] a = {"flower","flow","flight"};
        //String[] a = {"dog","racecar","car"};
        String cp = l.longestCommonPrefix(a);
        System.out.println(cp);
    }
}
