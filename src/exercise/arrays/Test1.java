package exercise.arrays;

/*
   剑指offer中的练习题：
   在一个二维数组中（每个一维数组的长度相同），
   每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
   请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test1 {

    public boolean Find(int target, int [][] array) {



        return false;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int target = 7;
        int[][] arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean a = test1.Find(target, arrays);
        System.out.println(a);
    }
}
