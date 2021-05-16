package exercise.linkedlList;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1670 👎 0
public class LeetCode206 {
    public static ListNode reverseList(ListNode head) {
        // 指向第一个节点 (target 表示后面要翻转的节点, 指向的位置)
        ListNode target = head;
        // 起始:  1 -> 2 -> 3 -> 4 -> 5
        // 第一次遍历 :  2 -> 1 -> 3 -> 4 -> 5
        // 第二次遍历:   3 -> 2 -> 1 -> 4 -> 5
        while (head.next != null){
            ListNode nextnext = head.next.next;
            head.next.next = target;
            target = head.next;
            head.next = nextnext;
        }
        return target;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(reverseList(n1));
    }
}
