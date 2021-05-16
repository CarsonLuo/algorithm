package exercise.linkedlList;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
public class LeetCode21 {

    /**
     * l1, l2 两个升序链表
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;
        ListNode tag1 = l1;
        ListNode tag2 = l2;
        while (tag1 != null && tag2 != null){
            if(tag1.val >= tag2.val){
                cur.next = tag2;
                cur = tag2;
                tag2 = tag2.next;
            }else {
                cur.next = tag1;
                cur = tag1;
                tag1 = tag1.next;
            }
        }
        if(tag1 == null){
            cur.next = tag2;
        }
        if(tag2 == null){
            cur.next = tag1;
        }
        return sentinel.next;
    }

    /**
     * 递归 : f(x)= x + f(x−1)
     */
    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val >= l2.val){
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(2);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode n6 = new ListNode(10);
        ListNode n5 = new ListNode(2, n6);
        ListNode n4 = new ListNode(1, n5);

        System.out.println(mergeTwoLists2(n1, n4));
    }
}
