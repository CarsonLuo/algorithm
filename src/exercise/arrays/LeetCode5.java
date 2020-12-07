package exercise.arrays;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2927 👎 0

public class LeetCode5 {
    private static String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        if(array.length < 1){
            return "";
        }
        if(array.length == 1){
            return array[0] + "";
        }
        int start = -1;
        int length = -1;
        for(int i = 0; i < array.length; i++){
            for(int y = i + 1; y < array.length; y++){
                int z = a(array, i, y);
                if(z > length){
                    start = i;
                    length = z;
                }
            }
        }
        if(start == -1){
            return "";
        }
        return String.valueOf(array, start, length);
    }

    private static int a(char[] array, int i, int y){
        for(int x = i, k = y; x <= y && k >= i && x <= k; x++, k--) {
            char a = array[x];
            char b = array[k];
            if (a != b) {
                return 1;
            }
        }
        return y - i + 1;
    }

    public static void main(String[] args) {
        String a = "babad";
        System.out.println(longestPalindrome(a));

        String b = "cbbd";
        System.out.println(longestPalindrome(b));

        String c = "ab";
        System.out.println(longestPalindrome(c));
    }
}
